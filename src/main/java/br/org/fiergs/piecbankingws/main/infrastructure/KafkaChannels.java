package br.org.fiergs.piecbankingws.main.infrastructure;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface KafkaChannels {

    String GETBANKSLIP_INPUT = "piec-getbankslip";

    @Input(GETBANKSLIP_INPUT)
    MessageChannel bankSlipInput();
}
