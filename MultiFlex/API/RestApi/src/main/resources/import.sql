--Color
insert into Color (name, colorCode) values ('Bambus', 'BA');
insert into Color (name, colorCode) values ('Buche','34');
insert into Color (name, colorCode) values ('Eiche','62');
insert into Color (name, colorCode) values ('Ebenholz','67');
insert into Color (name, colorCode) values ('Rustikal','22');
insert into Color (name, colorCode) values ('Stein','14');
insert into Color (name, colorCode) values ('Ulme','51');
insert into Color (name, colorCode) values ('29','29');

-- INSERT PRODUCTS
--Category
insert into Category (name, acronym, type) values ('Blume des Lebens', 'BL', 'Product');
insert into Category (name, acronym, type) values ('Lotusblume', 'LO', 'Product');
insert into Category (name, acronym, type) values ('Baum des Lebens', 'BA', 'Product');
insert into Category (name, acronym, type) values ('Baum des Lebens eckig', 'BAE', 'Product');
insert into Category (name, acronym, type) values ('TESTWERT', 'TE', 'Product');

--Size
insert into Size (size) values (39);
insert into Size (size) values (49);

--Article
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BL 39 34', 18, 4 , 1,2, 1 );
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BL 39 62', 19, 5 , 1,3, 1 );
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BL 39 67', 17, 8 , 1,4, 1 );
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BL 39 22', 19, 7 , 1,5, 1 );
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BL 39 14', 12, 3 , 1,6, 1 );
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BL 39 51', 13, 9 , 1,7, 1 );
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BL 39 29', 11, 4 , 1,8, 1 );
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BL 39 BA', 14, 7 , 1,1, 1 );
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BL 49 34', 12, 9 , 1,2, 2 );
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BL 49 62', 19, 4 ,  1,3, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BL 49 67', 18, 6 ,  1,4, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BL 49 22', 14, 3 ,  1,5, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BL 49 14', 12, 8 ,  1,6, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BL 49 51', 17, 6 ,  1,7, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BL 49 29', 16, 4 ,  1,8, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BL 49 BA', 14, 5 ,  1,1, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('LO 39 34', 19, 7 ,  2,2, 1);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('LO 39 62', 14, 9 ,  2,3, 1);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('LO 39 67', 13, 9 ,  2,4, 1);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('LO 39 22', 14, 7 ,  2,5, 1);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('LO 39 14', 15, 7 ,  2,6, 1);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('LO 39 51', 14, 3 ,  2,7, 1);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('LO 39 29', 15, 3 ,  2,8, 1);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('LO 39 BA', 13, 4 ,  2,1, 1);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('LO 49 34', 18, 9 ,  2,2, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('LO 49 62', 15, 3 ,  2,3, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('LO 49 67', 10, 7 ,  2,4, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('LO 49 22', 13, 4 ,  2,5, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('LO 49 14', 10, 8 ,  2,6, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('LO 49 51', 14, 5 ,  2,7, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('LO 49 29', 14, 5 ,  2,8, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('LO 49 BA', 13, 9 ,  2,1, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BA 39 34', 19, 5 ,  3,2, 1);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BA 39 62', 15, 6 ,  3,3, 1);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BA 39 67', 12, 8 ,  3,4, 1);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BA 39 22', 13, 9 ,  3,5, 1);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BA 39 14', 13, 3 ,  3,6, 1);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BA 39 51', 16, 7 ,  3,7, 1);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BA 39 29', 12, 9 ,  3,8, 1);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BA 39 BA', 13, 3 ,  3,1, 1);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BA 49 34', 16, 5 ,  3,2, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BA 49 62', 11, 8 ,  3,3, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BA 49 67', 11, 5 ,  3,4, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BA 49 22', 13, 5 ,  3,5, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BA 49 14', 19, 3 ,  3,6, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BA 49 51', 15, 5 ,  3,7, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BA 49 29', 11, 3 ,  3,8, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BA 49 BA', 15, 7 ,  3,1, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BAE 39 34', 11, 3,  4,2, 1);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BAE 39 62', 10, 4,  4,3, 1);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BAE 39 67', 12, 8,  4,4, 1);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BAE 39 22', 10, 8,  4,5, 1);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BAE 39 14', 14, 4,  4,6, 1);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BAE 39 51', 12, 8,  4,7, 1);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BAE 39 29', 15, 9,  4,8, 1);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BAE 39 BA', 15, 9,  4,1, 1);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BAE 49 34', 17, 9,  4,2, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BAE 49 62', 12, 8,  4,3, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BAE 49 67', 17, 3,  4,4, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BAE 49 22', 14, 5,  4,5, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BAE 49 14', 17, 4,  4,6, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BAE 49 51', 10, 4,  4,7, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BAE 49 29', 10, 5,  4,8, 2);
insert into Article (name, value, minValue, category_id, color_id, size_id) values ('BAE 49 BA', 16, 7,  4,1, 2);

