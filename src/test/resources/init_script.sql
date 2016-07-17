create table Users (
    id int primary key,
    Username varchar(200),
    Password varchar(200),
    Email varchar(200)
);

insert into Users (id, Username, Password, Email) values (
    1,
    'nomTest',
    'mdpTest',
    'emailTest'
);
