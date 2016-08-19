ALTER TABLE `episode` 
  ADD CONSTRAINT `episode_genre_fk`
  FOREIGN KEY (`genre_id` )
  REFERENCES `genre` (`id` )
  ON DELETE CASCADE
  ON UPDATE NO ACTION
, ADD INDEX `episode_genre_fk` (`genre_id` ASC) ;