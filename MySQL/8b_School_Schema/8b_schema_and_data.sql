DROP SCHEMA IF EXISTS skole;
CREATE SCHEMA skole;
USE skole;

CREATE TABLE student
(
  snr     INT(4), 
  navn    VARCHAR(12),
  adresse VARCHAR(12),
  fdato   DATE,
  CONSTRAINT student_snr_pk PRIMARY KEY (snr)
);

CREATE TABLE fag
(
  fnr         INT(4),
  fnavn       VARCHAR(10),
  studiepoeng FLOAT(3,1),
  CONSTRAINT fag_fnr_pk PRIMARY KEY (fnr)
);

CREATE TABLE eksamen
(
  snr      INT(4),
  fnr      INT(4),
  dato     DATE,
  karakter FLOAT(2,1) NOT NULL,
  CONSTRAINT eksamen_snr_fnr_dato_pk PRIMARY KEY (snr, fnr, dato),
  CONSTRAINT eksamen_fnr_fk FOREIGN KEY (fnr) REFERENCES fag(fnr),
  CONSTRAINT eksamen_snr_fk FOREIGN KEY (snr) REFERENCES student(snr)
);

INSERT INTO student VALUES
(1,'EVA',  'AVEIEN 1', STR_TO_DATE('01-01-1987', '%d-%m-%Y')),
(3,'OLA',  NULL,       STR_TO_DATE('10-02-1989', '%d-%m-%Y')),
(5,'KARI', 'BVEIEN 2', STR_TO_DATE('05-06-1982', '%d-%m-%Y')),
(7,'PER',  'AVEIEN 4', STR_TO_DATE('02-10-1986', '%d-%m-%Y')),
(9,'GURI', 'CVEIEN 5', STR_TO_DATE('15-11-1977', '%d-%m-%Y'));

INSERT INTO fag VALUES
(1, 'PROG',  7.5),
(2, 'SYS',  15.0),
(3, 'DB',    7.5),
(4, 'MAT',   5.0);

INSERT INTO eksamen VALUES
(1, 1, STR_TO_DATE('20-05-2008', '%d-%m-%Y'), 4.0),
(3, 1, STR_TO_DATE('20-05-2008', '%d-%m-%Y'), 2.0),
(7, 1, STR_TO_DATE('20-05-2008', '%d-%m-%Y'), 1.5),
(9, 1, STR_TO_DATE('20-05-2008', '%d-%m-%Y'), 4.5),
(1, 2, STR_TO_DATE('10-12-2008', '%d-%m-%Y'), 3.0),
(5, 2, STR_TO_DATE('10-12-2008', '%d-%m-%Y'), 2.5),
(7, 2, STR_TO_DATE('10-12-2008', '%d-%m-%Y'), 4.0),
(3, 3, STR_TO_DATE('01-06-2009', '%d-%m-%Y'), 3.5),
(5, 3, STR_TO_DATE('01-06-2009', '%d-%m-%Y'), 5.0),
(7, 3, STR_TO_DATE('01-06-2009', '%d-%m-%Y'), 2.0),
(9, 3, STR_TO_DATE('01-06-2009', '%d-%m-%Y'), 3.0),
(1, 4, STR_TO_DATE('05-12-2009', '%d-%m-%Y'), 5.0),
(7, 4, STR_TO_DATE('05-12-2009', '%d-%m-%Y'), 1.5),
(9, 4, STR_TO_DATE('05-12-2009', '%d-%m-%Y'), 2.0),
(5, 1, STR_TO_DATE('01-12-2009', '%d-%m-%Y'), 2.5),
(9, 1, STR_TO_DATE('01-12-2009', '%d-%m-%Y'), 3.0),
(1, 3, STR_TO_DATE('25-08-2009', '%d-%m-%Y'), 3.5),
(3, 3, STR_TO_DATE('25-08-2009', '%d-%m-%Y'), 2.0),
(5, 3, STR_TO_DATE('25-08-2009', '%d-%m-%Y'), 4.5),
(1, 1, STR_TO_DATE('10-06-2010', '%d-%m-%Y'), 3.0),
(1, 1, STR_TO_DATE('12-12-2010', '%d-%m-%Y'), 1.5),
(1, 1, STR_TO_DATE('08-08-2010', '%d-%m-%Y'), 1.5),
(3, 2, STR_TO_DATE('10-12-2008', '%d-%m-%Y'), 2.5),
(3, 2, STR_TO_DATE('12-05-2010', '%d-%m-%Y'), 4.0);
