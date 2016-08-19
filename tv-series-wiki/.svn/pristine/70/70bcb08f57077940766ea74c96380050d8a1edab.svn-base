ALTER TABLE `episode` 
  ADD CONSTRAINT `episode_director_fk`
  FOREIGN KEY (`director_id` )
  REFERENCES `director` (`id` )
  ON DELETE CASCADE
  ON UPDATE NO ACTION
, ADD INDEX `episode_director_fk` (`director_id` ASC) ;