CREATE VIEW `episode_view` AS
    select 
        `e`.`id` AS `id`,
        `e`.`name` AS `name`,
        `e`.`production_year` AS `production_year`,
        `e`.`episode_number` AS `episode_number`,
        `e`.`season_number` AS `season_number`,
        `e`.`episode_description` AS `episode_description`,
        `s`.`name` AS `series_name`,
        `r`.`name` AS `rating_name`,
        `g`.`name` AS `genre_name`,
        `d`.`name` AS `director_name`
    from
        ((((`episode` `e`
        join `series` `s` ON ((`e`.`series_id` = `s`.`id`)))
        join `rating` `r` ON ((`e`.`rating_id` = `r`.`id`)))
        join `genre` `g` ON ((`e`.`genre_id` = `g`.`id`)))
        join `director` `d` ON ((`e`.`director_id` = `d`.`id`)))