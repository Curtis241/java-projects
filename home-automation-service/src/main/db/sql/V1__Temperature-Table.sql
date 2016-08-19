CREATE TABLE `temperature` (
  `temperature_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `temperature` decimal(5,2) NOT NULL,
  `thermometer_name` varchar(45) NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`temperature_id`)
)