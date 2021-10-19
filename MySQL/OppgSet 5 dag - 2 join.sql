use world;

###Oppgave 1
Select Name
from city
where Name like 'O%o';

###Oppgave 2
Select co.Name, ci.Name, ci.Population innbyggere
from City as ci
join country as co on Code = CountryCode
where ci.Name like 'O%o'
ORDER BY co.Name, ci.Name ;

###Oppgave 3
Select co.continent, co.Name, ci.Name
from country as co
join city as ci on Code = CountryCode
where ID = Capital
order by continent asc;

###Opppgave 4
Select co.Name, count(ci.Name) as NumOfCities, avg(ci.population) as AvgPopulation
from country as co
join city as ci on Code = CountryCode
group by co.Name
HAVING NumOfCities>=1;

###Oppgave 5
Select co.Name, ci.Name, co.Population
from country as co
left join city as ci on Code = CountryCode
where co.Population<1000
order by co.name;

select co.Name, co.Continent, ci.Name, ci.Population 
from country co
left join City ci on ci.countryCode = co.Code
where co.Population<1000;


###Oppgave 6
select co.Name, ci.Name, ci.population, co.GovernmentForm
from country as co
join city as ci on Code = CountryCode
where GovernmentForm like '%Monarchy%'
order by ci.population desc;

###Oppgave 7
Select ci.Name, ci.Population, co.Continent
from city as ci
join country as co on CountryCode = Code
where ci.population>=8000000
order by ci.population desc;

###Oppgave 8
select co.Name, count(cl.Language) as NumOfLanguages
from country as co
join countrylanguage as cl on Code = CountryCode
where co.Continent = 'Asia'
group by co.Name
having NumOfLanguages>=10
order by NumOfLanguages desc;

use test;

###Oppgave 9
create table Hest(
    id int auto_increment primary key,
    navn varchar(50),
    far int default null,
    mor int default null,
    foreign key (mor) references Hest(id) on delete set null ,
    foreign key (far) references Hest(id) on delete set null
);

desc hest;

insert into Hest values
(1, 'Man o'' War', null, null),
(2, 'Tea Biscuit', null, null),
(3, 'Hard Tack', 1, 2),
(4, 'Whisk Broom II', null, null),
(5, 'Swing On', 4, null),
(6, 'Seabiscuit', 3, 5);

select * from hest;

select h.navn, far.navn, mor.navn
from hest as h
left join hest as far on far.ID = h.far
left join hest as mor on mor.ID = h.mor
group by h.navn;

###Oppgave 10
select h.navn, far.navn as far, mor.navn as mor, farfar.navn as farfar,
farmor.navn as farmor, morfar.navn as morfar, mormor.navn as mormor
from hest as h
left join hest as far on far.ID = h.far
left join hest as mor on mor.ID = h.mor
left join hest as farfar on farfar.ID = far.far
left join hest as farmor on farmor.ID = far.mor
left join hest as morfar on morfar.ID = mor.far
left join hest as mormor on mormor.ID = mor.mor
group by h.navn;

