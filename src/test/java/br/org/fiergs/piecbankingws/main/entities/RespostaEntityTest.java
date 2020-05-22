package br.org.fiergs.piecbankingws.main.entities;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class RespostaEntityTest {

    @Test
    void testToString1() {
        RespostaEntity resp = new RespostaEntity();
        resp.setSiglaSistemaMensagem("SDF");
        resp.setCodigoRetornoPrograma((short) 4);
        resp.setNomeProgramaErro("asdsd");
        resp.setTextoMensagemErro("aasdsda");
        resp.setNumeroPosicaoErroPrograma((short) 5);
        resp.setCodigoTipoRetornoPrograma((short) 5);
        resp.setTextoNumeroTituloCobrancaBb("dadf");
        resp.setNumeroCarteiraCobranca((short) 6);
        resp.setNumeroVariacaoCarteiraCobranca((short) 7);
        resp.setCodigoPrefixoDependenciaBeneficiario((short) 3);
        resp.setNumeroContaCorrenteBeneficiario(5);
        resp.setCodigoCliente(5);
        resp.setLinhaDigitavel("654646546546546546543218153198");
        resp.setCodigoBarraNumerico("5646545646548627817987981798798");
        resp.setCodigoTipoEnderecoBeneficiario((short) 5);
        resp.setNomeLogradouroBeneficiario("ahfdgfg");
        resp.setNomeBairroBeneficiario("asdefadf");
        resp.setNomeMunicipioBeneficiario("asfadsgadsg");
        resp.setCodigoMunicipioBeneficiario(5);
        resp.setSiglaUfBeneficiario("RS");
        resp.setCodigoCepBeneficiario(6845646);
        resp.setIndicadorComprovacaoBeneficiario("65");
        resp.setNumeroContratoCobranca(5);

        assertNotNull(resp.toString());
    }

    @Test
    void testEquals1() {
        RespostaEntity re = new ObjectFactory().createResposta();
        RespostaEntity re1 = new ObjectFactory().createResposta();

        assertEquals(re, re1);
    }

    @Test
    void testHashCode1() {
        RespostaEntity re = new ObjectFactory().createResposta();
        RespostaEntity re1 = new ObjectFactory().createResposta();

        assertEquals(re.hashCode(), re1.hashCode());
    }
}
