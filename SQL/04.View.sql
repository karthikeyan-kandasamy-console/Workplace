-- @block CREATE VIEWS
CREATE VIEW chennai_tn_team AS SELECT * FROM employees WHERE location = 'Chennai' AND designation = 'Development'; 


-- @block DELETE VIEWS
DROP VIEW IF EXISTS chennai_tn_team; 


-- @block ACCESS VIEWS
SELECT * FROM chennai_tn_team;
