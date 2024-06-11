
INSERT INTO mgscharacter (id, name, codename, age, status) VALUES (1, 'David', 'Solid Snake', 42, 1);
INSERT INTO mgscharacter (id, name, codename, age, status) VALUES (2, 'John', 'Naked Snake', 50, 0);
INSERT INTO mgscharacter (id, name, codename, age, status) VALUES (3, 'Jack', 'Raiden', 32, 1);
INSERT INTO mgscharacter (id, name, codename, age, status) VALUES (4, 'Shalashaska', 'Revolver Ocelot', 55, 1);
INSERT INTO mgscharacter (id, name, codename, age, status) VALUES (5, 'Meryl Silverburgh', 'Meryl', 28, 1);
INSERT INTO mgscharacter (id, name, codename, age, status) VALUES (6, 'Unknown', 'Vamp', 40, 0);
INSERT INTO mgscharacter (id, name, codename, age, status) VALUES (7, 'George Sears', 'Solidus Snake', 45, 0);
INSERT INTO mgscharacter (id, name, codename, age, status) VALUES (8, 'Kazuhira Miller', 'Kaz', 38, 1);
INSERT INTO mgscharacter (id, name, codename, age, status) VALUES (9, 'Rose Mary', 'Rose', 30, 1);
INSERT INTO mgscharacter (id, name, codename, age, status) VALUES (10, 'Eli', 'Liquid Snake', 30, 1);
INSERT INTO mgscharacter (id, name, codename, age, status) VALUES (11, 'Unknown', 'The Boss', 30, 1);
INSERT INTO mgscharacter (id, name, codename, age, status) VALUES (12, 'V', 'Venom Snake', 40, 1);
INSERT INTO mgscharacter (id, name, codename, age, status) VALUES (13, 'Tixij', 'Quiet', 29, 1);
INSERT INTO mgscharacter (id, name, codename, age, status) VALUES (14, 'Hal Emmerich', 'Otacon', 40, 1);


INSERT INTO game (id, name) VALUES (1, 'Metal Gear Solid');
INSERT INTO game (id, name) VALUES (2, 'Metal Gear Solid 2: Sons of Liberty');
INSERT INTO game (id, name) VALUES (3, 'Metal Gear Solid 3: Snake Eater');
INSERT INTO game (id, name) VALUES (4, 'Metal Gear Solid 4: Guns of the Patriots');
INSERT INTO game (id, name) VALUES (5, 'Metal Gear Solid V: The Phantom Pain');


-- Metal Gear Solid
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (1, 1, 1); -- Solid Snake
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (2, 1, 4); -- Revolver Ocelot
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (3, 1, 5); -- Meryl Silverburgh
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (4, 1, 10); -- Liquid Snake
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (5, 1, 14); -- Otacon

-- Metal Gear Solid 2: Sons of Liberty
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (6, 2, 1); -- Solid Snake
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (7, 2, 3); -- Raiden
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (8, 2, 4); -- Revolver Ocelot
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (9, 2, 6); -- Vamp
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (10, 2, 7); -- Solidus Snake
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (11, 2, 9); -- Rose Mary
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (12, 2, 10); -- Liquid Snake
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (13, 2, 14); -- Otacon


-- Metal Gear Solid 3: Snake Eater
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (14, 3, 2); -- Naked Snake
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (15, 3, 4); -- Revolver Ocelot
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (16, 3, 11); -- The Boss

-- Metal Gear Solid 4: Guns of the Patriots
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (17, 4, 1); -- Solid Snake
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (18, 4, 3); -- Raiden
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (19, 4, 4); -- Revolver Ocelot
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (20, 4, 5); -- Meryl Silverburgh
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (21, 4, 6); -- Vamp
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (22, 4, 10); -- Liquid Snake
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (23, 4, 14); -- Otacon


-- Metal Gear Solid V: The Phantom Pain
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (24, 5, 2); -- Naked Snake
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (25, 5, 4); -- Revolver Ocelot
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (26, 5, 8); -- Kazuhira Miller
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (27, 5, 11); -- Venom Snake
INSERT INTO gamemsgcharacter (id, game_id, mgsCharacter_id) VALUES (28, 5, 12); -- Quiet


INSERT INTO director (director_id, full_name) VALUES (1, 'Hideo Kojima');

INSERT INTO director_game (director_id, game_id) VALUES (1, 1);
INSERT INTO director_game (director_id, game_id) VALUES (1, 2);
INSERT INTO director_game (director_id, game_id) VALUES (1, 3);
INSERT INTO director_game (director_id, game_id) VALUES (1, 4);
INSERT INTO director_game (director_id, game_id) VALUES (1, 5);


INSERT INTO artist (artist_id, full_name) VALUES (1, 'Yoji Shinkawa');


INSERT INTO artistmgscharacter (artist_id, mgsCharacter_id) VALUES (1, 1);
INSERT INTO artistmgscharacter (artist_id, mgsCharacter_id) VALUES (1, 2);
INSERT INTO artistmgscharacter (artist_id, mgsCharacter_id) VALUES (1, 3);
INSERT INTO artistmgscharacter (artist_id, mgsCharacter_id) VALUES (1, 4);
INSERT INTO artistmgscharacter (artist_id, mgsCharacter_id) VALUES (1, 5);
INSERT INTO artistmgscharacter (artist_id, mgsCharacter_id) VALUES (1, 6);
INSERT INTO artistmgscharacter (artist_id, mgsCharacter_id) VALUES (1, 7);
INSERT INTO artistmgscharacter (artist_id, mgsCharacter_id) VALUES (1, 8);
INSERT INTO artistmgscharacter (artist_id, mgsCharacter_id) VALUES (1, 9);
INSERT INTO artistmgscharacter (artist_id, mgsCharacter_id) VALUES (1, 10);
INSERT INTO artistmgscharacter (artist_id, mgsCharacter_id) VALUES (1, 11);
INSERT INTO artistmgscharacter (artist_id, mgsCharacter_id) VALUES (1, 12);
INSERT INTO artistmgscharacter (artist_id, mgsCharacter_id) VALUES (1, 13);
INSERT INTO artistmgscharacter (artist_id, mgsCharacter_id) VALUES (1, 14);

