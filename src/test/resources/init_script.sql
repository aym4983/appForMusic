create table utilisateur (
    id int primary key,
    nom varchar(200),
    mdp varchar(200),
    email varchar(200)
);

insert into utilisateur (id, nom, mdp, email) values (
    1,
    'nomTest',
    'mdpTest',
    'emailTest'
);
