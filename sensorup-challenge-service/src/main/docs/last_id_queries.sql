SELECT LAST_INSERT_ID() as lastId FROM `sensorup`.sensor;


SELECT MAX( id ) as lastId FROM `sensorup`.sensor;


SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'sensorup' AND TABLE_NAME = 'sensor';