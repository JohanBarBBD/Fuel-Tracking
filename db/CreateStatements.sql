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
