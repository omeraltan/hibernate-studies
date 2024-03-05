insert into PRODUCT_TYPE(id, TYPE, NAME) values(1, 'food', 'FOOD');
insert into PRODUCT_TYPE(id, TYPE, NAME) values(2, 'drink', 'DRİNK');
insert into PRODUCT_TYPE(id, TYPE, NAME) values(3, 'clothes', 'CLOTHES');
insert into PRODUCT_TYPE(id, TYPE, NAME) values(4, 'fuel', 'FUEL');
insert into PRODUCT_TYPE(id, TYPE, NAME) values(5, 'consumptionmaterial', 'CONSUMPTIONMATERIAL');

insert into PRODUCT
(id, ENUM_UNIT, EXPIRATION_DATE, NAME, PRICE, STOCK_AMOUNT, ID_PRODUCT_TYPE)
values(1, 'piece', "2030-01-01", 'Bread', 5, 200, 1);
insert into PRODUCT
(id, ENUM_UNIT, EXPIRATION_DATE, NAME, PRICE, STOCK_AMOUNT, ID_PRODUCT_TYPE)
values(2, 'piece', "2020-02-02", 'Wood', 12, 123, 4);
insert into PRODUCT
(id, ENUM_UNIT, EXPIRATION_DATE, NAME, PRICE, STOCK_AMOUNT, ID_PRODUCT_TYPE)
values(3, 'liter', "2017-03-02", 'Gasoline', 100.23, 200, 4);
insert into PRODUCT
(id, ENUM_UNIT, EXPIRATION_DATE, NAME, PRICE, STOCK_AMOUNT, ID_PRODUCT_TYPE)
values(4, 'liter', "2021-11-01", 'Diesel', 123.33, 234, 4);
insert into PRODUCT
(id, ENUM_UNIT, EXPIRATION_DATE, NAME, PRICE, STOCK_AMOUNT, ID_PRODUCT_TYPE)
values(5, 'piece', "2007-02-08", 'Spoon', 75.75, 200, 5);
insert into PRODUCT
(id, ENUM_UNIT, EXPIRATION_DATE, NAME, PRICE, STOCK_AMOUNT, ID_PRODUCT_TYPE)
values(6, 'piece', "2007-02-10", 'Fork', 57.67, 3300, 5);
insert into PRODUCT
(id, ENUM_UNIT, EXPIRATION_DATE, NAME, PRICE, STOCK_AMOUNT, ID_PRODUCT_TYPE)
values(7, 'pack', "2019-12-23", 'Bean', 40.25, 2000, 1);
insert into PRODUCT
(id, ENUM_UNIT, EXPIRATION_DATE, NAME, PRICE, STOCK_AMOUNT, ID_PRODUCT_TYPE)
values(8, 'pack', "2023-10-03", 'Lentil', 100, 23000, 1);
insert into PRODUCT
(id, ENUM_UNIT, EXPIRATION_DATE, NAME, PRICE, STOCK_AMOUNT, ID_PRODUCT_TYPE)
values(9, 'portion', "2041-07-07", 'Soap', 43, 23445, 5);
insert into PRODUCT
(id, ENUM_UNIT, EXPIRATION_DATE, NAME, PRICE, STOCK_AMOUNT, ID_PRODUCT_TYPE)
values(10, 'weight', "2030-01-01", 'Rice', 100, 34000, 1);
