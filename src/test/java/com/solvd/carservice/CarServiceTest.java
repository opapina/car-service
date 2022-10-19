package com.solvd.carservice;

import com.solvd.carservice.domain.CarService;
import com.solvd.carservice.service.CarServiceService;
import com.solvd.carservice.service.impl.CarServiceServiceImpl;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;

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
    public void verifyCarServiceOnDeleteId (Long id) {
        CarServiceService carServiceService = new CarServiceServiceImpl();
        carServiceService.deleteById(id);
        List<CarService> carServices = carServiceService.selectById(id);

        SoftAssert softAssert = new SoftAssert();
        carServices.forEach(carService -> {
            Assert.assertNull(carService, "Car service with id wasn't delete " + carService.getId());
        });

        softAssert.assertAll();
    }

    @Test(testName = "Verify Name car service is not null", dataProvider = "carServiceIds")
    public void verifyCarServiceNameNotNull(Long id) {
        CarServiceService carServiceService = new CarServiceServiceImpl();
        List<CarService> carServices = carServiceService.selectById(id);

        SoftAssert softAssert = new SoftAssert();
        carServices.forEach(carService -> {
            Assert.assertNotNull(carService.getName(), "Car service name  is null " + carService.getId());
        });

        softAssert.assertAll();
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
