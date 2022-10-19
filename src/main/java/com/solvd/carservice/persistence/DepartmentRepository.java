package com.solvd.carservice.persistence;

import com.solvd.carservice.domain.department.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentRepository {

    void create(@Param("department") Department department, @Param("carServiceId") Long carServiceId);

    void update(@Param("id") Long id, @Param("name") String name);

    void delete(Long id);

    List<Department> findByName(String name);

    List<Department> findByCarServiceId(Long id);

    List<Department> findById(Long id);

}
