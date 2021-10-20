CREATE SCHEMA `academy` ;
use academy;

# Lag tabeller
create table epost (
`Epost` varchar(100) not null unique primary key,
`Type` varchar(20),
`Konsulent_ID` int not null
);

create table konsulent (
`ID` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`Navn` varchar(100) NOT NULL,
`telefonnummer`char(8) unique default null,
`KursID` int default null
);

create table kurs (
`KursID` int not null auto_increment primary key,
`Navn` varchar(50) not null,
`FraDato` DATE,
`TilDato` DATE,
`Sted` varchar(50)
);

create table modul (
`ModulID` char(9) not null unique primary key,
`Navn` varchar(50) not null unique,
`Dager` INT default null
);

create table kurs_modul (
`ID_Kurs` int,
`ID_Modul` char(9)
);

# Koble Primary key/Foreign Key i tabeller
alter table kurs_modul
ADD CONSTRAINT `kursfk` # Navnet på koblingen
  FOREIGN KEY (`ID_Kurs`) # Navnet på kolonnen fra kurs_modul tabellen
  REFERENCES `kurs` (`KursID`) # Hvilken tabell og navnet på kolonnen den skal koble til
  ON DELETE CASCADE
  ON UPDATE NO ACTION,
ADD CONSTRAINT `modulfk`
  FOREIGN KEY (`ID_Modul`)
  REFERENCES `modul` (`ModulID`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

alter table epost
ADD CONSTRAINT `Kosnulent_ID`
  FOREIGN KEY (`Konsulent_ID`)
  REFERENCES `konsulent` (`ID`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;
  
  alter table konsulent
  ADD constraint `KursID`
  FOREIGN KEY (`KursID`)
  REFERENCES `kurs` (`KursID`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;