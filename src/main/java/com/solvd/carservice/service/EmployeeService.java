package com.solvd.carservice.service;

import com.solvd.carservice.domain.employee.Employee;

public interface EmployeeService {

    Employee create(Employee employee, Long id);
}
