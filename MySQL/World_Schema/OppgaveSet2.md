
-- Oppgave 1
SELECT Code, Name
FROM country
where Code like '_W_';

--Oppgave 2
SELECT *
from country
WHERE Name like 'N%' OR Name like 'O%' OR Name like 'P%'
-- WHERE Name between 'N%' and 'Q%'
ORDER BY Name ASC;

--Oppgave 3
Select Language, Percentage, Name
from countrylanguage, country
Where Percentage > 99
and CountryCode = Code
ORDER BY Percentage DESC, Language ASC;

--Oppgave 4
Select Code, Name, Continent
from country
where Continent like '%America'
ORDER BY Code ASC;

--Oppgave 5
Select Continent, Count(*)
from country
group by Continent;

--Oppgave 6
Select Continent, Count(*) AS count
from country
group by Continent
HAVING count>=30
ORDER BY count ASC;

--Oppgave 7
Select Continent, SUM(Population)
from country
group by Continent
ORDER BY SUM(Population) DESC;

--Oppgave 8
Select SUM(Population)
from country;

Select Continent, count(*)

--Ekstraoppgave 9
Select Name, Language
From country, countrylanguage
where country.code = CountryCode and Percentage>80
ORDER by name asc;

Select Name, Language
From country
join countrylanguage
on countrylanguage.CountryCode = Code
where Percentage>80
ORDER by name asc;
