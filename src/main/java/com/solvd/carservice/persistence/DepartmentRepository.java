package com.solvd.carservice.persistence;

import com.solvd.carservice.domain.department.Department;

import java.util.ArrayList;
import java.util.List;

public interface DepartmentRepository {

    void create(Department department);

    default List<Department> findAll() {
        List<Department> departments = new ArrayList<>();
        return departments;
    }

}
