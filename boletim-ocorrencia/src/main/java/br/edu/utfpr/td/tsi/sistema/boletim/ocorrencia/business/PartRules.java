package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.business;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Part;

public interface PartRules {

    public boolean isValidEmail(String email);
    public boolean isValidPhoneNumber(String phoneNumber);
    public String hideName(String name);
    public String hideEmail(String email);
    public String hidePhoneNumber(String phoneNumber);

    public void registerPart(Part part);
}
