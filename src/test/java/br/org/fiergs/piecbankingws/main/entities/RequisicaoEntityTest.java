package br.org.fiergs.piecbankingws.main.entities;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class RequisicaoEntityTest {

    @Test
    void testToString() {
        RequisicaoEntity requisicaoEntity = new RequisicaoEntity();
        requisicaoEntity.setCodigoTipoContaCaucao(((short) 4));
        requisicaoEntity.setCodigoTipoDesconto((short) 4);
        requisicaoEntity.setCodigoTipoJuroMora((short) 4);
        requisicaoEntity.setDataDescontoTitulo("01.03.2020");
        requisicaoEntity.setDataMultaTitulo("01.03.2020");
        requisicaoEntity.setQuantidadeDiaProtesto((short) 1);
        requisicaoEntity.setPercentualDescontoTitulo(new BigDecimal(0));
        requisicaoEntity.setPercentualJuroMoraTitulo(new BigDecimal(0));
        requisicaoEntity.setValorAbatimentoTitulo(new BigDecimal(0));
        requisicaoEntity.setValorMultaTitulo(new BigDecimal(0));
        requisicaoEntity.setValorDescontoTitulo(new BigDecimal(0));
        requisicaoEntity.setValorJuroMoraTitulo(new BigDecimal(0));
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
        requisicaoEntity.setCodigoTipoInscricaoAvalista((short) 2);
        requisicaoEntity.setNomeAvalistaTitulo("Eu");
        requisicaoEntity.setNumeroInscricaoAvalista(101032000156L);
        requisicaoEntity.setPercentualMultaTitulo(new BigDecimal(0));
        requisicaoEntity.setTextoDescricaoTipoTitulo("ddds");
        requisicaoEntity.setTextoNumeroTituloBeneficiario("ddsdf");
        requisicaoEntity.setTextoCampoUtilizacaoBeneficiario("adsdgsfds");
        requisicaoEntity.setTextoMensagemBloquetoOcorrencia("asdddsdgsfds");

        assertNotNull(requisicaoEntity.toString());
    }

    @Test
    void testEquals() {
        RequisicaoEntity re = new ObjectFactory().createRequisicao();
        RequisicaoEntity re1 = new ObjectFactory().createRequisicao();

        assertEquals(re, re1);
    }

    @Test
    void testHashCode() {
        RequisicaoEntity re = new ObjectFactory().createRequisicao();
        RequisicaoEntity re1 = new ObjectFactory().createRequisicao();

        assertEquals(re.hashCode(), re1.hashCode());
    }
}
