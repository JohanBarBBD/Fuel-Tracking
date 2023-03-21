USE master;

IF EXISTS(select * from sys.databases where name='FuelTrackerDB')
DROP DATABASE FuelTrackerDB;

CREATE DATABASE FuelTrackerDB;
GO

USE FuelTrackerDB;

CREATE TABLE [Access] (
  [access_id] int PRIMARY KEY IDENTITY(1, 1),
  [email] nvarchar(255),
  [api_key] nvarchar(255),
  [validity_until] date
)
GO

CREATE TABLE [Vehicles] (
  [vehicle_id] int PRIMARY KEY IDENTITY(1, 1),
  [access_id] int,
  [make] nvarchar(255),
  [model] nvarchar(255),
  [reg] nvarchar(255),
  [odometer] float,
  [fuel_type] int,
  [tank_size] float,
  [km_per_litre] float
)
GO

CREATE TABLE [Fuels] (
  [fuel_id] int PRIMARY KEY IDENTITY(1, 1),
  [start_date] date,
  [end_date] date,
  [fuel_type] nvarchar(255),
  [price_per_litre] float
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
