delete from `location`;
delete from `configuration`;

insert into `location` (name) values ('Guest Room');
insert into `location` (name) values ('Living Room');
insert into `location` (name) values ('Kitchen');
insert into `location` (name) values ('Utility Room');
insert into `location` (name) values ('Office');
insert into `location` (name) values ('Master Bedroom');
insert into `location` (name) values ('Foster Room');
insert into `location` (name) values ('Nathans Room');
insert into `location` (name) values ('Outside');


insert into `configuration` (property_key,property_value) values ('weather.service.url','http://api.wunderground.com/api/3ebc563b3a21f044/conditions/q/AB/Calgary.json');
insert into `configuration` (property_key,property_value) values ('weather.service.update.frequency.cron', '0 0/30 * 1/1 * ? *');