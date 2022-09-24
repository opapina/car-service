package com.solvd.carservice.persistence;

import com.solvd.carservice.domain.price.DiscountProgram;

public interface DiscountProgramRepository {

    void create(DiscountProgram discountProgram);

}
