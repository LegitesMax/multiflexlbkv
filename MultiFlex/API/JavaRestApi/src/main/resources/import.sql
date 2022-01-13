-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
insert into Regal (id, max_anzahl_fächer, name) values(nextval('hibernate_sequence'), 10, 'test1');
insert into Regal (id, max_anzahl_fächer, name) values(nextval('hibernate_sequence'), 12, 'test2');
insert into Fach (fach_id, position, regal_id, ware_id) values(nextval('hibernate_sequence'), 1, 1, 1);
insert into Fach (fach_id, position, regal_id, ware_id) values(nextval('hibernate_sequence'), 1, 2, 1);
insert into Ware (ware_id, bestand, mindestbestand, name) values(nextval('hibernate_sequence'), 10, 4, 'BAXXXX');