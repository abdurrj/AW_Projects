use checkpoint;

# Oppgave 1c

select year, name, creator
from language
order by year;

select *
from tool
where name = 'Visual Studio Code';

######### Oppgave 2

# Oppg 2a

select ToolID, count(*) NumberOfLanguages
from language
where toolID is not null
group by toolID;

select l.name Language, t.name Tool # eller bruke coalesce(t.name, 'No tool for this language') Tool
from language l
left join tool t on l.ToolID = t.ID;

# Oppg 2d

select t.name, count(lt.toolID) NumberOfLanguages
from tool t
join languagetools lt on t.ID = lt.toolID
group by t.name;

select l.name Language, t.name Tool
from language2 l
left join languagetools lt on lt.languageID = l.ID
left join tool t on t.ID = lt.ToolID
order by Language, tool;

