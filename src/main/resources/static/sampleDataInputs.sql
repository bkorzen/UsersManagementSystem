INSERT INTO `groups`(`group_name`) VALUES ('Java'); -- 1
INSERT INTO `groups`(`group_name`) VALUES ('C/C++'); -- 2
INSERT INTO `groups`(`group_name`) VALUES ('MySQL'); -- 3
INSERT INTO `groups`(`group_name`) VALUES ('Python'); -- 4
INSERT INTO `groups`(`group_name`) VALUES ('PHP'); -- 5
INSERT INTO `groups`(`group_name`) VALUES ('Scala'); -- 6
INSERT INTO `groups`(`group_name`) VALUES ('.Net'); -- 7
INSERT INTO `groups`(`group_name`) VALUES ('Ruby'); -- 8
INSERT INTO `groups`(`group_name`) VALUES ('Mobile'); -- 9
--

INSERT INTO `users`(`date_of_birth`, `first_name`, `last_name`, `password`, `username`)
VALUES ('1975-08-20', 'John', 'Smith', '12345', 'johnny'); -- 1
INSERT INTO `users`(`date_of_birth`, `first_name`, `last_name`, `password`, `username`)
VALUES ('1965-09-24', 'Chris', 'Mandolew', '12345', 'chris'); -- 2
INSERT INTO `users`(`date_of_birth`, `first_name`, `last_name`, `password`, `username`)
VALUES ('1995-02-10', 'Thomas', 'Shelby', '12345', 'tommy'); -- 3
INSERT INTO `users`(`date_of_birth`, `first_name`, `last_name`, `password`, `username`)
VALUES ('1966-06-12', 'John', 'Rambo', '12345', 'rambo'); -- 4
INSERT INTO `users`(`date_of_birth`, `first_name`, `last_name`, `password`, `username`)
VALUES ('1993-05-23', 'Arthur', 'Shelby', '12345', 'R2D2'); -- 5
INSERT INTO `users`(`date_of_birth`, `first_name`, `last_name`, `password`, `username`)
VALUES ('2000-12-11', 'Luke', 'Skywalker', '12345', 'lukas'); -- 6
INSERT INTO `users`(`date_of_birth`, `first_name`, `last_name`, `password`, `username`)
VALUES ('1995-08-20', 'Darth', 'Vader', '12345', 'vadi'); -- 7
INSERT INTO `users`(`date_of_birth`, `first_name`, `last_name`, `password`, `username`)
VALUES ('1996-03-10', 'Rick', 'Sanchez', '12345', 'ricky'); -- 8
INSERT INTO `users`(`date_of_birth`, `first_name`, `last_name`, `password`, `username`)
VALUES ('1987-01-01', 'Morty', 'Smith', '12345', 'mort'); -- 9

INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (1,1);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (1,2);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (1,5);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (1,8);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (1,9);

INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (2,1);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (2,3);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (2,6);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (2,8);

INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (3,3);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (3,4);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (3,5);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (3,9);

INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (4,2);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (4,3);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (4,6);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (4,7);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (4,8);

INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (5,1);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (5,7);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (5,8);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (5,9);

INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (6,9);

INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (7,1);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (7,2);

INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (8,1);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (8,2);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (8,3);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (8,4);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (8,5);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (8,6);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (8,8);

INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (9,5);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (9,6);
INSERT INTO `user_group`(`user_id`, `group_id`) VALUES (9,8);











