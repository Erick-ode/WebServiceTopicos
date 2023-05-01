package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Part;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryPartDAO implements PartDAO {
    List<Part> registeredParts = new ArrayList<>();

    @Override
    public void register(Part part) {
        this.registeredParts.add(part);
    }

    @Override
    public Part read(String name) {
        return registeredParts.stream()
                .filter(part -> part.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void remove(Part part) {
        registeredParts.remove(part);
    }

    @Override
    public List<Part> readAll() {
        return registeredParts;
    }
}
