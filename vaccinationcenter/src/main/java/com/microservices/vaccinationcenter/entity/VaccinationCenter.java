package com.microservices.vaccinationcenter.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VaccinationCenter {

    @Id
    private int vaccinationCenterId;
    private String centerName;
    private String centerAddress;

    public VaccinationCenter() {
    }

    public VaccinationCenter(int vaccinationCenterId, String centerName, String centerAddress) {
        this.vaccinationCenterId = vaccinationCenterId;
        this.centerName = centerName;
        this.centerAddress = centerAddress;
    }

    public int getVaccinationCenterId() {
        return vaccinationCenterId;
    }

    public void setVaccinationCenterId(int vaccinationCenterId) {
        this.vaccinationCenterId = vaccinationCenterId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterAddress() {
        return centerAddress;
    }

    public void setCenterAddress(String centerAddress) {
        this.centerAddress = centerAddress;
    }

    @Override
    public String toString() {
        return "VaccinationCenter{" +
                "vaccinationCenterId=" + vaccinationCenterId +
                ", centerName='" + centerName + '\'' +
                ", centerAddress='" + centerAddress + '\'' +
                '}';
    }
}
