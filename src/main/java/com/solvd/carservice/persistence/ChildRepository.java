package com.solvd.carservice.persistence;

import com.solvd.carservice.domain.employee.Child;
import com.solvd.carservice.domain.employee.Employee;

public interface ChildRepository {

    void create(Child child, Long id);

}
