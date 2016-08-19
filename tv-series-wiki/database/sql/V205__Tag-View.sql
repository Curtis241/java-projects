CREATE VIEW `tag_view` AS
    select 
        `t`.`id` AS `id`,
        `t`.`name` AS `name`,
        `s`.`name` AS `series_name`
    from
        (`tag` `t`
        join `series` `s` ON ((`t`.`series_id` = `s`.`id`)))