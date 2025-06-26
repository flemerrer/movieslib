-- ENREGISTREMENTS :
	
--Insère des enregistrements dans la table GENRE
INSERT INTO GENRE (title) VALUES ('Animation');
INSERT INTO GENRE (title) VALUES ('Science-fiction');
INSERT INTO GENRE (title) VALUES ('Documentaire');
INSERT INTO GENRE (title) VALUES ('Action');
INSERT INTO GENRE (title) VALUES ('Comédie');
INSERT INTO GENRE (title) VALUES ('Drame');
INSERT INTO GENRE (title) VALUES ('Policier');
INSERT INTO GENRE (title) VALUES ('Horreur');
                          
	
--Insère des enregistrements dans la table CASTMEMBER
INSERT INTO CASTMEMBER (lastName,firstName) VALUES ('Spielberg','Steven');
INSERT INTO CASTMEMBER (lastName,firstName) VALUES ('Cronenberg','David');
INSERT INTO CASTMEMBER (lastName,firstName) VALUES ('Boon','Dany');
INSERT INTO CASTMEMBER (lastName,firstName) VALUES ('Attenborough','Richard');
INSERT INTO CASTMEMBER (lastName,firstName) VALUES ('Goldblum','Jeff');
INSERT INTO CASTMEMBER (lastName,firstName) VALUES ('Davis','Geena');
INSERT INTO CASTMEMBER (lastName,firstName) VALUES ('Rylance','Mark');
INSERT INTO CASTMEMBER (lastName,firstName) VALUES ('Barnhill','Ruby');
INSERT INTO CASTMEMBER (lastName,firstName) VALUES ('Merad','Kad');

						  
	
--Insère des enregistrements dans la table REGISTEREDUSER
INSERT INTO REGISTEREDUSER (email,lastName,firstName,password) VALUES ('abaille@campus-eni.fr','BAILLE','Anne-Lise', '{bcrypt}$2a$10$KaSHgvH9p/cUnsOVPzYvzunWDAIv68whrOxmui1S.0AjzbP5RX7yO');/*Mot de Passe = annelise*/
INSERT INTO REGISTEREDUSER (email,lastName,firstName,password) VALUES ('jtrillard@campus-eni.fr','TRILLARD','Julien','{bcrypt}$2a$10$VwQ7gMUPLeQnFC6vCsOoTevzdPe.JPu0L/7cwPGdJ6TjSpipGwY.y');/*Mot de Passe = julien*/
INSERT INTO REGISTEREDUSER (email,lastName,firstName,password) VALUES ('fdelaschesnais@campus-eni.fr','DELACHESNAIS','Frédéric', '{bcrypt}$2a$10$GhRo8SeZhL64e7E7/DQ3Le5mgkAjuesQCjQptJFh0oQLjwdeH9ZWG');/*Mot de Passe = frederic*/
INSERT INTO REGISTEREDUSER (email,lastName,firstName,password,isAdmin) VALUES ('pmontembault@campus-eni.fr','MONTEMBAULT','Philippe', '{bcrypt}$2a$10$0g3xzuioWFxQLVdmc8LRKOb.sVxyH/uQQjdNg.CPX7tg3cYRK3VTe',1);/*Mot de Passe = philippe*/
INSERT INTO REGISTEREDUSER (email,lastName,firstName,password) VALUES ('hbernard@campus-eni.fr','BERNARD','Hervé', '{bcrypt}$2a$10$oYzLsRNezWP.ruY83rkYAuUH14nuNv356V3z3O4pRkuA.GwaXNGke');/*Mot de Passe = herve*/
INSERT INTO REGISTEREDUSER (email,lastName,firstName,password) VALUES ('tgroussard@campus-eni.fr','GROUSSARD','Thierry', '{bcrypt}$2a$10$ca.IC8NI2Km3kRRUoZ9EeORDJMPPe0iyyYShQ1IqPswr5YXDLqwey');/*Mot de Passe = thierry*/
INSERT INTO REGISTEREDUSER (email,lastName,firstName,password,isAdmin) VALUES ('sgobin@campus-eni.fr','GOBIN','Stéphane','{bcrypt}$2a$10$B5U29ajHsIKd8aY3c/JNn.xTJpOCAeoXvT9XvfzbbHGP4iIFV9Lkm',1);/*Mot de Passe = stephane*/


--Insère des enregistrements dans la table MOVIE
INSERT INTO MOVIE (title,year,duration,synopsis,director_id,genre_id) VALUES ('Jurassic Park',1993,128,'Le film raconte l''histoire d''un milliardaire et son équipe de généticiens parvenant à ramener à la vie des dinosaures grâce au clonage.',1,2);
INSERT INTO MOVIE (title,year,duration,synopsis,director_id,genre_id) VALUES ('The Fly',1986, 95,'Il s''agit de l''adaptation cinématographique de la nouvelle éponyme de l''auteur George Langelaan.',2,2);
INSERT INTO MOVIE (title,year,duration,synopsis,director_id,genre_id) VALUES ('The BFG',2016, 117,'Le Bon Gros Géant est un géant bien différent des autres habitants du Pays des Géants.',1,5);
INSERT INTO MOVIE (title,year,duration,synopsis,director_id,genre_id) VALUES ('Bienvenue chez les Ch''tis',2008, 106,'Philippe Abrams marié à Julie (dépressive) essaie d''être mutaté dans le Sud. Il se retrouve à Bergues dans le Nord.',3,5);

--Insère des enregistrements dans la table de jointure avec MOVIE - ACTORS
INSERT INTO ACTORS (movie_id,castMember_id) VALUES (1,4);
INSERT INTO ACTORS (movie_id,castMember_id) VALUES (1,5);
INSERT INTO ACTORS (movie_id,castMember_id) VALUES (2,5);
INSERT INTO ACTORS (movie_id,castMember_id) VALUES (2,6);
INSERT INTO ACTORS (movie_id,castMember_id) VALUES (3,7);
INSERT INTO ACTORS (movie_id,castMember_id) VALUES (3,8);
INSERT INTO ACTORS (movie_id,castMember_id) VALUES (4,3);
INSERT INTO ACTORS (movie_id,castMember_id) VALUES (4,9);

--Insère des enregistrements dans la table de AVIS
INSERT INTO AVIS (note,commentaire,id_membre,movie_id) VALUES (4,'On rit du début à la fin',1,4);

-- Requetes pour aider à tester
/*
select * from GENRE;
select * from CASTMEMBER;
select * from REGISTEREDUSER;

select * from MOVIE;

select f.*, g.title as Genre, (r.firstName + ' ' +r.lastName)as Realisateur  from Film f
	inner join genre g on f.genre_id=g.id
	inner join CASTMEMBER r on r.id = f.director_id;
select * from ACTORS;

select f.*, (p.firstName + ' '+ p.lastName) as Acteur from MOVIE f
	inner join ACTORS a on a.movie_id = f.id
	inner join CASTMEMBER p on a.castMember_id = p.id;

select * from AVIS;

*/