package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.sistema;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.business.PartManager;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.business.PartRules;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao.InMemoryPartDAO;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao.InMemoryReportDAO;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@SpringBootApplication
@ComponentScan("br.edu.utfpr.td.tsi.sistema")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run((Class)Main.class, args);
    }

}