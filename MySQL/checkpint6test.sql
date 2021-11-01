CREATE TABLE DIRECTOR(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(64)
);

CREATE TABLE MOVIE(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    MOVIE_TITLE VARCHAR(64) NOT NULL,
    PRICE INT NOT NULL,
    DIRECTOR_ID INT,
    KEY `MovieDirector` (`DIRECTOR_ID`),
    constraint `MovieDirector` foreign key (`DIRECTOR_ID`) references DIRECTOR (`ID`) ON DELETE CASCADE
);