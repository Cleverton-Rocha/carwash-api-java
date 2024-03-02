CREATE TABLE IF NOT EXISTS Customer (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  address VARCHAR(255) NOT NULL,
  phone VARCHAR(13) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS Car (
  id SERIAL PRIMARY KEY,
  customer_id INT,
  brand VARCHAR(50) NOT NULL,
  model VARCHAR(50) NOT NULL,
  color VARCHAR(50) NOT NULL,
  plate VARCHAR(15) NOT NULL,
  FOREIGN KEY (customer_id) REFERENCES Customer(id)
);

CREATE TABLE IF NOT EXISTS Appointments (
  id SERIAL PRIMARY KEY,
  customer_id INT,
  car_id INT,
  date TIMESTAMP NOT NULL,
  service VARCHAR(255) NOT NULL,
  washed BOOLEAN DEFAULT FALSE NOT NULL,
  FOREIGN KEY (customer_id) REFERENCES Customer(id),
  FOREIGN KEY (car_id) REFERENCES Car(id)
);

CREATE TABLE IF NOT EXISTS services (
  id SERIAL PRIMARY KEY,
  serviceName VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  price_in_cents INT NOT NULL
);

INSERT INTO
  services (serviceName, description, price_in_cents)
VALUES
  (
    'Traditional washing',
    'Revitalize your vehicle with our traditional car wash, delivering exceptional shine and care.',
    6500
  ),
  (
    'Luxury washing',
    'Indulge in luxury with our premium car detailing service, ensuring a meticulous and sophisticated touch for your esteemed vehicle.',
    12000
  );