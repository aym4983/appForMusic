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

ALTER TABLE Users ADD CONSTRAINT FK_Users_IdPlace FOREIGN KEY (IdPlace) REFERENCES Place(IdPlace);
ALTER TABLE Place ADD CONSTRAINT FK_Place_IdUser FOREIGN KEY (idUser) REFERENCES Users(IdUser);

