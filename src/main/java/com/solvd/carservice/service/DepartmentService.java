package com.solvd.carservice.service;

import com.solvd.carservice.domain.department.Department;

public interface DepartmentService {

    Department create(Department department, Long id);

}
