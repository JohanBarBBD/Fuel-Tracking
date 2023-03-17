CREATE TABLE [Access] (
  [access_id] int PRIMARY KEY IDENTITY(1, 1),
  [email_address] varchar(80),
  [api_key] varchar(12),
  [validity_until] date
)
GO

CREATE TABLE [Vehicles] (
  [vehicles_id] int PRIMARY KEY IDENTITY(1, 1),
  [access_id] int,
  [make] varchar(80),
  [model] varchar(80),
  [registration_number] varchar(8),
  [odometer] float,
  [fuel_type] varchar(13),
  [tank_size] float,
  [km_per_litre] float
)
GO

CREATE TABLE [Fuel] (
  [fuel_id] int PRIMARY KEY IDENTITY(1, 1),
  [start_date] date,
  [end_date] date,
  [fuel_type] varchar(13),
  [price_per_litre] float
)
GO

CREATE TABLE [Records] (
  [record_id] int PRIMARY KEY IDENTITY(1, 1),
  [vehicles_id] int,
  [record_date] date,
  [fuel_usage] float,
  [distance] float
)
GO

CREATE TABLE [Refuels] (
  [refuel_id] int PRIMARY KEY IDENTITY(1, 1),
  [vehicles_id] int,
  [refuel_date] date,
  [refuel_amount] float,
  [odometer_reading] float,
  [cost] float
)
GO

ALTER TABLE [Vehicles] ADD FOREIGN KEY ([access_id]) REFERENCES [Access] ([access_id])
GO

CREATE TABLE [Vehicles_Records] (
  [Vehicles_vehicles_id] int,
  [Records_vehicles_id] int,
  PRIMARY KEY ([Vehicles_vehicles_id], [Records_vehicles_id])
);
GO

ALTER TABLE [Vehicles_Records] ADD FOREIGN KEY ([Vehicles_vehicles_id]) REFERENCES [Vehicles] ([vehicles_id]);
GO

ALTER TABLE [Vehicles_Records] ADD FOREIGN KEY ([Records_vehicles_id]) REFERENCES [Records] ([vehicles_id]);
GO


CREATE TABLE [Vehicles_Refuels] (
  [Vehicles_vehicles_id] int,
  [Refuels_vehicles_id] int,
  PRIMARY KEY ([Vehicles_vehicles_id], [Refuels_vehicles_id])
);
GO

ALTER TABLE [Vehicles_Refuels] ADD FOREIGN KEY ([Vehicles_vehicles_id]) REFERENCES [Vehicles] ([vehicles_id]);
GO

ALTER TABLE [Vehicles_Refuels] ADD FOREIGN KEY ([Refuels_vehicles_id]) REFERENCES [Refuels] ([vehicles_id]);
GO

