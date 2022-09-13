-- MySQL Script generated by MySQL Workbench
-- Tue Sep 13 09:43:17 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema carservices_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema carservices_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `carservices_db` DEFAULT CHARACTER SET utf8 ;
USE `carservices_db` ;

-- -----------------------------------------------------
-- Table `carservices_db`.`car_services`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carservices_db`.`car_services` ;

CREATE TABLE IF NOT EXISTS `carservices_db`.`car_services` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carservices_db`.`clients`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carservices_db`.`clients` ;

CREATE TABLE IF NOT EXISTS `carservices_db`.`clients` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(50) NOT NULL,
  `clientscol` VARCHAR(50) NOT NULL,
  `dob` TIMESTAMP NOT NULL,
  `registration_date` TIMESTAMP NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carservices_db`.`departments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carservices_db`.`departments` ;

CREATE TABLE IF NOT EXISTS `carservices_db`.`departments` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `car_service_id` BIGINT UNSIGNED NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  INDEX `fk_departments_car_services1_idx` (`car_service_id` ASC),
  CONSTRAINT `fk_departments_car_services1`
    FOREIGN KEY (`car_service_id`)
    REFERENCES `carservices_db`.`car_services` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carservices_db`.`employees`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carservices_db`.`employees` ;

CREATE TABLE IF NOT EXISTS `carservices_db`.`employees` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `car_service_id` BIGINT UNSIGNED NOT NULL,
  `department_id` BIGINT UNSIGNED NOT NULL,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `dob` TIMESTAMP NOT NULL,
  `salary` DECIMAL(10000) NULL,
  `experience` INT NOT NULL,
  `profession` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_employees_car_services_idx` (`car_service_id` ASC),
  INDEX `fk_employees_departments1_idx` (`department_id` ASC),
  CONSTRAINT `fk_employees_car_services`
    FOREIGN KEY (`car_service_id`)
    REFERENCES `carservices_db`.`car_services` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employees_departments1`
    FOREIGN KEY (`department_id`)
    REFERENCES `carservices_db`.`departments` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carservices_db`.`children`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carservices_db`.`children` ;

CREATE TABLE IF NOT EXISTS `carservices_db`.`children` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `dob` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carservices_db`.`tools`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carservices_db`.`tools` ;

CREATE TABLE IF NOT EXISTS `carservices_db`.`tools` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `department_id` BIGINT UNSIGNED NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tools_departments1_idx` (`department_id` ASC),
  CONSTRAINT `fk_tools_departments1`
    FOREIGN KEY (`department_id`)
    REFERENCES `carservices_db`.`departments` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carservices_db`.`discount_programs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carservices_db`.`discount_programs` ;

CREATE TABLE IF NOT EXISTS `carservices_db`.`discount_programs` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `car_service_id` BIGINT UNSIGNED NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `discount` DECIMAL NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_discount_programs_car_services1_idx` (`car_service_id` ASC),
  CONSTRAINT `fk_discount_programs_car_services1`
    FOREIGN KEY (`car_service_id`)
    REFERENCES `carservices_db`.`car_services` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carservices_db`.`prices`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carservices_db`.`prices` ;

CREATE TABLE IF NOT EXISTS `carservices_db`.`prices` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `performed_flag` TINYINT NOT NULL DEFAULT 0,
  `material_price` DECIMAL NULL,
  `worked_time` INT NULL,
  `discount` DECIMAL NULL,
  `total price` DECIMAL NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carservices_db`.`materials`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carservices_db`.`materials` ;

CREATE TABLE IF NOT EXISTS `carservices_db`.`materials` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `quantity` DECIMAL NOT NULL DEFAULT 0,
  `units` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carservices_db`.`suspension_maintenances`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carservices_db`.`suspension_maintenances` ;

CREATE TABLE IF NOT EXISTS `carservices_db`.`suspension_maintenances` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `reason` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carservices_db`.`electrical_maintenances`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carservices_db`.`electrical_maintenances` ;

CREATE TABLE IF NOT EXISTS `carservices_db`.`electrical_maintenances` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `part_electrical` VARCHAR(45) NOT NULL,
  `reason` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carservices_db`.`engine_maintenances`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carservices_db`.`engine_maintenances` ;

CREATE TABLE IF NOT EXISTS `carservices_db`.`engine_maintenances` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `volume_engine` DECIMAL NOT NULL,
  `reason` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carservices_db`.`car_paintings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carservices_db`.`car_paintings` ;

