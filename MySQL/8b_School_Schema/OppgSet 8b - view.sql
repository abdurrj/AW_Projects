select * from eksamen;

select * from fag;

select * from student;

select f.fnavn Fag, s.snr Studentnr, s.navn Navn, e.karakter EksamensResultat
from fag f
join eksamen e on f.fnr = e.fnr
join student s on s.snr = e.snr
where f.fnr = 1 and e.dato = str_to_date('20.05.2008','%d.%m.%Y');

# enklere
select s.snr, s.navn, e.karakter
from eksamen e
join student s on s.snr = e.snr
where e.fnr = 1 and e.dato = str_to_date('20.05.2008','%d.%m.%Y');

create or replace view StudentRaadet as
select navn, adresse
from student;

select * from studentraadet;


###################################
create or replace view RektorView as
select f.fnavn, max(e.karakter) BesteKarakter
from fag f
join eksamen e on e.fnr = f.fnr
group by f.fnavn;

select * from rektorview;

###################################
create or replace view studieadm_eksamenoversikt_view as
select MIN(Karakter) bestekarakter, fnr, snr
from eksamen
group by snr, fnr;

###################################
create or replace view studieadm_studentstudiepoeng_view as
select s.snr, s.navn, sum(f.studiepoeng) sumstudiepoeng
from student s
left join(
select min(karakter) karakter, snr, fnr from eksamen group by snr, fnr
) as e on e.snr = s.snr
join fag f on f.fnr = e.fnr
group by s.snr;


select f.fnr, f.fnavn, ev.bestekarakter, f.studiepoeng
from studieadm_eksamenoversikt_view ev
join fag f on f.fnr = ev.fnr
where ev.snr = 1;






