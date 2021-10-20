select * from modul;

insert into academytraining.modul
values
('JV-OSL-01', 'Introduction to Java'),
('JV-OSL-02', 'GitHub and Unit Testing'),
('JV-OSL-03', 'Advanced Java'),
('JV-OSL-04', 'Relational databases'),
('JS-OSL-01', 'UX og UI design'),
('JS-OSL-02', 'JavaScript basics'),
('JS-OSL-03', 'External JS tools'),
('JS-OSL-04', 'Angular in-depth');

insert into kurs(Navn, FraDato, TilDato, Sted)
values
('Java Oslo Vinter 2020', str_to_date('2020-11-01', '%Y-%m-%d'), str_to_date('2021-01-31', '%Y-%m-%d'), 'Oslo');
('JavaScript Oslo Vinter 2021', str_to_date('2021-03-01', '%Y-%m-%d'), str_to_date('2021-06-30', '%Y-%m-%d'), 'Oslo');

select * from kurs;

insert into kurs_modul
values
(1, 'JV-OSL-01'),
(1, 'JV-OSL-02'),
(1, 'JV-OSL-03'),
(1, 'JV-OSL-04'),
(1, 'JS-OSL-01'),
(1, 'JS-OSL-02'),
(1, 'JS-OSL-03');

insert into kurs_modul
values
(2, 'JV-OSL-02'),
(2, 'JS-OSL-01'),
(2, 'JS-OSL-02'),
(2, 'JS-OSL-03'),
(2, 'JS-OSL-04');


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
WHERE ID = 3;

UPDATE konsulent
SET kursID = 2
where ID = 4;

Select ko.navn, ku.navn KursNavn, km.ID_Modul ModulNavn
from konsulent as ko
join kurs as ku on ko.KursID = ku.KursID
join kurs_modul as km on ko.KursID = km.ID_Kurs
where ko.navn = 'Abdur';

select * from konsulent;

Select ku.Navn KursNavn, count(ko.navn) Deltagere
from kurs ku
join konsulent ko on ku.KursID = ko.KursID
where ku.KursID = 1;

select * 
from kurs_modul
where ID_Kurs = 1;

Update kurs_modul
set Lærer = 'Stian'
where ID_Kurs = 1;

Update kurs_modul
set Lærer = 'Eirik'
where ID_Kurs = 1 and ID_Modul = 'JV-OSL-04';

select * from modul;