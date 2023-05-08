package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.csv.FileReaderStolenVehicles;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.StolenVehicleReport;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryReportDAO implements ReportDAO {

    @Autowired
    private FileReaderStolenVehicles fileReaderStolenVehicles;
    List<StolenVehicleReport> incidentReports;


    @PostConstruct
    public void init(){
        incidentReports = new ArrayList<>(fileReaderStolenVehicles.getReports());
    }

    @Override
    public void register(StolenVehicleReport stolenVehicleReport) {
        incidentReports.add(stolenVehicleReport);
    }

    @Override
    public void update(StolenVehicleReport stolenVehicleReport) {
        StolenVehicleReport existingReport = this.readById(stolenVehicleReport.getId());

        existingReport.setOccurrenceDate(stolenVehicleReport.getOccurrenceDate());
        existingReport.setOccurrenceLocal(stolenVehicleReport.getOccurrenceLocal());
        existingReport.setOccurrenceDayTime(stolenVehicleReport.getOccurrenceDayTime());
        existingReport.setStolenVehicle(stolenVehicleReport.getStolenVehicle());
    }

    @Override
    public StolenVehicleReport readById(int id) {
        return incidentReports.stream()
                .filter(report -> report.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<StolenVehicleReport> readByCity(String city) {
        final List<StolenVehicleReport> listReports = new ArrayList<>();
        incidentReports.stream()
                .filter(report -> report.getOccurrenceLocal().getCity().equals(city))
                .forEach(listReports::add);
        return listReports;
    }

    @Override
    public List<StolenVehicleReport> readByDayTime(String dayTime) {
        final List<StolenVehicleReport> listReports = new ArrayList<>();

        incidentReports.stream()
                .filter(report -> report.getOccurrenceDayTime().equals(dayTime))
                .forEach(listReports::add);
        return listReports;
    }

    @Override
    public void remove(int id) {
        incidentReports.remove(incidentReports.indexOf(this.readById(id)));
    }

    @Override
    public List<StolenVehicleReport> readAll() {
        return incidentReports;
    }
}
