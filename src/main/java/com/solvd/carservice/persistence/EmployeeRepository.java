package com.solvd.carservice.persistence;

import com.solvd.carservice.domain.employee.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeRepository {

    void create(@Param("employee")Employee employee, @Param("departmentId") Long id);

    void update(@Param("id") Long id, @Param("firstName") String firstName, @Param("lastName") String lastName);

    void delete(Long id);

    List<Employee> findByProfession(String name);

}
