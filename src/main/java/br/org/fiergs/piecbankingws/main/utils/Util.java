package br.org.fiergs.piecbankingws.main.utils;

import br.org.fiergs.cobranca.bb.entities.Requisicao;
import br.org.fiergs.cobranca.bb.entities.Resposta;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class Util {
    public static Resposta unMarsh(String resposta) throws JAXBException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(replaceXmlResposta(resposta).getBytes());

        JAXBContext jaxbContext = JAXBContext.newInstance(Resposta.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        return (Resposta) jaxbUnmarshaller.unmarshal(byteArrayInputStream);
    }


    public static String marsh(Requisicao requisicaoObject) throws JAXBException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        JAXBContext jaxbContext = JAXBContext.newInstance(Requisicao.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new MyNamespaceMapper());
        jaxbMarshaller.marshal(requisicaoObject, stream);

        return replaceXmlRequisicao(new String(stream.toByteArray()));
    }

    private static String replaceXmlRequisicao(String xml) {
        xml = xml.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "")
                .replace("<sch:requisicao xmlns:sch=\"http://www.tibco.com/schemas/bws_registro_cbr/Recursos/XSD/Schema.xsd\">", "<sch:requisicao>")
                .replaceAll("[\\n]", "")
                .replaceAll(" {2}", "");

        return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:sch=\"http://www.tibco.com/schemas/bws_registro_cbr/Recursos/XSD/Schema.xsd\">" +
                "<soapenv:Header/>" +
                "<soapenv:Body>" +
                xml +
                "</soapenv:Body>" +
                "</soapenv:Envelope>";
    }

    private static String replaceXmlResposta(String xml) {
        return xml.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "")
                .replace("<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\"><SOAP-ENV:Body>", "")
                .replace("</SOAP-ENV:Body></SOAP-ENV:Envelope>", "")
                .replaceAll(" {2}", "");
    }

    public static String fillText(String value) {
        String zeroes = "0000000000";

        if (value.length() < 10) {
            return zeroes.substring(0, (10 - value.length())) + value;
        } else {
            return value.substring(0, 10);
        }
    }

}
