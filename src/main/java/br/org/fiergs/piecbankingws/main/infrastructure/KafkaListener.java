package br.org.fiergs.piecbankingws.main.infrastructure;

import br.org.fiergs.piecbankingws.main.controllers.BankSlipController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

@Component
public class KafkaListener {

    @Autowired
    BankSlipController bankSlipController;
    /*
    CLASSE ENCARREGADA DE ENVIAR A REQUISIÇÃO PARA O SERVIÇO BANKSLIPSERVICE
     */

   // @StreamListener(KafkaChannels.GETBANKSLIP_INPUT)
   // public void getRegisterBilletHomolog() throws NoSuchAlgorithmException, KeyManagementException {
   //     bankSlipController.registerBilletHom();
    //}
}
