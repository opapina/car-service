package com.solvd.carservice.persistence;

import com.solvd.carservice.domain.department.Department;

public interface DepartmentRepository {

    void create(Department department, Long id);

}
