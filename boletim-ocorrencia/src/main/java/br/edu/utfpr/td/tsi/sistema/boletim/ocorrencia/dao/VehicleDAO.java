package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Registration;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Vehicle;

import java.util.List;

public interface VehicleDAO {

    public void register(Vehicle vehicle);
    public Vehicle read(Registration registration);
    public Vehicle readByPlate(String plate);
    public Vehicle readByColor(String color);
    public Vehicle readByType (String type);
    public void remove(Vehicle vehicle);
    public List<Vehicle> readAll();
    
    
}
