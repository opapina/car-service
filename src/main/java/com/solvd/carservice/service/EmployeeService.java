package com.solvd.carservice.service;

import com.solvd.carservice.domain.employee.Employee;

import java.util.List;

public interface EmployeeService {

    Employee create(Employee employee, Long id);

    Employee update(Employee employee, String firstName, String lastName);

    void deleteById(Long id);

    List<Employee> selectByProfession(String name);

}
