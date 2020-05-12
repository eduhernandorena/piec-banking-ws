package br.org.fiergs.piecbankingws.main.services;

import br.org.fiergs.cobranca.bb.entities.Requisicao;
import br.org.fiergs.cobranca.bb.entities.Resposta;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.*;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

import javax.xml.soap.MimeHeaders;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.logging.Logger;

public class BankSlipService extends WebServiceGatewaySupport {
    private static final String URL_TOKEN_HOM = "https://oauth.hm.bb.com.br/oauth/token";
    private static final String URL_REGISTRAR_BOLETO_HOM = "https://cobranca.homologa.bb.com.br:7101/registrarBoleto";
    private static final String URL_TOKEN_PROD = "https://oauth.bb.com.br/oauth/token";
    private static final String URL_REGISTRAR_BOLETO_PROD = "https://cobranca.bb.com.br:7101/registrarBoleto";

    private String urlToken = URL_TOKEN_HOM;
    private String urlRegistrarBoleto = URL_REGISTRAR_BOLETO_HOM;

    public BankSlipService() {
    }

    public BankSlipService(int env) {
        if (env == 1) {
            urlToken = URL_TOKEN_PROD;
            urlRegistrarBoleto = URL_REGISTRAR_BOLETO_PROD;
        } else if (env == 0) {
            urlToken = URL_TOKEN_HOM;
            urlRegistrarBoleto = URL_REGISTRAR_BOLETO_HOM;
        }
    }


    public Resposta registerBillet(String clientID, String clientSecret, Requisicao requisicao) {
        String token = getToken(clientID, clientSecret);
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("br.org.fiergs.cobranca.bb.entities");
        getWebServiceTemplate().setMarshaller(marshaller);
        getWebServiceTemplate().setUnmarshaller(marshaller);

        return (Resposta) getWebServiceTemplate().marshalSendAndReceive(urlRegistrarBoleto, requisicao, message -> {
            try {
                if (message instanceof SaajSoapMessage) {
                    SaajSoapMessage soapMessage = (SaajSoapMessage) message;
                    MimeHeaders mimeHeader = soapMessage.getSaajMessage().getMimeHeaders();
                    mimeHeader.setHeader("Authorization", "Bearer " + token);
                    mimeHeader.setHeader("SOAPAction", "registrarBoleto");
                    mimeHeader.setHeader("Content-Type", "application/xml");
                }
            } catch (Exception e) {
                Logger.getLogger(BankSlipService.class.getName()).severe(e.getMessage());
            }
        });
    }

    private String getToken(String clientID, String clientSecret) {
        String auth = clientID + ":" + clientSecret;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.UTF_8));
        String authHeaderValue = "Basic " + new String(encodedAuth);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.set("Authorization", authHeaderValue);
        headers.set("Content-Type", "application/x-www-form-urlencoded");
        headers.set("charset", "utf-8");

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "client_credentials");
        map.add("scope", "cobranca.registro-boletos");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
        RestTemplate rest = new RestTemplate();
        ResponseEntity<String> response =
                rest.exchange(urlToken,
                        HttpMethod.POST,
                        entity,
                        String.class);

        String resp = response.getBody();
        return Objects.requireNonNull(resp).substring(17, resp.indexOf("\",\"token_type"));
    }
}


