package com.solvd.carservice.service;

import com.solvd.carservice.domain.department.Department;

import java.util.List;

public interface DepartmentService {

    Department create(Department department, Long id);

    Department update(Department department, String name);

    void deleteById(Long id);

    List<Department> selectById(Long id);

    List<Department> selectByCarServiceId(Long id);

    List<Department> selectByName(String name);

}
