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

insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 47.7254090, -0,5584802, 'Mon premier lieu', 		'Bulle Turbo', 			'', '49100', 'test');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 48.8148570, -0,5084230, 'Mon deuxième lieu', 	'Veau Authentique', 	'', '49100', 'test');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 48.8100880, -0,5062932, 'Mon troisième lieu', 	'Animal Absolu', 		'', '49100', 'test');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 47.7891510, -0,5602542, 'Mon quatrième lieu', 	'Gazelle Quark', 		'', '49100', 'test');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 47.7956260, -0,5709142, 'Mon cinquième lieu', 	'Orage Labo', 			'', '49100', 'test');

insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 47.7061770, -0,5441146, 'Mon premier lieu', 		'Le Studio Solution', 	'', '49100', 'dorian');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 46.6792440, -0,5096653, 'Mon deuxième lieu', 	'Plage Chic', 			'', '49100', 'dorian');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 48.8322600, -0,5765614, 'Mon troisième lieu', 	'Chevalier Violet', 	'', '49100', 'dorian');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 47.7213010, -0,5838031, 'Mon quatrième lieu', 	'Renard Violet', 		'', '49100', 'dorian');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 47.7895350, -0,5421846, 'Mon cinquième lieu', 	'Homme Bronzé', 		'', '49100', 'dorian');

insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 48.8150820, -0,5778253, 'Mon premier lieu', 		'Merveilleux Créatif', 	'', '49100', 'lila');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 46.6898710, -0,5546227, 'Mon deuxième lieu', 	'Chat Lab', 			'', '49100', 'lila');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 46.6599680, -0,5246390, 'Mon troisième lieu', 	'Réalité Gris', 		'', '49100', 'lila');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 47.7333180, -0,5961490, 'Mon quatrième lieu', 	'Leader Bleu', 			'', '49100', 'lila');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 47.7656860, -0,5577963, 'Mon cinquième lieu', 	'Skipper Relance', 		'', '49100', 'lila');

insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 46.6989300, -0,5790373, 'Mon premier lieu', 		'Voyage Turbo', 		'', '49100', 'loic');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 47.7110180, -0,5287437, 'Mon deuxième lieu', 	'Buzz Innov', 			'', '49100', 'loic');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 47.7953010, -0,5507054, 'Mon troisième lieu', 	'Boîte Authentique', 	'', '49100', 'loic');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 47.7713500, -0,5469014, 'Mon quatrième lieu', 	'Plage Conseil', 		'', '49100', 'loic');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 47.7992240, -0,5772130, 'Mon cinquième lieu', 	'Commande Azur', 		'', '49100', 'loic');

insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 47.7872120, -0,5469193, 'Mon premier lieu', 		'Buzz Calme', 			'', '49100', 'tiphanie');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 47.7634240, -0,5349527, 'Mon deuxième lieu', 	'Merveilleux Fou', 		'', '49100', 'tiphanie');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 47.7549150, -0,5498901, 'Mon troisième lieu', 	'Orchidée Jaune', 		'', '49100', 'tiphanie');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 47.7653560, -0,5330977, 'Mon quatrième lieu', 	'Bambou Argenté', 		'', '49100', 'tiphanie');
insert into place (city, latitude, longitude, privatelabel, publiclabel, street, zipcode, owner) values ('Angers', 47.7776660, -0,5974014, 'Mon cinquième lieu', 	'Grenouille Azur', 		'', '49100', 'tiphanie');