package com.solvd.carservice.domain.equipment.material;

import com.solvd.carservice.domain.equipment.MaterialForRepair;
import com.solvd.carservice.domain.pattern.strategy.IMaterial;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThermalProtection extends MaterialForRepair implements IMaterial {

    private static final Logger LOGGER = LogManager.getLogger(ThermalProtection.class);

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

    @Override
    public void put() {
        LOGGER.info("Thermal protection was put");
    }

    @Override
    public int dry() {
        return 1;
    }
}
