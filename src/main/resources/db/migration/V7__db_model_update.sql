ALTER TABLE ah.USERS RENAME user;
ALTER TABLE ah.user DROP COLUMN username;
ALTER TABLE ah.user ADD first_name VARCHAR(80) NOT NULL;
ALTER TABLE ah.user ADD last_name VARCHAR(80) NOT NULL;
ALTER TABLE ah.user MODIFY pesel VARCHAR(11) NOT NULL;
ALTER TABLE ah.user ADD UNIQUE (pesel);

ALTER TABLE ah.ADDRESS RENAME address;
ALTER TABLE ah.address MODIFY city VARCHAR(45) NOT NULL;

ALTER TABLE ah.ITEMS RENAME item;
ALTER TABLE ah.item MODIFY item_name VARCHAR(60) NOT NULL;
ALTER TABLE ah.item MODIFY category ENUM('JEWELRY', 'SPORTS', 'FURNITURE', 'RTVAGD') NULL;
ALTER TABLE ah.item MODIFY status ENUM('AVAILABLE', 'UNAVAILABLE') NOT NULL DEFAULT 'AVAILABLE';
ALTER TABLE ah.item DROP FOREIGN KEY fk_Items_Trade1;
ALTER TABLE ah.item DROP COLUMN trade_id;
ALTER TABLE ah.item RENAME COLUMN user_id TO seller_id;

ALTER TABLE ah.TRADE RENAME trade;
ALTER TABLE ah.trade RENAME COLUMN user_id TO buyer_id;
ALTER TABLE ah.trade ADD item_id INT;
ALTER TABLE ah.trade ADD FOREIGN KEY (item_id) REFERENCES item(id);

ALTER TABLE ah.trade RENAME INDEX fk_Trade_Users1_idx TO buyer_id;

CREATE TABLE IF NOT EXISTS ah.opinion (
                                               `id` INT NOT NULL AUTO_INCREMENT,
                                               `rate` INT NOT NULL,
                                               `description` VARCHAR(255) NULL,
                                               `trade_id` INT NOT NULL,
                                               `buyer_id` INT NOT NULL,
                                               `user_id` INT NOT NULL,
                                               PRIMARY KEY (`id`, `trade_id`, `buyer_id`, `user_id`),
                                               INDEX `fk_opinion_trade1_idx` (`trade_id` ASC, `buyer_id` ASC) VISIBLE,
                                               INDEX `fk_opinion_user1_idx` (`user_id` ASC) VISIBLE,
                                               CONSTRAINT `fk_opinion_trade1`
                                                   FOREIGN KEY (`buyer_id` , `trade_id`)
                                                       REFERENCES `ah`.`trade` (`buyer_id` , `id`)
                                                       ON DELETE NO ACTION
                                                       ON UPDATE NO ACTION,
                                               CONSTRAINT `fk_opinion_user1`
                                                   FOREIGN KEY (`user_id`)
                                                       REFERENCES `ah`.`user` (`id`)
                                                       ON DELETE NO ACTION
                                                       ON UPDATE NO ACTION)
    ENGINE = InnoDB;
