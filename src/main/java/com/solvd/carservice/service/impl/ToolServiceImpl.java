package com.solvd.carservice.service.impl;

import com.solvd.carservice.domain.equipment.Tool;
import com.solvd.carservice.persistence.ToolRepository;
import com.solvd.carservice.persistence.impl.ToolRepositoryImpl;
import com.solvd.carservice.service.ToolService;

public class ToolServiceImpl implements ToolService {

    private final ToolRepository toolRepository;

    public ToolServiceImpl() {
        this.toolRepository = new ToolRepositoryImpl();
    }

    @Override
    public Tool create(Tool tool, Long departmentId) {
        tool.setId(null);
        toolRepository.create(tool, departmentId);
        return tool;
    }
}
