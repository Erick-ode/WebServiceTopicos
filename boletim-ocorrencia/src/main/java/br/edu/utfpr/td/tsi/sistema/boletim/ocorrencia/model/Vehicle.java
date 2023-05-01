package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model;

public class Vehicle {

    private Integer year;
    private String color;
    private String brand;
    private String type;
    private Registration registration;

    public Integer getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }
}
