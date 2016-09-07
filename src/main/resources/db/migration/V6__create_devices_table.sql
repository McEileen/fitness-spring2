CREATE TABLE `fitness`.`devices` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT NOT NULL DEFAULT 0,
  `serial_number` VARCHAR(45) NOT NULL,
  `product` ENUM('FITBITSURGE', 'UP3', 'APPLEWATCH', 'DROIDWATCH') NOT NULL,
  `category` ENUM('RUNNING', 'SWIMMING', 'BIKING') NULL,
  `user_id` INT NOT NULL,
  `created` TIMESTAMP NOT NULL DEFAULT NOW(),
  `modified` TIMESTAMP NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_users_v6`
  FOREIGN KEY (`user_id`)
  REFERENCES `fitness`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
