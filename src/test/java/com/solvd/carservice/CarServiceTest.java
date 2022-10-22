package com.solvd.carservice;

import com.solvd.carservice.domain.CarService;
import com.solvd.carservice.service.CarServiceService;
import com.solvd.carservice.service.impl.CarServiceServiceImpl;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Random;

public class CarServiceTest {

    @BeforeClass
    public void setupClass() {
        System.out.println("Before class CarService Test do next steps");
    }

    @BeforeMethod
    public void setupMethod() {
        System.out.println("Before method CarService Test follow some steps");
    }

    @DataProvider(name = "ids")
    public Object[][] ids() {
        return new Object[][] {
                {15L},
                {25L},
                {35L},
                {85L},
                {95L}
        };
    }

    @DataProvider(name = "carServiceIds")
    public Object[][] carServiceIds() {
        return new Object[][] {
                {1L},
                {2L},
                {5L},
                {105L},
                {120L}
        };
    }

    @Test(testName = "Verify delete by id", dataProvider = "ids")
    public void verifyCarServiceOnDeleteIdTest (Long id) {
        CarServiceService carServiceService = new CarServiceServiceImpl();
        carServiceService.deleteById(id);
        List<CarService> carServices = carServiceService.selectById(id);

        SoftAssert softAssert = new SoftAssert();
        carServices.forEach(carService -> {
            softAssert.assertNull(carService, "Car service with id wasn't delete " + carService.getId());
        });

        softAssert.assertAll();
    }

    @Test(testName = "Verify Name car service is not null", dataProvider = "carServiceIds")
    public void verifyCarServiceNameNotNullTest(Long id) {
        CarServiceService carServiceService = new CarServiceServiceImpl();
        List<CarService> carServices = carServiceService.selectById(id);

        SoftAssert softAssert = new SoftAssert();
        carServices.forEach(carService ->
            softAssert.assertNotNull(carService.getName(), "Car service name  is null " + carService.getId()));

        softAssert.assertAll();
    }

    @Test(testName = "Verify Car service name will be updated")
    public void verifyCarServiceUpdatedByIdTest() {
        CarServiceService carServiceService = new CarServiceServiceImpl();
        List<CarService> carServices = carServiceService.selectById(276L);
        String previousName = carServices.get(0).getName();

        Random random = new Random();
        char symbol = (char)(random.nextInt(26) + 'A');
        String nameForUpdate = previousName + symbol;

        carServiceService.update(carServices.get(0), nameForUpdate);
        List<CarService> carServicesModified = carServiceService.selectById(276L);
        String newName = carServicesModified.get(0).getName();

        Assert.assertNotEquals(newName, previousName, "Name wasn't updated");
    }

    @AfterTest
    public void setupAfterTest() {
        System.out.println("After test CarService Test");
    }

    @AfterMethod
    public void setupAfterMethod() {
        System.out.println("After method CarService Test");
    }
}
