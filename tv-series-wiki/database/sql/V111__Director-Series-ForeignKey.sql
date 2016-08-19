ALTER TABLE `director` 
  ADD CONSTRAINT `director_series_fk`
  FOREIGN KEY (`series_id` )
  REFERENCES `series` (`id` )
  ON DELETE CASCADE
  ON UPDATE NO ACTION
, ADD INDEX `director_series_fk` (`series_id` ASC) ;