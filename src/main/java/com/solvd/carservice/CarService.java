package com.solvd.carservice;

import com.solvd.carservice.department.Department;

import java.util.List;

public class CarService {

    private Long id;
    private String name;
    private List<Department> departments;

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

    public List<Department> getDepartment() {
        return departments;
    }

    public void setDepartment(List<Department> department) {
        this.departments = department;
    }
}
