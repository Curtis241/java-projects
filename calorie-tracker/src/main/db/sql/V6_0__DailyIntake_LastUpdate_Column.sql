ALTER TABLE `daily_intake` CHANGE COLUMN `last_update` `last_update` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ;