USE master;

IF EXISTS(select * from sys.databases where name='FuelTrackerDB')
DROP DATABASE FuelTrackerDB;

CREATE DATABASE FuelTrackerDB;
GO

USE FuelTrackerDB;

CREATE TABLE [Access] (
  [access_id] int PRIMARY KEY IDENTITY(1, 1),
  [email] varchar(80),
  [api_key] varchar(12),
  [validity_until] date
)
GO

CREATE TABLE [Vehicles] (
  [vehicle_id] int PRIMARY KEY IDENTITY(1, 1),
  [access_id] int,
  [make] varchar(80),
  [model] varchar(80),
  [reg] varchar(80),
  [odometer] float,
  [fuel_type] int,
  [tank_size] float,
  [km_per_litre] float
)
GO

CREATE TABLE [Fuels] (
  [fuel_id] int PRIMARY KEY IDENTITY(1, 1),
  [fuel_type] varchar(13)
)
GO

CREATE TABLE [FuelPrices] (
  [fuel_price_id] int PRIMARY KEY IDENTITY(1, 1),
  [fuel_id] int,
  [start_date] date,
  [end_date] date,
  [price_per_litre] float
)
GO

CREATE TABLE [Records] (
  [record_id] int PRIMARY KEY IDENTITY(1, 1),
  [vehicle_id] int,
  [record_date] date,
  [fuel_usage] float,
  [distance] float
)
GO

CREATE TABLE [Refuels] (
  [refuel_id] int PRIMARY KEY IDENTITY(1, 1),
  [vehicle_id] int,
  [refuel_date] date,
  [refuel_amount] float,
  [odometer_reading] float,
  [cost] float
)
GO

ALTER TABLE [Vehicles] ADD FOREIGN KEY ([access_id]) REFERENCES [Access] ([access_id])
ALTER TABLE [Vehicles] ADD FOREIGN KEY ([fuel_type]) REFERENCES [Fuels] ([fuel_id])
GO

ALTER TABLE [FuelPrices] ADD FOREIGN KEY ([fuel_id]) REFERENCES [Fuels] ([fuel_id])
GO

ALTER TABLE [Records] ADD FOREIGN KEY ([vehicle_id]) REFERENCES [Vehicles] ([vehicle_id])
GO

ALTER TABLE [Refuels] ADD FOREIGN KEY ([vehicle_id]) REFERENCES [Vehicles] ([vehicle_id])
GO

USE FuelTrackerDB;