-- insert into Article (name, value, minValue) values ('LÖ', 10, 5);

--Product
insert into Product(id) values(1);
insert into Product(id) values(2);
insert into Product(id) values(3);
insert into Product(id) values(4);
insert into Product(id) values(5);
insert into Product(id) values(6);
insert into Product(id) values(7);
insert into Product(id) values(8);
insert into Product(id) values(9);
insert into Product(id) values(10);
insert into Product(id) values(11);
insert into Product(id) values(12);
insert into Product(id) values(13);
insert into Product(id) values(14);
insert into Product(id) values(15);
insert into Product(id) values(16);
insert into Product(id) values(17);
insert into Product(id) values(18);
insert into Product(id) values(19);
insert into Product(id) values(20);
insert into Product(id) values(21);
insert into Product(id) values(22);
insert into Product(id) values(23);
insert into Product(id) values(24);
insert into Product(id) values(25);
insert into Product(id) values(26);
insert into Product(id) values(27);
insert into Product(id) values(28);
insert into Product(id) values(29);
insert into Product(id) values(30);
insert into Product(id) values(31);
insert into Product(id) values(32);
insert into Product(id) values(33);
insert into Product(id) values(34);
insert into Product(id) values(35);
insert into Product(id) values(36);
insert into Product(id) values(37);
insert into Product(id) values(38);
insert into Product(id) values(39);
insert into Product(id) values(40);
insert into Product(id) values(41);
insert into Product(id) values(42);
insert into Product(id) values(43);
insert into Product(id) values(44);
insert into Product(id) values(45);
insert into Product(id) values(46);
insert into Product(id) values(47);
insert into Product(id) values(48);
insert into Product(id) values(49);
insert into Product(id) values(50);
insert into Product(id) values(51);
insert into Product(id) values(52);
insert into Product(id) values(53);
insert into Product(id) values(54);
insert into Product(id) values(55);
insert into Product(id) values(56);
insert into Product(id) values(57);
insert into Product(id) values(58);
insert into Product(id) values(59);
insert into Product(id) values(60);
insert into Product(id) values(61);
insert into Product(id) values(62);
insert into Product(id) values(63);
insert into Product(id) values(64);



-- INSERT Material
insert into Category (id, name, type) values (1000, 'Holz', 'Material');

insert into Article(id, name, value, minValue, category_id) values(1000, 'Holz', 55, 40, 1000);
insert into Article(id, name, value, minValue, category_id,  size_id) values(1000, 'Holz 39', 55, 40, 1000,  1);
insert into Article(id, name, value, minValue, category_id,  size_id) values(1001, 'Holz 49', 55, 40, 1000,  2);
insert into Material(id) values(1000);
insert into Material(id) values(1001);


insert into Category (id, name, type) values (1001, 'Folie', 'Material');

