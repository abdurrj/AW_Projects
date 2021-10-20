CREATE SCHEMA `testschemas` ;
use testschemas;

create table epostTest (
`Epost` varchar(100) not null unique primary key,
`Type` varchar(20),
`Konsulent_ID` int not null
);


create table konsulentTest (
`ID` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`Navn` varchar(100) NOT NULL,
`telefonnummer`char(8) unique default null,
`KursID` int default null
);


/*
CREATE TABLE `konsulent` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Navn` varchar(100) NOT NULL,
  `telefonnummer` char(8) DEFAULT NULL,
  `KursID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  UNIQUE KEY `telefonnummer_UNIQUE` (`telefonnummer`),
  KEY `kursID_idx` (`KursID`),
  CONSTRAINT `kursID` FOREIGN KEY (`KursID`) REFERENCES `kurs` (`KursID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
*/

create table kursTest (
`KursID` int not null auto_increment primary key,
`Navn` varchar(50) not null,
`FraDato` DATE,
`TilDato` DATE,
`Sted` varchar(50)
);

create table modulTest (
`ModulID` char(9) not null unique primary key,
`Navn` varchar(50) not null unique
);

create table kurs_modulTest (
`ID_Kurs` int,
`ID_Modul` char(9)
);

alter table kurs_modulTest
ADD CONSTRAINT `kursfk`
  FOREIGN KEY (`ID_Kurs`)
  REFERENCES `kurstest` (`KursID`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION,
ADD CONSTRAINT `modulfk`
  FOREIGN KEY (`ID_Modul`)
  REFERENCES `modultest` (`ModulID`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

alter table eposttest
ADD CONSTRAINT `Kosnulent_ID`
  FOREIGN KEY (`Konsulent_ID`)
  REFERENCES `konsulenttest` (`ID`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;
  
  alter table konsulenttest
  ADD constraint `KursID`
  FOREIGN KEY (`KursID`)
  REFERENCES `kurstest` (`KursID`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;


CREATE TABLE `kurs_modul` (
  `ID_Kurs` int DEFAULT NULL,
  `ID_Modul` char(9) DEFAULT NULL,
  `Lærer` varchar(45) DEFAULT NULL,
  KEY `KursID_idx` (`ID_Kurs`),
  KEY `modulfk` (`ID_Modul`),
  CONSTRAINT `kursfk` FOREIGN KEY (`ID_Kurs`) REFERENCES `kurs` (`KursID`),
  CONSTRAINT `modulfk` FOREIGN KEY (`ID_Modul`) REFERENCES `modul` (`ModulID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


ALTER TABLE `academytraining`.`kurs_modul` 
ADD CONSTRAINT `kursfk`
  FOREIGN KEY (`ID_Kurs`)
  REFERENCES `academytraining`.`kurs` (`KursID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `modulfk`
  FOREIGN KEY (`ID_Modul`)
  REFERENCES `academytraining`.`modul` (`ModulID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;