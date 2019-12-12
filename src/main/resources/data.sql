INSERT INTO user_account (user_account_id, date_of_birth, email, username, first_name, last_name, password_hash, phone_number)
VALUES (1,'1995-01-01','johndoe@gmail.com','johndough','John','Doe','$2a$12$AiuoGa8ryJTe2ixlT.pQueAx3rnVjAF70HIQpI572MnCJntgT.fAG','111-111-1111'),
       (2,'1995-02-02','jackdaniel@gmail.com','jackisbest','Jack','Daniel','$2a$12$AiuoGa8ryJTe2ixlT.pQue2V/jdVm65dCynPlsrzYpQy15XlC758u','222-222-2222'),
       (3,'1995-03-03','bacardirum@gmail.com','bacardiworst','Bacardi','Rum','$2a$12$AiuoGa8ryJTe2ixlT.pQue5ZBSS69oIwTrdcIjcaQgQgwl3qq6slS','333-333-3333');

INSERT INTO address (address_id,city,country,post_code,state,street_address)
VALUES (1,'Staten Island','USA','11111','New York','123 Johnny Street'),
       (2,'Staten Island','USA','22222','New York','123 Jack Street'),
       (3,'Staten Island','USA','33333','New York','123 Bacardi Street');

INSERT INTO product (product_id,available,color,description,image_path,quantity_rented,quantity_stock,rental_price,size,title,seller_id)
 VALUES (1, b'1', 3, 'The NFL Seattle Seahawks Dri-FIT Jersey delivers unparalleled fit and style at the stadium or on the street. Sweat-wicking technology offers up cool comfort, while the twill lettering adds an authentic touch.',
         'ftp://71.105.7.77/uisn31tch7idksxmuyzm.webp', 0, 10, '20.00', 1, 'NFL Seattle Seahawks Dri-FIT (Russell Wilson)', '1'),
        (2, b'1', 4, 'Hit a HOME RUN with Joe Bonamassa\'s Signature "BonaBaseball" Jersey!', 'ftp://Admin@71.105.7.77/bsbljsy.jpeg', 0, 5, '15.50', 2, 'BonaBaseball Jersey', 1),
         (3, b'1', 1, 'Rep your favorite team anytime in the NFL Buffalo Bills Game Jersey, inspired by what they’re wearing on the field and designed for total comfort.', 'ftp://Admin@71.105.7.77/dgyqmfa88j5j6mzqc4dg.webp', 0, 7, '30.00', 2, 'NFL Buffalo Bills Game (Josh Allen)', 2),
        (4, b'1', 7, 'Rep your favorite team and player in the NFL Atlanta Falcons Game Jersey, inspired by what they\'re wearing on the field and designed for total comfort.', 'ftp://Admin@71.105.7.77/f59amidwq9kn8qwkfp1y.webp', 0, 4, '10.00', 3, 'NFL Atlanta Falcons Game Jersey (Deion Sanders)', 3);

INSERT INTO user_account_address (address_id,user_account_id)
VALUES (1, 1),
       (2, 2),
       (3, 3);

INSERT INTO invoice (invoice_id,delivery_date,expected_return_date,total_price,transaction_date,buyer_id,seller_id,delivery_address_id)
 VALUES (1, DATE_ADD(curDate(),INTERVAL 3 DAY), DATE_ADD(curDate(),INTERVAL 10 DAY), '31.00', curDate(), 1, 2, 1),
        (2, DATE_ADD(curDate(),INTERVAL 3 DAY), DATE_ADD(curDate(),INTERVAL 10 DAY), '45.50', curDate(), 2, 1, 2);

INSERT INTO invoice_details (invoice_id,product_id)
 VALUES (1, 2),(2, 4),(2, 2);
