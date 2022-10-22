package com.solvd.carservice;

import com.solvd.carservice.domain.department.Department;
import com.solvd.carservice.service.DepartmentService;
import com.solvd.carservice.service.impl.DepartmentServiceImpl;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class DepartmentTest {

    @BeforeClass
    public void setupClass() {
        System.out.println("Before class Department Test");
    }

    @BeforeMethod
    public void setupMethod() {
        System.out.println("Before method Department Test");
    }

    @BeforeTest
    public void setupTest() {
        System.out.println("Before test Department Test");
    }

    @DataProvider(name = "ids")
    public Object[][] ids() {
        return new Object[][] {
                {1L},
                {10L},
                {20L},
                {30L}
        };
    }
    @Test(testName = "Verify delete by id", dataProvider = "ids", enabled = false)
    public void verifyDepartmentOnDeleteIdTest (Long id) {
        DepartmentService departmentService = new DepartmentServiceImpl();
        departmentService.deleteById(id);
        List<Department> departments = departmentService.selectById(id);

        SoftAssert softAssert = new SoftAssert();
        departments.forEach(department ->
            softAssert.assertNull(department, "Department with id wasn't delete " + department.getId()));

        softAssert.assertAll();
    }

    @Test(testName = "Verify that painting department in name will be found")
    public void verifyDepartmentOnFindByNameTest () {
        DepartmentService departmentService = new DepartmentServiceImpl();
        List<Department> departments = departmentService.selectByName("painting department");

        SoftAssert softAssert = new SoftAssert();
        departments.forEach(department ->
                softAssert.assertEquals(department.getName(), "painting department", "Painting departments weren't found"));

        softAssert.assertAll();
    }

    @Test(testName = "Verify than found Department name is not empty", dataProvider = "ids")
    public void verifyDepartmentNameIsNotEmptyTest (Long id) {
        DepartmentService departmentService = new DepartmentServiceImpl();
        List<Department> departments = departmentService.selectById(id);
        SoftAssert softAssert = new SoftAssert();
        departments.forEach(department ->
                softAssert.assertNotNull(department.getName(), "Department name is null"));

        softAssert.assertAll();
    }

    @AfterClass
    public void setupAfterClass() {
        System.out.println("After class Department Test");
    }

    @AfterTest
    public void setupAfterTest() {
        System.out.println("After test Department Test");
    }

    @AfterMethod
    public void setupAfterMethod() {
        System.out.println("After method Department Test");
    }
}
