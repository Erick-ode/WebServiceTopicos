package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Registration;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Vehicle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryVehicleDAO implements VehicleDAO {

    List<Vehicle> registeredsVehicles = new ArrayList<>();

    @Override
    public void register(Vehicle vehicle) {
        this.registeredsVehicles.add(vehicle);
    }

    @Override
    public Vehicle read(Registration registration) {
        return registeredsVehicles.stream()
                .filter(vehicle -> vehicle.getRegistration().equals(registration))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void remove(Vehicle vehicle) {
        registeredsVehicles.remove(vehicle);
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
