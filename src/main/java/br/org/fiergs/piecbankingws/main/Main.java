package br.org.fiergs.piecbankingws.main;

import br.org.fiergs.cobranca.bb.entities.Resposta;
import br.org.fiergs.piecbankingws.main.services.PaymentBilletFill;
import com.mashape.unirest.http.exceptions.UnirestException;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException, UnirestException {
        String clientID = "eyJpZCI6IjgwNDNiNTMtZjQ5Mi00YyIsImNvZGlnb1B1YmxpY2Fkb3IiOjEwOSwiY29kaWdvU29mdHdhcmUiOjEsInNlcXVlbmNpYWxJbnN0YWxhY2FvIjoxfQ";
        String clientSecret = "eyJpZCI6IjBjZDFlMGQtN2UyNC00MGQyLWI0YSIsImNvZGlnb1B1YmxpY2Fkb3IiOjEwOSwiY29kaWdvU29mdHdhcmUiOjEsInNlcXVlbmNpYWxJbnN0YWxhY2FvIjoxLCJzZXF1ZW5jaWFsQ3JlZGVuY2lhbCI6MX0";

        Resposta resp = PaymentBilletFill.registerBillet(clientID, clientSecret);

        if (resp.getCodigoBarraNumerico().isBlank()) {
            System.out.println("CÓD ERRO: " + resp.getCodigoRetornoPrograma());
            System.out.println("MSG ERRO: " + resp.getTextoMensagemErro());
        } else {
            System.out.println("CÓD BARRA: " + resp.getCodigoBarraNumerico());
            System.out.println("LINHA DIG: " + resp.getLinhaDigitavel());
        }
    }
}
