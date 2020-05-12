package br.org.fiergs.piecbankingws.main.config;

import br.org.fiergs.piecbankingws.main.infrastructure.KafkaChannels;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(KafkaChannels.class)
public class KafkaConfig {
}
