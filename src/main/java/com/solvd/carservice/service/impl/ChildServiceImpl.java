package com.solvd.carservice.service.impl;

import com.solvd.carservice.domain.department.Department;
import com.solvd.carservice.domain.employee.Child;
import com.solvd.carservice.domain.employee.Employee;
import com.solvd.carservice.domain.equipment.Tool;
import com.solvd.carservice.persistence.ChildRepository;
import com.solvd.carservice.persistence.DepartmentRepository;
import com.solvd.carservice.persistence.impl.ChildRepositoryImpl;
import com.solvd.carservice.persistence.impl.DepartmentRepositoryImpl;
import com.solvd.carservice.service.ChildService;
import com.solvd.carservice.service.EmployeeService;
import com.solvd.carservice.service.ToolService;

import java.util.List;
import java.util.stream.Collectors;

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
