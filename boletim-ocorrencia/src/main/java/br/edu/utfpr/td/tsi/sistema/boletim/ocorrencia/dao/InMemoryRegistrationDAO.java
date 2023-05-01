package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Registration;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRegistrationDAO implements RegistrationDAO{
    List<Registration> registrationsList = new ArrayList<>();
    @Override
    public void register(Registration registration) {
        this.registrationsList.add(registration);
    }

    @Override
    public Registration read(String plate) {
        return registrationsList.stream()
                .filter(registration -> registration.getPlate().equals(plate))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void remove(Registration registration) {
registrationsList.remove(registration);
    }

    @Override
    public List<Registration> readAll() {
        return registrationsList;
    }
}
