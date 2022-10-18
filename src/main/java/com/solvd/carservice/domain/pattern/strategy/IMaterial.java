package com.solvd.carservice.domain.pattern.strategy;

/**
 * This interface for strategy pattern. It allows to change material in working process
 */

public interface IMaterial {

    void put();

    int dry();

}
