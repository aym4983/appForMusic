insert into role (label) values ('user');

-- Tests

insert into appuser (username, email, enabled, firstname, lastname, passwordhash) values ('test', 'test@test.fr', true, 'Test', 'Test', '$2a$10$WWQLKlimcQS4Cd4.FVcZ7eJVhJFMdTTrA7Zae85wUzOhUYi073CbW');
	
insert into user_role (username, role_id) values ('test', 1);