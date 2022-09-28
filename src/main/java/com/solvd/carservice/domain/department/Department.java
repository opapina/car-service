package com.solvd.carservice.domain.department;

import com.solvd.carservice.domain.employee.Employee;
import com.solvd.carservice.domain.equipment.Tool;

import java.util.List;

public class Department {

    private Long id;
    private String name;
    private List<Tool> tools;
    private List<Employee> employees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
