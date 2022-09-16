package com.solvd.carservice;

import com.solvd.carservice.client.Client;
import com.solvd.carservice.department.Department;

import java.util.List;

public class CarService {

    private Long id;
    private String name;
    private List<Department> departments;
    private List<Client> clients;

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

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
