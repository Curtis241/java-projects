ALTER TABLE `viewing_history` 
  ADD CONSTRAINT `viewing_history_episode_fk`
  FOREIGN KEY (`episode_id` )
  REFERENCES `episode` (`id` )
  ON DELETE CASCADE
  ON UPDATE NO ACTION
, ADD INDEX `viewing_history_episode_fk` (`episode_id` ASC) ;