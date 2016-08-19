CREATE  TABLE `director` (
  `id` CHAR(40) NOT NULL ,
  `name` VARCHAR(50) NOT NULL,
  `created_at` TIMESTAMP NULL,
  `updated_at` TIMESTAMP NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_unique` (`id` ASC) 
);