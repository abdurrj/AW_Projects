select count(*)
from city
where population>=(select avg(Population) from city);

SELECT (SELECT avg(population) from country) as avgCountryPopulation,
(Select avg(population) from city) as avgCityPopulation;

#######################################

Select Name from country
where Capital IS NULL
order by name;

Select * from country
where country.Code NOT IN (Select CountryCode from city)
order by Name;

select * from country co
left join city ci on ci.countrycode = co.code
where ci.Name is null;

########################################

Select Name, Population*100/(Select SUM(Population) from country) WorldPopPercentage, SurfaceArea
from country
order by WorldPopPercentage desc;

Select Name,
case 
	when GovernmentForm like '%onarchy%' THEN "Monarki"
	when GovernmentForm like '%epublic%' THEN "Republikk"
	ELSE "annet"
end as StyreForm
from Country
order by name;

select co.Name, ci.Name
from country as co
left join city as ci on code=CountryCode
order by ci.name asc;

select co.Name, COALESCE(ci.Name, "Har ingen by") as 'by'
from country as co
left join city as ci on code=countrycode
order by ci.Name;

select co.Name, co.SurfaceArea*100/(Select SUM(SurfaceArea) from country) '% surafe area of the world'
from country as co
left join city as ci on code=countryCode
where ci.Name is null;

/*
Hvor mye areal opptar land med en befolkning på mindre enn 5000, og hvor mye utgjør dette i prosent av verdens totale areal?
Hvor mange personer bor totalt i disse landene?
Skriv ned det samlede arealet (TotArea), Arealet i prosent(AreaPercentage) og samlet befolkning for disse landene(TotPeople)
*/
select
	(select sum(SurfaceArea) from country where population<5000) TotArea,
	(select sum(SurfaceArea) from country where population<5000)*100/(Select sum(SurfaceArea) from country) AreaPercentage,
    (select sum(Population) from country where population<5000) TotPeople;


select name, Population from country where population<5000;