package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.business;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao.InMemoryVehicleDAO;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleManager implements VehicleRules{
	
	List<Vehicle> registeredsVehicles = new ArrayList<>();
	
    @Autowired
    private InMemoryVehicleDAO vehicleDAO;
    @Override
    public void registerVehicle(Vehicle vehicle) {
        if (vehicleDAO.readAll().stream().anyMatch(v -> v.getRegistration().equals(vehicle.getRegistration()))) {
            throw new RuntimeException("Placa já registrada: " + vehicle.getRegistration().getPlate());
        }
        vehicleDAO.register(vehicle);
    }
    
	@Override
	public List<Vehicle> readAll() {
        return registeredsVehicles;
    }
	
	@Override
	public Vehicle readByPlate(String plate) {
		return registeredsVehicles.stream()
				.filter(vehicle -> vehicle.getRegistration().getPlate().equals(plate))
				.findFirst()
				.orElse(null);
	}
	@Override
	public Vehicle readByColor(String color) {
		return registeredsVehicles.stream()
				.filter(vehicle -> vehicle.getColor().equals(color))
				.findFirst()
				.orElse(null);
	}
	@Override
	public Vehicle readByType(String type) {
		return registeredsVehicles.stream()
				.filter(vehicle -> vehicle.getType().equals(type))
				.findFirst()
				.orElse(null);
	}

    	
}
