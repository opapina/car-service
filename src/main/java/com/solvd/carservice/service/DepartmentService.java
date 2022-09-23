package com.solvd.carservice.service;

import com.solvd.carservice.domain.department.Department;

import java.util.List;

public interface DepartmentService {

    Department create(Department department, Long id);

    List<Department> retrieveAll();
}
