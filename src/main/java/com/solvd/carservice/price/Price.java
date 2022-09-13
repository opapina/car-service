package com.solvd.carservice.price;

import com.solvd.carservice.worktime.ServiceWorkTime;

import java.math.BigDecimal;

public class Price {

    private Long id;
    private ServiceWorkTime serviceWorkTime;
    private Boolean performedFlag;
    private BigDecimal materialPrice;
    private Double discount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ServiceWorkTime getWorkedTime() {
        return serviceWorkTime;
    }

    public void setWorkedTime(ServiceWorkTime serviceWorkTime) {
        this.serviceWorkTime = serviceWorkTime;
    }

    public Boolean getPerformedFlag() {
        return performedFlag;
    }

    public void setPerformedFlag(Boolean performedFlag) {
        this.performedFlag = performedFlag;
    }

    public BigDecimal getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(BigDecimal materialPrice) {
        this.materialPrice = materialPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
