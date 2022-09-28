package com.solvd.carservice.service;

import com.solvd.carservice.domain.employee.EmployeeChildren;

import java.util.List;


public interface EmployeeChildrenService {

    EmployeeChildren create(Long employeeId, Long childrenId);

    List<EmployeeChildren> selectById(Long id);

    void deleteById(Long id);

}