INSERT INTO [Access] (api_key, email, validity_until) 
VALUES 
    ('l8Kw6D4qP4KU', 'cpettet0@google.com.au', '2023-05-08'),
    ('xvqNL90iM9aZ', 'bedelheit1@psu.edu', '2023-05-20'),
    ('vqNkYDNppavh', 'ebowlas2@mac.com', '2023-07-26'),
    ('4CkfZ9U1l2kn', 'chedgeley3@free.fr', '2023-05-28'),
    ('TieEmJtyonqI', 'lcrichton4@amazon.co.jp', '2022-06-28'),
    ('A1QvemgV8N0i', 'elacey5@webs.com', '2023-03-10'),
    ('rSIiG3bSUTqw', 'adwelley6@columbia.edu', '2022-07-10'),
    ('4mssF8joPtbb', 'oskittrell7@mac.com', '2022-07-26'),
    ('4ziufM4MevCH', 'kliepina8@stanford.edu', '2023-03-20'),
    ( 'sDfKxRsBmD1Y', 'fgrigorkin9@cornell.edu', '2023-02-10'),
    ( 'TgQhoejHs6R1', 'dgoldhawka@quantcast.com', '2023-04-20'),
    ( '0dWcP78Fw8S3', 'oschruurb@uol.com.br', '2022-06-12'),
    ( 'Ntl9rLScX9Eo', 'fpreecec@businessinsider.com', '2022-05-05'),
    ( 'BZUkXzhlWLyo', 'abrunnsteind@mail.ru', '2023-07-08'),
    ( 'mWJO8h3eRO4a', 'tcordiee@163.com', '2023-07-01'),
    ( 'xijCtykxQolu', 'dgeraldf@mozilla.org', '2023-09-22'),
    ( 'lD0f4tv5L55t', 'rcamoysg@howstuffworks.com', '2023-04-11'),
    ( 'aTS2RTEsmDNI', 'mpughsleyh@phoca.cz', '2023-05-23'),
    ( 'q0BbtQALK07b', 'djanosevici@canalblog.com', '2022-09-04'),
    ( 'iLKfCjM4KZGP', 'mtwigleyj@oracle.com', '2023-10-18'),
    ( 'KLLnaI8BTjKj', 'rdederickk@quantcast.com', '2023-02-14'),
    ( 'YWaLGaPtmnFp', 'aranscombl@bbb.org', '2023-04-14'),
    ( 'rNgWrThngYEI', 'fziemenm@slideshare.net', '2022-10-19'),
    ( 'qjUUuiHjBtzm', 'efernehoughn@friendfeed.com', '2023-04-26'),
    ( 'fYfpJ5Ft5LZl', 'ceasono@msn.com', '2022-09-12'),
    ( 'i297ReXAJSpo', 'acoulep@geocities.jp', '2023-10-02'),
    ( 't0jf94mKCNoP', 'druckledgeq@jalbum.net', '2022-05-13'),
    ( 'at9YsNyuU1oa', 'kdelaguar@wp.com', '2023-04-04'),
    ( 'Awx0WerHMdR6', 'gassafs@opensource.org', '2023-08-08'),
    ( 'sEu702Wkso08', 'igarradt@tinypic.com', '2023-05-06'),
    ( 'VkAiekpQMHtQ', 'dshirrellu@gov.uk', '2022-11-18'),
    ( 'SB0W21MCiyaq', 'blidellv@devhub.com', '2022-06-10'),
    ( 'r9trueUvQYln', 'nmcconaghyw@fastcompany.com', '2022-12-20'),
    ( '9TxBWFiQaVPc', 'jkarlolczakx@yellowbook.com', '2022-05-28'),
    ( 'AYuWICwMIrMy', 'phuzzeyy@e-recht24.de', '2022-11-05'),
    ( 'DcPtw6IUDslo', 'hpurbrickz@telegraph.co.uk', '2022-12-25'),
    ( 'YkDuGrVruXp8', 'bwildman10@blogger.com', '2022-09-22'),
    ( 'dxvUZKsEl0un', 'aborrill11@vimeo.com', '2022-04-22'),
    ( 'FuHsdmPXhVDN', 'tlycett12@xrea.com', '2023-10-23'),
    ( 'vOkfHB7L4ZbD', 'fbarnwill13@netlog.com', '2023-01-14'),
    ( '8A5XQK6oANCp', 'mhertwell14@kickstarter.com', '2023-07-17'),
    ( '7b8g3xjv0nTu', 'dgarces15@forbes.com', '2023-09-13'),
    ( 'fufSc7GLDhgp', 'mhannay16@shinystat.com', '2022-05-20'),
    ( 'oHdhUJ3mb9xN', 'nbiggadyke17@typepad.com', '2023-07-14'),
    ( 'LOs1OkFDQvjU', 'bjenkerson18@gmpg.org', '2023-05-26'),
    ( '0311Vuxab0dz', 'mgeldeford19@tinypic.com', '2022-11-28'),
    ( 'taUtDjT5pFLO', 'pbaynon1a@unicef.org', '2023-08-04'),
    ( '00zCzQmMlZBF', 'vdunkerk1b@trellian.com', '2023-08-07'),
    ( 'deqVa8cmbqQL', 'kabisetti1c@ucoz.ru', '2022-08-10'),
    ( 'FHjJ1qQh73Hz', 'vdavidove1d@umich.edu', '2023-08-25');


INSERT INTO [Fuels] (fuel_type)
VALUES 
	('Petrol 95 ULP'),
	('Petrol 93 ULP'),
	('Petrol 93 LRP'),
	('Diesel');


