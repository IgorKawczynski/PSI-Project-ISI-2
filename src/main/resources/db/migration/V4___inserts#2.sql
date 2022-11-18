INSERT INTO ah.items(item_name, description, price, category, status, user_id)
              VALUES('itemNameTest1', 'descriptionTest1', 2100, 'FURNITURE', 'AVAILABLE', 1);

INSERT INTO ah.items(item_name, description, price, category, status)
              VALUES('itemNameTest2', 'descriptionTest2', 1500, 'RTVAGD', 'UNAVAILABLE');

INSERT INTO ah.trade(value, user_id)
              VALUES(2110, 1);