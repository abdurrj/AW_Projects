# Oppgaveset 1

### Oppgave 1
SELECT * FROM city;

### Oppgave 2
SELECT *
FROM city
WHERE CountryCode = 'NOR'

### Oppgave 3
SELECT Name, Population
FROM city
WHERE CountryCode = 'NOR'
ORDER BY Population DESC

### Oppgave 4
SELECT COUNT(*) AS 'Antall Land'
from country;

### Oppgave 5
SELECT SUM(population)
FROM country

### Oppgave 6
SELECT SUM(population)
FROM country
WHERE Continent = 'Asia'

### Oppgave 7
SELECT Name, SurfaceArea
FROM Country
ORDER BY SurfaceArea ASC

### Oppgave 8
SELECT Name, LifeExpectancy, Population
FROM country
order by LifeExpectancy DESC, Population ASC

### Oppgave 9
Select Name AS 'Land', Population/SurfaceArea AS 'Befolkningstetthet'
From country
WHERE Population > 0
order by Befolkningstetthet ASC

### Oppgave 10
SELECT Code, Name, IndepYear
FROM country
where IndepYear IS NOT NULL
ORDER BY IndepYear ASC

### Ekstraoppgave 11
SELECT city.Name AS 'Hovedstad', country.Name AS 'Land'
FROM city, country
WHERE Capital=city.ID