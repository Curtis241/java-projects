CREATE TRIGGER `actor_trigger` BEFORE INSERT ON `actor` FOR EACH ROW SET NEW.created_at=now();