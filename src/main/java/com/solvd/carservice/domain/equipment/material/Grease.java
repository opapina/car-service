package com.solvd.carservice.domain.equipment.material;

import com.solvd.carservice.domain.equipment.MaterialForRepair;

public class Grease extends MaterialForRepair {

    private String type;

    public Grease (String name, Double quantity, String unit, Double priceOfUnit, String type) {
        super (name, quantity, unit, priceOfUnit);
        this.type = type;
    }

    public Grease(){
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
