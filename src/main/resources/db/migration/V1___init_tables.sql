CREATE SCHEMA IF NOT EXISTS `ah` DEFAULT CHARACTER SET utf8 ;
USE `ah` ;

CREATE TABLE IF NOT EXISTS `ah`.ADDRESS
(
    `id`       INTEGER     NOT NULL  PRIMARY KEY AUTO_INCREMENT,
    `zip_code` VARCHAR(6)  NOT NULL,
    `city`     VARCHAR(30) NOT NULL,
    `street`   VARCHAR(60) NULL
    )
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `ah`.USERS
(
    `id`         INTEGER                  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `email`      VARCHAR(50)              NOT NULL,
    `password`   VARCHAR(255)             NOT NULL,
    `username`   VARCHAR(30)              NULL,
    `pesel`      VARCHAR(11)              NULL,
    `type`       ENUM ('ADMIN', 'CLIENT') NULL,
    `address_id` INT                      NOT NULL,
    UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
    INDEX `fk_Users_Address1_idx` (`address_id` ASC) VISIBLE,
    CONSTRAINT `fk_Users_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `ADDRESS` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    )
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `ah`.TRADE
(
    `id`      INTEGER    NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `value`   DOUBLE     NOT NULL,
    `user_id` INT        NOT NULL,
    INDEX `fk_Trade_Users1_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_Trade_Users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `USERS` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    )
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `ah`.ITEMS
(
    `id`          INTEGER                                           NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `item_name`   VARCHAR(45)                                       NOT NULL,
    `description` VARCHAR(255)                                      NULL,
    `price`       DOUBLE                                            NOT NULL,
    `category`    ENUM ('JEWELRY', 'SPORTS', 'FURNITURE', 'RTVAGD') NOT NULL,
    `status`      ENUM ('AVAILABLE', 'UNAVAILABLE')                 NOT NULL,
    `user_id`     INT                                               NOT NULL,
    `trade_id`    INT                                               NOT NULL,
    CONSTRAINT `fk_Items_Users`
    FOREIGN KEY (`user_id`)
    REFERENCES `USERS` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_Items_Trade1`
    FOREIGN KEY (`trade_id`)
    REFERENCES `TRADE` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    )
    ENGINE = InnoDB;
