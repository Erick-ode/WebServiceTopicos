package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.business;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.StolenVehicleReport;

import java.util.List;

public interface ReportRules {
    public void register(StolenVehicleReport report);

    public List<StolenVehicleReport> readAll();
    public StolenVehicleReport readById(int id);
    public List<StolenVehicleReport> readByCity(String city);
    public List<StolenVehicleReport> readByDayTime(String dayTime);
    public void remove(int id);
}
