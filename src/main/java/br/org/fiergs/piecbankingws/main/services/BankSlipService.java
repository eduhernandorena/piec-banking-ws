package br.org.fiergs.piecbankingws.main.services;

import br.org.fiergs.piecbankingws.main.config.SSLUtil;
import br.org.fiergs.piecbankingws.main.entities.RequisicaoEntity;
import br.org.fiergs.piecbankingws.main.entities.RespostaEntity;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import javax.net.ssl.SSLContext;
import javax.xml.soap.MimeHeaders;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.logging.Logger;

public class BankSlipService extends WebServiceGatewaySupport {
    private static final String URL_TOKEN_HOM = "https://oauth.hm.bb.com.br/oauth/token";
    private static final String URL_REGISTRAR_BOLETO_HOM = "https://cobranca.homologa.bb.com.br:7101/registrarBoleto";
    private static final String URL_TOKEN_PROD = "https://oauth.bb.com.br/oauth/token";
    private static final String URL_REGISTRAR_BOLETO_PROD = "https://cobranca.bb.com.br:7101/registrarBoleto";

    private String urlToken = URL_TOKEN_HOM;
    private String urlRegistrarBoleto = URL_REGISTRAR_BOLETO_HOM;

    public BankSlipService(int env) {
        if (env == 1) {
            urlToken = URL_TOKEN_PROD;
            urlRegistrarBoleto = URL_REGISTRAR_BOLETO_PROD;
        } else if (env == 0) {
            urlToken = URL_TOKEN_HOM;
            urlRegistrarBoleto = URL_REGISTRAR_BOLETO_HOM;
        }
    }


    public RespostaEntity registerBillet(String clientID, String clientSecret, RequisicaoEntity requisicaoEntity) throws NoSuchAlgorithmException, KeyManagementException {
        String token = getToken(clientID, clientSecret);
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("br.org.fiergs.piecbankingws.main.entities");
        getWebServiceTemplate().setMarshaller(marshaller);
        getWebServiceTemplate().setUnmarshaller(marshaller);

        return (RespostaEntity) getWebServiceTemplate().marshalSendAndReceive(urlRegistrarBoleto, requisicaoEntity, message -> {
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

    private String getToken(String clientID, String clientSecret) throws KeyManagementException, NoSuchAlgorithmException {
        SSLUtil.turnOffSslChecking();
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

    @Bean
    public HttpComponentsMessageSender httpComponentsMessageSender() throws Exception {
        HttpComponentsMessageSender httpComponentsMessageSender = new HttpComponentsMessageSender();
        httpComponentsMessageSender.setHttpClient(httpClient());

        return httpComponentsMessageSender;
    }

    public HttpClient httpClient() throws Exception {
        return HttpClientBuilder.create().setSSLSocketFactory(sslConnectionSocketFactory())
                .addInterceptorFirst(new HttpComponentsMessageSender.RemoveSoapHeadersInterceptor()).build();
    }

    public SSLConnectionSocketFactory sslConnectionSocketFactory() throws Exception {
        return new SSLConnectionSocketFactory(sslContext(), NoopHostnameVerifier.INSTANCE);
    }

    public SSLContext sslContext() throws Exception {
        return SSLContextBuilder.create()
                .loadTrustMaterial(ResourceUtils.getFile(
                        "file:ca/jssecacerts"), "changeit".toCharArray()).build();
    }
}


