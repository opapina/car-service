package com.solvd.carservice.domain.equipment.material;

import com.solvd.carservice.domain.equipment.MaterialForRepair;

public class EngineOil extends MaterialForRepair {

    private String engineType;

    public  EngineOil(String name, Double quantity, String unit, Double priceOfUnit, String engineType) {
        super(name, quantity, unit, priceOfUnit);
        this.engineType = engineType;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}
