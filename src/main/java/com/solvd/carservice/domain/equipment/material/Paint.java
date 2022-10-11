package com.solvd.carservice.domain.equipment.material;

import com.solvd.carservice.domain.equipment.MaterialForRepair;

import java.math.BigDecimal;

public class Paint extends MaterialForRepair {

    private String color;

    public Paint(String name, BigDecimal quantity, String unit, BigDecimal priceOfUnit, String color) {
        super (name, quantity, unit, priceOfUnit);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
