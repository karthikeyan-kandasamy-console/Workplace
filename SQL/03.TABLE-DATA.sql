-- @block DESCRIBE
DESC employees;


-- @block INSERT
INSERT INTO employees (employee_name, date_of_birth, date_of_join, blood_group, address, designation, location, mobile_number, salary)
VALUES
('Karthik', '1990-05-10', '2020-06-01', 'O+', '123 Main St, Chennai', 'Development', 'Chennai', '9876543210', 50000.00),
('Abishek', '1985-08-15', '2019-07-20', 'A-', '456 Elm St, Hyderabad', 'Testing', 'Hyderabad', '9876543211', 60000.00),
('Gary', '1992-12-25', '2021-01-15', 'B+', '789 Pine St, Kochi', 'HR', 'Kochi', '9876543212', 55000.00),
('Harish', '1988-03-30', '2018-05-10', 'AB+', '101 Maple St, Chennai', 'Development', 'Chennai', '9876543213', 70000.00),
('Lucky', '1995-11-05', '2022-02-28', 'O-', '202 Oak St, Hyderabad', 'Training', 'Hyderabad', '9876543214', 45000.00);



-- @block READ
SELECT * FROM employees;
-- SELECT employee_name,date_of_birth FROM employees;


-- @block UPDATE
UPDATE employees SET salary=10000;


--  @block DELETE
-- DELETE FROM STUDENT;
DELETE FROM employees WHERE employee_id=5;


--  @block TRUNCATE
TRUNCATE employees;


