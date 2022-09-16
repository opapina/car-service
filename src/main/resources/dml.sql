use car_services_db;
#insert car_services table
insert into car_services(name) value('RepairCar');
insert into car_services(name) values('SteMaxService'),('CityService');
#insert departments table
insert into departments(car_service_id, name) value(1,'painting department');
insert into departments(car_service_id, name) values
					(1,'engine department'),
                    (1,'suspention department'),
                    (1,'electrical department'),
                    (2,'painting department'),
                    (2,'engine department'),
                    (2,'suspention department'),
                    (2,'electrical department'),
                    (3,'painting department'),
                    (3,'engine department'),
                    (3,'suspention department'),
                    (3,'electrical department'),
                    (1,'tuning department'),
                    (2,'accounting department'),
                    (3,'accounting department'),
                    (1,'accounting department');
#insert employees table                 
insert into employees(department_id,first_name,last_name,dob,experience,profession) value
					(1,'Ivan', 'Semenov', '1980-06-01', 5, 'painter');
insert into employees(department_id,first_name,last_name,dob,experience,profession) values
					(1,'Pavel', 'Semenov', '1980-06-01', 3, 'painter'),
                    (5,'Leonid', 'Selin', '1987-10-03', 1, 'painter'),
                    (5,'Alex', 'Ledinov', '1990-04-21', 4, 'painter'),
                    (5,'Pavel', 'Kirov', '1985-12-08', 10, 'painter'),
                    (9,'Levon', 'Stelin', '1997-10-03', 2, 'painter'),
                    (9,'Andrey', 'Titov', '1990-04-21', 4, 'painter'),
                    (9,'Leonid', 'Selin', '1987-12-28', 7, 'painter'),
                    (1,'Alex', 'Ledinov', '1999-07-25', 4, 'painter'),
                    (9,'Alex', 'Ledinov', '2011-04-01', 7, 'painter'),
					(9,'Alex', 'Ledinov', '2011-04-01', 9, 'painter');
insert into employees(department_id,first_name,last_name,dob,experience,profession) values
					(3,'Pavel', 'Semenov', '1980-06-01', 1, 'mechanic'),
                    (3,'Leonid', 'Selin', '1987-10-03', 2, 'mechanic'),
                    (3,'Alex', 'Ledinov', '1990-04-21', 3, 'mechanic'),
                    (7,'Pavel', 'Kirov', '1985-12-08', 4, 'mechanic'),
                    (7,'Levon', 'Stelin', '1997-10-03', 6, 'mechanic'),
                    (7,'Andrey', 'Titov', '1990-04-21', 8, 'mechanic'),
                    (11,'Leonid', 'Selin', '1987-12-28', 7, 'mechanic'),
                    (11,'Dmitry', 'Dedov', '1999-07-25', 10, 'mechanic'),
                    (11,'Denis', 'Gnom', '2011-04-01', 9, 'mechanic'),
					(11,'Alex', 'Ivanov', '2011-04-01', 1, 'mechanic'),
                    (4,'Pavel', 'Senov', '1980-06-01', 1, 'electronic engineer'),
                    (4,'Leonid', 'Selivanov', '1987-10-03', 2, 'electronic engineer'),
                    (4,'Alex', 'Innov', '1990-04-21', 3, 'electronic engineer'),
                    (4,'Pavel', 'Krotov', '1985-12-08', 4, 'electronic engineer'),
                    (8,'Levon', 'Slavkin', '1997-10-03', 6, 'electronic engineer'),
                    (8,'Andrey', 'Laitov', '1990-04-21', 8, 'electronic engineer'),
                    (8,'Leonid', 'Stalin', '1987-12-28', 7, 'electronic engineer'),
                    (12,'Dmitry', 'Dedovik', '1999-07-25', 10, 'electronic engineer'),
                    (12,'Denis', 'Krasnyi', '2011-04-01', 9, 'electronic engineer'),
					(2,'Alex', 'Petrov', '2011-04-01', 1, 'engines engineer'),
                    (2,'Pavel', 'Senov', '1980-06-01', 1, 'engines engineer'),
                    (2,'Leonid', 'Selivanov', '1987-10-03', 2, 'engines engineer'),
                    (6,'Alex', 'Innov', '1990-04-21', 3, 'engines engineer'),
                    (6,'Pavel', 'Krotov', '1985-12-08', 4, 'engines engineer'),
                    (6,'Levon', 'Slavkin', '1997-10-03', 6, 'engines engineer'),
                    (6,'Andrey', 'Laitov', '1990-04-21', 8, 'engines engineer'),
                    (10,'Leonid', 'Stalin', '1987-12-28', 7, 'engines engineer'),
                    (10,'Dmitry', 'Dedovik', '1999-07-25', 10, 'engines engineer'),
                    (10,'Denis', 'Krasnyi', '2011-04-01', 9, 'engines engineer'),
                     (16,'Sandra', 'Innovna', '1997-05-24', 3, 'accounter'),
                    (14,'Natalia', 'Krotova', '1985-12-08', 4, 'accounter'),
                    (14,'Lena', 'Slavkina', '1997-10-03', 5, 'accounter'),
                    (15,'Diana', 'Laitova', '1990-04-21', 9, 'accounter'),
                    (15,'Lubov', 'Stalin', '1987-12-28', 1, 'accounter'),
                    (16,'Darya', 'Dedovik', '1999-07-25', 2, 'accounter');
