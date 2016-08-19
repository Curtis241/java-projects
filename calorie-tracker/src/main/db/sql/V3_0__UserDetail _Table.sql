CREATE TABLE `user_detail` (
  `uid` INT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `md5hash` VARCHAR(255) NOT NULL,
  `last_update` DATETIME NOT NULL,
    `active` TINYINT NOT NULL,
  PRIMARY KEY (`uid`));