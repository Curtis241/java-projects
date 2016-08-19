CREATE VIEW `first_billed_cast_view` AS
    select 
        `f`.`id` AS `id`,
        `f`.`name` AS `name`,
        `a`.`name` AS `actor_name`,
        `a`.`character_name` AS `character_name`,
        `s`.`name` AS `series_name`
    from
        ((`first_billed_cast` `f`
        join `actor` `a` ON ((`f`.`actor_id` = `a`.`id`)))
        join `series` `s` ON ((`a`.`series_id` = `s`.`id`)))