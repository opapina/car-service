package com.solvd.carservice.domain.price;

import com.solvd.carservice.domain.equipment.MaterialForRepair;
import com.solvd.carservice.domain.service.Service;

import java.util.List;

public class Price {

    private Long id;
    private Boolean performedFlag;
    private List<Service> services;

    public Price (List<Service> services) {
        this.services = services;
    }

    /**
     * Facade for countPrice method
     * @return price amount in called place, and process of counting price is not available for user
     */

    public Double countPrice() {
        return countPriceService();
    }

    private Double countPriceService() {
        double priceService = 0;
        priceService += services.stream().mapToDouble(service -> service.getPriceOfHour() * service.getWorkTime()).sum();
        return priceService;
    }

    private Double countPriceMaterial() {
        double priceMaterial = 0;
        for (Service service : services) {
            List<MaterialForRepair> materialForRepairs = service.getMaterials();
            priceMaterial += materialForRepairs.stream().mapToDouble(materialForRepair -> materialForRepair.getPriceOfUnit() * materialForRepair.getQuantity()).sum();
        }
        return priceMaterial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getPerformedFlag() {
        return performedFlag;
    }

    public void setPerformedFlag(Boolean performedFlag) {
        this.performedFlag = performedFlag;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}