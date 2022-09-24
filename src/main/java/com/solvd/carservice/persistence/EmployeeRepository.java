package com.solvd.carservice.persistence;

import com.solvd.carservice.domain.employee.Employee;

public interface EmployeeRepository {

    void create(Employee employee);

}
