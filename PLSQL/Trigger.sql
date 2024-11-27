use aspiresys;

show tables;

select * from employees;

CREATE TABLE employees (
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


INSERT INTO employees (employee_name, date_of_birth, date_of_join, blood_group, address, designation, location, mobile_number, salary)
VALUES
('John Doe', '1990-05-10', '2020-06-01', 'O+', '123 Main St, Chennai', 'Development', 'Chennai', '9876543210', 50000.00);



CREATE TABLE employees (
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

-- @block 
CREATE TABLE salary_update_count (
    update_count INT DEFAULT 0
);

-- @block
INSERT INTO salary_update_count (update_count) VALUES (0);

-- @block
TRUNCATE salary_update_count;

-- @block 
SET GLOBAL sql_mode = '';
SET SQL_SAFE_UPDATES = 0;



DROP table salary_update_count;



-- @block 
SELECT * FROM salary_update_count;


-- @block
UPDATE employees SET salary = 210000 WHERE employee_id = 1;


-- @block
DELIMITER $$
CREATE TRIGGER trg_salary_update_count
AFTER UPDATE ON employees
FOR EACH ROW
BEGIN
    IF OLD.salary != NEW.salary THEN
        -- Increment the count of updated salaries
        UPDATE salary_update_count SET update_count = update_count + 1;
    END IF;
END$$
DELIMITER ;


-- @block
select *  from employees;

-- @block
show tables;


-- @block
desc employees;