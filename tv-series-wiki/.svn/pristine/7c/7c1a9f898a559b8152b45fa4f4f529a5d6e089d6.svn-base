ALTER TABLE `episode` 
  ADD CONSTRAINT `episode_rating_fk`
  FOREIGN KEY (`rating_id` )
  REFERENCES `rating` (`id` )
  ON DELETE CASCADE
  ON UPDATE NO ACTION
, ADD INDEX `episode_rating_fk` (`rating_id` ASC) ;