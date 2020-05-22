package br.org.fiergs.piecbankingws.main.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RootEntityTest {

    @Test
    void getRequisicaoEntity() {
        RootEntity re = new ObjectFactory().createRoot();
        re.setRequisicaoEntity(new ObjectFactory().createRequisicao());

        assertNotNull(re.getRequisicaoEntity());
    }

    @Test
    void getRespostaEntity() {
        RootEntity re = new ObjectFactory().createRoot();
        re.setRespostaEntity(new ObjectFactory().createResposta());

        assertNotNull(re.getRespostaEntity());
    }

    @Test
    void getErroEntity() {
        RootEntity re = new ObjectFactory().createRoot();
        re.setErroEntity(new ObjectFactory().createErro());

        assertNotNull(re.getErroEntity());
    }
}
