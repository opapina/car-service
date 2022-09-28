package com.solvd.carservice.service;

import com.solvd.carservice.domain.employee.Child;

import java.util.List;

public interface ChildService {

    Child create(Child child);

    Child update(Child child, String firstName);

    void deleteById(Long id);

    List<Child> selectByName(String lastName);

    List<Child> selectAll();

}
