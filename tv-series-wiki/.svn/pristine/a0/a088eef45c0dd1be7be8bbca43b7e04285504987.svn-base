ALTER TABLE `tag_cloud` 
  ADD CONSTRAINT `tag_cloud_episode_fk`
  FOREIGN KEY (`episode_id` )
  REFERENCES `episode` (`id` )
  ON DELETE CASCADE
  ON UPDATE NO ACTION
, ADD INDEX `tag_cloud_episode_fk` (`episode_id` ASC) ;