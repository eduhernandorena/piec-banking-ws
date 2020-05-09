package br.org.fiergs.piecbankingws.main;

import br.org.fiergs.cobranca.bb.entities.Requisicao;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

import org.apache.commons.codec.binary.Base64;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.soap.*;
import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class PaymentBilletFill {

    public static void main(String[] args) throws IOException, JAXBException, SOAPException, UnirestException {
        new PaymentBilletFill().teste();
    }

    private String getToken(String clientID, String clientSecret, String urlToken, String urlParameters) throws IOException {
        String auth = clientID + ":" + clientSecret;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.UTF_8));
        String authHeaderValue = "Basic " + new String(encodedAuth);

        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

        URL url = new URL(urlToken);
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

        String retorno = sb.toString();
        return retorno.substring(17, retorno.indexOf("\",\"token_type"));
    }

    public void teste() throws IOException, JAXBException, SOAPException, UnirestException {
        String clientID = "eyJpZCI6IjgwNDNiNTMtZjQ5Mi00YyIsImNvZGlnb1B1YmxpY2Fkb3IiOjEwOSwiY29kaWdvU29mdHdhcmUiOjEsInNlcXVlbmNpYWxJbnN0YWxhY2FvIjoxfQ";
        String clientSecret = "eyJpZCI6IjBjZDFlMGQtN2UyNC00MGQyLWI0YSIsImNvZGlnb1B1YmxpY2Fkb3IiOjEwOSwiY29kaWdvU29mdHdhcmUiOjEsInNlcXVlbmNpYWxJbnN0YWxhY2FvIjoxLCJzZXF1ZW5jaWFsQ3JlZGVuY2lhbCI6MX0";
        String urlToken = "https://oauth.hm.bb.com.br/oauth/token";
        String url = "https://cobranca.homologa.bb.com.br:7101/registrarBoleto";
        String urlParameters = "grant_type=client_credentials&scope=cobranca.registro-boletos";

        String token = getToken(clientID, clientSecret, urlToken, urlParameters);

        Requisicao requisicao = new Requisicao();
        requisicao.setNumeroConvenio(1014051);
        requisicao.setNumeroCarteira((short) 17);
        requisicao.setNumeroVariacaoCarteira((short) 19);
        requisicao.setCodigoModalidadeTitulo((short) 1);
        requisicao.setDataEmissaoTitulo("01.03.2017");
        requisicao.setDataVencimentoTitulo("21.11.2017");
        requisicao.setValorOriginalTitulo(new BigDecimal(30000));
        requisicao.setCodigoTipoDesconto((short) 1);
        requisicao.setDataDescontoTitulo("21.11.2016");
        requisicao.setValorDescontoTitulo(new BigDecimal(10));
        requisicao.setQuantidadeDiaProtesto((short) 0);
        requisicao.setCodigoTipoJuroMora((short) 0);
        requisicao.setCodigoTipoMulta((short) 2);
        requisicao.setDataMultaTitulo("22.11.2017");
        requisicao.setPercentualMultaTitulo(new BigDecimal(10));
        requisicao.setCodigoAceiteTitulo("N");
        requisicao.setCodigoTipoTitulo((short) 2);
        requisicao.setTextoDescricaoTipoTitulo("DUPLICATA");
        requisicao.setIndicadorPermissaoRecebimentoParcial("N");
        requisicao.setTextoNumeroTituloBeneficiario("987654321987654");
        requisicao.setCodigoTipoContaCaucao((short) 1);
        requisicao.setTextoNumeroTituloCliente("00010140510000000000");
        requisicao.setTextoMensagemBloquetoOcorrencia("Pagamento disponível até a data de vencimento");
        requisicao.setCodigoTipoInscricaoPagador((short) 2);
        requisicao.setNumeroInscricaoPagador(73400584000166L);
        requisicao.setNomePagador("MERCADO ANDREAZA DE MACEDO");
        requisicao.setTextoEnderecoPagador("RUA SEM NOME");
        requisicao.setNumeroCepPagador(12345678);
        requisicao.setNomeMunicipioPagador("BRASILIA");
        requisicao.setNomeBairroPagador("SIA");
        requisicao.setSiglaUfPagador("DF");
        requisicao.setTextoNumeroTelefonePagador("45619988");
        requisicao.setCodigoTipoInscricaoAvalista((short) 0);
        requisicao.setNumeroInscricaoAvalista(0L);
        requisicao.setCodigoChaveUsuario("1");
        requisicao.setCodigoTipoCanalSolicitacao((short) 5);
        //        requisicao.setPercentualDescontoTitulo(null);
        //        requisicao.setValorAbatimentoTitulo(null);
        //        requisicao.setNomeAvalistaTitulo(null);
        //        requisicao.setPercentualJuroMoraTitulo(null);
        //        requisicao.setValorJuroMoraTitulo(null);
        //        requisicao.setValorMultaTitulo(null);
        //        requisicao.setTextoCampoUtilizacaoBeneficiario(null);


        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post(url)
                .header("Content-Type", "application/xml")
                .header("SOAPAction", "registrarBoleto")
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/xml")
                .body(marsh(requisicao))
                .asString();
    }


    private String marsh(Requisicao requisicao) throws JAXBException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        JAXBContext jaxbContext = JAXBContext.newInstance(Requisicao.class);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new MyNamespaceMapper());
        jaxbMarshaller.marshal(requisicao, stream);

        String finalString = new String(stream.toByteArray());
        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:sch=\"http://www.tibco.com/schemas/bws_registro_cbr/Recursos/XSD/Schema.xsd\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                replaceXml(finalString) +
                "</soapenv:Body></soapenv:Envelope>";

        return xml;
    }

    private String replaceXml(String xmlOriginal){
        return xmlOriginal.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "")
                .replace("<sch:requisicao xmlns:sch=\"http://www.tibco.com/schemas/bws_registro_cbr/Recursos/XSD/Schema.xsd\">", "<sch:requisicao>")
                .replaceAll("[\\n]", "")
                .replaceAll(" {2}","");
    }
}


class MyNamespaceMapper extends NamespacePrefixMapper {

    private static final String SCH_PREFIX = "sch";
    private static final String SCH_URI = "http://www.tibco.com/schemas/bws_registro_cbr/Recursos/XSD/Schema.xsd";

    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion,
                                     boolean requirePrefix) {
        if (SCH_URI.equals(namespaceUri)) {
            return SCH_PREFIX;
        }
        return suggestion;
    }

    @Override
    public String[] getPreDeclaredNamespaceUris() {
        return new String[]{SCH_URI};
    }

}
