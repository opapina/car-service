package com.solvd.carservice;

import com.solvd.carservice.domain.employee.Employee;
import com.solvd.carservice.service.EmployeeService;
import com.solvd.carservice.service.impl.EmployeeServiceImpl;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.LocalDate;

public class EmployeeTest {

    @BeforeMethod
    public void setup() {
        System.out.println("Before method Employee Test");
    }

    @BeforeClass
    public void setupClass() {
        System.out.println("Before class Employee Test");
    }

    @BeforeTest
    public void setupTest() {
        System.out.println("Before test Employee Test");
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

    @AfterClass
    public void setupAfterClass() {
        System.out.println("After class Employee Test");
    }

    @AfterMethod
    public void setupAfterMethod() {
        System.out.println("After method Employee Test");
    }
}
