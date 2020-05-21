package br.org.fiergs.piecbankingws.main.controllers;

import br.org.fiergs.piecbankingws.main.entities.RequisicaoEntity;
import br.org.fiergs.piecbankingws.main.entities.RespostaEntity;
import br.org.fiergs.piecbankingws.main.services.BankSlipService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

@RestController
@RequestMapping(value = "/bankslip", produces = MediaType.APPLICATION_JSON_VALUE)
public class BankSlipController {

    /**
     * Método que registra um boleto no banco do brasil
     *
     * @param requisicaoEntity   boleto própriamente dito, objeto contendo as informações do boleto
     * @param environment  ambiente a ser utilizado, sendo 0 - Homologação e 1 - Produção
     * @param clientId     identificação do cliente
     * @param clientSecret secret key do cliente
     * @return uma resposta contendo os dados do boleto registrado ou o erro que foi gerado
     */
    @PostMapping(value = {"/register-billet", "/register-billet/"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespostaEntity registerBillet(@RequestBody RequisicaoEntity requisicaoEntity,
                                         @RequestHeader("environment") int environment,
                                         @RequestHeader("clientId") String clientId,
                                         @RequestHeader("clientSecret") String clientSecret) throws KeyManagementException, NoSuchAlgorithmException {
        return new BankSlipService(environment).registerBillet(clientId, clientSecret, requisicaoEntity);
    }
}
