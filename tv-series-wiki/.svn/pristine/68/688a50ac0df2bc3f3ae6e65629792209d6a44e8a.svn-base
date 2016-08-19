ALTER TABLE `cast` 
  ADD CONSTRAINT `cast_episode_fk`
  FOREIGN KEY (`episode_id` )
  REFERENCES `episode` (`id` )
  ON DELETE CASCADE
  ON UPDATE NO ACTION
, ADD INDEX `cast_episode_fk` (`episode_id` ASC) ;