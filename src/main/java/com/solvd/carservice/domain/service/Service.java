package com.solvd.carservice.domain.service;

import com.solvd.carservice.domain.equipment.Material;
import com.solvd.carservice.domain.price.Price;

import java.math.BigDecimal;
import java.util.List;

public class Service {

    private Long id;
    private Type name;
    private BigDecimal priceOfHour;
    private Integer workTime;
    private Price price;
    private List<Material> materials;

    public enum Type {
        CARPAINTING("carPainting"), ENGINEMAINTENANCE("engineMaintenance"), ELECTRICALMAINTENANCE("electricalMaintenance"), SUSPENSIONMAINTENANCE("suspensionMaintenance");

        private final String displayName;

        Type(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getName() {
        return name;
    }

    public void setName(Type name) {
        this.name = name;
    }

    public BigDecimal getPriceOfHour() {
        return priceOfHour;
    }

    public void setPriceOfHour(BigDecimal priceOfHour) {
        this.priceOfHour = priceOfHour;
    }

    public Integer getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Integer workTime) {
        this.workTime = workTime;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
