ALTER TABLE `serving`
ADD CONSTRAINT `fk_serving_daily_intake`
  FOREIGN KEY (`daily_intake_id`)
  REFERENCES `daily_intake` (`daily_intake_id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;