package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.sistema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.edu.utfpr.td.tsi.sistema")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run((Class)Main.class, args);
    }
}