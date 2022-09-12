package com.solvd.carservice.department;

import java.util.List;

public class Department {

    private Long id;
    private String name;
    private Integer countOfEmployee;
    private List<String> tools;

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

    public Integer getCountOfEmployee() {
        return countOfEmployee;
    }

    public void setCountOfEmployee(Integer countOfEmployee) {
        this.countOfEmployee = countOfEmployee;
    }

    public List<String> getTools() {
        return tools;
    }

    public void setTools(List<String> tools) {
        this.tools = tools;
    }
}
