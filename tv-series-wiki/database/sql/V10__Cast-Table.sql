CREATE  TABLE `cast` (
  `id` CHAR(40) NOT NULL,
  `episode_id` CHAR(40) NOT NULL,
  `actor_id` CHAR(40) NOT NULL,
  `created_at` TIMESTAMP NULL, 
  `updated_at` TIMESTAMP NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_unique` (`id` ASC) 
);