CREATE SCHEMA IF NOT EXISTS `ah_graphql` DEFAULT CHARACTER SET utf8 ;
USE `ah_graphql` ;

CREATE TABLE IF NOT EXISTS `ah_graphql`.ADDRESS
(
    `id`       INTEGER     NOT NULL  PRIMARY KEY AUTO_INCREMENT,
    `city`     VARCHAR(30) NOT NULL,
    `street`   VARCHAR(60) NULL
)
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `ah_graphql`.USERS
(
    `id`         INTEGER                  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `email`      VARCHAR(50)              NOT NULL,
    `first_name`   VARCHAR(30)              NULL,
    `last_name`   VARCHAR(30)              NULL,
    `pesel`      VARCHAR(11)              NULL,
    `address` INT                      NULL,
    INDEX `fk_Users_Address1_idx` (`address` ASC) VISIBLE,
    CONSTRAINT `fk_Users_address1`
        FOREIGN KEY (`address`)
            REFERENCES `ADDRESS` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `ah_graphql`.TRADE
(
    `id`      INTEGER    NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `value`   DOUBLE     NOT NULL,
    `buyer` INT        NOT NULL,
    INDEX `fk_Trade_Users1_idx` (`buyer` ASC) VISIBLE,
    CONSTRAINT `fk_Trade_Users1`
        FOREIGN KEY (`buyer`)
            REFERENCES `USERS` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    `seller` INT        NOT NULL,
    INDEX `fk_Trade_Users2_idx` (`seller` ASC) VISIBLE,
    CONSTRAINT `fk_Trade_Users2`
        FOREIGN KEY (`seller`)
            REFERENCES `USERS` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `ah_graphql`.ITEM
(
    `id`          INTEGER                                           NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name`   VARCHAR(45)                                       NOT NULL,
    `cost`       DOUBLE                                            NOT NULL,
    `user`     INT,
    CONSTRAINT `fk_Items_Users`
        FOREIGN KEY (`user`)
            REFERENCES `USERS` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;
