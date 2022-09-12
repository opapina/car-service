package com.solvd.carservice.price;

import com.solvd.carservice.worktime.WorkedTime;

import java.math.BigDecimal;

public class Price {

    private Long id;
    private WorkedTime workedTime;
    private Boolean performedFlag;
    private BigDecimal materialPrice;
    private Double discount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WorkedTime getWorkedTime() {
        return workedTime;
    }

    public void setWorkedTime(WorkedTime workedTime) {
        this.workedTime = workedTime;
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
