package com.solvd.carservice.domain.equipment.material;

import com.solvd.carservice.domain.equipment.MaterialForRepair;

public class Paint extends MaterialForRepair {

    private String color;

    public Paint(String name, Double quantity, String unit, Double priceOfUnit, String color) {
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
