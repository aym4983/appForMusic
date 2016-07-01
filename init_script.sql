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

CREATE TABLE Genres (
  id VARCHAR(10) NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE Instruments (
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

CREATE TABLE Users_authorization(
    user_role_id SERIAL,
    users VARCHAR(255) NOT NULL,
    role VARCHAR(30) NOT NULL,
    PRIMARY KEY(user_role_id),
    FOREIGN KEY (users) REFERENCES Users(userName)
);

CREATE TABLE Places (
  id SERIAL NOT NULL,
  users VARCHAR(255) NOT NULL,
  label VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  cp VARCHAR(5) NOT NULL,
  city VARCHAR(255) NOT NULL,
  capacity INTEGER NOT NULL,
  latitude DECIMAL NOT NULL,
  longitude DECIMAL NOT NULL,
  PRIMARY KEY(id)
  FOREIGN KEY(users) REFERENCES Users(userName)
);

CREATE TABLE ProfessionalsPlaces (
  id SERIAL NOT NULL ,
  place INTEGER NOT NULL,
  siret VARCHAR(255) NULL,
  isValidated BOOL NULL,
  googlePlaceId VARCHAR(255) NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(place) REFERENCES Places(id) 
);

CREATE TABLE Events (
  id SERIAL NOT NULL,
  genre VARCHAR(10) NOT NULL,
  startDate TIMESTAMP NOT NULL,
  endDate TIMESTAMP NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(genre) REFERENCES Genres(id)
);

CREATE TABLE PlayedInstruments (
  id SERIAL NOT NULL,
  users VARCHAR(255) NOT NULL,
  instrument VARCHAR(100) NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(users) REFERENCES Users(userName),
  FOREIGN KEY(instrument) REFERENCES Instruments(id)
);

CREATE TABLE Boeufs (
  id INTEGER NOT NULL,
  genre VARCHAR(10) NOT NULL,
  event INTEGER NOT NULL,
  users VARCHAR(255) NOT NULL,
  label VARCHAR(255) NOT NULL,
  maxMusicians INTEGER NOT NULL,
  startDate TIMESTAMP NOT NULL,
  endDate TIMESTAMP NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(genre) REFERENCES Genres(id),
  FOREIGN KEY(event) REFERENCES Events(id),
  FOREIGN KEY(users) REFERENCES Users(userName)
);

CREATE TABLE Participate (
  id SERIAL NOT NULL,
  instrument VARCHAR(100) NOT NULL,
  users VARCHAR(255) NOT NULL,
  boeuf INTEGER NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(boeuf) REFERENCES Boeufs(id),
  FOREIGN KEY(instrument) REFERENCES Instruments(id),
  FOREIGN KEY(users) REFERENCES Users(userName)
);

CREATE TABLE Organize  (
  id SERIAL NOT NULL,
  place INTEGER NOT NULL,
  instrument VARCHAR(100) NOT NULL,
  users VARCHAR(255) NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(place) REFERENCES Places(id),
  FOREIGN KEY(instrument) REFERENCES Instruments(id),
  FOREIGN KEY(users) REFERENCES Users(userName)
);
