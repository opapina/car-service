package com.solvd.carservice;

import com.solvd.carservice.domain.employee.Child;
import com.solvd.carservice.domain.employee.Employee;
import com.solvd.carservice.service.ChildService;
import com.solvd.carservice.service.EmployeeService;
import com.solvd.carservice.service.impl.ChildServiceImpl;
import com.solvd.carservice.service.impl.EmployeeServiceImpl;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

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
    public void verifyEmployeeHasFirstNameTest() {
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
    public void verifyEmployeeHasLastNameTest() {
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
    public void verifyEmployeeIdNotEmptyOnCreateTest() {
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

    @Test(testName = "Verify that during creation employee children with Id will be created accordingly")
    public void verifyEmployeeChildOnCreateTest() {
        Child child1 = new Child();
        child1.setFirstName("Anya");
        child1.setLastName("Komleva");
        child1.setDob(LocalDate.of(2016, 3, 27));

        Child child2 = new Child();
        child2.setFirstName("Dima");
        child2.setLastName("Komlev");
        child2.setDob(LocalDate.of(2011, 12, 13));

        Employee employee = new Employee();
        employee.setFirstName("Leonid");
        employee.setLastName("Komlev");
        employee.setDob(LocalDate.of(1990, 5, 12));
        employee.setExperience(5);
        employee.setProfession("designer");
        employee.setChildren(Arrays.asList(child1, child2));

        EmployeeService employeeService = new EmployeeServiceImpl();
        employee = employeeService.create(employee, 15L);

        ChildService childService = new ChildServiceImpl();
        List<Child> children1 = childService.selectByName("Anya");
        List<Child> children2 = childService.selectByName("Dima");
        Long childId1Actual = employee.getChildren().get(0).getId();
        Long childId2Actual = employee.getChildren().get(1).getId();
        Long childId1Expected = children1.get(children1.size() - 1).getId();
        Long childId2Expected = children2.get(children1.size() - 1).getId();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(childId1Actual, childId1Expected, "First child for employee is not created");
        softAssert.assertEquals(childId2Actual, childId2Expected, "Second child for employee is not created");

        softAssert.assertAll();
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
