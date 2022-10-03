package com.solvd.carservice.persistence.impl;

import com.solvd.carservice.domain.employee.EmployeeChildren;
import com.solvd.carservice.persistence.EmployeeChildrenRepository;
import com.solvd.carservice.persistence.MybatisConfig;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmployeeChildrenMapperImpl implements EmployeeChildrenRepository {
    @Override
    public void create(EmployeeChildren employeeChildren, Long employeeId, Long childrenId) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            EmployeeChildrenRepository employeeChildrenRepository = session.getMapper(EmployeeChildrenRepository.class);
            employeeChildrenRepository.create(employeeChildren, employeeId, childrenId);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            EmployeeChildrenRepository employeeChildrenRepository = session.getMapper(EmployeeChildrenRepository.class);
            employeeChildrenRepository.delete(id);
        }
    }

    @Override
    public List<EmployeeChildren> selectById(Long id) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            EmployeeChildrenRepository employeeChildrenRepository = session.getMapper(EmployeeChildrenRepository.class);
            return employeeChildrenRepository.selectById(id);
        }
    }
}
