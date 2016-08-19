CREATE TABLE `user_detail` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `md5hash` VARCHAR(255) NOT NULL,
  `last_update` DATETIME NOT NULL,
  `active` TINYINT NOT NULL,
  PRIMARY KEY (`user_id`));