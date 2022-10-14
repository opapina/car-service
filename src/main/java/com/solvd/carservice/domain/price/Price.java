package com.solvd.carservice.domain.price;

import com.solvd.carservice.domain.equipment.MaterialForRepair;
import com.solvd.carservice.domain.service.Service;

import java.math.BigDecimal;
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

    public BigDecimal countPrice() {
        return countPriceService().add(countPriceMaterial());
    }

    private BigDecimal countPriceService() {

        return (BigDecimal) services.stream()
                .map(service -> {
                    BigDecimal ps = service.getPriceOfHour().multiply(BigDecimal.valueOf(service.getWorkTime()));
                    BigDecimal priceService;
                    return priceService = BigDecimal.valueOf(1).add(ps);
                });
    }

    private BigDecimal countPriceMaterial() {
        return (BigDecimal) services.stream()
                .map(service -> {
                    List<MaterialForRepair> materialForRepairs = service.getMaterials();
                    return materialForRepairs.stream()
                            .map(materialForRepair -> {
                                BigDecimal priceMaterial;
                                BigDecimal mr = materialForRepair.getPriceOfUnit().multiply(materialForRepair.getQuantity());
                                priceMaterial = BigDecimal.valueOf(1).add(mr);
                                return priceMaterial;
                            });
                });
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
