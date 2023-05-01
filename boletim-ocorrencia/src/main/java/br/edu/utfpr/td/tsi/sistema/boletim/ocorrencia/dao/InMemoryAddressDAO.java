package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Address;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAddressDAO implements AddressDAO {

    List<Address> registeredAddresses = new ArrayList<>();

    @Override
    public void register(Address address) {
        this.registeredAddresses.add(address);
    }

    @Override
    public Address read(Integer number) {
        return registeredAddresses.stream()
                .filter(address -> address.getNumber().equals(number))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void remove(Address address) {
        registeredAddresses.remove(address);
    }

    @Override
    public List<Address> readAll() {
        return registeredAddresses;
    }
}
