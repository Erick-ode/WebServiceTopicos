package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Part;

import java.util.List;

public interface PartDAO {

    public void register(Part part);
    public Part read(String name);
    public void remove(Part part);
    public List<Part> readAll();
}
