create table Users (
    IdUser int primary key,
    Username varchar(200),
    Password varchar(200),
    Email varchar(200),
    Rank int,
    Firstname varchar(50),
    Lastname varchar(50),
    IdPlace int,
);

CREATE TABLE Place(
    IdPlace     int NOT NULL ,
    PlaceName   VARCHAR (50)  ,
    Description VARCHAR (2000)  NOT NULL ,
    idUser      INT  NOT NULL ,
    CONSTRAINT prk_constraint_Place PRIMARY KEY (IdPlace)
);

ALTER TABLE Place ADD CONSTRAINT FK_Place_IdUser FOREIGN KEY (idUser) REFERENCES Users(IdUser);

insert into Users (IdUser, Username, Password, Email, Rank, Firstname, Lastname, IdPlace) values(
    1, 'test', 'mdp', 'test', 3, 'test', 'test', 2
);

insert into Place values (
    2, 'test', 'test', 1
);