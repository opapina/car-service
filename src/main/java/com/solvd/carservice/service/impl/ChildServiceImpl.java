package com.solvd.carservice.service.impl;


import com.solvd.carservice.domain.employee.Child;

import com.solvd.carservice.persistence.ChildRepository;
import com.solvd.carservice.persistence.impl.ChildRepositoryImpl;
import com.solvd.carservice.service.ChildService;

public class ChildServiceImpl implements ChildService {

    private final ChildRepository childRepository;

    public ChildServiceImpl() {
        this.childRepository = new ChildRepositoryImpl();
    }

    @Override
    public Child create(Child child, Long employeeId) {
        child.setId(null);
        childRepository.create(child, employeeId);
        return child;
    }
}