#insert tools table  
insert into tools(department_id,name,quantity) values
				 (1, 'grinder', 4),(1, 'brush', 10),(1, 'compressor', 2),
                 (5, 'grinder', 2),(5, 'brush', 40),(5, 'compressor', 1),
                 (9, 'grinder', 7),(9, 'brush', 33),(9, 'compressor', 5),
                 (2, 'pliers', 14),(2, 'screwdriver', 12),(2, 'compressor', 1),
                 (6, 'pliers', 9),(6, 'screwdriver', 8),(6, 'compressor', 1),
                 (10, 'pliers', 7),(10, 'screwdriver', 21),(10, 'compressor', 1),
                 (3, 'pliers', 4),(3, 'screwdriver', 10),(3, 'compressor', 2),
                 (7, 'pliers', 2),(7, 'screwdriver', 40),(7, 'compressor', 1),
                 (11, 'pliers', 7),(11, 'screwdriver', 33),(11, 'compressor', 3),
                 (4, 'soldering iron', 24),(4, 'screwdriver', 15),(4, 'compressor', 4),
                 (8, 'probe', 18),(8, 'soldering iron', 28),(8, 'compressor', 8),
                 (12, 'probe', 17),(12, 'screwdriver', 11),(12, 'soldering iron', 11),
                 (14, 'printer', 7),(15, 'printer', 3),(16, 'printer', 11);
#insert children table  
insert into children(first_name,last_name,dob) values    
	('Yana', 'Slavkina','2015-11-12'), ('Yan', 'Dedovik','2010-01-15'), 
	('Sasha', 'Laitova','2019-10-10'), ('Denis', 'Laitov','2018-04-25'),
	('Petya', 'Slavkin','2021-12-23'), ('Ivan', 'Dedovik','2020-01-31'),
	('Diana', 'Petrova','2015-11-12'), ('Yan', 'Senov','2010-01-15'), 
	('Sasha', 'Selivanova','2019-10-10'), ('Denis', 'Krotov','2018-04-25'),
	('Petya', 'Titov','2021-12-23'), ('Ivan', 'Kirov','2020-01-31'); 
#insert employee_children table
insert into employee_children(employee_id, child_id) values(26,1),(46,1),(26,5),(46,5),
							(39,2),(46,2),(39,6),(46,6),(27,3),(44,3),(27,4),(44,4),
                            (31,7),(22,8),(23,9),(25,10),(17,11),(5,12),(27,4),(44,4);
