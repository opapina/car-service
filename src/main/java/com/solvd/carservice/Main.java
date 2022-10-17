package com.solvd.carservice;

import com.solvd.carservice.domain.CarService;
import com.solvd.carservice.domain.client.Client;
import com.solvd.carservice.domain.department.Department;
import com.solvd.carservice.domain.employee.Child;
import com.solvd.carservice.domain.employee.Employee;
import com.solvd.carservice.domain.equipment.MaterialForRepair;
import com.solvd.carservice.domain.equipment.Tool;
import com.solvd.carservice.domain.pattern.ClientDecorator;
import com.solvd.carservice.domain.pattern.Factory;
import com.solvd.carservice.domain.price.DiscountProgram;
import com.solvd.carservice.domain.price.Price;
import com.solvd.carservice.domain.service.Service;
import com.solvd.carservice.domain.vehicle.Car;
import com.solvd.carservice.service.CarServiceService;
import com.solvd.carservice.service.DepartmentService;
import com.solvd.carservice.service.impl.CarServiceServiceImpl;
import com.solvd.carservice.service.impl.DepartmentServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] arg) {
        Child child1 = new Child();
        child1.setFirstName("Nina");
        child1.setLastName("Ivanova");
        child1.setDob(LocalDate.of(2016,7,7));

        Child child2 = new Child();
        child2.setFirstName("Anna");
        child2.setLastName("Ivanova");
        child2.setDob(LocalDate.of(2011,7,7));

        Child child3 = new Child();
        child3.setFirstName("Ivan");
        child3.setLastName("Petrov");
        child3.setDob(LocalDate.of(2017,8,8));


        Employee employee1 = new Employee();
        employee1.setFirstName("Petr");
        employee1.setLastName("Petrov (" + wordRandom() + ")");
        employee1.setDob(LocalDate.of(1999,5,12));
        employee1.setExperience(5);
        employee1.setProfession("designer");
        employee1.setChildren(List.of(child3));

        Employee employee2 = new Employee();
        employee2.setFirstName("Ivan");
        employee2.setLastName("Ivanov (" + wordRandom() + ")");
        employee2.setDob(LocalDate.of(2000,6,13));
        employee2.setExperience(2);
        employee2.setProfession("designer");
        employee2.setChildren(Arrays.asList(child1,child2));

        Employee employee3 = new Employee();
        employee3.setFirstName("Diana");
        employee3.setLastName("Ivanova (" + wordRandom() + ")");
        employee3.setDob(LocalDate.of(2001,7,14));
        employee3.setExperience(4);
        employee3.setProfession("designer");

        Employee employee4 = new Employee();
        employee4.setFirstName("Misha");
        employee4.setLastName("Shustov (" + wordRandom() + ")");
        employee4.setDob(LocalDate.of(2002,4,5));
        employee4.setExperience(5);
        employee4.setProfession("constructor");

        Employee employee5 = new Employee();
        employee5.setFirstName("Irina");
        employee5.setLastName("Petrova (" + wordRandom() + ")");
        employee5.setDob(LocalDate.of(2003,3,10));
        employee5.setExperience(2);
        employee5.setProfession("constructor");

        Tool tool1 = new Tool();
        tool1.setName("wrench (" + wordRandom() + ")");
        tool1.setQuantity(numberRandom());

        Tool tool2 = new Tool();
        tool2.setName("chisel (" + wordRandom() + ")");
        tool2.setQuantity(numberRandom());

        Tool tool3 = new Tool();
        tool3.setName("pliers (" + wordRandom() + ")");
        tool3.setQuantity(numberRandom());

        Tool tool4 = new Tool();
        tool4.setName("brush (" + wordRandom() + ")");
        tool4.setQuantity(numberRandom());

        Tool tool5 = new Tool();
        tool5.setName("putty knife (" + wordRandom() + ")");
        tool5.setQuantity(numberRandom());

        Tool tool6 = new Tool();
        tool6.setName("pump (" + wordRandom() + ")");
        tool6.setQuantity(numberRandom());

        Department department1 = new Department();
        department1.setName("Design Department");
        department1.setEmployees(Arrays.asList(employee1, employee2, employee3));
        department1.setTools(Arrays.asList(tool1, tool2, tool3));

        Department department2 = new Department();
        department2.setName("Constructor Department");
        department2.setEmployees(Arrays.asList(employee4, employee5));
      department2.setTools(Arrays.asList(tool4, tool5, tool6));


        Client client1 = Client.builder()
                .firstName("Andrei")
                .lastName("Bukin")
                .dob(LocalDate.of(2000,3,10))
                .registrationDate(LocalDate.of(2022,5,20))
                .build();

        Client client2 = Client.builder()
               .firstName("Vasyi")
               .lastName("Bukhankin")
                .dob(LocalDate.of(2001,5,15))
                .registrationDate(LocalDate.of(2022,6,10))
                .build();

        CarService carService = new CarService();
        carService.setName("Car" + wordRandom());
        carService.setDepartments(Arrays.asList(department1, department2));
//        carService.setClients(Arrays.asList(client1,client2));

        CarServiceService carServiceService = new CarServiceServiceImpl();
        carService = carServiceService.create(carService);
        LOGGER.info(carService.getId() + " " + carService.getName());

        List<CarService> childCarServices = carServiceService.retrieveAll();
        LOGGER.info("child for car-services were found above");

        MaterialForRepair material1 = Factory.getMaterial(Service.Type.ENGINEMAINTENANCE);
        LOGGER.info("material for Electrical work: " + material1);
        MaterialForRepair material2 = Factory.getMaterial(Service.Type.CARPAINTING);
        LOGGER.info("material for Painting work: " + material2);

        DiscountProgram silver = new DiscountProgram();
        silver.setName("SILVER");
        silver.setDiscount(0.20);

        Car car1 = new Car();
        car1.setBrand("Mazda");
        car1.setModel("5");

        Car car2 = new Car();
        car2.setBrand("BMW");
        car2.setModel("5");

        Client client = Client.builder()
                .firstName("Leonid")
                .lastName("Vlasov")
                .dob(LocalDate.of(1999, 3, 25))
                .registrationDate(LocalDate.of(2022, 1, 30))
                .discountProgram(silver)
                .build();

        client.toBuilder()
                .cars(Arrays.asList(car1, car2))
                .build();

        Client client3 = Client.builder()
                .firstName("Sasha")
                .lastName("Kulich")
                .dob(LocalDate.of(2002, 4, 5))
                .registrationDate(LocalDate.of(2022, 3, 10))
                .build();

        LOGGER.info("Client with all info: " + client.toString());
        LOGGER.info("Client with F,L,dob and registration date: " + client3.toString());

        Service service1 = new Service(Service.Type.CARPAINTING, 23.50, 16, Collections.singletonList(material2));
        Service service2 =  new Service(Service.Type.ENGINEMAINTENANCE, 3.45, 2, Collections.singletonList(material1));
        Price price = new Price(Arrays.asList(service1, service2));
        Double price1 = price.countPrice();
        LOGGER.info("For " + car1.toString() + " service price is " + price1);

        ClientDecorator clientDecorator = new ClientDecorator(silver, car1);
        clientDecorator.receiveSales();
        clientDecorator.move();
    }

    private static String wordRandom() {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }

    private static Integer numberRandom() {
        int min = 1;
        int max = 500;
        double a = Math.random()*(max-min+1)+min;
        int b = (int)(Math.random()*(max-min+1)+min);
        return b;
    }
}


