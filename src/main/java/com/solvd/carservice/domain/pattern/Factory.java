package com.solvd.carservice.domain.pattern;

import com.solvd.carservice.domain.equipment.MaterialForRepair;
import com.solvd.carservice.domain.equipment.material.EngineOil;
import com.solvd.carservice.domain.equipment.material.Grease;
import com.solvd.carservice.domain.equipment.material.Paint;
import com.solvd.carservice.domain.equipment.material.ThermalProtection;
import com.solvd.carservice.domain.service.Service;

import java.math.BigDecimal;

public class Factory {

    public static MaterialForRepair getMaterial (Service.Type serviceType) {
        MaterialForRepair materialForRepair = null;
        switch (serviceType) {
            case CARPAINTING:
                materialForRepair = new Paint("carpaint", BigDecimal.valueOf(200.45), "mL", BigDecimal.valueOf(46.56), "red");
                break;
            case ENGINEMAINTENANCE:
                materialForRepair = new EngineOil("Shell", BigDecimal.valueOf(5.65),"L", BigDecimal.valueOf(25.30), "diesel");
                break;
            case ELECTRICALMAINTENANCE:
                materialForRepair = new ThermalProtection("TP", BigDecimal.valueOf(4.78), "mG", BigDecimal.valueOf(1.34), 250);
                break;
            case SUSPENSIONMAINTENANCE:
                materialForRepair = new Grease("PG", BigDecimal.valueOf(5.66), "mG", BigDecimal.valueOf(0.79), "lanolin");
            default:
                materialForRepair = null;
        }
        return materialForRepair;
    }
}