#insert clients table
insert into clients(car_service_id,first_name,last_name,dob,registration_date) values    
	(1,'Olya', 'Rein','1995-11-12','2021-04-09'),
    (1,'Yan', 'Dedovik','1999-01-15','2022-01-03'), 
    (1,'Nastya', 'Zotova','1990-11-12','2021-08-25'), 
    (1,'Leonid', 'Agutin','2000-03-10','2022-04-11'),
    (1,'Igor', 'Zotov','1989-12-10','2021-11-24'), 
    (1,'Leonid', 'Ivanov','1993-06-17','2022-07-28'),
    (2,'Olya', 'Ivanova','2003-10-22','2021-12-08'),
    (2,'Ilya', 'Dedov','1999-05-19','2022-02-06'), 
    (2,'Anna', 'Lutova','1998-07-14','2021-01-18'), 
    (2,'Leonid', 'Petrov','2001-05-13','2022-06-22'),
    (3,'Igor', 'Kotov','1990-12-10','2021-12-24'),
    (3,'Lena', 'Rein','1985-11-12','2021-04-10'),
    (3,'Yura', 'Medovik','1995-01-15','2022-01-08'), 
    (3,'Nastya', 'Ivleeva','1997-11-12','2021-07-25'), 
    (3,'Ivan', 'Lapin','2002-05-10','2022-09-11'),
    (3,'Igor', 'Valinov','1991-11-10','2021-11-20'); 
#insert cars table 
insert into cars(client_id,model,brand,year_create,vin_code) values
				(1,'3','BMW','2003-10-22','ABCD12345GHJK890'),
                (1,'Tiguan','VW','2011-03-17','ABTY12345GHJK887'),
                (2,'5','BMW','2003-10-22','ABCD12345GHJK891'),
                (3,'Polo','VW','2014-05-22','ABTY12345GHJK882'),
                (4,'7','BMW','2000-11-21','ABCD12345GHJK892'),
                (5,'Tiguan','VW','2020-04-15','ABTY12345GHJK881'),
                (6,'Quashqai','Nessan','2003-11-02','ABCD12345GHJK893'),
                (7,'Tuareg','VW','2015-06-10','ABTY12345GHJK883'),
                (7,'Juke','Nessan','2017-09-20','ABCD12345GHJK894'),
                (8,'Q5','Audi','2011-03-17','ABTY12345GHJK884'),
                (9,'A1','Mercedes','2003-10-22','ABCD12345GHJK895'),
                (10,'Q7','Audi','2013-09-17','ABTY12345GHJK885'),
                (11,'7','BMW','2012-11-05','ABCD12345GHJK896'),
                (12,'A6','Mercedes','2019-09-19','ABTY12345GHJK886'),
                (13,'3','Mazda','2009-02-23','ABCD12345GHJK897'),
                (14,'A100','Mercedes','2010-07-19','ABTY12345GHJK880'),
                (15,'6','Mazda','2004-06-26','ABCD12345GHJK899'),
                (16,'Polo','VW','1999-12-14','ABTY12345GHJK889');
#insert discount_programs table 
insert into discount_programs(client_id,name,discount) values
							 (1, 'SILVER', 0.2), (2, 'SILVER', 0.2), (3, 'SILVER', 0.2),
                             (5, 'BRONZE', 0.1), (6, 'BRONZE', 0.1),(7, 'GOLD', 0.3), 
                             (8, 'GOLD', 0.3), (9, 'GOLD', 0.3),(10, 'SILVER', 0.2),
                             (13, 'BRONZE', 0.1),(15, 'BRONZE', 0.1),(16, 'GOLD', 0.3);
#insert services table 
insert into services(name,price_of_hour,work_time) values
					('CAR_PAINTING', '20.55',7), ('CAR_PAINTING', '13.88',2),
					('ENGINE_MAINTENANCE', '13.55',5), ('ENGINE_MAINTENANCE', '20.88',3);
