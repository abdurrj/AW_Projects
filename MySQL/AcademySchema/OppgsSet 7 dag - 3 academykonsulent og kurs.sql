
select * from modul;

insert into academy.modul
values
('JV-OSL-01', 'Introduction to Java', 5),
('JV-OSL-02', 'GitHub and Unit Testing', 2),
('JV-OSL-03', 'Advanced Java', 8),
('JV-OSL-04', 'Relational databases', 5),
('JS-OSL-01', 'UX og UI design', 5),
('JS-OSL-02', 'JavaScript basics', 3),
('JS-OSL-03', 'External JS tools', 3),
('JS-OSL-04', 'Angular in-depth', 5);

# Gjort i ettertid for alle, en om gangen
/*
update modul
set Dager = 5
where ModulID = 'JS-OSL-04';
*/

insert into kurs(Navn, FraDato, TilDato, Sted)
values
('Java Oslo Vinter 2020', str_to_date('2020-11-01', '%Y-%m-%d'), str_to_date('2021-01-31', '%Y-%m-%d'), 'Oslo'),
('JavaScript Oslo Vinter 2021', str_to_date('2021-03-01', '%Y-%m-%d'), str_to_date('2021-06-30', '%Y-%m-%d'), 'Oslo');

select * from kurs;

/* insert into kurs_modul 
values
(1, 'JV-OSL-01'),
(1, 'JV-OSL-02'),
(1, 'JV-OSL-03'),
(1, 'JV-OSL-04'),
(1, 'JS-OSL-01'),
(1, 'JS-OSL-02'),
(1, 'JS-OSL-03');
*/
insert into kurs_modul(ID_Kurs, ID_Modul)
select 1, modul.ModulID from modul where ModulID != 'JS-OSL-04';

/*
insert into kurs_modul
values
(2, 'JV-OSL-02'),
(2, 'JS-OSL-01'),
(2, 'JS-OSL-02'),
(2, 'JS-OSL-03'),
(2, 'JS-OSL-04');
*/
insert into kurs_modul(ID_Kurs, ID_Modul)
select 2, modul.ModulID 
from modul 
where ModulID like 'JS%' or ModulID like 'JV-OSL-02';

select * from kurs_modul;

insert into konsulent(Navn, telefonnummer)
values
('Abdur', 12345678),
('Frank', 23456789);

insert into konsulent(Navn, telefonnummer, KursID)
values
('Liv-Mette', 11223344, 1),
('Lars', 22334455, 1),
('Elin', 33445566, 1),
('Cecilie', 44556677, 1);

select * from konsulent;

UPDATE konsulent
SET kursID = 1
WHERE ID = 1;

UPDATE konsulent
SET kursID = 2
where ID = 2;

Select ko.navn, ku.navn KursNavn, m.Navn
from konsulent as ko
join kurs as ku on ku.KursID = ko.KursID
join kurs_modul as km on ko.KursID = km.ID_Kurs
join modul as m on km.ID_Modul = m.ModulID
where ko.navn = 'Abdur';

select * from konsulent;

Select ku.Navn KursNavn, count(ko.navn) Deltagere
from kurs ku
join konsulent ko on ku.KursID = ko.KursID
where ku.KursID = 1;

alter table kurs_modul
add column
Lærer varchar(30);

select * 
from kurs_modul
where ID_Kurs = 1;

Update kurs_modul
set Lærer = 'Eirik'
where ID_Kurs = 2;

Update kurs_modul
set Lærer = 'Stian'
where ID_Kurs = 2 and ID_Modul like 'JV%';

select * from modul;

select * from kurs_modul;

Select km.Lærer, count(distinct ko.navn) as HoderUnderVistSamletForAlleFag
from kurs_modul km
join konsulent ko on ko.KursID = km.ID_Kurs
where km.Lærer = 'Stian';

Select km.lærer, count(distinct m.navn) as ModulerUndervistAvStian
from kurs_modul km
join modul m on km.ID_Modul = m.ModulID
where km.lærer = 'Stian';

create view UndervisningsDagerforLærer as
Select km.lærer, sum(m.dager) as Undervisningsdager
from kurs_modul as km
join modul m on km.ID_Modul = m.ModulID
group by km.lærer;

select *
from undervisningsdagerforlærer;

drop view undervisningsdagerforlærer;
