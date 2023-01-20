ALTER TABLE ah.address MODIFY COLUMN city varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL;
ALTER TABLE ah.address MODIFY COLUMN zip_code varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL;

ALTER TABLE ah.trade MODIFY COLUMN item_id int NOT NULL;