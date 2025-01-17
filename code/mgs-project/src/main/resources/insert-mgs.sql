INSERT INTO artists (artist_id, full_name) VALUES (1, 'Yoji Shinkawa');

INSERT INTO directors (director_id, full_name) VALUES (1, 'Hideo Kojima');

INSERT INTO games (id, name, director_director_id) VALUES (1, 'Metal Gear Solid', 1);
INSERT INTO games (id, name, director_director_id) VALUES (2, 'Metal Gear Solid 2: Sons of Liberty', 1);
INSERT INTO games (id, name, director_director_id) VALUES (3, 'Metal Gear Solid 3: Snake Eater', 1);
INSERT INTO games (id, name, director_director_id) VALUES (4, 'Metal Gear Solid 4: Guns of the Patriots', 1);
INSERT INTO games (id, name, director_director_id) VALUES (5, 'Metal Gear Solid V: The Phantom Pain', 1);

INSERT INTO mgscharacters (id, age, codename, name, status, artist_artist_id) VALUES (1, 42, 'Solid Snake', 'David', 1, 1);
INSERT INTO mgscharacters (id, age, codename, name, status, artist_artist_id) VALUES (2, 50, 'Naked Snake', 'John', 0, 1);
INSERT INTO mgscharacters (id, age, codename, name, status, artist_artist_id) VALUES (3, 32, 'Raiden', 'Jack', 1, 1);
INSERT INTO mgscharacters (id, age, codename, name, status, artist_artist_id) VALUES (4, 55, 'Revolver Ocelot', 'Shalashaska', 1, 1);
INSERT INTO mgscharacters (id, age, codename, name, status, artist_artist_id) VALUES (5, 28, 'Meryl', 'Meryl Silverburgh', 1, 1);
INSERT INTO mgscharacters (id, age, codename, name, status, artist_artist_id) VALUES (6, 40, 'Vamp', 'Unknown', 0, 1);
INSERT INTO mgscharacters (id, age, codename, name, status, artist_artist_id) VALUES (7, 45, 'Solidus Snake', 'George Sears', 0, 1);
INSERT INTO mgscharacters (id, age, codename, name, status, artist_artist_id) VALUES (8, 38, 'Kaz', 'Kazuhira Miller', 1, 1);
INSERT INTO mgscharacters (id, age, codename, name, status, artist_artist_id) VALUES (9, 30, 'Rose', 'Rose Mary', 1, 1);
INSERT INTO mgscharacters (id, age, codename, name, status, artist_artist_id) VALUES (10, 30, 'Liquid Snake', 'Eli', 1, 1);
INSERT INTO mgscharacters (id, age, codename, name, status, artist_artist_id) VALUES (11, 30, 'The Boss', 'Unknown', 1, 1);
INSERT INTO mgscharacters (id, age, codename, name, status, artist_artist_id) VALUES (12, 40, 'Venom Snake', 'V', 1, 1);
INSERT INTO mgscharacters (id, age, codename, name, status, artist_artist_id) VALUES (13, 29, 'Quiet', 'Tixij', 1, 1);
INSERT INTO mgscharacters (id, age, codename, name, status, artist_artist_id) VALUES (14, 40, 'Otacon', 'Hal Emmerich', 1, 1);

INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (1, 1); -- Solid Snake
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (1, 4); -- Revolver Ocelot
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (1, 5); -- Meryl
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (1, 10); -- Liquid Snake
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (1, 14); -- Otacon

INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (2, 1); -- Solid Snake
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (2, 3); -- Raiden
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (2, 9); -- Rose Mary
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (2, 6); -- Vamp
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (2, 7); -- Solidus Snake
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (2, 14); -- Otacon

INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (3, 2); -- Naked Snake
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (3, 4); -- Revolver Ocelot
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (3, 11); -- The Boss

INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (4, 1); -- Solid Snake
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (4, 3); -- Raiden
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (4, 4); -- Revolver Ocelot
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (4, 5); -- Meryl
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (4, 14); -- Otacon

INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (5, 8); -- Kazuhira Miller
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (5, 12); -- Venom Snake
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (5, 13); -- Quiet
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (5, 4); -- Revolver Ocelot


INSERT INTO roles (id, name) VALUES (1, 'Admin');
INSERT INTO roles (id, name) VALUES (2, 'User');

INSERT INTO users (id, name, email, password, role_id) VALUES (1, 'nabil', 'nabil14716@gmail.com', '1q2w3e4r', 1);
INSERT INTO users (id, name, email, password, role_id) VALUES (2, 'alejandro t.', 'atprod@gmail.com', '1q2w3e4r', 2);