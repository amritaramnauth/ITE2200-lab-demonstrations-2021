CREATE TABLE users (
    id serial PRIMARY KEY,
    email VARCHAR(60) NOT NULL,
    contact_number VARCHAR(15) NOT NULL,
    address VARCHAR(100) NOT NULL,
    name VARCHAR(50) NOT NULL,
    age INT,
    gender VARCHAR(7),
    hobbies text,
    characteristics text
);