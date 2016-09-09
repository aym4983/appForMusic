insert into role (label) values ('user');

-- Tests

insert into appuser (username, email, enabled, firstname, lastname, passwordhash) values ('test', 		'test@test.fr', 	true, 'Test', 		'Test', '$2a$10$WWQLKlimcQS4Cd4.FVcZ7eJVhJFMdTTrA7Zae85wUzOhUYi073CbW');
insert into appuser (username, email, enabled, firstname, lastname, passwordhash) values ('dorian', 	'dorian@test.fr', 	true, 'Dorian', 	'Test', '$2a$10$2Iuec9EgCM4PjJr3VV.ElOxmcSiOlLNCGiVQWVz1hD8tCNSr/xvLy');
insert into appuser (username, email, enabled, firstname, lastname, passwordhash) values ('lila', 		'lila@test.fr', 	true, 'Lila', 		'Test', '$2a$10$e1b/CvJpW1S6KuPq7EXGIu.9axBjFKC4Lhjeyhg5Rr3dnA9qQkDh2');
insert into appuser (username, email, enabled, firstname, lastname, passwordhash) values ('loic', 		'loic@test.fr', 	true, 'Loic', 		'Test', '$2a$10$gyNUqqaP2Sn4KDJfddmUduKIc5Yw1gZsZapk0yVhHLudOsgTSrkzS');
insert into appuser (username, email, enabled, firstname, lastname, passwordhash) values ('tiphanie', 	'tiphanie@test.fr', true, 'Tiphanie', 	'Test', '$2a$10$zyXzLV8WHegR6WhZfXMQnePRJIQpqW9hfF/MGNnYpfqAQxZTGIrmO');

insert into user_role (username, role_id) values ('test', 		1);
insert into user_role (username, role_id) values ('dorian', 	1);
insert into user_role (username, role_id) values ('lila', 		1);
insert into user_role (username, role_id) values ('loic', 		1);
insert into user_role (username, role_id) values ('tiphanie', 	1);

insert into event (startevent, endevent, titleevent, place) values ('2016-09-09T09:00:00', '2016-09-09T12:00:00', 'titleBdd', 6);
insert into event (startevent, endevent, titleevent) values ('2016-09-09T09:00:00', '2016-09-09T12:00:00', 'location');
insert into event (startevent, endevent, titleevent) values ('2016-09-15T10:00:00', '2016-09-15T12:00:00', 'studio Angers');
insert into event (startevent, endevent, titleevent) values ('2016-09-10T21:00:00', '2016-09-10T22:00:00', 'garage');

insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4126973, -0.5584802, 'Mon premier lieu', 	'Bulle Turbo', 			'', '49100', 'test','Description');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4626837, -0.5084230, 'Mon deuxi�me lieu', 	'Veau Authentique', 	'', '49100', 'test','Description');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4812072, -0.5062932, 'Mon troisi�me lieu', 	'Animal Absolu', 		'', '49100', 'test','Description');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4722125, -0.5602542, 'Mon quatri�me lieu', 	'Gazelle Quark', 		'', '49100', 'test','Description');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4557064, -0.5709142, 'Mon cinqui�me lieu', 	'Orage Labo', 			'', '49100', 'test','Description');

insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4174061, -0.5441146, 'Mon premier lieu', 	'Le Studio Solution', 	'', '49100', 'dorian','Description');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4425138, -0.5096653, 'Mon deuxi�me lieu', 	'Plage Chic', 			'', '49100', 'dorian','Description');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4563631, -0.5765614, 'Mon troisi�me lieu', 	'Chevalier Violet', 	'', '49100', 'dorian','Description');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4005738, -0.5838031, 'Mon quatri�me lieu', 	'Renard Violet', 		'', '49100', 'dorian','Description');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4517958, -0.5421846, 'Mon cinqui�me lieu', 	'Homme Bronz�', 		'', '49100', 'dorian','Description');

insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4384891, -0.5778253, 'Mon premier lieu', 	'Merveilleux Cr�atif', '', '49100', 'lila','Description');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4847625, -0.5546227, 'Mon deuxi�me lieu', 	'Chat Lab', 			'', '49100', 'lila','Description');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4552906, -0.5246390, 'Mon troisi�me lieu', 	'R�alit� Gris', 		'', '49100', 'lila','Description');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4611897, -0.5961490, 'Mon quatri�me lieu', 	'Leader Bleu', 			'', '49100', 'lila','Description');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4196438, -0.5577963, 'Mon cinqui�me lieu', 	'Skipper Relance', 		'', '49100', 'lila','Description');

insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4474078, -0.5790373, 'Mon premier lieu', 	'Voyage Turbo', 		'', '49100', 'loic','Description');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4898317, -0.5287437, 'Mon deuxi�me lieu', 	'Buzz Innov', 			'', '49100', 'loic','Description');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4624222, -0.5507054, 'Mon troisi�me lieu', 	'Bo�te Authentique', 	'', '49100', 'loic','Description');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4211354, -0.5469014, 'Mon quatri�me lieu', 	'Plage Conseil', 		'', '49100', 'loic','Description');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4974042, -0.5772130, 'Mon cinqui�me lieu', 	'Commande Azur', 		'', '49100', 'loic','Description');

insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4723090, -0.5469193, 'Mon premier lieu', 	'Buzz Calme', 			'', '49100', 'tiphanie','Description');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4048509, -0.5349527, 'Mon deuxi�me lieu', 	'Merveilleux Fou', 		'', '49100', 'tiphanie','Description');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4599969, -0.5498901, 'Mon troisi�me lieu', 	'Orchid�e Jaune', 		'', '49100', 'tiphanie','Description');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4340458, -0.5330977, 'Mon quatri�me lieu', 	'Bambou Argent�', 		'', '49100', 'tiphanie','Description');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner, description) values ('Angers', 47.4140655, -0.5974014, 'Mon cinqui�me lieu', 	'Grenouille Azur', 		'', '49100', 'tiphanie','Description');