insert into Article(id, name, value, minValue, category_id,color_id , size_id) values(1100, 'Folie 39 BA', 55, 40, 1001, 1, 1);
insert into Article(id, name, value, minValue, category_id, color_id, size_id) values(1101, 'Folie 39 34', 55, 40, 1001, 2, 1);
insert into Article(id, name, value, minValue, category_id,  color_id,size_id) values(1102, 'Folie 39 62', 55, 40, 1001, 3, 1);
insert into Article(id, name, value, minValue, category_id,  color_id,size_id) values(1103, 'Folie 39 67', 55, 40, 1001,  4,1);

insert into Article(id, name, value, minValue, category_id,  color_id,size_id) values(1104, 'Folie 39 22', 55, 40, 1001, 5, 1);
insert into Article(id, name, value, minValue, category_id,  color_id,size_id) values(1105, 'Folie 39 14', 55, 40, 1001, 6, 1);
insert into Article(id, name, value, minValue, category_id,  color_id,size_id) values(1106, 'Folie 39 51', 55, 40, 1001, 7, 1);
insert into Article(id, name, value, minValue, category_id,  color_id,size_id) values(1107, 'Folie 39 29', 55, 40, 1001, 8, 1);

insert into Article(id, name, value, minValue, category_id,color_id , size_id) values(1108, 'Folie 49 BA', 55, 40, 1001, 1, 2);
insert into Article(id, name, value, minValue, category_id, color_id, size_id) values(1109, 'Folie 49 34', 55, 40, 1001, 2, 2);
insert into Article(id, name, value, minValue, category_id,  color_id,size_id) values(1110, 'Folie 49 62', 55, 40, 1001, 3, 2);
insert into Article(id, name, value, minValue, category_id,  color_id,size_id) values(1111, 'Folie 49 67', 55, 40, 1001,  4,2);

insert into Article(id, name, value, minValue, category_id,  color_id,size_id) values(1112, 'Folie 49 22', 55, 40, 1001, 5, 2);
insert into Article(id, name, value, minValue, category_id,  color_id,size_id) values(1113, 'Folie 49 14', 55, 40, 1001, 6, 2);
insert into Article(id, name, value, minValue, category_id,  color_id,size_id) values(1114, 'Folie 49 51', 55, 40, 1001, 7, 2);
insert into Article(id, name, value, minValue, category_id,  color_id,size_id) values(1115, 'Folie 49 29', 55, 40, 1001, 8, 2);
insert into Material(id) values(1100);
insert into Material(id) values(1101);
insert into Material(id) values(1102);
insert into Material(id) values(1103);

insert into Material(id) values(1104);
insert into Material(id) values(1105);
insert into Material(id) values(1106);
insert into Material(id) values(1107);

insert into Material(id) values(1108);
insert into Material(id) values(1109);
insert into Material(id) values(1110);
insert into Material(id) values(1111);

insert into Material(id) values(1112);
insert into Material(id) values(1113);
insert into Material(id) values(1114);
insert into Material(id) values(1115);


insert into Category (id, name, type) values (1002, 'Klebeband', 'Material');

insert into Article(id, name, value, minValue, category_id, size_id) values(1200, 'Klebeband-Packet', 55, 40, 1002,  1);
insert into Article(id, name, value, minValue, category_id, size_id) values(1201, 'Klebeband-Sicherung', 55, 40, 1002,  1);
insert into Material(id) values(1200);
insert into Material(id) values(1201);


insert into Category (id, name, type) values (1003, 'Schachtel', 'Material');

insert into Article(id, name, value, minValue, category_id, size_id) values(1300, 'Schachtel 39', 55, 40, 1003, 1);
insert into Article(id, name, value, minValue, category_id, size_id) values(1301, 'Schachtel 49', 55, 40, 1003, 2);
insert into Material(id) values(1300);
insert into Material(id) values(1301);

