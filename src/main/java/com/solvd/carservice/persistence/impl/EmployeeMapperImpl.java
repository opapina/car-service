package com.solvd.carservice.persistence.impl;

import com.solvd.carservice.domain.employee.Child;
import com.solvd.carservice.domain.employee.Employee;
import com.solvd.carservice.persistence.EmployeeRepository;
import com.solvd.carservice.persistence.MybatisConfig;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmployeeMapperImpl implements EmployeeRepository {
    @Override
    public void create(Employee employee, Long id) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            EmployeeRepository employeeRepository = session.getMapper(EmployeeRepository.class);
            employeeRepository.create(employee, id);
        }
    }

    @Override
    public void update(Long id, String firstName, String lastName) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            EmployeeRepository employeeRepository = session.getMapper(EmployeeRepository.class);
            employeeRepository.update(id, firstName, lastName);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            EmployeeRepository employeeRepository = session.getMapper(EmployeeRepository.class);
            employeeRepository.delete(id);
        }
    }

    @Override
    public List<Employee> findByProfession(String name) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            EmployeeRepository employeeRepository = session.getMapper(EmployeeRepository.class);
            return employeeRepository.findByProfession(name);
        }
    }

    @Override
    public void createEmployeeChildren(Employee employee, Child child) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            EmployeeRepository employeeRepository = session.getMapper(EmployeeRepository.class);
            employeeRepository.createEmployeeChildren(employee, child);
        }
    }
}
