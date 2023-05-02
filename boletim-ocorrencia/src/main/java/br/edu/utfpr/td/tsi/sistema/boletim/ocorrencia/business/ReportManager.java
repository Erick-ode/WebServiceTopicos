package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.business;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao.InMemoryReportDAO;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.StolenVehicleReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.DateTimeException;
import java.util.Date;
import java.util.List;

@Component
public class ReportManager implements ReportRules{
    @Autowired
    private InMemoryReportDAO reportDAO;

    @Override
    public void register(StolenVehicleReport report) {
        if (isDataValid(report.getOccurrenceDate())){
            reportDAO.register(report);
        }else {
            throw new DateTimeException("A data informada é maior que a data atual!");
        }
    }

    @Override
    public List<StolenVehicleReport> readAll() {
        return reportDAO.readAll();
    }

    @Override
    public void remove(int id) {
        reportDAO.remove(id);
    }


    public boolean isDataValid(Date reportDate){
        Date currentDate = new Date();
        return reportDate.before(currentDate) || reportDate.equals(currentDate);
    }
}
