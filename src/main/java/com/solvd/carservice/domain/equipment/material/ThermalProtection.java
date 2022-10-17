package com.solvd.carservice.domain.equipment.material;

import com.solvd.carservice.domain.equipment.MaterialForRepair;

public class ThermalProtection extends MaterialForRepair {

    private Integer temperatureProtection;

    public ThermalProtection (String name, Double quantity, String unit, Double priceOfUnit, Integer temperatureProtection) {
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
