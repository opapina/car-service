package com.solvd.carservice.persistence.impl;

import com.solvd.carservice.domain.department.Department;
import com.solvd.carservice.persistence.DepartmentRepository;
import com.solvd.carservice.persistence.MybatisConfig;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DepartmentMapperImpl implements DepartmentRepository {
    @Override
    public void create(Department department, Long id) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            DepartmentRepository departmentRepository = session.getMapper(DepartmentRepository.class);
            departmentRepository.create(department, id);
        }
    }

    @Override
    public void update(Long id, String name) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            DepartmentRepository departmentRepository = session.getMapper(DepartmentRepository.class);
            departmentRepository.update(id, name);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            DepartmentRepository departmentRepository = session.getMapper(DepartmentRepository.class);
            departmentRepository.delete(id);
        }
    }

    @Override
    public List<Department> findByName(String name) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            DepartmentRepository departmentRepository = session.getMapper(DepartmentRepository.class);
            return departmentRepository.findByName(name);
        }
    }

    @Override
    public List<Department> findByCarServiceId(Long id) {try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
        DepartmentRepository departmentRepository = session.getMapper(DepartmentRepository.class);
        return departmentRepository.findByCarServiceId(id);
    }
    }

    @Override
    public List<Department> findById(Long id) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            DepartmentRepository departmentRepository = session.getMapper(DepartmentRepository.class);
            return departmentRepository.findById(id);
        }
    }
}
