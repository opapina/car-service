package com.solvd.carservice.domain.pattern;

import com.solvd.carservice.domain.equipment.MaterialForRepair;
import com.solvd.carservice.domain.equipment.material.Paint;
import com.solvd.carservice.domain.service.Service;

public class Factory {

    public static MaterialForRepair getMaterial (Service.Type serviceType) {
        MaterialForRepair materialForRepair = null;
        switch (serviceType) {
            case CARPAINTING:
                materialForRepair = new Paint("red", "carpaint", 45.56);
                break;
            case ENGINEMAINTENANCE:
                materialForRepair = new MaterialForRepair();
                break;
            case ELECTRICALMAINTENANCE:
                materialForRepair = new MaterialForRepair();
                break;
            case SUSPENSIONMAINTENANCE:
                materialForRepair = new MaterialForRepair();
            default:
                materialForRepair = null;
        }
    }
}
