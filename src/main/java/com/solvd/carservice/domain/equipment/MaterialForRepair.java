package com.solvd.carservice.domain.equipment;

import java.math.BigDecimal;

public abstract class MaterialForRepair {

    private Long id;
    private String name;
    private BigDecimal quantity;
    private String unit;
    private BigDecimal priceOfUnit;

    public MaterialForRepair(String name, BigDecimal quantity, String unit, BigDecimal priceOfUnit) {
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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getPriceOfUnit() {
        return priceOfUnit;
    }

    public void setPriceOfUnit(BigDecimal priceOfUnit) {
        this.priceOfUnit = priceOfUnit;
    }
}