INSERT INTO Vehicles (access_id, make, model, reg, odometer, fuel_type, tank_size, km_per_litre) 
VALUES 
    (13, 'Volkswagen', 'Vivo', 'HQ25NZGP', 2848.0, 1, 39.1, 17.2),
    (46, 'Mercedes', 'Golf', 'EQ82JFGP', 2935.8, 2, 43.8, 13.6),
    (34, 'BMW', 'Golf', 'TO12BDGP', 2912.3, 2, 59.5, 19.5),
    (31, 'Volkswagen', 'Polo', 'CP45LNGP', 4571.2, 2, 38.6, 12.7),
    (41, 'Mazda', 'Yaris', 'IA37APGP', 323.0, 4, 36.5, 19.7),
    (7, 'Toyota', 'RS7', 'SA36KSGP', 4934.2, 1, 57.1, 16.6),
    (9, 'Audi', 'Vivo', 'LE56YVGP', 3644.1, 1, 53.6, 8.5),
    (36, 'Toyota', 'RS7', 'KO62QDGP', 912.2, 3, 58.2, 18.8),
    (24, 'Audi', 'Golf', 'HW27IFGP', 4357.7, 2, 40.9, 9.5),
    (8, 'Mazda', 'RS7', 'NV01VEGP', 4528.1, 1, 44.1, 11.4),
    (38, 'Mazda', 'M2', 'WY53LHGP', 689.9, 1, 59.0, 16.0),
    (17, 'Volkswagen', 'A1', 'UX33HEGP', 182.0, 1, 35.6, 7.9),
    (34, 'Mercedes', 'RS7', 'YU17OOGP', 4344.9, 2, 32.6, 7.6),
    (43, 'Audi', 'A1', 'OF83FWGP', 3288.4, 3, 43.3, 15.4),
    (19, 'BMW', 'Mazda 2', 'TK54LHGP', 3758.1, 3, 33.3, 10.4),
    (4, 'Toyota', 'Mazda 2', 'GV61MYGP', 4485.1, 1, 39.5, 12.3),
    (29, 'Toyota', 'Yaris', 'DX60LYGP', 2601.0, 2, 59.2, 5.4),
    (2, 'Volkswagen', 'Golf', 'EM21JUGP', 4657.4, 3, 47.3, 15.1),
    (29, 'Audi', 'Yaris', 'RZ64EXGP', 4840.2, 2, 51.7, 5.0),
    (9, 'Volkswagen', 'A1', 'JH28MQGP', 2749.8, 2, 37.1, 13.4),
    (22, 'BMW', 'Polo', 'FM86QQGP', 2837.0, 1, 39.9, 5.5),
    (49, 'Mazda', 'A1', 'BE79TMGP', 3506.5, 3, 33.9, 9.4),
    (31, 'BMW', 'Yaris', 'IM60FKGP', 3825.5, 4, 42.6, 17.3),
    (50, 'Mazda', 'RS7', 'ZK08QLGP', 4927.0, 3, 52.1, 12.4),
    (43, 'Audi', 'RS7', 'CW35QAGP', 4707.0, 3, 35.0, 10.2),
    (48, 'Volkswagen', 'Mazda 2', 'OK72EKGP', 1484.7, 3, 55.4, 11.6),
    (13, 'Mercedes', 'A250', 'ZL49SRGP', 3090.4, 1, 43.3, 17.3),
    (24, 'BMW', 'RS7', 'AQ57GHGP', 4382.8, 3, 58.8, 13.5),
    (16, 'Mercedes', 'A1', 'NE90PIGP', 397.3, 2, 34.8, 15.0),
    (8, 'Audi', 'Golf', 'HO00CKGP', 3980.2, 2, 58.7, 12.2),
    (31, 'Toyota', 'M2', 'ET98HWGP', 3645.8, 1, 51.3, 13.4),
    (19, 'BMW', 'RS7', 'TZ56OVGP', 296.2, 1, 48.1, 16.3),
    (31, 'Mazda', 'A1', 'VZ83PUGP', 1594.6, 2, 51.3, 10.6),
    (44, 'Mercedes', 'Polo', 'CN77YDGP', 3643.4, 4, 42.4, 18.0),
    (16, 'Volkswagen', 'M2', 'AZ76MBGP', 796.9, 3, 48.9, 14.7),
    (35, 'Mazda', 'Vivo', 'CS43GXGP', 3930.8, 2, 58.2, 18.2),
    (5, 'BMW', 'M2', 'ED96ICGP', 1540.2, 3, 55.5, 19.8),
    (25, 'Mercedes', 'Golf', 'XG44KHGP', 2204.4, 3, 58.7, 13.5),
    (49, 'Toyota', 'Yaris', 'EX48BVGP', 591.9, 2, 51.4, 6.2),
    (16, 'Mazda', 'A1', 'JI62LNGP', 3694.0, 4, 33.2, 16.0),
    (18, 'Toyota', 'Mazda 2', 'BE27HTGP', 4289.1, 4, 39.2, 13.2),
    (4, 'BMW', 'Polo', 'MQ97UYGP', 2021.6, 2, 39.3, 16.1),
    (6, 'BMW', 'A1', 'FQ11HRGP', 2171.7, 3, 59.0, 8.0),
    (9, 'Mazda', 'M2', 'NG24SAGP', 2682.1, 4, 49.4, 8.6),
    (4, 'BMW', 'Golf', 'EM85MIGP', 2891.4, 3, 55.3, 5.8),
    (41, 'Audi', 'M2', 'CV50BJGP', 3784.7, 2, 55.6, 19.9),
    (36, 'Mazda', 'Mazda 2', 'NX80WGGP', 4327.9, 4, 44.9, 12.3),
    (46, 'Volkswagen', 'A250', 'SE02EUGP', 2215.8, 1, 57.3, 14.2),
    (2, 'Volkswagen', 'A1', 'CE10EGGP', 956.2, 3, 56.4, 13.0),
    (37, 'Toyota', 'Yaris', 'PM92LZGP', 3048.6, 3, 45.9, 10.7),
    (48, 'Audi', 'RS7', 'IA88PJGP', 738.1, 3, 30.7, 11.1),
    (46, 'Mercedes', 'A250', 'AR51WZGP', 4608.9, 1, 59.9, 9.0),
    (4, 'Mazda', 'Golf', 'CY46WMGP', 3432.8, 4, 37.7, 14.1),
    (27, 'Mercedes', 'Yaris', 'CB18ZGGP', 2619.0, 3, 34.7, 6.7),
    (18, 'Toyota', 'Vivo', 'EX38IRGP', 2265.4, 3, 46.0, 12.5),
    (13, 'Volkswagen', 'A1', 'BN93WFGP', 2051.4, 1, 41.2, 11.0),
    (41, 'Audi', 'M2', 'TZ64AGGP', 4833.2, 1, 39.3, 18.4),
    (43, 'Mazda', 'A1', 'CK70JCGP', 1451.7, 4, 41.0, 12.2),
    (23, 'Mercedes', 'Polo', 'YS71TNGP', 844.0, 1, 39.4, 11.7),
    (5, 'Volkswagen', 'A1', 'AM53ETGP', 4564.4, 3, 40.5, 12.6),
    (18, 'BMW', 'A1', 'FM51LXGP', 180.9, 4, 40.0, 12.2),
    (22, 'Mercedes', 'A250', 'VM59EJGP', 2566.2, 4, 41.7, 15.5),
    (37, 'Audi', 'Polo', 'AM70FIGP', 1614.0, 1, 32.3, 19.9),
    (15, 'BMW', 'Mazda 2', 'UP99YCGP', 524.0, 4, 35.5, 7.5),
    (23, 'Audi', 'Vivo', 'LU16QIGP', 1586.5, 3, 36.4, 13.6),
    (36, 'Audi', 'Polo', 'HW76IPGP', 2157.5, 1, 32.0, 17.8),
    (32, 'Toyota', 'Mazda 2', 'KI98EBGP', 1116.3, 4, 33.2, 17.0),
    (29, 'Volkswagen', 'RS7', 'ZD90GOGP', 482.7, 2, 42.3, 8.3),
    (42, 'Mazda', 'Mazda 2', 'ZH77KBGP', 3172.4, 4, 46.5, 19.7),
    (9, 'Volkswagen', 'Vivo', 'JW29RUGP', 1218.9, 2, 36.5, 17.4),
    (35, 'BMW', 'A250', 'CF75KMGP', 4083.2, 3, 59.6, 10.7),
    (33, 'Volkswagen', 'A250', 'FU23QEGP', 1020.1, 2, 36.2, 19.2),
    (42, 'Volkswagen', 'RS7', 'CL09ZTGP', 506.0, 1, 34.0, 19.3),
    (35, 'Mazda', 'RS7', 'XC28NLGP', 4301.7, 2, 34.1, 10.2),
    (36, 'Toyota', 'A1', 'DB39GIGP', 2909.2, 3, 53.9, 5.4);
    
   
