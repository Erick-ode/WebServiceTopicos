package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.csv.FileReaderStolenVehicles;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.StolenVehicleReport;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Vehicle;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryVehicleDAO implements VehicleDAO {

    @Autowired
    FileReaderStolenVehicles fileReaderStolenVehicles;
    List<Vehicle> registeredVehicles = new ArrayList<>();

    @Override
    public void register(Vehicle vehicle) {
        this.registeredVehicles.add(vehicle);
    }

    @PostConstruct
    public void init(){
        final List<StolenVehicleReport> reports = new ArrayList<>(fileReaderStolenVehicles.getReports());
        for ( final StolenVehicleReport stolenVehicleReport : reports) {
            this.registeredVehicles.add(stolenVehicleReport.getStolenVehicle());
        }
    }

    @Override
    public Vehicle readByPlate(String plate) {
        return registeredVehicles.stream()
                .filter(vehicle -> vehicle.getRegistration().getPlate().equals(plate))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Vehicle> readByColor(String color) {
        List<Vehicle> listVehicles = new ArrayList<>();
        registeredVehicles.stream()
                .filter(vehicle -> vehicle.getColor().equals(color))
                .forEach(listVehicles::add);
        return listVehicles;
    }

    @Override
    public List<Vehicle> readByType(String type) {
        List<Vehicle> listVehicles = new ArrayList<>();
        registeredVehicles.stream()
                .filter(vehicle -> vehicle.getType().equals(type))
                .forEach(listVehicles::add);
        return listVehicles;
    }


    @Override
    public List<Vehicle> readAll() {
        return registeredVehicles;
    }
}
