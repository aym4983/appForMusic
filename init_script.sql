DROP ROLE IF EXISTS lila;
DROP ROLE IF EXISTS tiphanie;
DROP ROLE IF EXISTS dorian;
DROP ROLE IF EXISTS loic;
DROP DATABASE IF EXISTS appformusic;

/*
* Création des rôles utilisateurs
*/
CREATE ROLE lila WITH SUPERUSER CREATEDB LOGIN PASSWORD 'lila';
CREATE ROLE tiphanie WITH SUPERUSER CREATEDB LOGIN PASSWORD 'tiphanie';
CREATE ROLE dorian WITH SUPERUSER CREATEDB LOGIN PASSWORD 'dorian';
CREATE ROLE loic WITH SUPERUSER CREATEDB LOGIN PASSWORD 'loic';

CREATE DATABASE appformusic;

CREATE TABLE test (
    id SERIAL,
    nom VARCHAR(50),
    CONSTRAINT test_pk PRIMARY KEY (id)
);