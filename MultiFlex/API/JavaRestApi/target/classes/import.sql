-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database

--Regale
insert into Regal (maxAmountShelfs, name) values(10, 'Regal-1');
insert into Regal (maxAmountShelfs, name) values( 12, 'Regal-2');

--TypeDto
insert into Type (name) values ('Produkt');
insert into Type (name)  values ('Material');

--Waren
insert into Ware (stock, maxAmount, minAmount, name, type_id) values(8, 15, 5,'BAXXXX', 1);
insert into Ware (stock, maxAmount, minAmount, name, type_id) values(2, 10, 1,'LÖXXXX', 1);
insert into Ware (stock, maxAmount, minAmount, name, type_id) values(10, 15, 5,'LOXXXX', 1);
insert into Ware (stock, maxAmount, minAmount, name, type_id) values(4, 15, 2,'TAXXXX', 1);
insert into Ware (stock, maxAmount, minAmount, name, type_id) values(7, 10, 3,'HEXXXX', 1);

--Fächer
insert into Shelf (maxAmount, position, regal_id, ware_id) values( 20, 1, 1, 1);
insert into Shelf (position, regal_id, ware_id, maxAmount) values(2, 1, 2, 20);
insert into Shelf (position, regal_id, ware_id, maxAmount) values(3, 1, 5, 20);
insert into Shelf (position, regal_id, ware_id, maxAmount) values(1, 2, 3, 20);
insert into Shelf (position, regal_id, ware_id, maxAmount) values(2, 2, 4, 20);

--Supplier
insert into Supplier (name, link, deliveryTime) values('Amazon', 'https://www.amazon.de/', 3);
insert into Supplier (name, link, deliveryTime) values('Obi', 'https://www.obi.at ', 3);
insert into Supplier (name, link, deliveryTime) values('Bauhaus', 'https://www.bauhaus.at/', 3);

--Color
insert into Color (name) values ('Schwarz');


insert into Ware (stock, maxAmount, minAmount, name, type_id) values (7, 10, 3,'Schrott', 2);
insert into Ware (stock, maxAmount, minAmount, name, type_id) values (7, 10, 3,'Holzplatte-Schwarz', 2);
insert into Ware (stock, maxAmount, minAmount, name, type_id) values (7, 10, 3,'Holzplatte-Braun', 2);

--TypeDto-Ware
insert into Ware_Supplier (Supplier_id, ware_id) values (1, 6);
insert into Ware_Supplier (Supplier_id, ware_id) values (1, 7);
insert into Ware_Supplier (Supplier_id, ware_id) values (1, 8);
insert into Ware_Supplier (Supplier_id, ware_id) values (2, 7);
insert into Ware_Supplier (Supplier_id, ware_id) values (3, 6);
insert into Ware_Supplier (Supplier_id, ware_id) values (3, 7);



