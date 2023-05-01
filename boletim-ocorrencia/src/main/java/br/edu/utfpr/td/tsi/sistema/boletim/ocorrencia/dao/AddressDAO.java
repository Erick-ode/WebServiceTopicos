package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Address;

import java.util.List;

public interface AddressDAO {

    public void register(Address address);
    public Address read(Integer number);
    public void remove(Address address);
    public List<Address> readAll();
}
