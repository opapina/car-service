package com.solvd.carservice.domain.equipment.material;

import com.solvd.carservice.domain.equipment.MaterialForRepair;

import java.math.BigDecimal;

public class ThermalProtection extends MaterialForRepair {

    private Integer temperatureProtection;

    public ThermalProtection (String name, BigDecimal quantity, String unit, BigDecimal priceOfUnit, Integer temperatureProtection) {
        super(name, quantity, unit, priceOfUnit);
        this.temperatureProtection = temperatureProtection;
    }

    public ThermalProtection() {
    }

    public Integer getTemperatureProtection() {
        return temperatureProtection;
    }

    public void setTemperatureProtection(Integer temperatureProtection) {
        this.temperatureProtection = temperatureProtection;
    }
}
