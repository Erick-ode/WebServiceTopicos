package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.business;

import java.util.List;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Vehicle;

public interface VehicleRules {
    public List<Vehicle> readAll();
    public Vehicle readByPlate(String plate);
    public List<Vehicle> readByColor(String color);
    public List<Vehicle> readByType (String type);
}