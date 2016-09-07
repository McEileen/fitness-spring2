CREATE TABLE `fitness`.`positions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `version` INT NOT NULL DEFAULT 0,
  `run_id` INT NOT NULL,
  `current_time` TIMESTAMP NOT NULL DEFAULT NOW(),
  `latitude` FLOAT NULL,
  `longitude` FLOAT NULL,
  `altitude` FLOAT NULL,
  `created` TIMESTAMP NOT NULL DEFAULT NOW(),
  `modified` TIMESTAMP NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_runs_v8`
  FOREIGN KEY (`run_id`)
  REFERENCES `fitness`.`devices` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