CREATE TABLE IF NOT EXISTS `carservices_db`.`car_paintings` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `part_car_body` VARCHAR(45) NOT NULL,
  `count_layers` INT NOT NULL,
  `color_painting` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carservices_db`.`service_work_times`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carservices_db`.`service_work_times` ;

CREATE TABLE IF NOT EXISTS `carservices_db`.`service_work_times` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `prices_id` BIGINT UNSIGNED NOT NULL,
  `suspension_maintenance_id` BIGINT UNSIGNED NULL,
  `electrical_maintenance_id` BIGINT UNSIGNED NULL,
  `engine_maintenances_id` BIGINT UNSIGNED NULL,
  `car_painting_id` BIGINT UNSIGNED NULL,
  `hour` INT NULL,
  `employee_last_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_service_work_times_prices1_idx` (`prices_id` ASC),
  INDEX `fk_service_work_times_suspension_maintenances1_idx` (`suspension_maintenance_id` ASC),
  INDEX `fk_service_work_times_electrical_maintenances1_idx` (`electrical_maintenance_id` ASC),
  INDEX `fk_service_work_times_engine_maintenances1_idx` (`engine_maintenances_id` ASC),
  INDEX `fk_service_work_times_car_paintings1_idx` (`car_painting_id` ASC),
  CONSTRAINT `fk_service_work_times_prices1`
    FOREIGN KEY (`prices_id`)
    REFERENCES `carservices_db`.`prices` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_service_work_times_suspension_maintenances1`
    FOREIGN KEY (`suspension_maintenance_id`)
    REFERENCES `carservices_db`.`suspension_maintenances` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_service_work_times_electrical_maintenances1`
    FOREIGN KEY (`electrical_maintenance_id`)
    REFERENCES `carservices_db`.`electrical_maintenances` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_service_work_times_engine_maintenances1`
    FOREIGN KEY (`engine_maintenances_id`)
    REFERENCES `carservices_db`.`engine_maintenances` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_service_work_times_car_paintings1`
    FOREIGN KEY (`car_painting_id`)
    REFERENCES `carservices_db`.`car_paintings` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carservices_db`.`cars`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carservices_db`.`cars` ;

CREATE TABLE IF NOT EXISTS `carservices_db`.`cars` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `client_id` BIGINT UNSIGNED NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  `brand` VARCHAR(45) NOT NULL,
  `year_create` TIMESTAMP NOT NULL,
  `vin_code` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cars_clients1_idx` (`client_id` ASC),
  CONSTRAINT `fk_cars_clients1`
    FOREIGN KEY (`client_id`)
    REFERENCES `carservices_db`.`clients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carservices_db`.`employees_children`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carservices_db`.`employees_children` ;

