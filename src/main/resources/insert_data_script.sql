delete from user;
delete from hobbie;

-- insertion des données sur la table User
insert into user (username, useremail, userpassword, userstate, usergroup, usersex, userage)
values	('Aimeric', 'aimeric.01@hotmail.fr', '123456789', 'ENABLE', 'PREMIUM', 'MALE', 21),
	('Robert51', 'robertpastis@hotmail.fr', '123456789', 'ENABLE', 'FREE', 'MALE', 50),
	('Julie', 'juju@hotmail.fr', '123456789', 'ENABLE', 'FREE', 'FEMALE', 19),
	('Patrick', 'cartouche@hotmail.fr', '123456789', 'DISABLE', 'PREMIUM', 'MALE', 34),
	('Mohamed', 'momohamed@hotmail.fr', '123456789', 'ENABLE', 'ADMINISTRATOR', 'MALE', 28),
	('Orlanne', 'orlando@hotmail.fr', '123456789', 'ENABLE', 'FREE', 'FEMALE', 24);

-- insertion des données sur la table Hobbie
insert into hobbie (Label, Description)
values	('Pétanque', ''),
	('Jeux vidéos', ''),
	('Films / Séries TV', ''),
	('Sortir en boite', ''),
	('Boire un verre', ''),
	('Musique', ''),
	('Informatique', ''),
	('J2EE', '');
	
-- affectation de hobbies pour les utilisateurs
insert into userhobbies(IdKeyUser, IdKeyHobbie)
values (0,1),
	(0,3),
	(2,4),
	(2,2),
	(1,5),
	(4,0),
	(4,1),
	(4,4),
	(0,2),
	(5,3);