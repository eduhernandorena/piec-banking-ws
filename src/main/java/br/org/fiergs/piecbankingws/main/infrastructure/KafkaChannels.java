package br.org.fiergs.piecbankingws.main.infrastructure;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface KafkaChannels {

    String GETBANKSLIP_INPUT = "piec-getbankslip";
    String SENDBANKSLIP_OUTPUT = "piec-sendbankslip";

    @Input(GETBANKSLIP_INPUT)
    MessageChannel getBankslipInput();

    @Output(SENDBANKSLIP_OUTPUT)
    MessageChannel sendBankslipOutput();
}
