CREATE TRIGGER `rating_trigger` BEFORE INSERT ON `rating` FOR EACH ROW SET NEW.created_at=now();