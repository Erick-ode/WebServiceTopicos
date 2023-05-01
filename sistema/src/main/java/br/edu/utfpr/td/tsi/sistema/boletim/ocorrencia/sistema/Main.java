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

    @Autowired
    private PartManager partRules;
    @Autowired
    private InMemoryPartDAO partDao;
    @Autowired
    private InMemoryReportDAO reportDAO;
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @PostConstruct
    public void beginning(){
        //aqui começa a aplicação Spring
        Vehicle v = new Vehicle();
        Registration r = new Registration();
        Address a = new Address();
        Part p = new Part();
        StolenVehicleReport s = new StolenVehicleReport();

        r.setCity("Toledo");
        r.setPlate("AH234HH");
        r.setState("Parána");

        v.setBrand("Ford");
        v.setColor("Azul");
        v.setRegistration(r);
        v.setType("Carro");
        v.setYear(2019);

        a.setCity("Toledo");
        a.setState("Paraná");
        a.setDistrict("Centro");
        a.setNumber(145);
        a.setStreetName("Rua Barão do Rio Branco");

        p.setName("Mario Gomes");
        p.setPhone("99999999999");
        p.setEmail("marinhoDelicio@gmail.com");
        p.setTypeInvolvement("Dono");

        s.setId(1);
        LocalDate yesterday = LocalDate.now().plusDays(1);
        Instant instant = yesterday.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        s.setOccurrenceDate(Date.from(instant));
        s.setPart(p);
        s.setOccurrenceLocal(a);
        s.setStolenVehicle(v);
        s.setOccurrencePeriod("Manhã");

        reportDAO.register(s);
    }
}