package com.solvd.carservice.domain.equipment.material;

import com.solvd.carservice.domain.equipment.MaterialForRepair;

import java.math.BigDecimal;

public class Grease extends MaterialForRepair {

    private String type;

    public Grease (String name, BigDecimal quantity, String unit, BigDecimal priceOfUnit, String type) {
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
