ALTER TABLE `tag_cloud` 
  ADD CONSTRAINT `tag_cloud_tag_fk`
  FOREIGN KEY (`tag_id` )
  REFERENCES `tag` (`id` )
  ON DELETE CASCADE
  ON UPDATE NO ACTION
, ADD INDEX `tag_cloud_tag_fk` (`tag_id` ASC) ;