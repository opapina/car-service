package com.solvd.carservice.persistence;

import com.solvd.carservice.domain.department.Department;

import java.util.ArrayList;
import java.util.List;

public interface DepartmentRepository {

    void create(Department department, Long id);

    void update(Long id, String name);

    void delete(Long id);

    default List<Department> findByName(String name) {
        List<Department> departments = new ArrayList<>();
        return departments;
    }

    default List<Department> findById(Long id) {
        List<Department> departments = new ArrayList<>();
        return departments;
    }
}
