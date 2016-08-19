ALTER TABLE `daily_intake`
ADD CONSTRAINT `fk_daily_intake_user_detail`
  FOREIGN KEY (`user_id`)
  REFERENCES `user_detail` (`user_id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;