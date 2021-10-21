use test;

alter table person
add ID int auto_increment primary key;

select * from person;

create table Epost( 
adresse varchar(75) not null unique,
Type varchar(50),
Person_ID int not null,
FOREIGN KEY (Person_ID) references person(ID)
);

desc Epost;

UPDATE person
SET EPost = 'holding@places.no'
WHERE Personnummer = '98765432109';

INSERT INTO epost (adresse, Person_ID)
SELECT EPost, ID
from person
WHERE epost IS NOT NULL;

select * from epost;

alter table person drop column epost;

select * from person;

select ID, Personnummer, Navn, adresse
from person
join epost on ID=Person_ID;

delete
from person
where Navn = 'Abdur Rahman Jalil';

### select column_name, data_type
### from information_schema.columns
### where table_schema = 'test';

desc Person;

alter table person CHANGE COLUMN ID ID int AUTO_INCREMENT AFTER Personnummer;
alter table person CHANGE COLUMN Personnummer Personnummer char(11) AFTER ID;
### alter table person CHANGE COLUMN ID ID int AUTO_INCREMENT not null FIRST;
alter table person CHANGE COLUMN foedselsdato foedselsdato date;

USE world;

select id from city
order by ID desc;

Select *
from information_schema.tables
where table_schema = 'world';

Select MAX(ID)
from city;

select *
from city
ORDER BY ID desc;

