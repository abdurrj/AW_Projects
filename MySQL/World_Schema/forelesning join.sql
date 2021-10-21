USE world;

Select CountryCode, Percentage
FROM countrylanguage
where Language = 'spanish' and IsOfficial = 'T'
order by CountryCode;

Select code, name, Percentage
from country
join countrylanguage on countrylanguage.CountryCode = country.Code
where Language = 'spanish' and IsOfficial = 'T'
order by CountryCode;

SELECT country.Name, city.Name
FROM Country
LEFT JOIN City ON Country.code = City.CountryCode -- LEFT JOIN for å få med seg Antarctica
Where country.Name like 'An%'
order by Country.Name;

SELECT ci.Name, ci.Population, co.name
from Country as co join City as ci on co.code = ci.CountryCode
where co.continent >= 'Europe';

Select ci.Name, ci.Population, co.name
