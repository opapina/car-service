package com.solvd.carservice.domain.service;

import com.solvd.carservice.domain.equipment.MaterialForRepair;

import java.math.BigDecimal;
import java.util.List;

public class Service {

    private Long id;
    private Type name;
    private Double priceOfHour;
    private Integer workTime;
    private List<MaterialForRepair> materialForRepairs;

    public Service(Type name, Double priceOfHour, Integer workTime, List<MaterialForRepair> materialForRepairs) {
        this.name = name;
        this.priceOfHour = priceOfHour;
        this.workTime = workTime;
        this.materialForRepairs = materialForRepairs;

    }

    public enum Type {
        CARPAINTING("carPainting"), ENGINEMAINTENANCE("engineMaintenance"), ELECTRICALMAINTENANCE("electricalMaintenance"), SUSPENSIONMAINTENANCE("suspensionMaintenance");

        private final String displayName;

        Type(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getName() {
        return name;
    }

    public void setName(Type name) {
        this.name = name;
    }

    public Double getPriceOfHour() {
        return priceOfHour;
    }

    public void setPriceOfHour(Double priceOfHour) {
        this.priceOfHour = priceOfHour;
    }

    public Integer getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Integer workTime) {
        this.workTime = workTime;
    }

    public List<MaterialForRepair> getMaterials() {
        return materialForRepairs;
    }

    public void setMaterials(List<MaterialForRepair> materialForRepairs) {
        this.materialForRepairs = materialForRepairs;
    }
}
