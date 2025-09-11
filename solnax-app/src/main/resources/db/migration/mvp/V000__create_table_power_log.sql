
CREATE TABLE power_log(
    time timestamp primary key default current_timestamp,
    solar_in double precision,
    house_out double precision,
    heat_out double precision,
    charger_out double precision,
    power_wall double precision
);