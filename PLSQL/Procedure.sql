-- @block CREATE PROCEDURE
CREATE PROCEDURE get_employee_details(IN emp_id INT)
BEGIN
    SELECT *
    FROM employees
    WHERE employee_id = emp_id;
END;


-- @block EXECUTE
CALL get_employee_details(1);

-- @block 
SHOW PROCEDURE STATUS;

-- @block FOR PARTICULAR DATABASE
SHOW PROCEDURE STATUS WHERE Db = 'incvo';


-- @block 
DROP PROCEDURE IF EXISTS get_employee_details;
