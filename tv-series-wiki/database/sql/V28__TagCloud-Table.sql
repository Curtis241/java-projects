CREATE  TABLE `tag_cloud` (
  `id` CHAR(40) NOT NULL ,
  `episode_id` CHAR(40) NOT NULL,
  `tag_id` CHAR(40) NOT NULL,
  `created_at` TIMESTAMP NULL,
  `updated_at` TIMESTAMP NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_unique` (`id` ASC) 
);