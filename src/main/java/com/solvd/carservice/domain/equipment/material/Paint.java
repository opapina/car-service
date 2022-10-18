package com.solvd.carservice.domain.equipment.material;

import com.solvd.carservice.domain.equipment.MaterialForRepair;
import com.solvd.carservice.domain.pattern.strategy.IMaterial;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Paint extends MaterialForRepair implements IMaterial {

    private static final Logger LOGGER = LogManager.getLogger(Paint.class);

    private String color;

    public Paint(String name, Double quantity, String unit, Double priceOfUnit, String color) {
        super (name, quantity, unit, priceOfUnit);
        this.color = color;
    }

    public Paint() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void put() {
        LOGGER.info("Paint put on car surface");
    }

    @Override
    public int dry() {
        return 3;
    }
}
