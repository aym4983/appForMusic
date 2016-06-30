DROP ROLE IF EXISTS lila;
DROP ROLE IF EXISTS tiphanie;
DROP ROLE IF EXISTS dorian;
DROP ROLE IF EXISTS loic;
DROP ROLE IF EXISTS admini;
DROP DATABASE IF EXISTS appformusic;

/*
* Création des rôles utilisateurs
*/
CREATE ROLE lila WITH SUPERUSER CREATEDB LOGIN PASSWORD 'lila';
CREATE ROLE tiphanie WITH SUPERUSER CREATEDB LOGIN PASSWORD 'tiphanie';
CREATE ROLE dorian WITH SUPERUSER CREATEDB LOGIN PASSWORD 'dorian';
CREATE ROLE loic WITH SUPERUSER CREATEDB LOGIN PASSWORD 'loic';
CREATE ROLE admini WITH SUPERUSER CREATEDB LOGIN PASSWORD 'admini';

CREATE DATABASE appformusic;

GRANT CONNECT ON DATABASE appformusic TO admini;

\connect appformusic;

CREATE TABLE Genre (
  id VARCHAR(10) NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE Instrument (
  id VARCHAR(100) NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE Users(
  userName VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password  VARCHAR(255) NOT NULL,
  enabled BOOL NOT NULL,
  firstName VARCHAR(60) NOT NULL,
  lastName VARCHAR(60) NOT NULL,
  isProfessional BOOL NOT NULL,
  phone VARCHAR(10) NULL,
  PRIMARY KEY(userName)
);

CREATE TABLE Place (
  id SERIAL NOT NULL,
  userName VARCHAR(255) NOT NULL,
  label VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  cp VARCHAR(5) NOT NULL,
  city VARCHAR(255) NOT NULL,
  capacity INTEGER NOT NULL,
  latitude DECIMAL NOT NULL,
  longitude DECIMAL NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE ProfessionalPlace (
  id SERIAL NOT NULL ,
  idPlace INTEGER NOT NULL,
  siret VARCHAR(255) NULL,
  isValidated BOOL NULL,
  googlePlaceId VARCHAR(255) NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(idPlace) REFERENCES Place(id) 
);

CREATE TABLE Events (
  id SERIAL NOT NULL,
  idGenre VARCHAR(10) NOT NULL,
  startDate TIMESTAMP NOT NULL,
  endDate TIMESTAMP NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(idGenre) REFERENCES Genre(id)
);

CREATE TABLE PlayedInstruments (
  userName VARCHAR(255) NOT NULL,
  idInstrument VARCHAR(100) NOT NULL,
  PRIMARY KEY(idInstrument, userName),
  FOREIGN KEY(userName) REFERENCES Users(userName),
  FOREIGN KEY(idInstrument) REFERENCES Instrument(id)
);

CREATE TABLE Boeuf (
  id INTEGER NOT NULL,
  idGenre VARCHAR(10) NOT NULL,
  idEvent INTEGER NOT NULL,
  userName VARCHAR(255) NOT NULL,
  label VARCHAR(255) NOT NULL,
  maxMusicians INTEGER NOT NULL,
  startDate TIMESTAMP NOT NULL,
  endDate TIMESTAMP NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(idGenre) REFERENCES Genre(id),
  FOREIGN KEY(idEvent) REFERENCES Events(id),
  FOREIGN KEY(userName) REFERENCES Users(userName)
);

CREATE TABLE Participate (
  idInstrument VARCHAR(100) NOT NULL,
  userName VARCHAR(255) NOT NULL,
  idBoeuf INTEGER NOT NULL,
  PRIMARY KEY(idInstrument,userName,idBoeuf),
  FOREIGN KEY(idBoeuf) REFERENCES Boeuf(id),
  FOREIGN KEY(idInstrument) REFERENCES Instrument(id),
  FOREIGN KEY(userName) REFERENCES Users(userName)
);

CREATE TABLE Organise  (
  idPlace INTEGER NOT NULL,
  idInstrument VARCHAR(100) NOT NULL,
  userName VARCHAR(255) NOT NULL,
  PRIMARY KEY(idPlace, idInstrument,userName),
  FOREIGN KEY(idPlace) REFERENCES Place(id),
  FOREIGN KEY(idInstrument) REFERENCES Instrument(id),
  FOREIGN KEY(userName) REFERENCES Users(userName)
);
