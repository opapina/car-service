package com.solvd.carservice.service.impl;

import com.solvd.carservice.domain.department.Department;
import com.solvd.carservice.domain.employee.Employee;
import com.solvd.carservice.domain.equipment.Tool;
import com.solvd.carservice.persistence.DepartmentRepository;
import com.solvd.carservice.persistence.impl.DepartmentRepositoryImpl;
import com.solvd.carservice.service.DepartmentService;
import com.solvd.carservice.service.EmployeeService;
import com.solvd.carservice.service.ToolService;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeService employeeService;
    private final ToolService toolService;

    public DepartmentServiceImpl() {
        this.departmentRepository = new DepartmentRepositoryImpl();
        this.employeeService = new EmployeeServiceImpl();
        this.toolService = new ToolServiceImpl();
    }

    @Override
    public Department create(Department department, Long carServiceId) {
        department.setId(null);
        departmentRepository.create(department, carServiceId);

        if (department.getEmployees() != null) {
            List<Employee> employees = department.getEmployees().stream()
                    .map(employee -> employeeService.create(employee, department.getId()))
                    .collect(Collectors.toList());
            department.setEmployees(employees);
        }

        if (department.getTools() != null) {
            List<Tool> tools = department.getTools().stream()
                    .map(tool -> toolService.create(tool, department.getId()))
                    .collect(Collectors.toList());
            department.setTools(tools);
        }
        return department;
    }

    @Override
    public Department update(Department department, String name) {
        departmentRepository.update(department.getId(),name);
        return department;
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.delete(id);
    }

    @Override
    public List<Department> selectByCarServiceId(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public List<Department> selectByName(String name) {
        return departmentRepository.findByName(name);
    }
}
