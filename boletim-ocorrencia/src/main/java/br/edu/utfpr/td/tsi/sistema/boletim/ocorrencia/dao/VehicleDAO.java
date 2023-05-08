package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Vehicle;

import java.util.List;

public interface VehicleDAO {

    public void register(Vehicle vehicle);
    public Vehicle readByPlate(String plate);

    public List<Vehicle> readByColor(String color);
    public List<Vehicle> readByType (String type);
    public List<Vehicle> readAll();
}
