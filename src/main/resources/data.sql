INSERT INTO TYPE(id,name) VALUES (1, 'Телевизор'); 
INSERT INTO TYPE(id,name) VALUES(2, 'Холодильник');
INSERT INTO TYPE(id,name) VALUES(3, 'Стиральная машина');

INSERT INTO Brand(id, name) VALUES(1,'Samsung');
INSERT INTO Brand(id, name) VALUES(2,'Toshiba');
INSERT INTO Brand(id, name) VALUES(3,'Zanussi');
INSERT INTO Brand(id, name) VALUES(4,'Sony');
INSERT INTO Brand(id, name) VALUES(5,'Bosch');


INSERT INTO Property(id,type_id, name) VALUES(1,1,'Диагональ');
INSERT INTO Property(id,type_id, name) VALUES(2,1,'Толщина');
INSERT INTO Property(id,type_id, name) VALUES(3,1,'Тип матрицы');
INSERT INTO Property(id,type_id, name) VALUES(4,2,'Морозильная камера');
INSERT INTO Property(id,type_id, name) VALUES(5,2,'Габариты');
INSERT INTO Property(id,type_id, name) VALUES(6,3,'Тип загрузки');
INSERT INTO Property(id,type_id, name) VALUES(7,3,'Габариты');

INSERT INTO Product(id, model, type_id, brand_id, quantity, price) VALUES(1, '32W3753DG', 1, 2, 50, 20000);
INSERT INTO Product(id, model, type_id, brand_id, quantity, price) VALUES(2, 'UE-32 N 4000 AUXRU', 1, 1, 50, 17500);
INSERT INTO Product(id, model, type_id, brand_id, quantity, price) VALUES(3, 'KDL-32RE303', 1, 4, 50, 22500);
INSERT INTO Product(id, model, type_id, brand_id, quantity, price) VALUES(4, 'RB-37J5461EF/WT', 2, 1, 20, 50000);
INSERT INTO Product(id, model, type_id, brand_id, quantity, price) VALUES(5, 'KGE39XL2AR', 2, 5, 20, 38000);
INSERT INTO Product(id, model, type_id, brand_id, quantity, price) VALUES(6, 'FCS 1020 C', 3, 3, 20, 45000);
INSERT INTO Product(id, model, type_id, brand_id, quantity, price) VALUES(7, 'WW 90 M 64 LOPO/LP', 3, 1, 20, 75000);

INSERT INTO Product_property(id, product_id, property_id, value) VALUES(1,1,1,'32 ''''');
INSERT INTO Product_property(id, product_id, property_id, value) VALUES(2,2,1,'32 ''''');
INSERT INTO Product_property(id, product_id, property_id, value) VALUES(3,3,1,'32 ''''');
INSERT INTO Product_property(id, product_id, property_id, value) VALUES(4,1,2,'735 мм');
INSERT INTO Product_property(id, product_id, property_id, value) VALUES(5,2,2,'438 мм');
INSERT INTO Product_property(id, product_id, property_id, value) VALUES(6,3,2,'735 мм');
INSERT INTO Product_property(id, product_id, property_id, value) VALUES(7,1,3,'LED');
INSERT INTO Product_property(id, product_id, property_id, value) VALUES(8,2,3,'LED');
INSERT INTO Product_property(id, product_id, property_id, value) VALUES(9,3,3,'LED');
INSERT INTO Product_property(id, product_id, property_id, value) VALUES(10,4,4,'Есть (снизу)');
INSERT INTO Product_property(id, product_id, property_id, value) VALUES(11,5,4,'Есть (снизу)');
INSERT INTO Product_property(id, product_id, property_id, value) VALUES(12,4,5,'(ВxШxГ) 201x59.5x67.5 см');
INSERT INTO Product_property(id, product_id, property_id, value) VALUES(13,5,5,'(ВxШxГ) 200x60х63 см');
INSERT INTO Product_property(id, product_id, property_id, value) VALUES(14,6,7,'(ВxШxГ) 67x50x52 см');
INSERT INTO Product_property(id, product_id, property_id, value) VALUES(15,7,7,'(ВxШxГ) 85х60х60 см');
INSERT INTO Product_property(id, product_id, property_id, value) VALUES(16,6,6,'фронтальная');
INSERT INTO Product_property(id, product_id, property_id, value) VALUES(17,7,6,'фронтальная');
