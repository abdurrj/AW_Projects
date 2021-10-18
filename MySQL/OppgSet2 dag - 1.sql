SELECT Code, Name
FROM country
where Code like '%W%';

SELECT Code, Name
FROM country
where Code like '_W_';

SELECT *
from country
WHERE Name like 'N%' OR Name like 'O%' OR Name like 'P%'
-- WHERE Name between 'N%' and 'Q%'
ORDER BY Name ASC;

Select Language, Percentage, Name
from countrylanguage, country
Where Percentage > 99
and CountryCode = Code
ORDER BY Percentage DESC, Language ASC;

Select Code, Name, Continent
from country
where Continent like '%America'
ORDER BY Code ASC;

Select Continent, Count(*)
from country
group by Continent;

Select Continent, Count(*) AS count
from country
group by Continent
HAVING count>=30
ORDER BY count ASC;

Select Continent, SUM(Population)
from country
group by Continent
ORDER BY SUM(Population) DESC;

-- Select Continent, count(*)
-- from country
-- Where Continent like '%America'
-- group by Continent;

Select Name, Language
From country, countrylanguage
where country.code = CountryCode and countrylanguage.IsOfficial='T' and Percentage>80
ORDER by name asc;

Select Name, Language
From country
join countrylanguage
on countrylanguage.CountryCode = Code
where Percentage>80;

SELECT city.Name AS 'Hovedstad', country.Name AS 'Land'
FROM city, country
WHERE Capital=city.ID;

Select count(DISTINCT Continent, Language)
from country, countrylanguage
group by Continent;

Select Name, Language
from country, countrylanguage;

-- Select DISTINCT co.continent, cl.Language
Select continent, count(DISTINCT cl.Language, co.continent)
from countrylanguage as cl
join country as co on cl.CountryCode = co.Code
WHERE cl.Percentage>30
group by continent;

Select distinct co.continent, cl.Language
from countrylanguage as cl
join country as co on cl.CountryCode = co.Code
where Percentage>30 and continent='North America';

