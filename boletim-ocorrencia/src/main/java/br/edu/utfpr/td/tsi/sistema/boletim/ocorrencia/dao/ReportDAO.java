package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.StolenVehicleReport;

import java.util.List;

public interface ReportDAO {

    public void register(StolenVehicleReport stolenVehicleReport);
    public void update(StolenVehicleReport stolenVehicleReport);

    public StolenVehicleReport readById(int id);
    public List<StolenVehicleReport> readByCity(String city);
    public List<StolenVehicleReport> readByDayTime(String dayTime);

    public void remove(int id);
    public List<StolenVehicleReport> readAll();
}
