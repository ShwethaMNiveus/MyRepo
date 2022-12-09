--============================================================== CREATE  ==============================================================================

javalateralassignment_2=> create table vehicle (
javalateralassignment_2(> id int NOT NULL,
javalateralassignment_2(> registration_no VARCHAR(10) NOT NULL,
javalateralassignment_2(> vehicle_type VARCHAR(10) NOT NULL,
javalateralassignment_2(> name VARCHAR(256) NOT NULL,

javalateralassignment_2(> brand VARCHAR(256) NOT NULL,
javalateralassignment_2(> price DOUBLE PRECISION ,
javalateralassignment_2(> PRIMARY KEY(id) );
CREATE TABLE

insert into vehicle(id, registration_no, vehicle_type, name, brand, price) values(1,'KA 19 4262','2 WHEELER', 'Honda Activa', 'Honda',73534.00);
INSERT 0 1
javalateralassignment_2=>
insert into vehicle(id, registration_no, vehicle_type, name, brand, price) values(2,'KA 19 4222','4 WHEELER', 'Hyundai Creta', 'Hyundai',1044000.00);                                                                                   
INSERT 0 1

javalateralassignment_2=>
insert into vehicle(id, registration_no, vehicle_type, name, brand, price) values(3,'KA 19 8652','4 WHEELER', 'Hyundai Venue', 'Hyundai',753000.00);                                                                                    
INSERT 0 1

javalateralassignment_2=>                       
insert into vehicle(id, registration_no, vehicle_type, name, brand, price) values(4,'KA 19 9763','2 WHEELER', 'Yamaha R15 V4', 'Yamaha', 180195.00);                                                                                    
INSERT 0 1
   
--======================================================READ(SELECT) ====================================================================================
javalateralassignment_2=> select * from vehicle;
 id | registration_no | vehicle_type |     name      |  brand  |  price
----+-----------------+--------------+---------------+---------+---------
  1 | KA 19 4262      | 2 WHEELER    | Honda Activa  | Honda   |   73534
  2 | KA 19 4222      | 4 WHEELER    | Hyundai Creta | Hyundai | 1044000
  3 | KA 19 8652      | 4 WHEELER    | Hyundai Venue | Hyundai |  753000
  4 | KA 19 9763      | 2 WHEELER    | Yamaha R15 V4 | Yamaha  |  180195
(4 rows)


javalateralassignment_2=> select price from vehicle where id=1;                                                                                                                                                                         
 price
-------
 73534
(1 row)
--============================================= UPDATE  ================================================================================================
javalateralassignment_2=> update vehicle set price = 75000 where id=1;
UPDATE 1
javalateralassignment_2=> select price from vehicle where id=1;                                                                                                                                                                         
 price
-------
 75000
 (1 row)

javalateralassignment_2=> select * from vehicle
javalateralassignment_2-> ;
 id | registration_no | vehicle_type |     name      |  brand  |  price
----+-----------------+--------------+---------------+---------+---------
  2 | KA 19 4222      | 4 WHEELER    | Hyundai Creta | Hyundai | 1044000
  3 | KA 19 8652      | 4 WHEELER    | Hyundai Venue | Hyundai |  753000
  4 | KA 19 9763      | 2 WHEELER    | Yamaha R15 V4 | Yamaha  |  180195
  1 | KA 19 4262      | 2 WHEELER    | Honda Activa  | Honda   |   75000
(4 rows)
--====================================================================  DELETE   ========================================================================

javalateralassignment_2=> delete from vehicle where id=4;
DELETE 1
javalateralassignment_2=> select * from vehicle
javalateralassignment_2-> ;
 id | registration_no | vehicle_type |     name      |  brand  |  price
----+-----------------+--------------+---------------+---------+---------
  2 | KA 19 4222      | 4 WHEELER    | Hyundai Creta | Hyundai | 1044000
  3 | KA 19 8652      | 4 WHEELER    | Hyundai Venue | Hyundai |  753000
  1 | KA 19 4262      | 2 WHEELER    | Honda Activa  | Honda   |   75000
(3 rows)

