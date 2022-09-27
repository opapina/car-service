package com.solvd.carservice.persistence;

import com.solvd.carservice.domain.employee.Child;

import java.util.ArrayList;
import java.util.List;

public interface ChildRepository {

    void create(Child child);

    void update(Long id, String firstName);

    void delete(Long id);

    default List<Child> findByName(String name) {
        List<Child> children = new ArrayList<>();
        return children;
    };
}
