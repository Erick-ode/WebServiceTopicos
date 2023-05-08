package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.csv;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Address;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Registration;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.StolenVehicleReport;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Vehicle;
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

        try (BufferedReader br = new BufferedReader(new FileReader("furtos.csv"))) {
            String line;
            String[] headerNames = br.readLine().split("\t");
            List<String> headers = new ArrayList<>(Arrays.asList(headerNames));
            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\t");
                Vehicle stolenVehicle = this.createVehicle(columns, headers);
                StolenVehicleReport vehicleReport = this.createVehicleReport(columns, headers);

                vehicleReport.setStolenVehicle(stolenVehicle);
                listOfReports.add(vehicleReport);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listOfReports;
    }

    private Vehicle createVehicle(String[] data, List<String> headers) {
        Registration registration = new Registration();

        registration.setState(data[headers.indexOf("UF_VEICULO")]);
        registration.setPlate(data[headers.indexOf("PLACA_VEICULO")]);
        registration.setCity(data[headers.indexOf("CIDADE_VEICULO")]);

        Vehicle vehicle = new Vehicle();

        vehicle.setRegistration(registration);
        vehicle.setYear(Integer.valueOf(data[headers.indexOf("ANO_FABRICACAO")]));
        vehicle.setType(data[headers.indexOf("DESCR_TIPO_VEICULO")]);
        vehicle.setColor(data[headers.indexOf("DESCR_COR_VEICULO")]);
        vehicle.setBrand(data[headers.indexOf("DESCR_MARCA_VEICULO")]);

        return vehicle;
    }

    private StolenVehicleReport createVehicleReport(String[] data, List<String> headers) {
        String occuranceDateString = data[headers.indexOf("DATAOCORRENCIA")];
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate occuranceDate = LocalDate.parse(occuranceDateString, dateTimeFormatter);

        Address address = new Address();
        address.setStreetName(data[headers.indexOf("LOGRADOURO")]);
        address.setNumber(Integer.valueOf(data[headers.indexOf("NUMERO")]));
        address.setDistrict(data[headers.indexOf("BAIRRO")]);
        address.setCity(data[headers.indexOf("CIDADE")]);
        address.setState(data[headers.indexOf("UF")]);

        StolenVehicleReport report = new StolenVehicleReport();
        Random rdm = new Random();
        report.setId(rdm.nextInt(1) + 1000);
        report.setOccurrenceDate(occuranceDate);
        report.setOccurrenceLocal(address);
        report.setOccurrenceDayTime(data[headers.indexOf("PERIDOOCORRENCIA")]);

        return report;

    }
}
