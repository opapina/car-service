package com.solvd.carservice.domain.equipment;

import java.math.BigDecimal;

public abstract class MaterialForRepair {

    private Long id;
    private String name;
    private Double quantity;
    private String unit;
    private Double priceOfUnit;

    public MaterialForRepair(String name, Double quantity, String unit, Double priceOfUnit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.priceOfUnit = priceOfUnit;
    }

    public MaterialForRepair() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getPriceOfUnit() {
        return priceOfUnit;
    }

    public void setPriceOfUnit(Double priceOfUnit) {
        this.priceOfUnit = priceOfUnit;
    }
}
