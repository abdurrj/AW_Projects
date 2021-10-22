drop schema if exists Checkpoint;
create schema checkpoint;
use checkpoint;

Create table tool
(
	ID char(2) not null primary key,
    Name varchar(30) not null unique,
    Developer varchar(30) not null
);

create table Language
(
	ID int auto_increment primary key,
    Name varchar(20) unique,
    Year YEAR,
    Creator varchar(30),
    ToolID char(2),
    KEY `LanguageTool` (`ToolID`),
    constraint `LanguageTool` foreign key (`ToolID`) references tool (`ID`) on delete cascade
);

insert into tool
values
('VS', 'Visual Studio Code', 'Microsoft'),
('IJ', 'IntelliJ', 'JetBrains');

insert into Language(Name, Year, Creator, ToolID)
values
('Java', 1996, 'James Gosling', 'IJ'),
('JavaScript', 1997, 'Brendan Eich', 'VS'),
('C#', 2002, 'Anders Hejlsberg', 'VS'),
('Python', 1994, 'Guido van Rossum', null);


##### Oppgave 2c

create table language2 as (select * from language);
alter table language2 drop column ToolID;
select * from language2;

drop table if exists languagetools;
create table languagetools
(
	ToolID char(2) not null,
    languageID int not null,
    KEY `toolIDfk` (`ToolID`),
    KEY `languageIDfk` (`languageID`),
    constraint `toolIDfk` foreign key (`ToolID`) references tool (`ID`) on delete cascade,
    constraint `languageIDfk` foreign key (`languageID`) references language (`ID`) on delete cascade
);

insert into languagetools
select 'IJ', language.ID from language where ID != 3;

insert into languagetools
select 'VS', language.ID from language where ID != 1;

select * from languagetools
order by ToolID, languageID;
