package com.solvd.carservice.persistence.impl;

import com.solvd.carservice.domain.equipment.Tool;
import com.solvd.carservice.domain.exception.RequestException;
import com.solvd.carservice.persistence.ConnectionPool;
import com.solvd.carservice.persistence.ToolRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.solvd.carservice.persistence.Config.getData;

public class ToolRepositoryImpl implements ToolRepository {

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance(Integer.valueOf(Objects.requireNonNull(getData("poolSize"))));

    @Override
    public void create(Tool tool, Long departmentId) {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into tools(department_id,name,quantity) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, departmentId);
            preparedStatement.setString(2, tool.getName());
            preparedStatement.setInt(3, tool.getQuantity());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                tool.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RequestException("Unable to create tool: ", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(Long id, Integer quantity) {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("update tools set quantity = ? where id = ?");
            statement.setInt(1, quantity);
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RequestException("Unable to update this department: ", e);
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Long id) {
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("delete from tools where id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RequestException("Unable to delete this tool");
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<Tool> findByName(String name) {
        List<Tool> tools;
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select t.id as tool_id, t.name as tool_name, t.quantity as quantity, " +
                    "from tools t where t.name = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            tools = mapTools(resultSet);
            while (resultSet.next()) {
                Long id = resultSet.getLong("tool_id");
            }
        } catch (SQLException e) {
            throw new RequestException("Cannot find tools with that name");
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return tools;
    }

    public static List<Tool> mapTools (ResultSet resultSet) throws SQLException {
        List<Tool> tools = new ArrayList<>();
        while (resultSet.next()) {
            tools = mapTool(resultSet, tools);
        }
        return tools;
    }

    public static List<Tool> mapTool(ResultSet resultSet, List<Tool> tools) throws SQLException {
//        long id = resultSet.getLong("tool_id");
//        if (id != 0) {
//            if (tools == null) {
//                tools = new ArrayList<>();
//            }
//
//            Tool tool = findById(id, tools);
//            tool.setName(resultSet.getString("tool_name"));
//            tool.setQuantity(resultSet.getInt("quantity"));
//        }
        return tools;
    }

    private static Tool findById(Long id, List<Tool> tools) {
        return tools.stream().filter(tool -> tool.getId().equals(id))
                .findFirst()
                .orElseGet(() -> {
                    Tool createdTool = new Tool();
                    createdTool.setId(id);
                    tools.add(createdTool);
                    return createdTool;
                });
    }
}
