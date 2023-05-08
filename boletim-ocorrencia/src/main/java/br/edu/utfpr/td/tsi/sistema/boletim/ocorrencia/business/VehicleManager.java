package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.business;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao.InMemoryVehicleDAO;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleManager implements VehicleRules{

    @Autowired
    private InMemoryVehicleDAO vehicleDAO;

    @Override
    public List<Vehicle> readAll() {
        return vehicleDAO.readAll();
    }

    @Override
    public Vehicle readByPlate(String plate) {
        return vehicleDAO.readByPlate(plate);
    }
    @Override
    public List<Vehicle> readByColor(String color) {
        return vehicleDAO.readByColor(color);
    }
    @Override
    public List<Vehicle> readByType(String type) {
        return vehicleDAO.readByType(type);
    }


}