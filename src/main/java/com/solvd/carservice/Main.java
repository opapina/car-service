package com.solvd.carservice;

import com.solvd.carservice.domain.CarService;
import com.solvd.carservice.domain.department.Department;
import com.solvd.carservice.domain.employee.Employee;
import com.solvd.carservice.service.CarServiceService;
import com.solvd.carservice.service.DepartmentService;
import com.solvd.carservice.service.impl.CarServiceServiceImpl;
import com.solvd.carservice.service.impl.DepartmentServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] arg) {
        Employee employee1 = new Employee();
        employee1.setFirstName("Petr");
        employee1.setLastName("Petrov");
        employee1.setDob(LocalDate.of(1999,05,12));
        employee1.setExperience(5);
        employee1.setProfession("designer");

        Employee employee2 = new Employee();
        employee2.setFirstName("Ivan");
        employee2.setLastName("Ivanov");
        employee2.setDob(LocalDate.of(2000,06,13));
        employee2.setExperience(2);
        employee2.setProfession("designer");

        Employee employee3 = new Employee();
        employee3.setFirstName("Diana");
        employee3.setLastName("Ivanova");
        employee3.setDob(LocalDate.of(2001,07,14));
        employee3.setExperience(4);
        employee3.setProfession("designer");

        Employee employee4 = new Employee();
        employee4.setFirstName("Misha");
        employee4.setLastName("Shustov");
        employee4.setDob(LocalDate.of(2002,04,05));
        employee4.setExperience(5);
        employee4.setProfession("constructor");

        Employee employee5 = new Employee();
        employee5.setFirstName("Irina");
        employee5.setLastName("Petrova");
        employee5.setDob(LocalDate.of(2003,03,10));
        employee5.setExperience(2);
        employee5.setProfession("constructor");

        Department department1 = new Department();
        department1.setName("Design Department");
        department1.setEmployees(Arrays.asList(employee1, employee2, employee3));

        Department department2 = new Department();
        department2.setName("Constructor Department");
        department2.setEmployees(Arrays.asList(employee4, employee5));
//
//        Department department = new Department();
//        DepartmentService departmentService = new DepartmentServiceImpl();
//        department = departmentService.create(department1, 1L);
//        System.out.println(department.getId() + " " + department.getName());
//        String newDepartmentName = "DepUpdate" + wordRandom();
//        department = departmentService.update(department1, newDepartmentName);
//        System.out.println(department.getId() + " " + department.getName());

//        departmentService.deleteById(1);
//        List<Department> depToUpdate = departmentService.selectByCarServiceId(1L);
//        List<Department> depToUpdate1 = departmentService.selectByName("sus");
//        System.out.println(department.getId());
//        depToUpdate1.forEach(department3 -> {
//            departmentService.deleteById(department3.getId());
//        });
//
//        depToUpdate1.forEach(department3 -> {
//            departmentService.deleteById(department3.getId());
//        });

        CarService carService = new CarService();
        carService.setName("Auto" + wordRandom());
        carService.setDepartments(Arrays.asList(department1, department2));
//
        CarServiceService carServiceService = new CarServiceServiceImpl();
        carService = carServiceService.create(carService);
        System.out.println(carService.getId() + " " + carService.getName());
//
//        CarServiceService carServiceService2 = new CarServiceServiceImpl();
//        carService2 = carServiceService2.create(carService2);
//        System.out.println(carService2.getId() + " " + carService2.getName());
//
//
//        List<CarService> carToUpdate = carServiceService1.selectByName("Car");
//        System.out.println(carToUpdate.toString());
//
//        carToUpdate.forEach(carService -> {
//            String newName = "Car" + wordRandom();
//            carServiceService1.update(carService,newName);
//            System.out.println(carService.getId() + " " + carService.getName());
//        });
//
//        carToUpdate.forEach(carService -> {
//            carServiceService2.deleteById(carService.getId());
//            System.out.println(carService.getId() + " " + carService.getName());
//        });

    }

    private static String wordRandom() {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }
}


