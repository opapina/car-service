package com.solvd.carservice.persistence;

import com.solvd.carservice.domain.employee.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeRepository {

    void create(Employee employee, Long id);

    void update(Long id, String firstName, String lastName);

    void delete(Long id);

    default List<Employee> findByProfession(String name) {
        List<Employee> employees = new ArrayList<>();
        return employees;
    };

}
