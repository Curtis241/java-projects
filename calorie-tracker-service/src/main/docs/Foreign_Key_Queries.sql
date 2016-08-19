SELECT * FROM `calorie-tracker`.registration_info;
DELETE FROM `calorie-tracker`.registration_info;
TRUNCATE `calorie-tracker`.registration_info;

SELECT * FROM `calorie-tracker`.daily_intake;
DELETE FROM `calorie-tracker`.daily_intake;
TRUNCATE `calorie-tracker`.daily_intake;

SELECT * FROM `calorie-tracker`.user_detail;
DELETE FROM `calorie-tracker`.user_detail;
TRUNCATE `calorie-tracker`.user_detail;

SELECT * FROM `calorie-tracker`.serving;
DELETE FROM `calorie-tracker`.serving;
TRUNCATE `calorie-tracker`.serving;



ALTER TABLE `calorie-tracker`.`registration_info` 
DROP FOREIGN KEY `fk_registration_info_serving`;

ALTER TABLE `calorie-tracker`.`registration_info` 
ADD CONSTRAINT `fk_registration_info_serving`
  FOREIGN KEY (`user_id`)
  REFERENCES `calorie-tracker`.`serving` (`user_id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

ALTER TABLE `calorie-tracker`.`daily_intake` 
DROP FOREIGN KEY `fk_daily_intake_serving`;

ALTER TABLE `calorie-tracker`.`daily_intake` 
ADD CONSTRAINT `fk_daily_intake_serving`
  FOREIGN KEY (`user_id`)
  REFERENCES `calorie-tracker`.`serving` (`user_id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

ALTER TABLE `calorie-tracker`.`serving` 
DROP FOREIGN KEY `fk_serving_daily_intake`;

ALTER TABLE `calorie-tracker`.`serving` 
ADD CONSTRAINT `fk_serving_daily_intake`
  FOREIGN KEY (`daily_intake_id`)
  REFERENCES `calorie-tracker`.`daily_intake` (`daily_intake_id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;