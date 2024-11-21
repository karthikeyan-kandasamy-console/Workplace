-- @block SHOW ALL TABLES
SHOW TABLES;


-- @block CREATE TABLE
CREATE TABLE IF NOT EXISTS employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_name VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL,
    date_of_join DATE NOT NULL,
    blood_group VARCHAR(5),
    address TEXT,
    designation ENUM('Training', 'Development', 'Testing', 'HR') NOT NULL,
    location ENUM('Chennai', 'Hyderabad', 'Kochi') NOT NULL,
    mobile_number VARCHAR(15) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL
);


-- @block SHOW COLUMNS
SHOW COLUMNS FROM employees;


-- @block DESCRIBE TABLE
DESC employees;
DESCRIBE employees;


-- @block DELETE TABLE
DROP TABLE IF EXISTS employees;


-- @block DELETE ALL RECORDS FROM TABLE
TRUNCATE TABLE employees;


-- @block SHOW CREATE TABLE
SHOW CREATE TABLE employees;


-- @block VIEW TABLE DATA
SELECT * FROM employees;


-- @block ADD COLUMN
ALTER TABLE employees ADD COLUMN team VARCHAR(20);



-- @block DELETE COLUMN
ALTER TABLE employees DROP COLUMN team;



-- @block MODIFY COLUMN DATATYPE
ALTER TABLE employees MODIFY COLUMN blood_group VARCHAR(10);


-- @block RENAME COLUMN 
ALTER TABLE employees CHANGE COLUMN full_address address text;

