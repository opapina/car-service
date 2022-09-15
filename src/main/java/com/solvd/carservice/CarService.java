package com.solvd.carservice;

import com.solvd.carservice.department.Department;
import com.solvd.carservice.price.DiscountProgram;

import java.util.List;

public class CarService {

    private Long id;
    private String name;
    private List<Department> departments;
    private List<DiscountProgram> discountPrograms;

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

    public List<DiscountProgram> getDiscountPrograms() {
        return discountPrograms;
    }

    public void setDiscountPrograms(List<DiscountProgram> discountPrograms) {
        this.discountPrograms = discountPrograms;
    }
}