-- ProductionFormulas
-- BL 39 34
insert into ProductionFormula(product_id, material_id, amount) values(1, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(1, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(1, 1108, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(2, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(2, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(2, 1108, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(3, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(3, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(3, 1108, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(4, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(4, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(4, 1108, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(5, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(5, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(5, 1100, 0.5);


insert into ProductionFormula(product_id, material_id, amount) values(6, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(6, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(6, 1108, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(7, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(7, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(7, 1100, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(8, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(8, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(8, 1100, 0.5);


insert into ProductionFormula(product_id, material_id, amount) values(9, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(9, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(9, 1108, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(10, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(10, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(10, 1100, 0.5);


insert into ProductionFormula(product_id, material_id, amount) values(11, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(11, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(11, 1108, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(12, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(12, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(12, 1100, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(13, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(13, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(13, 1100, 0.5);


insert into ProductionFormula(product_id, material_id, amount) values(14, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(14, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(14, 1108, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(15, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(15, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(15, 1100, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(16, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(16, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(16, 1100, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(17, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(17, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(17, 1100, 0.5);


insert into ProductionFormula(product_id, material_id, amount) values(18, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(18, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(18, 1108, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(19, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(19, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(19, 1100, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(20, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(20, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(20, 1100, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(21, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(21, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(21, 1100, 0.5);


insert into ProductionFormula(product_id, material_id, amount) values(22, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(22, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(22, 1108, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(23, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(23, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(23, 1108, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(24, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(24, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(24, 1108, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(25, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(25, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(25, 1100, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(26, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(26, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(26, 1100, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(27, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(27, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(27, 1100, 0.5);


insert into ProductionFormula(product_id, material_id, amount) values(28, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(28, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(28, 1108, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(29, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(29, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(29, 1108, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(30, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(30, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(30, 1100, 0.5);


insert into ProductionFormula(product_id, material_id, amount) values(31, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(31, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(31, 1108, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(32, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(32, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(32, 1108, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(33, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(33, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(33, 1115, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(34, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(34, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(34, 1109, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(35, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(35, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(35, 1111, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(36, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(36, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(36, 1110, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(37, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(37, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(37, 1102, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(38, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(38, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(38, 1106, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(39, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(39, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(39, 1101, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(40, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(40, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(40, 1107, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(41, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(41, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(41, 1105, 0.5);


insert into ProductionFormula(product_id, material_id, amount) values(42, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(42, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(42, 1112, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(43, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(43, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(43, 1103, 0.5);


insert into ProductionFormula(product_id, material_id, amount) values(44, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(44, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(44, 1108, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(45, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(45, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(45, 1100, 0.5);


insert into ProductionFormula(product_id, material_id, amount) values(46, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(46, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(46, 1113, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(47, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(47, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(47, 1114, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(48, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(48, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(48, 1104, 0.5);


insert into ProductionFormula(product_id, material_id, amount) values(49, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(49, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(49, 1110, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(50, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(50, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(50, 1100, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(51, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(51, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(51, 1101, 0.5);


insert into ProductionFormula(product_id, material_id, amount) values(52, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(52, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(52, 1111, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(53, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(53, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(53, 1112, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(54, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(54, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(54, 1109, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(55, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(55, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(55, 1108, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(56, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(56, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(56, 1104, 0.5);


insert into ProductionFormula(product_id, material_id, amount) values(57, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(57, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(57, 1115, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(58, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(58, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(58, 1105, 0.5);


insert into ProductionFormula(product_id, material_id, amount) values(59, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(59, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(59, 1114, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(60, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(60, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(60, 1106, 0.5);


insert into ProductionFormula(product_id, material_id, amount) values(61, 1001, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(61, 1301, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(61, 1113, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(62, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(62, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(62, 1102, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(63, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(63, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(63, 1103, 0.5);

insert into ProductionFormula(product_id, material_id, amount) values(64, 1000, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(64, 1300, 0.5);
insert into ProductionFormula(product_id, material_id, amount) values(64, 1107, 0.5);

-- ProductionLog
insert into ProductionLog(id, product_id) values (1, 1);

-- Unknown Values
-- insert into Category (id, name) values (999, 'UNKNOWN');
insert into Color (id, name, colorCode) values (999, 'No Specified Color','UNKNOWN');
insert into Size (id, description) values (999, 'No Specified Size');