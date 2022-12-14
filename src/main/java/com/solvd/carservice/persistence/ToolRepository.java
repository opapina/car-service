package com.solvd.carservice.persistence;

import com.solvd.carservice.domain.equipment.Tool;

import java.util.ArrayList;
import java.util.List;

public interface ToolRepository {

    void create(Tool tool, Long departmentId);

    void update(Long id, Integer quantity);

    void delete(Long id);

    List<Tool> findByName(String name);

}
