package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.business;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao.InMemoryReportDAO;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.StolenVehicleReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;

@Component
public class ReportManager implements ReportRules {
    @Autowired
    private InMemoryReportDAO reportDAO;

    @Autowired
    private PartManager partManager;

    @Override
    public void register(StolenVehicleReport report) {
        if (isDataValid(report.getOccurrenceDate())) {
            report.setPart(partManager.hidePartInformations(report.getPart()));
            reportDAO.register(report);
        } else {
            throw new DateTimeException("A data informada é maior que a data atual!");
        }
    }

    @Override
    public void update(StolenVehicleReport report) {
        reportDAO.update(report);
    }

    @Override
    public List<StolenVehicleReport> readAll() {
        return reportDAO.readAll();
    }

    @Override
    public StolenVehicleReport readById(int id) {
        return reportDAO.readById(id);
    }

    @Override
    public List<StolenVehicleReport> readByCity(String city) {
        return reportDAO.readByCity(city);
    }

    @Override
    public List<StolenVehicleReport> readByDayTime(String dayTime) {
        return reportDAO.readByDayTime(dayTime);
    }

    @Override
    public void remove(int id) {
        reportDAO.remove(id);
    }


    public boolean isDataValid(LocalDate reportDate) {
        LocalDate currentDate = LocalDate.now();
        return reportDate.isBefore(currentDate) || reportDate.isEqual(currentDate);
    }
}
