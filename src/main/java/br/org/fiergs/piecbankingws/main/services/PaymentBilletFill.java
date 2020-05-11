package br.org.fiergs.piecbankingws.main.services;

import br.org.fiergs.cobranca.bb.entities.Requisicao;
import br.org.fiergs.cobranca.bb.entities.Resposta;
import br.org.fiergs.piecbankingws.main.utils.Util;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.apache.commons.codec.binary.Base64;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class PaymentBilletFill {

    private static final String URL_TOKEN = "https://oauth.hm.bb.com.br/oauth/token";
    private static final String URL_REGISTRAR_BOLETO = "https://cobranca.homologa.bb.com.br:7101/registrarBoleto";
    private static final String PARAM_URL = "grant_type=client_credentials&scope=cobranca.registro-boletos";

    public static Resposta registerBillet(String clientID, String clientSecret) throws IOException, JAXBException, UnirestException {
        String token = getToken(clientID, clientSecret);

        Requisicao requisicao = new Requisicao();
        requisicao.setNumeroConvenio(3248778);
        requisicao.setNumeroCarteira((short) 17);
        requisicao.setNumeroVariacaoCarteira((short) 434);
        requisicao.setCodigoModalidadeTitulo((short) 1);
        requisicao.setDataEmissaoTitulo("01.03.2020");
        requisicao.setDataVencimentoTitulo("21.11.2020");
        requisicao.setValorOriginalTitulo(new BigDecimal(30000));
        requisicao.setCodigoTipoMulta((short) 0);
        requisicao.setCodigoAceiteTitulo("N");
        requisicao.setCodigoTipoTitulo((short) 2);
        requisicao.setIndicadorPermissaoRecebimentoParcial("N");
        requisicao.setTextoNumeroTituloCliente(Util.fillText("3248778") + "0000000002");
        requisicao.setCodigoTipoInscricaoPagador((short) 2);
        requisicao.setNumeroInscricaoPagador(73400584000166L);
        requisicao.setNomePagador("MERCADO ANDREAZA DE MACEDO");
        requisicao.setTextoEnderecoPagador("RUA SEM NOME");
        requisicao.setNumeroCepPagador(12345678);
        requisicao.setNomeMunicipioPagador("BRASILIA");
        requisicao.setNomeBairroPagador("SIA");
        requisicao.setSiglaUfPagador("DF");
        requisicao.setTextoNumeroTelefonePagador("45619988");
        requisicao.setCodigoChaveUsuario("1");
        requisicao.setCodigoTipoCanalSolicitacao((short) 5);


        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post(URL_REGISTRAR_BOLETO)
                .header("Content-Type", "application/xml")
                .header("SOAPAction", "registrarBoleto")
                .header("Authorization", "Bearer " + token)
                .body(Util.marsh(requisicao))
                .asString();

        return Util.unMarsh(response.getBody());
    }

    private static String getToken(String clientID, String clientSecret) throws IOException {
        String auth = clientID + ":" + clientSecret;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.UTF_8));
        String authHeaderValue = "Basic " + new String(encodedAuth);

        byte[] postData = PARAM_URL.getBytes(StandardCharsets.UTF_8);

        URL url = new URL(URL_TOKEN);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setInstanceFollowRedirects(false);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", authHeaderValue);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("charset", "utf-8");
        conn.setRequestProperty("Content-Length", Integer.toString(postData.length));
        conn.setUseCaches(false);
        try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
            wr.write(postData);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        StringBuilder sb = new StringBuilder();
        String output;
        while ((output = br.readLine()) != null) {
            sb.append(output);
        }

        String response = sb.toString();
        return response.substring(17, response.indexOf("\",\"token_type"));
    }
}


