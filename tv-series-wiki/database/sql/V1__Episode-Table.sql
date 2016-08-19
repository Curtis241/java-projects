CREATE  TABLE `episode` (
  `id` CHAR(40) NOT NULL, 
  `name` VARCHAR(50) NOT NULL,
  `production_year` INT NOT NULL,
  `episode_number` INT NOT NULL,
  `season_number` INT NOT NULL,
  `episode_description` LONGTEXT NOT NULL,
  `series_id` CHAR(40) NOT NULL,
  `rating_id` CHAR(40) NOT NULL,
  `genre_id` CHAR(40) NOT NULL,
  `director_id` CHAR(40) NOT NULL,
  `created_at` TIMESTAMP NULL,
  `updated_at` TIMESTAMP NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_unique` (`id` ASC) 
);