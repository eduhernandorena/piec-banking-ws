package br.org.fiergs.piecbankingws.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication
public class BankingWSApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankingWSApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() throws IOException {
        System.clearProperty("javax.net.ssl.trustStore");
        System.setProperty("javax.net.ssl.trustStoreType", "JKS");
        System.setProperty("javax.net.ssl.trustStore", String.valueOf(new ClassPathResource("ca/jssecacerts").getFile()));
        System.out.println(new ClassPathResource("ca/jssecacerts").getFile());

        return null;
    }

}
