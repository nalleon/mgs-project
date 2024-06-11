CREATE TABLE Artist (
   id INTEGER PRIMARY KEY,
   fullName TEXT NOT NULL
);


INSERT INTO Artist (id, fullName) VALUES (1, 'Yoji Shinkawa');


CREATE TABLE MGSCharacter (
   id INTEGER PRIMARY KEY,
   name TEXT NOT NULL,
   codename TEXT NOT NULL,
   age INTEGER NOT NULL,
   status BOOLEAN NOT NULL,
   artist_id INTEGER,
   FOREIGN KEY (artist_id) REFERENCES Artist(id)
);


INSERT INTO MGSCharacter (id, name, codename, age, status, artist_id) VALUES (1, 'David', 'Solid Snake', 42, 1, 1);
INSERT INTO MGSCharacter (id, name, codename, age, status, artist_id) VALUES (2, 'John', 'Naked Snake', 50, 0, 1);
INSERT INTO MGSCharacter (id, name, codename, age, status, artist_id) VALUES (3, 'Jack', 'Raiden', 32, 1, 1);
INSERT INTO MGSCharacter (id, name, codename, age, status, artist_id) VALUES (4, 'Shalashaska', 'Revolver Ocelot', 55, 1, 1);
INSERT INTO MGSCharacter (id, name, codename, age, status, artist_id) VALUES (5, 'Meryl Silverburgh', 'Meryl', 28, 1, 1);
INSERT INTO MGSCharacter (id, name, codename, age, status, artist_id) VALUES (6, 'Unknown', 'Vamp', 40, 0, 1);
INSERT INTO MGSCharacter (id, name, codename, age, status, artist_id) VALUES (7, 'George Sears', 'Solidus Snake', 45, 0, 1);
INSERT INTO MGSCharacter (id, name, codename, age, status, artist_id) VALUES (8, 'Kazuhira Miller', 'Kaz', 38, 1, 1);
INSERT INTO MGSCharacter (id, name, codename, age, status, artist_id) VALUES (9, 'Rose Mary', 'Rose', 30, 1, 1);
INSERT INTO MGSCharacter (id, name, codename, age, status, artist_id) VALUES (10, 'Eli', 'Liquid Snake', 30, 1, 1);
INSERT INTO MGSCharacter (id, name, codename, age, status, artist_id) VALUES (11, 'Unknown', 'The Boss', 30, 1, 1);
INSERT INTO MGSCharacter (id, name, codename, age, status, artist_id) VALUES (12, 'V', 'Venom Snake', 40, 1, 1);
INSERT INTO MGSCharacter (id, name, codename, age, status, artist_id) VALUES (13, 'Tixij', 'Quiet', 29, 1, 1);
INSERT INTO MGSCharacter (id, name, codename, age, status, artist_id) VALUES (14, 'Hal Emmerich', 'Otacon', 40, 1, 1);




CREATE TABLE Director (
   id INTEGER PRIMARY KEY,
   fullName TEXT NOT NULL
);


INSERT INTO Director (id, fullName) VALUES (1, 'Hideo Kojima');


CREATE TABLE Game (
   id INTEGER PRIMARY KEY,
   name TEXT NOT NULL,
   director_id INTEGER,
   FOREIGN KEY (director_id) REFERENCES Director(id)
);


INSERT INTO Game (id, name, director_id) VALUES (1, 'Metal Gear Solid', 1);
INSERT INTO Game (id, name, director_id) VALUES (2, 'Metal Gear Solid 2: Sons of Liberty', 1);
INSERT INTO Game (id, name, director_id) VALUES (3, 'Metal Gear Solid 3: Snake Eater', 1);
INSERT INTO Game (id, name, director_id) VALUES (4, 'Metal Gear Solid 4: Guns of the Patriots', 1);
INSERT INTO Game (id, name, director_id) VALUES (5, 'Metal Gear Solid V: The Phantom Pain', 1);




CREATE TABLE GameMGSCharacter (
   id INTEGER PRIMARY KEY,
   game_id INTEGER NOT NULL,
   mgsCharacter_id INTEGER NOT NULL,
   FOREIGN KEY (game_id) REFERENCES Game(id),
   FOREIGN KEY (mgsCharacter_id) REFERENCES MGSCharacter(id)
);


INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (1, 1, 1); -- Solid Snake
INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (2, 1, 4); -- Revolver Ocelot
INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (3, 1, 5); -- Meryl Silverburgh
INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (4, 1, 10); -- Liquid Snake
INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (5, 1, 14); -- Otacon


INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (6, 2, 1); -- Solid Snake
INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (7, 2, 3); -- Raiden
INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (8, 2, 4); -- Revolver Ocelot
INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (9, 2, 6); -- Vamp
INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (10, 2, 7); -- Solidus Snake
INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (11, 2, 9); -- Rose Mary
INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (12, 2, 10); -- Liquid Snake
INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (13, 2, 14); -- Otacon



INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (14, 3, 2); -- Naked Snake
INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (15, 3, 4); -- Revolver Ocelot
INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (16, 3, 11); -- The Boss


INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (17, 4, 1); -- Solid Snake
INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (18, 4, 3); -- Raiden
INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (19, 4, 4); -- Revolver Ocelot
INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (20, 4, 5); -- Meryl Silverburgh
INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (21, 4, 6); -- Vamp
INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (22, 4, 10); -- Liquid Snake
INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (23, 4, 14); -- Otacon


INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (24, 5, 2); -- Naked Snake
INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (25, 5, 4); -- Revolver Ocelot
INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (26, 5, 8); -- Kazuhira Miller
INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (27, 5, 11); -- Venom Snake
INSERT INTO GameMGSCharacter (id, game_id, mgsCharacter_id) VALUES (28, 5, 12); -- Quiet


CREATE TABLE Weapon (
   id INTEGER PRIMARY KEY,
   name TEXT NOT NULL,
   type TEXT NOT NULL
);


INSERT INTO Weapon (id, name, type) VALUES (1, 'Katana', 'Sword');
INSERT INTO Weapon (id, name, type) VALUES (2, 'FAMAS', 'Assault Rifle');
INSERT INTO Weapon (id, name, type) VALUES (3, 'SOCOM', 'Semi-automatic Pistol');
INSERT INTO Weapon (id, name, type) VALUES (4, 'Stun Rod', 'Electric Baton');
INSERT INTO Weapon (id, name, type) VALUES (5, 'Tranquilizer Gun', 'Tranquilizer Pistol');


--CREATE TABLE CharacterWeapon (
--   character_id INTEGER,
--   weapon_id INTEGER,
--   FOREIGN KEY (character_id) REFERENCES MGSCharacter(id),
--   FOREIGN KEY (weapon_id) REFERENCES Weapon(id),
--   PRIMARY KEY (character_id, weapon_id)
--);


--INSERT INTO CharacterWeapon (character_id, weapon_id) VALUES (1, 1); -- Katana
--INSERT INTO CharacterWeapon (character_id, weapon_id) VALUES (1, 2); -- FAMAS
--INSERT INTO CharacterWeapon (character_id, weapon_id) VALUES (1, 3); -- SOCOM
--INSERT INTO CharacterWeapon (character_id, weapon_id) VALUES (3, 1); -- Katana
--INSERT INTO CharacterWeapon (character_id, weapon_id) VALUES (3, 4); -- Stun Rod
--INSERT INTO CharacterWeapon (character_id, weapon_id) VALUES (13, 5); -- Tranquilizer Gun











