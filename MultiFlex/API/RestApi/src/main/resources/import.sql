---- This file allow to write SQL commands that will be emitted in test and dev.
---- The commands are commented as their support depends of the database
--
----Regale
--insert into Regal (maxAmountShelfs, name) values(10, 'Regal-1');
--insert into Regal (maxAmountShelfs, name) values( 12, 'Regal-2');
--
----TypeDto
--insert into Type (name) values ('Produkt');
--insert into Type (name)  values ('Material');
--
----Waren
--insert into Ware (stock, maxAmount, minAmount, name, type_id) values(8, 15, 5,'BAXXXX', 1);
--insert into Ware (stock, maxAmount, minAmount, name, type_id) values(2, 10, 1,'LÖXXXX', 1);
--insert into Ware (stock, maxAmount, minAmount, name, type_id) values(10, 15, 5,'LOXXXX', 1);
--insert into Ware (stock, maxAmount, minAmount, name, type_id) values(4, 15, 2,'TAXXXX', 1);
--insert into Ware (stock, maxAmount, minAmount, name, type_id) values(7, 10, 3,'HEXXXX', 1);
--
----Fächer
--insert into Shelf (maxAmount, position, regal_id, ware_id) values( 20, 1, 1, 1);
--insert into Shelf (position, regal_id, ware_id, maxAmount) values(2, 1, 2, 20);
--insert into Shelf (position, regal_id, ware_id, maxAmount) values(3, 1, 5, 20);
--insert into Shelf (position, regal_id, ware_id, maxAmount) values(1, 2, 3, 20);
--insert into Shelf (position, regal_id, ware_id, maxAmount) values(2, 2, 4, 20);
--
----Supplier
--insert into Supplier (name, link, deliveryTime) values('Amazon', 'https://www.amazon.de/', 3);
--insert into Supplier (name, link, deliveryTime) values('Obi', 'https://www.obi.at ', 3);
--insert into Supplier (name, link, deliveryTime) values('Bauhaus', 'https://www.bauhaus.at/', 3);
--
----Color
--insert into Color (name) values ('Schwarz');
--
--
--insert into Ware (stock, maxAmount, minAmount, name, type_id) values (7, 10, 3,'Schrott', 2);
--insert into Ware (stock, maxAmount, minAmount, name, type_id) values (7, 10, 3,'Holzplatte-Schwarz', 2);
--insert into Ware (stock, maxAmount, minAmount, name, type_id) values (7, 10, 3,'Holzplatte-Braun', 2);
--
----TypeDto-Ware
--insert into Ware_Supplier (Supplier_id, ware_id) values (1, 6);
--insert into Ware_Supplier (Supplier_id, ware_id) values (1, 7);
--insert into Ware_Supplier (Supplier_id, ware_id) values (1, 8);
--insert into Ware_Supplier (Supplier_id, ware_id) values (2, 7);
--insert into Ware_Supplier (Supplier_id, ware_id) values (3, 6);
--insert into Ware_Supplier (Supplier_id, ware_id) values (3, 7);

--Color
insert into Color (name, color) values ('Bambus', 'BA');
insert into Color (name, color) values ('34','34');
insert into Color (name, color) values ('64','62');
insert into Color (name, color) values ('67','67');
insert into Color (name, color) values ('22','22');
insert into Color (name, color) values ('14','14');
insert into Color (name, color) values ('51','51');
insert into Color (name, color) values ('299','299');

--Category
insert into Category (name) values ('Blume des Lebens');
insert into Category (name) values ('Lotusblume');
insert into Category (name) values ('Baum des Lebens');
insert into Category (name) values ('Baum des Lebens eckig');
insert into Category (name) values ('Löwe');

--Size
insert into Size (size) values (39);
insert into Size (size) values (49);

--Article
insert into Article (name, Value, minValue) values ('BL 39 34', 10, 5);
insert into Article (name, Value, minValue) values ('BL 39 62', 10, 5);
insert into Article (name, Value, minValue) values ('BL 39 67', 10, 5);
insert into Article (name, Value, minValue) values ('BL 39 22', 10, 5);
insert into Article (name, Value, minValue) values ('BL 39 14', 10, 5);
insert into Article (name, Value, minValue) values ('BL 39 51', 10, 5);
insert into Article (name, Value, minValue) values ('BL 39 29', 10, 5);
insert into Article (name, Value, minValue) values ('BL 39 BA', 10, 5);

insert into Article (name, Value, minValue) values ('BL 49 34', 10, 5);
insert into Article (name, Value, minValue) values ('BL 49 62', 10, 5);
insert into Article (name, Value, minValue) values ('BL 49 67', 10, 5);
insert into Article (name, Value, minValue) values ('BL 49 22', 10, 5);
insert into Article (name, Value, minValue) values ('BL 49 14', 10, 5);
insert into Article (name, Value, minValue) values ('BL 49 51', 10, 5);
insert into Article (name, Value, minValue) values ('BL 49 29', 10, 5);
insert into Article (name, Value, minValue) values ('BL 49 BA', 10, 5);

