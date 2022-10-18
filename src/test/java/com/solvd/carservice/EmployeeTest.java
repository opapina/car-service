package com.solvd.carservice;

import com.solvd.carservice.domain.employee.Employee;
import com.solvd.carservice.service.EmployeeService;
import com.solvd.carservice.service.impl.EmployeeServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class EmployeeTest {

    @BeforeMethod
    private void setup() {
        System.out.println("Before method ");
    }

    @Test(testName = "Verify that first name is not null")
    public void verifyEmployeeHasFirstName() {
        Employee employee = new Employee();
        employee.setFirstName("Leonid");
        employee.setLastName("Petrov");
        employee.setDob(LocalDate.of(1999, 5, 12));
        employee.setExperience(5);
        employee.setProfession("designer");

        EmployeeService employeeService = new EmployeeServiceImpl();
        employee = employeeService.create(employee, 3L);
        Assert.assertNotNull(employee.getFirstName(), "Employee first name is null");
    }

    @Test(testName = "Verify that last name is not null")
    public void verifyEmployeeHasLastName() {
        Employee employee = new Employee();
        employee.setFirstName("Leonid");
        employee.setLastName("Petrov");
        employee.setDob(LocalDate.of(1999, 5, 12));
        employee.setExperience(5);
        employee.setProfession("designer");

        EmployeeService employeeService = new EmployeeServiceImpl();
        employee = employeeService.create(employee, 3L);

        Assert.assertNotNull(employee.getLastName(), "Employee last name is null");
    }

    @Test(testName = "Verify that id is not null after create employee")
    public void verifyEmployeeIdNotEmptyOnCreate() {
        Employee employee = new Employee();
        employee.setFirstName("Leonid");
        employee.setLastName("Petrov");
        employee.setDob(LocalDate.of(1999, 5, 12));
        employee.setExperience(5);
        employee.setProfession("designer");

        EmployeeService employeeService = new EmployeeServiceImpl();
        employee = employeeService.create(employee, 3L);

        Assert.assertNotNull(employee.getId(), "Employee id is null");
    }
}
