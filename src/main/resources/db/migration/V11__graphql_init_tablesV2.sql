CREATE TABLE IF NOT EXISTS `ah`.ADDRESS_GRAPHQL
(
    `id`       INTEGER     NOT NULL  PRIMARY KEY AUTO_INCREMENT,
    `city`     VARCHAR(30) NOT NULL,
    `street`   VARCHAR(60) NULL
)
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `ah`.USERS_GRAPHQL
(
    `id`         INTEGER                  NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `email`      VARCHAR(50)              NOT NULL,
    `first_name`   VARCHAR(30)              NULL,
    `last_name`   VARCHAR(30)              NULL,
    `pesel`      VARCHAR(11)              NULL,
    `address` INT                      NULL,
    INDEX `fk_Users_Address5_idx` (`address` ASC) VISIBLE,
    CONSTRAINT `fk_Users_address5`
        FOREIGN KEY (`address`)
            REFERENCES `ADDRESS_GRAPHQL` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `ah`.TRADE_GRAPHQL
(
    `id`      INTEGER    NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `value`   DOUBLE     NOT NULL,
    `buyer` INT        NOT NULL,
    INDEX `fk_Trade_Users5_idx` (`buyer` ASC) VISIBLE,
    CONSTRAINT `fk_Trade_Users5`
        FOREIGN KEY (`buyer`)
            REFERENCES `USERS_GRAPHQL` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    `seller` INT        NOT NULL,
    INDEX `fk_Trade_Users6_idx` (`seller` ASC) VISIBLE,
    CONSTRAINT `fk_Trade_Users6`
        FOREIGN KEY (`seller`)
            REFERENCES `USERS_GRAPHQL` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `ah`.ITEM_GRAPHQL
(
    `id`          INTEGER                                           NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name`   VARCHAR(45)                                       NOT NULL,
    `cost`       DOUBLE                                            NOT NULL,
    `user`     INT,
    CONSTRAINT `fk_Items_Users7`
        FOREIGN KEY (`user`)
            REFERENCES `USERS_GRAPHQL` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;
