package br.org.fiergs.piecbankingws.main.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErroEntityTest {

    @Test
    void getMensagem() {
        ErroEntity e = new ObjectFactory().createErro();
        e.setMensagem("Mensagem");

        assertNotNull(e.getMensagem());
    }
}
