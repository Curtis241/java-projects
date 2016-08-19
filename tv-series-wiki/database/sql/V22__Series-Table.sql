CREATE  TABLE `series` (
  `id` CHAR(40) NOT NULL ,
  `name` VARCHAR(50) NOT NULL,
  `season_count` INT NOT NULL,
  `start_date` TIMESTAMP NULL,
  `end_date` TIMESTAMP NULL,
  `created_at` TIMESTAMP NULL,
  `updated_at` TIMESTAMP NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_unique` (`id` ASC) 
);