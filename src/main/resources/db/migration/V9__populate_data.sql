INSERT INTO `fitness`.`roles` (`version`, `role`) VALUES ('0', 'USER');
INSERT INTO `fitness`.`roles` (`version`, `role`) VALUES ('0', 'ADMIN');

INSERT INTO `fitness`.`users` (`version`, `username`, `password`, `enabled`) VALUES ('0', 'bob@aol.com', '$2a$10$8jBGVl3r1DCCHqLHUabm2uV3IT8tA2p8yfYmR7Lru1QcspIYwrf8S', '1');

INSERT INTO `fitness`.`roles_users` (`role_id`, `user_id`) VALUES ('1', '1');
INSERT INTO `fitness`.`roles_users` (`role_id`, `user_id`) VALUES ('2', '1');

INSERT INTO `fitness`.`profiles` (`version`, `gender`, `age`, `height`, `weight`, `photo`, `user_id`)
VALUES ('0', 'M', '25', '70', '165', 'http://findicons.com/files/icons/1072/face_avatars/300/i05.png', '1');

INSERT INTO `fitness`.`exercises` (`version`, `type`, `quantity`, `calories`, `duration`, `user_id`)
VALUES ('0', 'RUN', '3', '900', '45', '1');

INSERT INTO `fitness`.`devices` (`version`, `serial_number`, `product`, `category`, `user_id`, `created`, `modified`)
VALUES ('0', '123ABC', 'FITBITSURGE', 'RUNNING', '1', '2016-01-01', '2016-01-01');

INSERT INTO `fitness`.`runs` (`version`, `device_id`, `start_time`, `end_time`, `created`, `modified`)
VALUES ('0', '1', '2016-01-02', '2016-01-02', '2016-01-03', '2016-01-02');
INSERT INTO `fitness`.`runs` (`version`, `device_id`, `start_time`, `end_time`, `created`, `modified`)
VALUES ('0', '1', '2016-01-02', '2016-01-03', '2016-01-04', '2016-01-02');
INSERT INTO `fitness`.`runs` (`version`, `device_id`, `start_time`, `created`, `modified`)
VALUES ('0', '1', '2016-01-02', '2016-01-02', '2016-01-02');

INSERT INTO `fitness`.`positions` (`version`, `run_id`, `current_time`, `latitude`, `longitude`, `altitude`, `created`, `modified`)
VALUES ('0', '1', '2016-01-02', '1', '1', '1', '2016-01-02', '2016-01-02');