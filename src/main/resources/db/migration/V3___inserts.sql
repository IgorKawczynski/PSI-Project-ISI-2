INSERT INTO ah.address(zip_code, city, street)
                VALUES('09-250', 'Warszawa', 'Wiejska 20');

INSERT INTO ah.address(zip_code, city, street)
                VALUES('08-250', 'Olsztyn', 'Nowowiejska 50');

INSERT INTO ah.users(email, password, username, pesel, type, address_id)
              VALUES('emailTest1@op.pl', 'passwordTest1', 'usernameTest1', '01382508666', 'ADMIN', 1);