INSERT INTO FuelPrices (fuel_id, start_date, end_date, price_per_litre)
VALUES
	(3, '2023-01-04', '2023-02-05', 22.74),
	(2, '2023-01-04', '2023-02-05', 22.74),
	(1, '2023-01-04', '2023-02-05', 22.74),
	(4, '2023-01-04', '2023-02-05', 20.47),
	(3, '2023-02-04', '2023-03-05', 21.78),
	(2, '2023-02-04', '2023-03-05', 21.78),
	(1, '2023-02-04', '2023-03-05', 21.78),
	(4, '2023-02-04', '2023-03-05', 22.32),
	(3, '2023-03-04', '2023-04-05', 22.32),
	(2, '2023-03-04', '2023-04-05', 22.32),
	(1, '2023-03-04', '2023-04-05', 22.32),
	(4, '2023-03-04', '2023-04-05', 22.32);


INSERT INTO Refuels (vehicle_id, refuel_date, refuel_amount, odometer_reading, cost) 
VALUES 
    (29, '2023-01-27', 25.34, 3268.2, 729.38),
    (14, '2023-02-26', 12.93, 2815.2, 1414.38),
    (36, '2022-11-22', 22.23, 4276.3, 1981.67),
    (51, '2023-02-26', 20.93, 314.7, 249.1),
    (68, '2023-01-12', 11.07, 1169.0, 1046.54),
    (36, '2022-12-07', 10.04, 4087.3, 701.6),
    (46, '2023-01-21', 6.39, 2162.2, 349.51),
    (61, '2022-11-28', 16.98, 3312.9, 1092.85),
    (58, '2023-01-30', 1.36, 1164.7, 1011.37),
    (72, '2023-03-05', 27.06, 2181.4, 1220.76),
    (42, '2023-03-03', 26.83, 3088.9, 1000.35),
    (65, '2022-12-10', 25.08, 1528.6, 107.39),
    (34, '2023-03-01', 2.27, 3786.3, 172.81),
    (47, '2023-01-13', 24.95, 4354.2, 818.85),
    (28, '2022-12-19', 26.17, 3314.9, 824.96),
    (59, '2022-12-11', 10.95, 1432.2, 675.58),
    (40, '2023-03-21', 24.19, 3617.2, 316.1),
    (64, '2023-01-01', 21.5, 2702.8, 295.66),
    (72, '2022-12-28', 13.91, 1433.9, 1023.72),
    (43, '2023-02-05', 13.34, 2830.9, 1870.19),
    (75, '2023-02-05', 0.56, 1668.6, 549.61),
    (3, '2023-01-02', 14.43, 3815.9, 511.56),
    (47, '2023-03-20', 29.65, 1558.9, 433.25),
    (50, '2022-12-08', 5.77, 2484.0, 1425.75),
    (19, '2022-12-28', 24.75, 4939.7, 735.31),
    (19, '2022-12-27', 11.8, 2644.4, 1787.06),
    (2, '2023-01-15', 0.72, 1283.3, 362.81),
    (28, '2022-12-31', 11.32, 659.9, 1577.9),
    (41, '2022-11-23', 9.05, 2096.6, 932.93),
    (68, '2023-02-11', 16.84, 1090.7, 1185.19),
    (43, '2023-02-20', 11.6, 3669.2, 883.96),
    (69, '2023-01-14', 12.1, 2535.1, 1757.4),
    (17, '2023-02-18', 5.05, 1621.7, 109.17),
    (28, '2023-02-09', 1.84, 3601.0, 346.89),
    (32, '2023-01-05', 7.64, 3205.2, 1953.63),
    (72, '2022-12-14', 23.09, 2628.8, 1796.87),
    (73, '2022-12-09', 17.85, 2654.2, 668.75),
    (37, '2023-03-07', 11.61, 1919.1, 1442.49),
    (50, '2023-01-15', 25.8, 3915.2, 1338.44),
    (48, '2023-02-17', 4.44, 2953.4, 1736.54),
    (36, '2022-12-15', 28.52, 1651.1, 1734.51),
    (38, '2023-01-26', 1.05, 3935.4, 992.22),
    (3, '2023-01-06', 10.65, 2057.0, 1341.95),
    (21, '2023-01-01', 8.25, 941.9, 812.25),
    (72, '2023-03-18', 1.61, 2807.0, 606.84),
    (52, '2023-01-16', 13.1, 275.4, 1701.88),
    (10, '2023-02-17', 28.18, 435.9, 1785.39),
    (12, '2023-03-12', 1.67, 2995.7, 1993.04),
    (26, '2023-03-01', 16.05, 3372.1, 1049.41),
    (7, '2022-11-27', 14.72, 1531.8, 1821.94),
    (14, '2022-12-26', 25.25, 3378.5, 1992.43),
    (47, '2023-01-14', 27.96, 3566.9, 557.43),
    (20, '2023-01-31', 5.46, 1520.7, 1627.69),
    (24, '2023-02-08', 4.92, 3725.5, 1520.34),
    (11, '2023-02-01', 29.07, 316.9, 1558.27),
    (75, '2022-12-31', 1.08, 3430.3, 1022.42),
    (50, '2022-11-24', 6.03, 3440.7, 864.54),
    (75, '2022-12-12', 22.15, 653.3, 623.51),
    (48, '2023-01-17', 20.84, 3936.4, 1057.11),
    (20, '2023-01-14', 3.98, 2751.7, 657.16),
    (48, '2022-11-27', 18.95, 4948.7, 803.78),
    (26, '2022-12-21', 10.15, 4746.4, 663.85),
    (64, '2022-12-29', 11.97, 4646.2, 354.2),
    (54, '2023-03-04', 13.05, 2484.8, 1243.29),
    (45, '2023-02-15', 9.6, 4952.4, 455.21),
    (17, '2022-11-30', 6.12, 394.5, 1343.72),
    (9, '2023-01-23', 29.73, 4270.2, 1940.67),
    (49, '2022-11-30', 19.53, 3869.2, 1145.82),
    (69, '2023-03-09', 0.39, 4335.2, 1414.92),
    (47, '2023-03-16', 27.15, 2565.7, 1708.54),
    (57, '2022-12-31', 6.95, 1563.4, 581.91),
    (24, '2023-01-29', 21.74, 4513.2, 1396.21),
    (65, '2023-01-30', 29.02, 4461.6, 1634.88),
    (39, '2023-03-01', 14.71, 3738.7, 1053.11),
    (41, '2022-11-27', 19.68, 3162.3, 666.27),
    (23, '2023-01-04', 20.07, 2714.2, 382.37),
    (28, '2023-01-14', 29.78, 4737.4, 1283.35),
    (60, '2022-12-12', 16.96, 1433.9, 1260.28),
    (63, '2022-11-22', 18.7, 799.4, 1653.88),
    (5, '2022-12-17', 5.47, 4250.5, 981.6);

