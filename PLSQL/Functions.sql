-- @block CREATE FUNCTION
CREATE FUNCTION greet_user(name VARCHAR(50))
RETURNS VARCHAR(100) DETERMINISTIC
BEGIN
    DECLARE greeting VARCHAR(100);
    IF HOUR(CURRENT_TIME) < 12 THEN
        SET greeting = CONCAT('Good Morning, ', name);
    ELSEIF HOUR(CURRENT_TIME) < 18 THEN
        SET greeting = CONCAT('Good Afternoon, ', name);
    ELSE
        SET greeting = CONCAT('Good Evening, ', name);
    END IF;
    RETURN greeting;
END;

-- @block VIEW ALL FUNCTIONS
SHOW FUNCTION STATUS;

-- @block DROP FUNCTION
DROP FUNCTION IF EXISTS greet_user;

-- @block EXECUTE FUNCTION
SELECT greet_user('Alice'); 




