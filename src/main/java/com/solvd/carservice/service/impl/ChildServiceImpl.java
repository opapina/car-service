package com.solvd.carservice.service.impl;

import com.solvd.carservice.domain.employee.Child;

import com.solvd.carservice.persistence.ChildRepository;
import com.solvd.carservice.persistence.impl.ChildRepositoryImpl;
import com.solvd.carservice.service.ChildService;

import java.util.List;

public class ChildServiceImpl implements ChildService {

    private final ChildRepository childRepository;

    public ChildServiceImpl() {
        this.childRepository = new ChildRepositoryImpl();
    }

    @Override
    public Child create(Child child) {
        child.setId(null);
        childRepository.create(child);
        return child;
    }

    @Override
    public Child update(Child child, String firstName) {
        childRepository.update(child.getId(), firstName);
        return child;
    }

    @Override
    public void deleteById(Long id) {
        childRepository.delete(id);
    }

    @Override
    public List<Child> selectByName(String lastName) {
        return childRepository.findByName(lastName);
    }

}
