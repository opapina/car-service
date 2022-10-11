package com.solvd.carservice.domain.equipment.material;

import com.solvd.carservice.domain.equipment.MaterialForRepair;

import java.math.BigDecimal;

public class EngineOil extends MaterialForRepair {

    private String engineType;

    public  EngineOil(String name, BigDecimal quantity, String unit, BigDecimal priceOfUnit, String engineType) {
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
