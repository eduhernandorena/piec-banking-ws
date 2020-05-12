package br.org.fiergs.piecbankingws.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

@SpringBootApplication
public class BankingWSApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankingWSApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() throws FileNotFoundException {
        System.clearProperty("javax.net.ssl.trustStore");
        System.setProperty("javax.net.ssl.trustStoreType", "JKS");
        System.setProperty("javax.net.ssl.trustStore", String.valueOf(ResourceUtils.getFile(
                "file:ca/jssecacerts")));
        System.out.println(ResourceUtils.getFile(
                "file:ca/jssecacerts"));

        return null;
    }

}
