ALTER TABLE `thermometer_location` ADD COLUMN `last_update` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP AFTER `trash` ;