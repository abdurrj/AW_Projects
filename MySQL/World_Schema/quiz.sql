use world;

/* Riktig
Hent ut navn på kontinenter og hvor mange unike språk som snakkes på hvert kontinent,
men kun hvor det er mer enn 30% som snakker språket. 
Sorter resultater etter antall unike språk i synkende rekkefølge
*/
Select continent, count(DISTINCT cl.Language, co.continent) UnikeSpraak
from countrylanguage as cl
join country as co on cl.CountryCode = co.Code
WHERE cl.Percentage>30
group by continent
order by UnikeSpraak desc;


# Hvilket kontinent har flest land og hvor mange land er det? Riktig
select co.continent, count(co.name) AntallLand
from country co
group by continent
order by AntallLand desc
limit 1;


/* riktig
Skriv ut alle land med sine hovedsteder og hovedstedenes prosentandel av sitt lands befolkning.
Skriv også ut kontinent først i tabellen. Dersom landet ikke har en hovedstad, skriv ut "Ingen hovedstad".
Prosentandelen kan fremdeles stå som NULL. 
Hint: Se bort ifra de to første forvirrende tallene i resultatet.
*/
select co.continent, co.name, coalesce(ci.name, 'Ingen hovedstad'), 100*ci.population/co.population PercentOfTotPop
from country co
left join city ci on co.code = ci.CountryCode
where ci.ID = co.capital or co.capital is null;


/* Riktig
 For alle land i verden som ikke har noen byer:
 hvor mange prosent av landene har forskjellig lokalt navn fra offisielt navn
*/
select 100*(select count(localName) from country where capital is null and localname!=name)/
(select count(localName) from country where capital is null) 
'Prosentandel land med ulike lokalnavn, av land uten byer';

/*
eksperimentering på oppg over
*/
select 100*
(select count(co.name) from country co
left join city ci on ci.countrycode = co.code
where ci.Name is null and co.name!=co.localname)/(select count(co.name) from country co
left join city ci on ci.countrycode = co.code
where ci.Name is null);


/* Riktig
Gi en oversikt over hvor mange byer det finnes i hvert kontinent der
byens land er franskspråkelig (offisielt språk). 
Sorter etter antall (synkende).
*/
select co.continent, count(ci.name) antallByerIFransktalendeLand
from country co
join countrylanguage cl on co.code=cl.countrycode 
join city ci on ci.countryCode = co.Code
where cl.IsOfficial='T' and cl.Language='French'
group by co.continent
order by antallByerIFransktalendeLand desc;

# Hvor mange land er det som starter på q, r, s, t, og u. Riktig
select (select count(name) from country where name between 'Q%' and 'V%')
as 'antall land som starter på q, r, s, t eller u';

# Hva er de tre største uoffisielle språkene i Russland? Riktig
select language, IsOfficial, Percentage
from countrylanguage
where CountryCode = 'RUS' and IsOfficial = 'F'
order by percentage desc
limit 3;