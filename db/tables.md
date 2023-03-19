## Tables
# Access
- access_id         int   (PK)
- email_address     varchar(80)
- api_key           varchar(12)
- validity_until    date

# Vehicles
- vehicles_id           int   (PK)
- access_id             int,
- make                  varchar(80)
- model                 varchar(80)
- registration_number   varchar(8)
- odometer              float
- fuel_type             varchar(13)
- tank_size             float
- km_per_litre          float


# Fuel
- fuel_id               int   (PK)
- start_date            date,
- end_date              date,
- fuel_type             varchar(13),
- price_per_litre       float

# Records
- record_id             int   (PK)
- vehicles_id           int,
- record_date           date,
- fuel_usage            float,
- distance              float

# Refuels
- refuel_id             int   (PK)
- vehicles_id           int
- refuel_date           date
- refuel_amount         float
- odometer_reading      float
- cost                  float

