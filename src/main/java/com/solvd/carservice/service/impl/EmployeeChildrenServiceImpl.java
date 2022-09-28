package com.solvd.carservice.service.impl;

import com.solvd.carservice.domain.employee.EmployeeChildren;
import com.solvd.carservice.persistence.EmployeeChildrenRepository;
import com.solvd.carservice.persistence.impl.EmployeeChildrenRepositoryImpl;
import com.solvd.carservice.service.EmployeeChildrenService;

import java.util.List;

public class EmployeeChildrenServiceImpl implements EmployeeChildrenService {

    private EmployeeChildrenRepository employeeChildrenRepository;

    public EmployeeChildrenServiceImpl() {
        this.employeeChildrenRepository = new EmployeeChildrenRepositoryImpl();
    }
    @Override
    public EmployeeChildren create(Long employeeId, Long childrenId) {
        EmployeeChildren employeeChildren = new EmployeeChildren();
        employeeChildren.setId(null);
        employeeChildrenRepository.create(employeeChildren, employeeId, childrenId);
        return employeeChildren;
    }

    @Override
    public List<EmployeeChildren> selectById(Long id) {
        return employeeChildrenRepository.selectById(id);
    }

    @Override
    public void deleteById(Long id) {
        employeeChildrenRepository.delete(id);
    }
}
