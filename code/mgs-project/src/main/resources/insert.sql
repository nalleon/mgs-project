
INSERT INTO mgscharacter (name, codename, age, status) VALUES ('David', 'Solid Snake', 42, 1);
INSERT INTO mgscharacter (name, codename, age, status) VALUES ('John', 'Naked Snake', 50, 0);
INSERT INTO mgscharacter (name, codename, age, status) VALUES ('Jack', 'Raiden', 32, 1);
INSERT INTO mgscharacter (name, codename, age, status) VALUES ('Shalashaska', 'Revolver Ocelot', 55, 1);
INSERT INTO mgscharacter (name, codename, age, status) VALUES ('Meryl Silverburgh', 'Meryl', 28, 1);
INSERT INTO mgscharacter (name, codename, age, status) VALUES ('Unknown', 'Vamp', 40, 0);
INSERT INTO mgscharacter (name, codename, age, status) VALUES ('George Sears', 'Solidus Snake', 45, 0);
INSERT INTO mgscharacter (name, codename, age, status) VALUES ('Kazuhira Miller', 'Kaz', 38, 1);
INSERT INTO mgscharacter (name, codename, age, status) VALUES ('Rose Mary', 'Rose', 30, 1);
INSERT INTO mgscharacter (name, codename, age, status) VALUES ('Eli', 'Liquid Snake', 30, 1);
INSERT INTO mgscharacter (name, codename, age, status) VALUES ('Unknown', 'The Boss', 30, 1);
INSERT INTO mgscharacter (name, codename, age, status) VALUES ('V', 'Venom Snake', 40, 1);
INSERT INTO mgscharacter (name, codename, age, status) VALUES ('Tixij', 'Quiet', 29, 1);
INSERT INTO mgscharacter (name, codename, age, status) VALUES ('Hal Emmerich', 'Otacon', 40, 1);


INSERT INTO game (name) VALUES ('Metal Gear Solid');
INSERT INTO game (name) VALUES ('Metal Gear Solid 2: Sons of Liberty');
INSERT INTO game (name) VALUES ('Metal Gear Solid 3: Snake Eater');
INSERT INTO game (name) VALUES ('Metal Gear Solid 4: Guns of the Patriots');
INSERT INTO game (name) VALUES ('Metal Gear Solid V: The Phantom Pain');


-- Metal Gear Solid
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (1, 1); -- Solid Snake
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (1, 4); -- Revolver Ocelot
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (1, 5); -- Meryl Silverburgh
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (1, 10); -- Liquid Snake
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (1, 14); -- Otacon

-- Metal Gear Solid 2: Sons of Liberty
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (2, 1); -- Solid Snake
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (2, 3); -- Raiden
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (2, 4); -- Revolver Ocelot
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (2, 6); -- Vamp
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (2, 7); -- Solidus Snake
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (2, 9); -- Rose Mary
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (2, 10); -- Liquid Snake
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (2, 14); -- Otacon


-- Metal Gear Solid 3: Snake Eater
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (3, 2); -- Naked Snake
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (3, 4); -- Revolver Ocelot
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (3, 11); -- The Boss

-- Metal Gear Solid 4: Guns of the Patriots
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (4, 1); -- Solid Snake
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (4, 3); -- Raiden
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (4, 4); -- Revolver Ocelot
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (4, 5); -- Meryl Silverburgh
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (4, 6); -- Vamp
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (4, 10); -- Liquid Snake
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (4, 14); -- Otacon


-- Metal Gear Solid V: The Phantom Pain
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (5, 2); -- Naked Snake
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (5, 4); -- Revolver Ocelot
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (5, 8); -- Kazuhira Miller
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (5, 11); -- Venom Snake
INSERT INTO gamemgscharacter (game_id, mgs_character_id) VALUES (5, 12); -- Quiet


INSERT INTO director (director_id, full_name) VALUES (1, 'Hideo Kojima');

INSERT INTO director_game (director_id, game_id) VALUES (1, 1);
INSERT INTO director_game (director_id, game_id) VALUES (1, 2);
INSERT INTO director_game (director_id, game_id) VALUES (1, 3);
INSERT INTO director_game (director_id, game_id) VALUES (1, 4);
INSERT INTO director_game (director_id, game_id) VALUES (1, 5);


INSERT INTO artist (artist_id, full_name) VALUES (1, 'Yoji Shinkawa');


INSERT INTO artistmgscharacter (artist_id, mgs_character_id) VALUES (1, 1);
INSERT INTO artistmgscharacter (artist_id, mgs_character_id) VALUES (1, 2);
INSERT INTO artistmgscharacter (artist_id, mgs_character_id) VALUES (1, 3);
INSERT INTO artistmgscharacter (artist_id, mgs_character_id) VALUES (1, 4);
INSERT INTO artistmgscharacter (artist_id, mgs_character_id) VALUES (1, 5);
INSERT INTO artistmgscharacter (artist_id, mgs_character_id) VALUES (1, 6);
INSERT INTO artistmgscharacter (artist_id, mgs_character_id) VALUES (1, 7);
INSERT INTO artistmgscharacter (artist_id, mgs_character_id) VALUES (1, 8);
INSERT INTO artistmgscharacter (artist_id, mgs_character_id) VALUES (1, 9);
INSERT INTO artistmgscharacter (artist_id, mgs_character_id) VALUES (1, 10);
INSERT INTO artistmgscharacter (artist_id, mgs_character_id) VALUES (1, 11);
INSERT INTO artistmgscharacter (artist_id, mgs_character_id) VALUES (1, 12);
INSERT INTO artistmgscharacter (artist_id, mgs_character_id) VALUES (1, 13);
INSERT INTO artistmgscharacter (artist_id, mgs_character_id) VALUES (1, 14);

