CREATE TRIGGER `series_trigger` BEFORE INSERT ON `series` FOR EACH ROW SET NEW.created_at=now();