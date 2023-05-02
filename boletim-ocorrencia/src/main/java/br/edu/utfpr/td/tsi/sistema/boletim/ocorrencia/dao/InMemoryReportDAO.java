package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.StolenVehicleReport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryReportDAO implements ReportDAO{
    List<StolenVehicleReport> incidentReports = new ArrayList<>();
    @Override
    public void register(StolenVehicleReport stolenVehicleReportort) {
        incidentReports.add(stolenVehicleReportort);
    }

    @Override
    public StolenVehicleReport read(int id) {
        return incidentReports.stream()
                .filter(report -> report.getId()== id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void remove(int id) {
        incidentReports.remove(id);
    }

    @Override
    public List<StolenVehicleReport> readAll() {
        return incidentReports;
    }
}