insert into Article (name, Value, minValue) values ('LO 39 34', 10, 5);
insert into Article (name, Value, minValue) values ('LO 39 62', 10, 5);
insert into Article (name, Value, minValue) values ('LO 39 67', 10, 5);
insert into Article (name, Value, minValue) values ('LO 39 22', 10, 5);
insert into Article (name, Value, minValue) values ('LO 39 14', 10, 5);
insert into Article (name, Value, minValue) values ('LO 39 51', 10, 5);
insert into Article (name, Value, minValue) values ('LO 39 29', 10, 5);
insert into Article (name, Value, minValue) values ('LO 39 BA', 10, 5);

insert into Article (name, Value, minValue) values ('LO 49 34', 10, 5);
insert into Article (name, Value, minValue) values ('LO 49 62', 10, 5);
insert into Article (name, Value, minValue) values ('LO 49 67', 10, 5);
insert into Article (name, Value, minValue) values ('LO 49 22', 10, 5);
insert into Article (name, Value, minValue) values ('LO 49 14', 10, 5);
insert into Article (name, Value, minValue) values ('LO 49 51', 10, 5);
insert into Article (name, Value, minValue) values ('LO 49 29', 10, 5);
insert into Article (name, Value, minValue) values ('LO 49 BA', 10, 5);

insert into Article (name, Value, minValue) values ('BA 39 34', 10, 5);
insert into Article (name, Value, minValue) values ('BA 39 62', 10, 5);
insert into Article (name, Value, minValue) values ('BA 39 67', 10, 5);
insert into Article (name, Value, minValue) values ('BA 39 22', 10, 5);
insert into Article (name, Value, minValue) values ('BA 39 14', 10, 5);
insert into Article (name, Value, minValue) values ('BA 39 51', 10, 5);
insert into Article (name, Value, minValue) values ('BA 39 29', 10, 5);
insert into Article (name, Value, minValue) values ('BA 39 BA', 10, 5);

insert into Article (name, Value, minValue) values ('BA 49 34', 10, 5);
insert into Article (name, Value, minValue) values ('BA 49 62', 10, 5);
insert into Article (name, Value, minValue) values ('BA 49 67', 10, 5);
insert into Article (name, Value, minValue) values ('BA 49 22', 10, 5);
insert into Article (name, Value, minValue) values ('BA 49 14', 10, 5);
insert into Article (name, Value, minValue) values ('BA 49 51', 10, 5);
insert into Article (name, Value, minValue) values ('BA 49 29', 10, 5);
insert into Article (name, Value, minValue) values ('BA 49 BA', 10, 5);

insert into Article (name, Value, minValue) values ('BAE 39 34', 10, 5);
insert into Article (name, Value, minValue) values ('BAE 39 62', 10, 5);
insert into Article (name, Value, minValue) values ('BAE 39 67', 10, 5);
insert into Article (name, Value, minValue) values ('BAE 39 22', 10, 5);
insert into Article (name, Value, minValue) values ('BAE 39 14', 10, 5);
insert into Article (name, Value, minValue) values ('BAE 39 51', 10, 5);
insert into Article (name, Value, minValue) values ('BAE 39 29', 10, 5);
insert into Article (name, Value, minValue) values ('BAE 39 BA', 10, 5);

insert into Article (name, Value, minValue) values ('BAE 49 34', 10, 5);
insert into Article (name, Value, minValue) values ('BAE 49 62', 10, 5);
insert into Article (name, Value, minValue) values ('BAE 49 67', 10, 5);
insert into Article (name, Value, minValue) values ('BAE 49 22', 10, 5);
insert into Article (name, Value, minValue) values ('BAE 49 14', 10, 5);
insert into Article (name, Value, minValue) values ('BAE 49 51', 10, 5);
insert into Article (name, Value, minValue) values ('BAE 49 29', 10, 5);
insert into Article (name, Value, minValue) values ('BAE 49 BA', 10, 5);

insert into Article (name, Value, minValue) values ('LÖ', 10, 5);

