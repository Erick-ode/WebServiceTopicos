package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.business;

import java.util.List;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Vehicle;

public interface VehicleRules {
    public void registerVehicle(Vehicle vehicle);
    public List<Vehicle> readAll();
    public Vehicle readByPlate(String plate);
    public Vehicle readByColor(String color);
    public Vehicle readByType (String type);
}
