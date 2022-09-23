package com.solvd.carservice.persistence.impl;

import com.solvd.carservice.domain.department.Department;
import com.solvd.carservice.persistence.DepartmentRepository;

import java.util.List;

public class DepartmentRepositoryImpl implements DepartmentRepository {
    @Override
    public void create(Department department) {

    }

    @Override
    public List<Department> findAll() {
        return DepartmentRepository.super.findAll();
    }
}
