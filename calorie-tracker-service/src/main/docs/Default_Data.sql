DELETE FROM `calorie-tracker`.`daily_intake`;
DELETE FROM `calorie-tracker`.`registration_info`;
DELETE FROM `calorie-tracker`.`serving`;
DELETE FROM `calorie-tracker`.`user_detail`;

#UserDetail
#Password=zewa5xc2
INSERT INTO `user_detail` (`username`,`password`,`last_update`,`active`)
VALUES ("curtispe", "emV3YTV4YzI=","2016-02-01 11:29:00",1);

#UserDetail
#Password=password
INSERT INTO `user_detail` (`username`,`password`,`last_update`,`active`)
VALUES ("nathanpe", "cGFzc3dvcmQ=","2016-02-01 11:29:00",1);

#RegistrationInfo
INSERT INTO `registration_info` (`user_id`,`first_name`,`last_name`,`city`,`state`,`country`,`email`,`last_update`,`active`)
VALUES (1,"Curtis","Peterson","Saskatoon","Saskatchewan","Canada","copeterson07@gmail.com","2016-02-01 11:29:00",1);

INSERT INTO `registration_info` (`user_id`,`first_name`,`last_name`,`city`,`state`,`country`,`email`,`last_update`,`active`)
VALUES (2,"Nathan","Peterson","Saskatoon","Saskatchewan","Canada","nbpeterson@gmail.com","2016-02-01 11:29:00",1);

#DailyIntake for curtispe
INSERT INTO `daily_intake` (`user_id`,`date`,`total_calories`,`calorie_limit`,`calorie_diff`,`active`)
VALUES (1,"2016-01-26",2000,1700,-300,1);

INSERT INTO `daily_intake` (`user_id`,`date`,`total_calories`,`calorie_limit`,`calorie_diff`,`active`)
VALUES (1,"2016-01-27",2000,1700,-300,1);

#DailyIntake for nbpeterson
INSERT INTO `daily_intake` (`user_id`,`date`,`total_calories`,`calorie_limit`,`calorie_diff`,`active`)
VALUES (2,"2016-01-26",2000,1700,-300,1);

INSERT INTO `daily_intake` (`user_id`,`date`,`total_calories`,`calorie_limit`,`calorie_diff`,`active`)
VALUES (2,"2016-01-27",2000,1700,-300,1);

#Servings for curtispe
INSERT INTO `serving` (`daily_intake_id`,`date`,`meal`,`description`,`quantity`,`unit`,`calories`,`last_update`,`active`)
VALUES (1,"2016-01-26","Breakfast","Meal 1",1,"Serving",250,"2016-02-01 11:29:00",1);

INSERT INTO `serving` (`daily_intake_id`,`date`,`meal`,`description`,`quantity`,`unit`,`calories`,`last_update`,`active`)
VALUES (1,"2016-01-26","Breakfast","Meal 2",1,"Serving",250,"2016-02-01 11:29:00",1);

INSERT INTO `serving` (`daily_intake_id`,`date`,`meal`,`description`,`quantity`,`unit`,`calories`,`last_update`,`active`)
VALUES (1,"2016-01-26","Breakfast","Meal 3",1,"Serving",250,"2016-02-01 11:29:00",1);

INSERT INTO `serving` (`daily_intake_id`,`date`,`meal`,`description`,`quantity`,`unit`,`calories`,`last_update`,`active`)
VALUES (1,"2016-01-26","Breakfast","Meal 4",1,"Serving",250,"2016-02-01 11:29:00",1);

INSERT INTO `serving` (`daily_intake_id`,`date`,`meal`,`description`,`quantity`,`unit`,`calories`,`last_update`,`active`)
VALUES (1,"2016-01-26","Breakfast","Meal 5",1,"Serving",250,"2016-02-01 11:29:00",1);

INSERT INTO `serving` (`daily_intake_id`,`date`,`meal`,`description`,`quantity`,`unit`,`calories`,`last_update`,`active`)
VALUES (1,"2016-01-26","Breakfast","Meal 6",1,"Serving",250,"2016-02-01 11:29:00",1);

INSERT INTO `serving` (`daily_intake_id`,`date`,`meal`,`description`,`quantity`,`unit`,`calories`,`last_update`,`active`)
VALUES (1,"2016-01-26","Breakfast","Meal 7",1,"Serving",250,"2016-02-01 11:29:00",1);

INSERT INTO `serving` (`daily_intake_id`,`date`,`meal`,`description`,`quantity`,`unit`,`calories`,`last_update`,`active`)
VALUES (1,"2016-01-26","Breakfast","Meal 8",1,"Serving",250,"2016-02-01 11:29:00",1);


#Servings for nbpeterson
INSERT INTO `serving` (`daily_intake_id`,`date`,`meal`,`description`,`quantity`,`unit`,`calories`,`last_update`,`active`)
VALUES (2,"2016-01-26","Breakfast","Meal 1",1,"Serving",250,"2016-02-01 11:29:00",1);

INSERT INTO `serving` (`daily_intake_id`,`date`,`meal`,`description`,`quantity`,`unit`,`calories`,`last_update`,`active`)
VALUES (2,"2016-01-26","Breakfast","Meal 2",1,"Serving",250,"2016-02-01 11:29:00",1);

INSERT INTO `serving` (`daily_intake_id`,`date`,`meal`,`description`,`quantity`,`unit`,`calories`,`last_update`,`active`)
VALUES (2,"2016-01-26","Breakfast","Meal 3",1,"Serving",250,"2016-02-01 11:29:00",1);

INSERT INTO `serving` (`daily_intake_id`,`date`,`meal`,`description`,`quantity`,`unit`,`calories`,`last_update`,`active`)
VALUES (2,"2016-01-26","Breakfast","Meal 4",1,"Serving",250,"2016-02-01 11:29:00",1);

INSERT INTO `serving` (`daily_intake_id`,`date`,`meal`,`description`,`quantity`,`unit`,`calories`,`last_update`,`active`)
VALUES (2,"2016-01-26","Breakfast","Meal 5",1,"Serving",250,"2016-02-01 11:29:00",1);

INSERT INTO `serving` (`daily_intake_id`,`date`,`meal`,`description`,`quantity`,`unit`,`calories`,`last_update`,`active`)
VALUES (2,"2016-01-26","Breakfast","Meal 6",1,"Serving",250,"2016-02-01 11:29:00",1);

INSERT INTO `serving` (`daily_intake_id`,`date`,`meal`,`description`,`quantity`,`unit`,`calories`,`last_update`,`active`)
VALUES (2,"2016-01-26","Breakfast","Meal 7",1,"Serving",250,"2016-02-01 11:29:00",1);

INSERT INTO `serving` (`daily_intake_id`,`date`,`meal`,`description`,`quantity`,`unit`,`calories`,`last_update`,`active`)
VALUES (2,"2016-01-26","Breakfast","Meal 8",1,"Serving",250,"2016-02-01 11:29:00",1);