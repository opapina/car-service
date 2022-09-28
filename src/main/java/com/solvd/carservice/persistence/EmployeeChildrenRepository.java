package com.solvd.carservice.persistence;

import com.solvd.carservice.domain.employee.EmployeeChildren;

import java.util.List;

public interface EmployeeChildrenRepository {

    void create(EmployeeChildren employeeChildren, Long employeeId, Long childrenId);

    void delete(Long id);

    List<EmployeeChildren> selectById(Long id);

}