CREATE TABLE IF NOT EXISTS `carservices_db`.`employees_children` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `employee_id` BIGINT UNSIGNED NOT NULL,
  `child_id` BIGINT UNSIGNED NOT NULL,
  INDEX `fk_employees_has_children_children1_idx` (`child_id` ASC),
  INDEX `fk_employees_has_children_employees1_idx` (`employee_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_employees_has_children_employees1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `carservices_db`.`employees` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employees_has_children_children1`
    FOREIGN KEY (`child_id`)
    REFERENCES `carservices_db`.`children` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carservices_db`.`client_discount_program`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carservices_db`.`client_discount_program` ;

CREATE TABLE IF NOT EXISTS `carservices_db`.`client_discount_program` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `client_id` BIGINT UNSIGNED NOT NULL,
  `discount_program_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_clients_has_discount_programs_discount_programs1_idx` (`discount_program_id` ASC),
  INDEX `fk_clients_has_discount_programs_clients1_idx` (`client_id` ASC),
  CONSTRAINT `fk_clients_has_discount_programs_clients1`
    FOREIGN KEY (`client_id`)
    REFERENCES `carservices_db`.`clients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clients_has_discount_programs_discount_programs1`
    FOREIGN KEY (`discount_program_id`)
    REFERENCES `carservices_db`.`discount_programs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carservices_db`.`program_price_discount`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carservices_db`.`program_price_discount` ;

CREATE TABLE IF NOT EXISTS `carservices_db`.`program_price_discount` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `discount_program_id` BIGINT UNSIGNED NOT NULL,
  `price_id` BIGINT UNSIGNED NOT NULL,
  INDEX `fk_discount_programs_has_prices_prices1_idx` (`price_id` ASC),
  INDEX `fk_discount_programs_has_prices_discount_programs1_idx` (`discount_program_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_discount_programs_has_prices_discount_programs1`
    FOREIGN KEY (`discount_program_id`)
    REFERENCES `carservices_db`.`discount_programs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_discount_programs_has_prices_prices1`
    FOREIGN KEY (`price_id`)
    REFERENCES `carservices_db`.`prices` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carservices_db`.`price_material`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carservices_db`.`price_material` ;

CREATE TABLE IF NOT EXISTS `carservices_db`.`price_material` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `price_id` BIGINT UNSIGNED NOT NULL,
  `material_id` BIGINT UNSIGNED NOT NULL,
  INDEX `fk_prices_has_materials_materials1_idx` (`material_id` ASC),
  INDEX `fk_prices_has_materials_prices1_idx` (`price_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_prices_has_materials_prices1`
    FOREIGN KEY (`price_id`)
    REFERENCES `carservices_db`.`prices` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prices_has_materials_materials1`
    FOREIGN KEY (`material_id`)
    REFERENCES `carservices_db`.`materials` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carservices_db`.`service_work_time_car`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carservices_db`.`service_work_time_car` ;

CREATE TABLE IF NOT EXISTS `carservices_db`.`service_work_time_car` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `service_work_time_id` BIGINT UNSIGNED NOT NULL,
  `car_id` BIGINT UNSIGNED NOT NULL,
  INDEX `fk_service_work_times_has_cars_cars1_idx` (`car_id` ASC),
  INDEX `fk_service_work_times_has_cars_service_work_times1_idx` (`service_work_time_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_service_work_times_has_cars_service_work_times1`
    FOREIGN KEY (`service_work_time_id`)
    REFERENCES `carservices_db`.`service_work_times` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_service_work_times_has_cars_cars1`
    FOREIGN KEY (`car_id`)
    REFERENCES `carservices_db`.`cars` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `carservices_db`.`service_work_time_employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carservices_db`.`service_work_time_employee` ;

CREATE TABLE IF NOT EXISTS `carservices_db`.`service_work_time_employee` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `service_work_times_id` BIGINT UNSIGNED NOT NULL,
  `employees_id` BIGINT UNSIGNED NOT NULL,
  INDEX `fk_service_work_times_has_employees_employees1_idx` (`employees_id` ASC),
  INDEX `fk_service_work_times_has_employees_service_work_times1_idx` (`service_work_times_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_service_work_times_has_employees_service_work_times1`
    FOREIGN KEY (`service_work_times_id`)
    REFERENCES `carservices_db`.`service_work_times` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_service_work_times_has_employees_employees1`
    FOREIGN KEY (`employees_id`)
    REFERENCES `carservices_db`.`employees` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;