insert into services(name,price_of_hour,work_time) values                    
                    ('ELECTRICAL_MAINTENANCE', '10.55',3), ('SUSPENSION_MAINTENANCE', '55.00',4),
					('ELECTRICAL_MAINTENANCE', '11.00',2), ('SUSPENSION_MAINTENANCE', '2.21',9),
                    ('CAR_PAINTING', '30.00',40), ('ENGINE_MAINTENANCE', '5.80',20),
					('ELECTRICAL_MAINTENANCE', '10.50',3), ('SUSPENSION_MAINTENANCE', '40.80',1);
#insert service_car table   
insert into service_car(service_id,car_id) values
					   (1,1),(1,2),(1,3),(1,4),(2,5),(2,6),(2,7),(2,8),(3,9),(3,10),
                       (1,11),(1,12),(1,13),(1,14),(2,15),(2,16),(2,17),(2,18),(3,14),(3,1),
                       (4,1),(4,2),(5,3),(5,4),(6,5),(6,6),(7,7),(7,8),(8,9),(10,10),
                       (11,11),(12,12),(7,13),(8,14),(9,15),(10,16),(1,17),(2,18),(3,4),(5,7);
#insert materials table   
insert into materials(name,quantity,unit,price_unit) values
					 ('paint-red','1.20','L','11.44'), ('paint-white','2.30','L','10.20'),
                     ('filler-c','0.80','L','5.78'), ('filler-d','1.30','L','3.25'),
                     ('mastic-a','2.20','L','6.74'), ('mastic-b','0.30','L','10.90'),
                     ('oil-naftan','8.00','L','20.34'), ('oil-elf','6.30','L','40.20');
#insert service_material table  
insert into service_material(service_id) values (5),(7),(8),(10),(12);
insert into service_material(service_id, material_id) values (1,1),(1,2),(2,1),(2,2); 
#insert prices table
insert into prices(service_id) values (1),(2),(3),(4),(5),(11),(12);
insert into prices(service_id,performed_flag) values (6,1),(7,1),(8,1),(9,1),(10,1);

-- DELETE
#delete from tools posissions with id=10,33,25
delete from tools where id in (10,33,25);

#delete from tools posission with department_id=15
delete from tools where department_id=15;

SET SQL_SAFE_UPDATES = 0; -- because safe_updates was turn

#delete from children posissions with first_name 'Yan'
SET FOREIGN_KEY_CHECKS=0;-- to disable fk
delete from children  where first_name = 'Yan' ;
SET FOREIGN_KEY_CHECKS=1; -- to re-enable fk

#delete from cliens posissions with first_name 'Igor'
SET FOREIGN_KEY_CHECKS=0;-- to disable fk
delete from clients where first_name = 'Igor';
SET FOREIGN_KEY_CHECKS=1; -- to re-enable fk

SET SQL_SAFE_UPDATES = 1; -- return safe_updates

#delete from materials posission with id = 6
delete from materials where id = 6;

#delete from materials posission filler-d
delete from materials where name in ('filler-d');

#delete from discount_programs posissions with id=1,11
delete from discount_programs where id in (1,11);

#delete from discount_programs posissions with client_id=8
delete from discount_programs where client_id in (8);

#delete from cars posissions with year_create='2015-06-10'
SET FOREIGN_KEY_CHECKS=0;-- to disable fk
delete from cars where year_create='2015-06-10';

#delete from cars posissions with vin_code='ABTY12345GHJK885'
delete from cars where vin_code='ABTY12345GHJK885';
SET FOREIGN_KEY_CHECKS=1; -- to re-enable fk

-- UPDATE

#update name in car_services which id = 1
update car_services set name='RenovateCar' where id=1; 

#update departments in departments which name is 'tuning department'
update departments set name='cleaning department' where name='tuning department';

#update experience of Employees with id = 3,7,12,10,36
update employees set experience=0 where id in(3,7,12,10,36);

#update profession of Employees with id = 3,8,15,20,26,39
update employees set profession='cleaner' where id in(3,8,15,20,26,39);

#update profession of Employees with department_id = 3
update employees set profession='engineer' where department_id =3;

#update tools of Employees with id = 3,8,15,20,26,39
update tools set name='scissors' where id in (3,8,15,20,26,39);

