package com.solvd.carservice.domain.client;
import com.solvd.carservice.domain.pattern.listener.IEvent;
import com.solvd.carservice.domain.price.DiscountProgram;
import com.solvd.carservice.domain.service.Service;
import com.solvd.carservice.domain.vehicle.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.List;

public class Client implements IEvent {

    private static final Logger LOGGER = LogManager.getLogger(Client.class);

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private LocalDate registrationDate;
    private String phoneNumber;
    private DiscountProgram discountProgram;
    private List<Car> cars;

    /**
     * @return Client
     * Allows to create clients with different parameters and update parameters which have the same data type without mistakes
     */

    public static ClientBuilder builder() {
        return new ClientBuilder(new Client());
    }

    public ClientBuilder toBuilder() {
        return new ClientBuilder(this);
    }

    @Override
    public void onPromotion() {
        LOGGER.info("On promotion: promotion is actual till Saturday" );
    }

    @Override
    public void onPerformedWork(List<Client> clients, List<Service> performedServices) {
        if (performedServices != null) {
            clients.forEach(client -> {
                if (client.cars != null) {
                    client.cars.forEach(car -> {
                        List<Service> services = car.getServices();
                        if (services != null) {
                            performedServices.forEach(performedService -> {
                                services.stream()
                                        .filter(service -> service.getId().equals(performedService.getId()))
                                        .forEach(service -> LOGGER.info("On performed work : services " + service.getId() + " is performed for " + client.firstName + " " + client.lastName));
                            });
                        }
                    });
                }
            });
        }
    }

    public static class ClientBuilder {

        private final Client client;

        public ClientBuilder (Client client) {
            this.client = client;
        }

        public ClientBuilder firstName (String firstName) {
            this.client.firstName = firstName;
            return this;
        }

        public ClientBuilder lastName (String lastName) {
            this.client.lastName = lastName;
            return this;
        }

        public ClientBuilder dob (LocalDate dob) {
            this.client.dob = dob;
            return this;
        }

        public ClientBuilder registrationDate (LocalDate registrationDate) {
            this.client.registrationDate = registrationDate;
            return this;
        }

        public ClientBuilder phoneNumber (String phoneNumber) {
            this.client.phoneNumber = phoneNumber;
            return  this;
        }

        public ClientBuilder discountProgram  (DiscountProgram discountProgram) {
            this.client.discountProgram = discountProgram;
            return this;
        }

        public ClientBuilder cars  (List<Car> cars) {
            this.client.cars = cars;
            return this;
        }

        public Client build() {
            return client;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public DiscountProgram getDiscountProgram() {
        return discountProgram;
    }

    public void setDiscountProgram(DiscountProgram discountProgram) {
        this.discountProgram = discountProgram;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", registrationDate=" + registrationDate +
                ", phoneNumber=" + phoneNumber +
                ", discountProgram=" + discountProgram +
                ", cars=" + cars +
                '}';
    }
}
