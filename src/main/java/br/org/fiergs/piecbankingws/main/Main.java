package br.org.fiergs.piecbankingws.main;

import br.org.fiergs.cobranca.bb.entities.Requisicao;
import br.org.fiergs.cobranca.bb.entities.Resposta;
import br.org.fiergs.piecbankingws.main.services.BankSlipService;
import br.org.fiergs.piecbankingws.main.utils.Util;
import com.mashape.unirest.http.exceptions.UnirestException;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException, UnirestException {
        String clientID = "eyJpZCI6IjgwNDNiNTMtZjQ5Mi00YyIsImNvZGlnb1B1YmxpY2Fkb3IiOjEwOSwiY29kaWdvU29mdHdhcmUiOjEsInNlcXVlbmNpYWxJbnN0YWxhY2FvIjoxfQ";
        String clientSecret = "eyJpZCI6IjBjZDFlMGQtN2UyNC00MGQyLWI0YSIsImNvZGlnb1B1YmxpY2Fkb3IiOjEwOSwiY29kaWdvU29mdHdhcmUiOjEsInNlcXVlbmNpYWxJbnN0YWxhY2FvIjoxLCJzZXF1ZW5jaWFsQ3JlZGVuY2lhbCI6MX0";

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

        Resposta resp = BankSlipService.registerBillet(clientID, clientSecret, requisicao);

        if (resp.getCodigoBarraNumerico().isBlank()) {
            System.out.println("CÓD ERRO: " + resp.getCodigoRetornoPrograma());
            System.out.println("MSG ERRO: " + resp.getTextoMensagemErro());
        } else {
            System.out.println("CÓD BARRA: " + resp.getCodigoBarraNumerico());
            System.out.println("LINHA DIG: " + resp.getLinhaDigitavel());
        }
    }
}
