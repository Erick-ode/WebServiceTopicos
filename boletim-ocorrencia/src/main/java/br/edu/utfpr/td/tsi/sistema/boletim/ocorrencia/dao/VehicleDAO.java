package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Registration;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Vehicle;

import java.util.List;

public interface VehicleDAO {

    public void register(Vehicle vehicle);
    public Vehicle read(Registration registration);
    public void remove(Vehicle vehicle);
    public List<Vehicle> readAll();
}
