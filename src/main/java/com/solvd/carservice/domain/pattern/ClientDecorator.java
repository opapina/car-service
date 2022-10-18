package com.solvd.carservice.domain.pattern;

import com.solvd.carservice.domain.price.DiscountProgram;
import com.solvd.carservice.domain.vehicle.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientDecorator {

    private static final Logger LOGGER = LogManager.getLogger(ClientDecorator.class);

    private final DiscountProgram discountProgram;
    private final Car car;

    public ClientDecorator(DiscountProgram discountProgram, Car car) {
        this.discountProgram = discountProgram;
        this.car = car;
    }

    public void receiveSales() {
        LOGGER.info("Client receive message after: ");
        discountProgram.sendSales();
    }

    public void move() {
        LOGGER.info("Client move fast because hi is into car : ");
        car.move();
    }
}
