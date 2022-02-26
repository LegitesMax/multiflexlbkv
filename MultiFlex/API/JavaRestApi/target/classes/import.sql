-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database

--Regale
insert into Regal (max_anzahl_faecher, name) values(10, 'Regal-1');
insert into Regal (max_anzahl_faecher, name) values( 12, 'Regal-2');
insert into Regal (max_anzahl_faecher, name) values( 12, 'Regal-3');
insert into Regal (max_anzahl_faecher, name) values( 12, 'Regal-4');

--Fächer
insert into Fach (position, regal_id, ware_id, maxbestand) values(1, 1, 1, 20);
insert into Fach (position, regal_id, ware_id, maxbestand) values(2, 1, 2, 20);
insert into Fach (position, regal_id, ware_id, maxbestand) values(3, 1, 5, 20);
insert into Fach (position, regal_id, ware_id, maxbestand) values(1, 2, 3, 20);
insert into Fach (position, regal_id, ware_id, maxbestand) values(2, 2, 4, 20);
insert into Fach (position, regal_id, ware_id, maxbestand) values(1, 3, 6, 20);
insert into Fach (position, regal_id, ware_id, maxbestand) values(2, 3, 7, 20);
insert into Fach (position, regal_id, ware_id, maxbestand) values(3, 3, 8, 20);
insert into Fach (position, regal_id, ware_id, maxbestand) values(4, 3, 9, 20);
insert into Fach (position, regal_id, ware_id, maxbestand) values(1, 4, 10, 20);
insert into Fach (position, regal_id, ware_id, maxbestand) values(2, 4, 11, 20);
insert into Fach (position, regal_id, ware_id, maxbestand) values(3, 4, 12, 20);

--Waren
insert into Ware (bestand, maxbestand, minbestand, name) values(8, 15, 5,'BAXXXX');
insert into Ware (bestand, maxbestand, minbestand, name) values(2, 10, 1,'LÖXXXX');
insert into Ware (bestand, maxbestand, minbestand, name) values(10, 15, 5,'LOXXXX');
insert into Ware (bestand, maxbestand, minbestand, name) values(4, 15, 2,'TAXXXX');
insert into Ware (bestand, maxbestand, minbestand, name) values(7, 10, 3,'BAXXXX');
insert into Ware (bestand, maxbestand, minbestand, name) values(7, 10, 3,'LOXXXX');
insert into Ware (bestand, maxbestand, minbestand, name) values(7, 10, 3,'LÖXXXX');
insert into Ware (bestand, maxbestand, minbestand, name) values(7, 10, 3,'HEXXXX');
insert into Ware (bestand, maxbestand, minbestand, name) values(7, 10, 3,'LOXXXX');
insert into Ware (bestand, maxbestand, minbestand, name) values(7, 10, 3,'BAXXXX');
insert into Ware (bestand, maxbestand, minbestand, name) values(7, 10, 3,'LÖXXXX');
