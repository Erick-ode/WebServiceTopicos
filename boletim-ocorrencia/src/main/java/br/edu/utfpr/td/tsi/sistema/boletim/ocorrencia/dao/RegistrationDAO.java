package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Registration;

import java.util.List;

public interface RegistrationDAO {

    public void register(Registration registration);
    public Registration read(String plate);
    public void remove(Registration registration);
    public List<Registration> readAll();
}
