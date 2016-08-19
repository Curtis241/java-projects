CREATE TABLE `configuration` (
  `configuration_id` INT NOT NULL AUTO_INCREMENT,
  `property_key` VARCHAR(500) NULL,
  `property_value` VARCHAR(500) NULL,
  PRIMARY KEY (`configuration_id`));