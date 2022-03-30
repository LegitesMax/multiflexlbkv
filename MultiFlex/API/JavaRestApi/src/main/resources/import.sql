-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database

--Regale
insert into Regal (max_anzahl_faecher, name) values(10, 'Regal-1');
insert into Regal (max_anzahl_faecher, name) values( 12, 'Regal-2');

--Typ
insert into Typ (typ) values ('Produkt');
insert into Typ (typ)  values ('Material');

--Waren
insert into Ware (bestand, maxbestand, minbestand, name, typ_id) values(8, 15, 5,'BAXXXX', 1);
insert into Ware (bestand, maxbestand, minbestand, name) values(2, 10, 1,'LÖXXXX');
insert into Ware (bestand, maxbestand, minbestand, name) values(10, 15, 5,'LOXXXX');
insert into Ware (bestand, maxbestand, minbestand, name) values(4, 15, 2,'TAXXXX');
insert into Ware (bestand, maxbestand, minbestand, name) values(7, 10, 3,'HEXXXX');

--Fächer
insert into Fach (maxbestand, position, regal_id, ware_id) values( 20, 1, 1, 1);
insert into Fach (position, regal_id, ware_id, maxbestand) values(2, 1, 2, 20);
insert into Fach (position, regal_id, ware_id, maxbestand) values(3, 1, 5, 20);
insert into Fach (position, regal_id, ware_id, maxbestand) values(1, 2, 3, 20);
insert into Fach (position, regal_id, ware_id, maxbestand) values(2, 2, 4, 20);

--Lieferant
insert into Lieferant (name, weblink, lieferzeit) values('Amazon', 'https://www.amazon.de/', 3);
insert into Lieferant (name, weblink, lieferzeit) values('Obi', 'https://www.obi.at ', 3);
insert into Lieferant (name, weblink, lieferzeit) values('Bauhaus', 'https://www.bauhaus.at/', 3);

--Farbe
insert into Farbe (name) values ('Schwarz');


insert into Ware (bestand, maxbestand, minbestand, name, typ_id) values (7, 10, 3,'Schrott', 2);
insert into Ware (bestand, maxbestand, minbestand, name, typ_id) values (7, 10, 3,'Holzplatte-Schwarz', 2);
insert into Ware (bestand, maxbestand, minbestand, name, typ_id) values (7, 10, 3,'Holzplatte-Braun', 2);

--Typ-Ware
insert into Lieferant_Ware (lieferant_id, waren_id) values (1, 6);
insert into Lieferant_Ware (lieferant_id, waren_id) values (1, 7);
insert into Lieferant_Ware (lieferant_id, waren_id) values (1, 8);
insert into Lieferant_Ware (lieferant_id, waren_id) values (2, 7);
insert into Lieferant_Ware (lieferant_id, waren_id) values (3, 6);
insert into Lieferant_Ware (lieferant_id, waren_id) values (3, 7);



