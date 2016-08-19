ALTER TABLE `episode` 
  ADD CONSTRAINT `episode_series_fk`
  FOREIGN KEY (`series_id` )
  REFERENCES `series` (`id` )
  ON DELETE CASCADE
  ON UPDATE NO ACTION
, ADD INDEX `episode_series_fk` (`series_id` ASC) ;