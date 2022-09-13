package com.solvd.carservice.price;

import com.solvd.carservice.equipment.Material;
import com.solvd.carservice.worktime.ServiceWorkTime;

import java.util.List;

public class Price {

    private Long id;
    private ServiceWorkTime serviceWorkTime;
    private Boolean performedFlag;
    private List<Material> materials;
    private List<DiscountProgram> discounts;

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

    public ServiceWorkTime getServiceWorkTime() {
        return serviceWorkTime;
    }

    public void setServiceWorkTime(ServiceWorkTime serviceWorkTime) {
        this.serviceWorkTime = serviceWorkTime;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public List<DiscountProgram> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<DiscountProgram> discounts) {
        this.discounts = discounts;
    }
}
