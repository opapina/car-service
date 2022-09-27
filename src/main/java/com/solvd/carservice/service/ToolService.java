package com.solvd.carservice.service;

import com.solvd.carservice.domain.equipment.Tool;

import java.util.List;

public interface ToolService {

    Tool create(Tool tool, Long id);

    Tool update(Tool tool, Integer quantity);

    void deleteById(Long id);

    List<Tool> selectByName(String name);

}
