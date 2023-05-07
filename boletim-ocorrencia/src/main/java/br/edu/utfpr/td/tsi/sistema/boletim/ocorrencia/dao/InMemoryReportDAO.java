package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.StolenVehicleReport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryReportDAO implements ReportDAO{
    List<StolenVehicleReport> incidentReports = new ArrayList<>();
    @Override
    public void register(StolenVehicleReport stolenVehicleReport) {
        incidentReports.add(stolenVehicleReport);
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
