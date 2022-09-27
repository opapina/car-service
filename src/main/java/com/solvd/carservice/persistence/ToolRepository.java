package com.solvd.carservice.persistence;

import com.solvd.carservice.domain.equipment.Tool;

public interface ToolRepository {

    void create(Tool tool, Long departmentId);
}