#update registration_date of clients for dates 2021-04-09 and 2021-04-10
update clients set registration_date='2022-09-09' where registration_date in ('2021-04-09', '2021-04-10');

#update prices performed_flag for service_id=4 
update prices set performed_flag=1 where service_id=4;

#update year_create for cars with id=5,15 
update cars set year_create='2010-09-08' where id=5 or id=15;

#update model car for brand BMW и client_id=1
update cars set model='7' where brand='BMW' and client_id=1;

-- SELECT
#select the name and lastname and prifession for department_id=4
select first_name as Name, last_name as Surname, profession as profession from employees e where e.department_id=4;

#select the name and lastname and id alias table_number for all department_id in not null
select first_name as Name, last_name as Surname, e.id as table_number from employees e where e.department_id is not null;

#select first_name of clients which registration_date is 2022-09-09
select first_name as Name from clients c where c.registration_date='2022-09-09';

#select first_name and last_name of clients which name contains 'a'
select c.first_name as Name, c.last_name as Surname from clients c where c.first_name like '%a%';

#select name of materials and quantity for name start from 'p'
select m.name as Material, m.quantity from materials m where m.name like 'p%';

#select tools with id from 20 to 30 amd name contains 's'
select t.id,t.name from tools t where id BETWEEN 20 AND 30 and t.name like'%s%';

#select first_name of clients which have BMW
select c.first_name as Name, c.last_name as Surname from clients c where c.id in (select ca.client_id from cars ca where brand='BMW');

#select  service name without materials
select s.id as ID, s.name as NAME from services s where s.id in (select sm.service_id from service_material sm where sm.material_id is null);

#select  children (name, dob) which parents accounter and last name starts 'D' 
select c.first_name as NAME, c.dob as Date_Of_Birth from children c where c.id in 
		(select ec.child_id from employee_children ec where ec.employee_id in 
        (select e.id from employees e where e.profession='accounter' and e.last_name like 'D%'));
        
 #select clients from car_service  RenovateCar   and order by lastname
 select c.first_name as name ,c.last_name as surname from clients c where c.car_service_id=1 order by c.last_name;
 
  #select clients from clients  which discaunt program SILVER or GOLD  and order by dob
  select c.first_name as name, c.last_name as surname, dob as DATE_BIRTH from clients c where c.id in 
					(select client_id from discount_programs d where d.name='Silver' or d.name='Gold') order by c.dob;
                    
#select clients from clients and discaunt_programs  which discaunt program SILVER or GOLD  and order by dob with inner join    
select c.first_name as name, c.last_name as surname, c.dob as DATE_BIRTH, dp.discount as Discount from clients c 
inner join discount_programs dp on c.id=dp.client_id where dp.name='Silver' or dp.name='Gold' order by DATE_BIRTH;

#select clients info(last_name and regictration_date), cars, servises which service materials is null and group by services and 'RI' in name
select cl.first_name as name, cl.last_name as surname, c.model as car_model, c.brand as car_brand, s.name as Service_name from clients cl
 inner join cars c on cl.id=c.client_id inner join service_car sr on c.id=sr.car_id inner join services s on sr.service_id=s.id
 inner join service_material on s.id=service_material.service_id where service_material.material_id is null group by s.name having s.name like '%RI%';
 
 #select  children (name, dob) which parents painter with left join order by children name
select c.first_name as NAME, c.dob as Date_Of_Birth, e.first_name as Parents_name, e.profession as Parents_prof from children c 
inner join employee_children ec on c.id=ec.child_id left join employees e on ec.employee_id=e.id where e.profession='painter' 
order by c.first_name desc;

#union for employees and clients
select c.first_name as name, c.last_name as surname, c.dob as Birth_day from clients c
union
select e.first_name as name, e.last_name as surname, e.dob as Birth_day from employees e order by Birth_day;

#union all for employees and children
select e.first_name as name, e.last_name as surname, e.dob as Birth_day from employees e
union all
select c.first_name as name, c.last_name as surname, c.dob as Birth_day from children c order by name desc;




                     