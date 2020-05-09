package br.org.fiergs.piecbankingws.main;

import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @author JavaC - Java Community
 */
public class NfeBuildCacerts {

    private static final String CACERTS = "jssecacerts";
    private static final int TIMEOUT_WS = 60;

    public static boolean gerar() {
        try {

            String enderecoWebService = "cobranca.homologa.bb.com.br";

            File cacertsFile = gerarCacerts(enderecoWebService, 7101);
            if (cacertsFile != null) {
                info("| Cacerts gerado em: " + cacertsFile.getAbsolutePath());
                return true;
            }
        } catch (Exception e) {
            error(e.toString());
        }
        return false;
    }

    public static boolean delete() {
        File cacerts = new File(CACERTS );
        if (cacerts.isFile()) {
            return cacerts.delete();
        }
        return false;
    }

    public static File gerarCacerts(String host, int port) throws Exception {
        char[] passphrase = "changeit".toCharArray();

        File file = new File(CACERTS);
        if (!file.isFile()) {
            char SEP = File.separatorChar;
            File dir = new File(System.getProperty("java.home") + SEP + "lib" + SEP + "security");
            file = new File(dir, CACERTS);
            if (!file.isFile()) {
                file = new File(dir, "cacerts");
            }
        }

        info("| Loading KeyStore " + file + "...");
        KeyStore ks;
        try (InputStream in = new FileInputStream(file)) {
            ks = KeyStore.getInstance(KeyStore.getDefaultType());
            ks.load(in, passphrase);
        }

        SSLContext context = SSLContext.getInstance("TLS");
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(ks);
        X509TrustManager defaultTrustManager = (X509TrustManager) tmf.getTrustManagers()[0];
        SavingTrustManager tm = new SavingTrustManager(defaultTrustManager);
        context.init(null, new TrustManager[]{tm}, null);
        SSLSocketFactory factory = context.getSocketFactory();

        info("| Opening connection to " + host + ":" + port + "...");
        SSLSocket socket = (SSLSocket) factory.createSocket(host, port);
        socket.setSoTimeout(TIMEOUT_WS * 1000);
        try {
            info("| Starting SSL handshake...");
            socket.startHandshake();
            socket.close();
            info("| No errors, certificate is already trusted");
        } catch (SSLHandshakeException e) {
            /**
             * PKIX path building failed:
             * sun.security.provider.certpath.SunCertPathBuilderException:
             * unable to find valid certification path to requested target Não
             * tratado, pois sempre ocorre essa exceção quando o cacerts nao
             * esta gerado.
             */
        } catch (SSLException e) {
            error("| " + e.toString());
        }

        X509Certificate[] chain = tm.chain;
        if (chain == null) {
            info("| Could not obtain server certificate chain");
            return null;
        }

        info("| Server sent " + chain.length + " certificate(s):");
        MessageDigest sha1 = MessageDigest.getInstance("SHA1");
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        for (int i = 0; i < chain.length; i++) {
            X509Certificate cert = chain[i];
            sha1.update(cert.getEncoded());
            md5.update(cert.getEncoded());

            String alias = host + "-" + (i);
            ks.setCertificateEntry(alias, cert);
            info("| Added certificate to keystore '" + CACERTS + "' using alias '" + alias + "'");
        }

        File cafile = new File(CACERTS);
        try (OutputStream out = new FileOutputStream(cafile)) {
            ks.store(out, passphrase);
        }

        return cafile;
    }

    private static class SavingTrustManager implements X509TrustManager {

        private final X509TrustManager tm;
        private X509Certificate[] chain;

        SavingTrustManager(X509TrustManager tm) {
            this.tm = tm;
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            this.chain = chain;
            tm.checkServerTrusted(chain, authType);
        }
    }

    private static void info(String info) {
        System.out.println("INFO: " + info);
    }

    private static void error(String error) {
        System.out.println("ERROR: " + error);
    }
}
