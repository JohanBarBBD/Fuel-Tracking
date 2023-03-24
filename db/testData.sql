use master;
GO

USE FuelApiDB;
GO

--INSERT TEMPLATES
--ACCESS
--INSERT INTO dbo.Access (email_address, api_key, validity_until) VALUES ('test1@test.co.za', 'API_KEY', 'yyyy-mm-dd')

--VEHICLES
--INSERT INTO dbo.Vehicles (access_id, make, model, registration_number, odometer, fuel_type, tank_size, km_per_litre) 
--VALUES (1, 'make', 'model', 'reg_num', 123456.12, 'petrol', 50, 12.34) 

--FUEL
--RECORDS
--REFUELS

--INSERT INTO 
INSERT INTO dbo.Access (email_address, api_key, validity_until) VALUES ('test1@test.co.za', 'testkey', '2023-03-31')


INSERT INTO dbo.Vehicles (access_id, make, model, registration_number, odometer, fuel_type, tank_size, km_per_litre) 
VALUES (1, 'make', 'model', 'reg_num', 123456.12, 'petrol', 50, 12.34) 