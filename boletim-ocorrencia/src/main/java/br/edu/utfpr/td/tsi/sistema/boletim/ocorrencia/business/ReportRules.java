package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.business;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.StolenVehicleReport;

import java.util.List;

public interface ReportRules {
    public void register(StolenVehicleReport report);

    public List<StolenVehicleReport> readAll();

    public void remove(int id);
}
