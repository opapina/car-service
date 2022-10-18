package com.solvd.carservice.domain.price;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DiscountProgram {

    private static final Logger LOGGER = LogManager.getLogger(DiscountProgram.class);

    private Long id;
    private String name;
    private Double discount;

    public void sendSales() {
        LOGGER.info("Send message about sales");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "DiscountProgram{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", discount=" + discount +
                '}';
    }
}
