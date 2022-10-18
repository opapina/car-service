package com.solvd.carservice.domain.pattern;

import com.solvd.carservice.domain.equipment.MaterialForRepair;
import com.solvd.carservice.domain.equipment.material.EngineOil;
import com.solvd.carservice.domain.equipment.material.Grease;
import com.solvd.carservice.domain.equipment.material.Paint;
import com.solvd.carservice.domain.equipment.material.ThermalProtection;
import com.solvd.carservice.domain.service.Service;

/**
 * This factory allows to add necessary material for repair car according to type of service
 * @see Service #Type
 * In DB all type of service work is constants, and if some of service type was selected, the material
 * for the corresponding service  will be created automatically
 */

public class Factory {

    public static MaterialForRepair getMaterial (Service.Type serviceType) {
        MaterialForRepair materialForRepair;
        switch (serviceType) {
            case CARPAINTING:
                materialForRepair = new Paint("carpaint",200.45, "mL", 46.56, "red");
                break;
            case ENGINEMAINTENANCE:
                materialForRepair = new EngineOil("Shell",5.65,"L", 25.30, "diesel");
                break;
            case ELECTRICALMAINTENANCE:
                materialForRepair = new ThermalProtection("TP",4.78, "mG", 1.34, 250);
                break;
            case SUSPENSIONMAINTENANCE:
                materialForRepair = new Grease("PG", 5.66, "mG", 0.79, "lanolin");
            default:
                materialForRepair = null;
        }
        return materialForRepair;
    }
}
