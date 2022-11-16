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
insert into Category (name, acronym) values ('Blume des Lebens', 'BL');
insert into Category (name, acronym) values ('Lotusblume', 'LO');
insert into Category (name, acronym) values ('Baum des Lebens', 'BA');
insert into Category (name, acronym) values ('Baum des Lebens eckig', 'BAE');
insert into Category (name, acronym) values ('Löwe', 'LÖ');

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
insert into Category (id, name) values (1000, 'Holz');

insert into Article(id, name, value, minValue, category_id) values(1000, 'Holz', 55, 40, 1000);
insert into Article(id, name, value, minValue, category_id,  size_id) values(1000, 'Holz39', 55, 40, 1000,  1);
insert into Article(id, name, value, minValue, category_id,  size_id) values(1001, 'Holz49', 55, 40, 1000,  2);
insert into Material(id) values(1000);
insert into Material(id) values(1001);


insert into Category (id, name) values (1001, 'Folie');

insert into Article(id, name, value, minValue, category_id,color_id , size_id) values(1100, 'Folie', 55, 40, 1001, 1, 1);
insert into Article(id, name, value, minValue, category_id, color_id, size_id) values(1101, 'Folie', 55, 40, 1001, 2, 1);
insert into Article(id, name, value, minValue, category_id,  color_id,size_id) values(1102, 'Folie', 55, 40, 1001, 3, 1);
insert into Article(id, name, value, minValue, category_id,  color_id,size_id) values(1103, 'Folie', 55, 40, 1001,  4,1);

insert into Article(id, name, value, minValue, category_id,  color_id,size_id) values(1104, 'Folie', 55, 40, 1001, 5, 1);
insert into Article(id, name, value, minValue, category_id,  color_id,size_id) values(1105, 'Folie', 55, 40, 1001, 6, 1);
insert into Article(id, name, value, minValue, category_id,  color_id,size_id) values(1106, 'Folie', 55, 40, 1001, 7, 1);
insert into Article(id, name, value, minValue, category_id,  color_id,size_id) values(1107, 'Folie', 55, 40, 1001, 8, 1);
insert into Material(id) values(1100);
insert into Material(id) values(1101);
insert into Material(id) values(1102);
insert into Material(id) values(1103);

insert into Material(id) values(1104);
insert into Material(id) values(1105);
insert into Material(id) values(1106);
insert into Material(id) values(1107);


insert into Category (id, name) values (1002, 'Klebeband');

insert into Article(id, name, value, minValue, category_id, size_id) values(1200, 'Klebeband-Packet', 55, 40, 1002,  1);
insert into Article(id, name, value, minValue, category_id, size_id) values(1201, 'Klebeband-Sicherung', 55, 40, 1002,  1);
insert into Material(id) values(1200);
insert into Material(id) values(1201);


insert into Category (id, name) values (1003, 'Schachtel');

insert into Article(id, name, value, minValue, category_id, size_id) values(1300, 'Schachtel49', 55, 40, 1003, 1);
insert into Article(id, name, value, minValue, category_id, size_id) values(1301, 'Schachtel39', 55, 40, 1003, 2);
insert into Material(id) values(1300);
insert into Material(id) values(1301);

-- ProductionFormulas
-- BL 39 34
insert into ProductionFormula(product_id, material_id, amount) values (1, 1000, 0.5);

-- ProductionLog
insert into ProductionLog(id, product_id) values (1, 1);


-- Unknown Values
-- insert into Category (id, name) values (999, 'UNKNOWN');
insert into Color (id, name, colorCode) values (999, 'UNKNOWN','UNKNOWN');
insert into Size (id, description, size) values (999, 'UNKNOWN', 999);