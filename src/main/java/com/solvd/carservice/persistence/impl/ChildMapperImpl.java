package com.solvd.carservice.persistence.impl;

import com.solvd.carservice.domain.employee.Child;
import com.solvd.carservice.persistence.ChildRepository;
import com.solvd.carservice.persistence.MybatisConfig;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ChildMapperImpl implements ChildRepository {
    @Override
    public void create(Child child) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            ChildRepository childRepository = session.getMapper(ChildRepository.class);
            childRepository.create(child);
        }
    }

    @Override
    public void update(Long id, String firstName) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            ChildRepository childRepository = session.getMapper(ChildRepository.class);
            childRepository.update(id, firstName);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            ChildRepository childRepository = session.getMapper(ChildRepository.class);
            childRepository.delete(id);
        }
    }

    @Override
    public List<Child> findByName(String name) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            ChildRepository childRepository = session.getMapper(ChildRepository.class);
            return childRepository.findByName(name);
        }
    }
}
