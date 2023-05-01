package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.StolenVehicleReport;

import java.util.List;

public interface ReportDAO {

    public void register(StolenVehicleReport stolenVehicleReportort);
    public StolenVehicleReport read(int id);
    public void remove(int id);
    public List<StolenVehicleReport> readAll();
}
