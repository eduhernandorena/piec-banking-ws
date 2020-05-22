package br.org.fiergs.piecbankingws.main.services;

import br.org.fiergs.piecbankingws.main.entities.RequisicaoEntity;
import br.org.fiergs.piecbankingws.main.entities.RespostaEntity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BankSlipServiceTest {

    @Test
    void registerBillet() throws KeyManagementException, NoSuchAlgorithmException {
        String clientID = "eyJpZCI6IjgwNDNiNTMtZjQ5Mi00YyIsImNvZGlnb1B1YmxpY2Fkb3IiOjEwOSwiY29kaWdvU29mdHdhcmUiOjEsInNlcXVlbmNpYWxJbnN0YWxhY2FvIjoxfQ";
        String clientSecret = "eyJpZCI6IjBjZDFlMGQtN2UyNC00MGQyLWI0YSIsImNvZGlnb1B1YmxpY2Fkb3IiOjEwOSwiY29kaWdvU29mdHdhcmUiOjEsInNlcXVlbmNpYWxJbnN0YWxhY2FvIjoxLCJzZXF1ZW5jaWFsQ3JlZGVuY2lhbCI6MX0";

        RequisicaoEntity requisicaoEntity = new RequisicaoEntity();
        requisicaoEntity.setNumeroConvenio(3248778);
        requisicaoEntity.setNumeroCarteira((short) 17);
        requisicaoEntity.setNumeroVariacaoCarteira((short) 434);
        requisicaoEntity.setCodigoModalidadeTitulo((short) 1);
        requisicaoEntity.setDataEmissaoTitulo("01.03.2020");
        requisicaoEntity.setDataVencimentoTitulo("21.11.2020");
        requisicaoEntity.setValorOriginalTitulo(new BigDecimal(30000));
        requisicaoEntity.setCodigoTipoMulta((short) 0);
        requisicaoEntity.setCodigoAceiteTitulo("N");
        requisicaoEntity.setCodigoTipoTitulo((short) 2);
        requisicaoEntity.setIndicadorPermissaoRecebimentoParcial("N");
        requisicaoEntity.setTextoNumeroTituloCliente("00032487780000009003");
        requisicaoEntity.setCodigoTipoInscricaoPagador((short) 2);
        requisicaoEntity.setNumeroInscricaoPagador(73400584000166L);
        requisicaoEntity.setNomePagador("MERCADO ANDREAZA DE MACEDO");
        requisicaoEntity.setTextoEnderecoPagador("RUA SEM NOME");
        requisicaoEntity.setNumeroCepPagador(12345678);
        requisicaoEntity.setNomeMunicipioPagador("BRASILIA");
        requisicaoEntity.setNomeBairroPagador("SIA");
        requisicaoEntity.setSiglaUfPagador("DF");
        requisicaoEntity.setTextoNumeroTelefonePagador("45619988");
        requisicaoEntity.setCodigoChaveUsuario("J1234567");
        requisicaoEntity.setCodigoTipoCanalSolicitacao((short) 5);
        System.out.println(requisicaoEntity);

        RespostaEntity resp = new BankSlipService(0).registerBillet(clientID, clientSecret, requisicaoEntity);
        System.out.println(resp.toString());

        assertNotNull(resp);
    }
}
