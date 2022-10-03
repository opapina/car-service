package com.solvd.carservice.persistence;

import com.solvd.carservice.domain.employee.EmployeeChildren;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeChildrenRepository {

    void create(@Param("employeeChildren") EmployeeChildren employeeChildren, @Param("employeeId") Long employeeId, @Param("childId")Long childrenId);

    void delete(Long id);

    List<EmployeeChildren> selectById(@Param("employeeChildrenId") Long id);

}
