package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.business;

import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.dao.InMemoryPartDAO;
import br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PartManager implements PartRules{

    @Autowired
    private InMemoryPartDAO partDAO;
    @Override
    public boolean isValidEmail(String email) {
        String regex = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        }else{
            throw new RuntimeException("E-mail inválido");
        }
    }

    @Override
    public boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^\\+?[0-9]{10,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.matches()) {
            return true;
        }else{
            throw new RuntimeException("Telefone inválido");
        }
    }

    @Override
    public String hideName(String name) {
        String[] names = name.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < names.length; i++) {
            if (i == names.length - 1) {
                result.append(names[i].substring(0, 1));
                for (int j = 1; j < names[i].length(); j++) {
                    result.append("*");
                }
            } else {
                result.append(names[i]).append(" ");
            }
        }
        return result.toString();
    }

    @Override
    public String hideEmail(String email){
        int atIndex = email.indexOf('@');
        if (atIndex > 2) {
            String firstPart = email.substring(0, 2);
            String secondPart = email.substring(atIndex);
            return firstPart + "****" + secondPart;
        } else {
            return "Email inválido.";
        }
    }

    @Override
    public String hidePhoneNumber(String phoneNumber){
        phoneNumber = phoneNumber.replaceAll("[^0-9]", "");
        int length = phoneNumber.length();
        if (length > 4) {
            String lastFourDigits = phoneNumber.substring(length - 4);
            String digitsToHide = phoneNumber.substring(0, length - 4);
            String hiddenDigits = digitsToHide.replaceAll(".", "*");
            return hiddenDigits + lastFourDigits;
        } else {
            return "Número de telefone inválido.";
        }
    }

    @Override
    public void registerPart(Part part) {
        if (isValidEmail(part.getEmail()) && isValidPhoneNumber(part.getPhone()))
            partDAO.register(hidePartInformations(part));
    }

    public Part hidePartInformations(Part part){
        part.setName(this.hideName(part.getName()));
        part.setPhone(this.hidePhoneNumber(part.getPhone()));
        part.setEmail(this.hideEmail(part.getEmail()));
        return part;
    }
}
