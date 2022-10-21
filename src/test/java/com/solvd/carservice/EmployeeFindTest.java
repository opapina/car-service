package com.solvd.carservice;

import com.solvd.carservice.domain.employee.Employee;
import com.solvd.carservice.service.EmployeeService;
import com.solvd.carservice.service.impl.EmployeeServiceImpl;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class EmployeeFindTest {

    @BeforeMethod
    private void setup() {
        System.out.println("Before method EmployeeFindTest");
    }

    @DataProvider(name = "professionNames")
    public Object[][] professionNames() {
        return new Object[][] {
                {"painter"},
                {"mechanic"},
                {"electronic engineer"},
                {"constructor"},
                {"designer"}
        };
    }

    @Test(testName = "Verify that all Employee according to profession will be found", dataProvider = "professionNames")
    public void verifyFindByProfessionTest (String profession) {
        List<Employee> employees;
        EmployeeService employeeService = new EmployeeServiceImpl();
        employees = employeeService.selectByProfession(profession);

        SoftAssert softAssert = new SoftAssert();
        employees.forEach(employee ->
            softAssert.assertEquals(employee.getProfession(), profession, "Profession doesn't match " + employee.getId()));

        softAssert.assertAll();
    }

    @AfterClass
    public void setupAfterClass() {
        System.out.println("After class EmployeeFind Test");
    }

    @AfterTest
    public void setupAfterTest() {
        System.out.println("After test EmployeeFind Test");
    }

    @AfterMethod
    public void setupAfterMethod() {
        System.out.println("After method EmployeeFind Test");
    }
}

