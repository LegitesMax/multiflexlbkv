-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database

--Regale
insert into Regal (max_anzahl_faecher, name) values(10, 'Regal-1');
insert into Regal (max_anzahl_faecher, name) values( 12, 'Regal-2');

--Waren
insert into Ware (bestand, maxbestand, minbestand, name) values(8, 15, 5,'BAXXXX');
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

--Material
--insert into Material (name, dimension) values ('Schrott', 3);

--Lieferant
insert into Lieferant (name, weblink, lieferzeit) values('Amazon', 'https://www.amazon.de/', 3);
insert into Lieferant (name, weblink, lieferzeit) values('Amazon2', 'https://www.amazon.de/', 3);
insert into Lieferant (name, weblink, lieferzeit) values('Amazon3', 'https://www.amazon.de/', 3);
--insert into Lieferant (name, weblink, lieferzeit) values('Holzgruber', 'https://www.holzgruber.com/', 3);