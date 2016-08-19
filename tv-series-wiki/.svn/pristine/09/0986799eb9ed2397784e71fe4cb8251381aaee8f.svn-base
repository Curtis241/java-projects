ALTER TABLE `first_billed_cast` 
  ADD CONSTRAINT `first_billed_cast_actor_fk`
  FOREIGN KEY (`actor_id` )
  REFERENCES `actor` (`id` )
  ON DELETE CASCADE
  ON UPDATE NO ACTION
, ADD INDEX `first_billed_cast_actor_fk` (`actor_id` ASC) ;