package br.edu.utfpr.td.tsi.sistema.boletim.ocorrencia.model;

import java.util.Date;

public class StolenVehicleReport {

    private Integer id;
    private Date occurrenceDate;
    private String occurrenceDayTime;
    private Part part;
    private Address occurrenceLocal;
    private Vehicle stolenVehicle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOccurrenceDate() {
        return occurrenceDate;
    }

    public void setOccurrenceDate(Date occurrenceDate) {
        this.occurrenceDate = occurrenceDate;
    }

    public String getOccurrenceDayTime() {
        return occurrenceDayTime;
    }

    public void setOccurrencePeriod(String occurrencePeriod) {
        this.occurrenceDayTime = occurrencePeriod;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public Address getOccurrenceLocal() {
        return occurrenceLocal;
    }

    public void setOccurrenceLocal(Address occurrenceLocal) {
        this.occurrenceLocal = occurrenceLocal;
    }

    public Vehicle getStolenVehicle() {
        return stolenVehicle;
    }

    public void setStolenVehicle(Vehicle stolenVehicle) {
        this.stolenVehicle = stolenVehicle;
    }
}
