-- Oppgave 1
create table person (
Personnummer char(11) NOT NULL unique,
Navn varchar(100) default 'Ukjent',
EPost varchar(100) unique );

-- Oppgave 2
insert into person
VALUES('12345678901', 'Ola Nordmann', 'ola@nordmann.no');

select * from person;

-- Oppgave 3
ALTER TABLE person
ADD foedselsdato datetime; -- Burde være date, ikke datetime

-- Oppgave 4
insert into person(Personnummer)
values('98765432109');

-- Oppgave 5
select * from person
where Personnummer = '98765432109';

UPDATE person
SET foedselsdato = '1990-01-01'
WHERE Personnummer = '98765432109';

-- Oppgave 6
insert into person
values(17049110101, 'Abdur Rahman Jalil', 'abdur@jalil.no', '1991-04-17');


UPDATE person
set foedselsdato = '1999-09-09 02:30'
where Personnummer = '17049110101';

USE test;

UPDATE person
set EPost = 'place@holder.no'
where Personnummer = '17049110101';

-- Oppgave 7
create table personcopy (
Personnummer char(11) NOT NULL unique,
Navn varchar(100) default 'Ukjent',
EPost varchar(100) unique );

DROP TABLE personcopy;

-- Oppgave 8
Select Navn, date_format(foedselsdato, '%d.%m.%Y')
from person;


update person
set foedselsdato = str_to_date('20.02.1912', '%d.%m.%Y')
where Navn = 'Ola Nordmann';

-- Oppgave 9
delete from city
where Name = 'Bærum';

Select Name from city where CountryCode='NOR';
