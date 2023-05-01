package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.business;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao.InMemoryVehicleDAO;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleManger implements VehicleRules{

    @Autowired
    private InMemoryVehicleDAO vehicleDAO;
    @Override
    public void registerVehicle(Vehicle vehicle) {
        if (vehicleDAO.readAll().stream().anyMatch(v -> v.getRegistration().equals(vehicle.getRegistration()))) {
            throw new RuntimeException("Placa já registrada: " + vehicle.getRegistration().getPlate());
        }
        vehicleDAO.register(vehicle);
    }
}
