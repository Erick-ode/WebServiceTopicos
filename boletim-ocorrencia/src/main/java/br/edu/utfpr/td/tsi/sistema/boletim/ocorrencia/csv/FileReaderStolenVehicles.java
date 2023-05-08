package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.csv;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Address;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Registration;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.StolenVehicleReport;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Vehicle;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class FileReaderStolenVehicles {
    private final List<StolenVehicleReport> reports;

    public FileReaderStolenVehicles() {
        this.reports = this.readCSVFile();
    }

    public List<StolenVehicleReport> getReports() {
        return reports;
    }

    private List<StolenVehicleReport> readCSVFile() {
        final List<StolenVehicleReport> listOfReports = new ArrayList<>();
        try {
            CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().withDelimiter('\t').parse(new FileReader("furtos.csv"));
            final List<CSVRecord> records = (List<CSVRecord>)csvParser.getRecords();

            for (CSVRecord record : records) {
                Vehicle stolenVehicle = createVehicle(record);
                StolenVehicleReport vehicleReport = createVehicleReport(record);

                vehicleReport.setStolenVehicle(stolenVehicle);
                listOfReports.add(vehicleReport);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listOfReports;
    }

    private static Vehicle createVehicle(CSVRecord record) {
        Registration registration = new Registration();
        Vehicle vehicle = new Vehicle();

        registration.setState(record.get("UF_VEICULO"));
        registration.setPlate(record.get("PLACA_VEICULO"));
        registration.setCity(record.get("CIDADE_VEICULO"));

        vehicle.setRegistration(registration);
        int year = 0;
        try{
            year = Integer.parseInt(record.get("ANO_FABRICACAO"));
        }catch (NumberFormatException e){
            year = 0;
        }
        vehicle.setYear(year);
        vehicle.setType(record.get("DESCR_TIPO_VEICULO"));
        vehicle.setColor(record.get("DESCR_COR_VEICULO"));
        vehicle.setBrand(record.get("DESCR_MARCA_VEICULO"));

        return vehicle;
    }


    private static StolenVehicleReport createVehicleReport(CSVRecord record) {
        String occurrenceDateString = record.get("DATAOCORRENCIA");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate occurrenceDate = LocalDate.parse(occurrenceDateString, dateTimeFormatter);

        Address address = new Address();
        address.setStreetName(record.get("LOGRADOURO"));
        address.setNumber(Integer.valueOf(record.get("NUMERO")));
        address.setDistrict(record.get("BAIRRO"));
        address.setCity(record.get("CIDADE"));
        address.setState(record.get("UF"));

        StolenVehicleReport report = new StolenVehicleReport();
        Random random = new Random();
        report.setId(random.nextInt(1000) + 1000);
        report.setOccurrenceDate(occurrenceDate);
        report.setOccurrenceLocal(address);
        report.setOccurrenceDayTime(record.get("PERIDOOCORRENCIA"));

        return report;
    }

}