--Product
insert into Product(id, category_id, color_id, size_id) values(1, 1,2, 1 );
insert into Product(id, category_id, color_id, size_id) values(2, 1,3, 1 );
insert into Product(id, category_id, color_id, size_id) values(3, 1,4, 1 );
insert into Product(id, category_id, color_id, size_id) values(4, 1,5, 1 );
insert into Product(id, category_id, color_id, size_id) values(5, 1,6, 1 );
insert into Product(id, category_id, color_id, size_id) values(6, 1,7, 1 );
insert into Product(id, category_id, color_id, size_id) values(7, 1,8, 1 );
insert into Product(id, category_id, color_id, size_id) values(8, 1,1, 1 );
insert into Product(id, category_id, color_id, size_id) values(9, 1,2, 2 );
insert into Product(id, category_id, color_id, size_id) values(10, 1,3, 2 );
insert into Product(id, category_id, color_id, size_id) values(11, 1,4, 2 );
insert into Product(id, category_id, color_id, size_id) values(12, 1,5, 2 );
insert into Product(id, category_id, color_id, size_id) values(13, 1,6, 2 );
insert into Product(id, category_id, color_id, size_id) values(14, 1,7, 2 );
insert into Product(id, category_id, color_id, size_id) values(15, 1,8, 2 );
insert into Product(id, category_id, color_id, size_id) values(16, 1,1, 2 );

insert into Product(id, category_id, color_id, size_id) values(17, 2,2, 1 );
insert into Product(id, category_id, color_id, size_id) values(18, 2,3, 1 );
insert into Product(id, category_id, color_id, size_id) values(19, 2,4, 1 );
insert into Product(id, category_id, color_id, size_id) values(20, 2,5, 1 );
insert into Product(id, category_id, color_id, size_id) values(21, 2,6, 1 );
insert into Product(id, category_id, color_id, size_id) values(22, 2,7, 1 );
insert into Product(id, category_id, color_id, size_id) values(23, 2,8, 1 );
insert into Product(id, category_id, color_id, size_id) values(24, 2,1, 1 );
insert into Product(id, category_id, color_id, size_id) values(25, 2,2, 2 );
insert into Product(id, category_id, color_id, size_id) values(26, 2,3, 2 );
insert into Product(id, category_id, color_id, size_id) values(27, 2,4, 2 );
insert into Product(id, category_id, color_id, size_id) values(28, 2,5, 2 );
insert into Product(id, category_id, color_id, size_id) values(29, 2,6, 2 );
insert into Product(id, category_id, color_id, size_id) values(30, 2,7, 2 );
insert into Product(id, category_id, color_id, size_id) values(31, 2,8, 2 );
insert into Product(id, category_id, color_id, size_id) values(32, 2,1, 2 );

insert into Product(id, category_id, color_id, size_id) values(33, 3,2, 1 );
insert into Product(id, category_id, color_id, size_id) values(34, 3,3, 1 );
insert into Product(id, category_id, color_id, size_id) values(35, 3,4, 1 );
insert into Product(id, category_id, color_id, size_id) values(36, 3,5, 1 );
insert into Product(id, category_id, color_id, size_id) values(37, 3,6, 1 );
insert into Product(id, category_id, color_id, size_id) values(38, 3,7, 1 );
insert into Product(id, category_id, color_id, size_id) values(39, 3,8, 1 );
insert into Product(id, category_id, color_id, size_id) values(40, 3,1, 1 );
insert into Product(id, category_id, color_id, size_id) values(41, 3,2, 2 );
insert into Product(id, category_id, color_id, size_id) values(42, 3,3, 2 );
insert into Product(id, category_id, color_id, size_id) values(43, 3,4, 2 );
insert into Product(id, category_id, color_id, size_id) values(44, 3,5, 2 );
insert into Product(id, category_id, color_id, size_id) values(45, 3,6, 2 );
insert into Product(id, category_id, color_id, size_id) values(46, 3,7, 2 );
insert into Product(id, category_id, color_id, size_id) values(47, 3,8, 2 );
insert into Product(id, category_id, color_id, size_id) values(48, 3,1, 2 );

insert into Product(id, category_id, color_id, size_id) values(49, 4,2, 1 );
insert into Product(id, category_id, color_id, size_id) values(50, 4,3, 1 );
insert into Product(id, category_id, color_id, size_id) values(51, 4,4, 1 );
insert into Product(id, category_id, color_id, size_id) values(52, 4,5, 1 );
insert into Product(id, category_id, color_id, size_id) values(53, 4,6, 1 );
insert into Product(id, category_id, color_id, size_id) values(54, 4,7, 1 );
insert into Product(id, category_id, color_id, size_id) values(55, 4,8, 1 );
insert into Product(id, category_id, color_id, size_id) values(56, 4,1, 1 );
insert into Product(id, category_id, color_id, size_id) values(57, 4,2, 2 );
insert into Product(id, category_id, color_id, size_id) values(58, 4,3, 2 );
insert into Product(id, category_id, color_id, size_id) values(59, 4,4, 2 );
insert into Product(id, category_id, color_id, size_id) values(60, 4,5, 2 );
insert into Product(id, category_id, color_id, size_id) values(61, 4,6, 2 );
insert into Product(id, category_id, color_id, size_id) values(62, 4,7, 2 );
insert into Product(id, category_id, color_id, size_id) values(63, 4,8, 2 );
insert into Product(id, category_id, color_id, size_id) values(64, 4,1, 2 );
