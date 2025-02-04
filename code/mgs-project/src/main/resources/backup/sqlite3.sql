CREATE TABLE artists (
    artist_id INTEGER NOT NULL PRIMARY KEY,
    full_name VARCHAR(255)
);

CREATE TABLE directors (
    director_id INTEGER NOT NULL PRIMARY KEY,
    full_name VARCHAR(255)
);

CREATE TABLE games (
    id INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(255),
    director_director_id INTEGER,
    FOREIGN KEY (director_director_id) REFERENCES directors(director_id)
);

CREATE TABLE games_mgscharacters (
    game_id INTEGER NOT NULL,
    mgs_character_id INTEGER NOT NULL,
    PRIMARY KEY (game_id, mgs_character_id),
    FOREIGN KEY (game_id) REFERENCES games(id),
    FOREIGN KEY (mgs_character_id) REFERENCES mgscharacters(id)
);

CREATE TABLE mgscharacters (
    id INTEGER NOT NULL PRIMARY KEY,
    age INTEGER NOT NULL,
    codename VARCHAR(255),
    name VARCHAR(255),
    status BOOLEAN NOT NULL,
    artist_artist_id INTEGER,
    FOREIGN KEY (artist_artist_id) REFERENCES artists(artist_id)
);

CREATE TABLE roles (
    id INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE users (
    id INTEGER NOT NULL PRIMARY KEY,
    email VARCHAR(255),
    name VARCHAR(255),
    password VARCHAR(255),
    role_id INTEGER,
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

INSERT INTO artists (artist_id, full_name) VALUES (1, 'Yoji Shinkawa');
INSERT INTO artists (artist_id, full_name) VALUES (2, 'Yoji Shinkawa');
INSERT INTO artists (artist_id, full_name) VALUES (3, 'Yushi Yamaguchi');
INSERT INTO artists (artist_id, full_name) VALUES (4, 'Shoji Yoshida');
INSERT INTO artists (artist_id, full_name) VALUES (5, 'Katsuya Terada');
INSERT INTO artists (artist_id, full_name) VALUES (6, 'Yojiro Kato');

INSERT INTO directors (director_id, full_name) VALUES (1, 'Hideo Kojima');

INSERT INTO games (id, name, director_director_id) VALUES (1, 'Metal Gear Solid', 1);
INSERT INTO games (id, name, director_director_id) VALUES (2, 'Metal Gear Solid 2: Sons of Liberty', 1);
INSERT INTO games (id, name, director_director_id) VALUES (3, 'Metal Gear Solid 3: Snake Eater', 1);
INSERT INTO games (id, name, director_director_id) VALUES (4, 'Metal Gear Solid 4: Guns of the Patriots', 1);
INSERT INTO games (id, name, director_director_id) VALUES (5, 'Metal Gear Solid V: The Phantom Pain', 1);
INSERT INTO games (id, name, director_director_id) VALUES (6, 'Metal Gear', 1);
INSERT INTO games (id, name, director_director_id) VALUES (7, 'Metal Gear 2: Solid Snake', 1);
INSERT INTO games (id, name, director_director_id) VALUES (8, 'Metal Gear Rising: Revengeance', 1);

INSERT INTO mgscharacters (id, age, codename, name, status, artist_artist_id) VALUES (1, 42, 'Solid Snake', 'David', 1, 1);
INSERT INTO mgscharacters (id, age, codename, name, status, artist_artist_id) VALUES (2, 50, 'Naked Snake, Big Boss', 'John', 0, 1);
INSERT INTO mgscharacters (id, age, codename, name, status, artist_artist_id) VALUES (3, 32, 'Raiden, Jack the Ripper', 'Jack', 1, 1);
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
INSERT INTO mgscharacters (id, age, codename, name, status, artist_artist_id) VALUES (15, 30, 'Jetstream Sam', 'Samuel Rodrigues', 1, 1);

INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (1, 1); -- Solid Snake
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (1, 4); -- Revolver Ocelot
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (1, 5); -- Meryl
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (1, 10); -- Liquid Snake
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (1, 14); -- Otacon

INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (2, 1); -- Solid Snake
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (2, 3); -- Raiden
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (2, 6); -- Vamp
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (2, 7); -- Solidus Snake
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (2, 9); -- Rose
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (2, 14); -- Otacon

INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (3, 2); -- Naked Snake
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (3, 4); -- Revolver Ocelot
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (3, 11); -- The Boss

INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (4, 1); -- Solid Snake
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (3, 3); -- Raiden
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (4, 4); -- Revolver Ocelot
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (4, 5); -- Meryl
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (4, 14); -- Otacon

INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (5, 2); -- Naked Snake
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (5, 4); -- Revolver Ocelot
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (5, 8); -- Kaz
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (5, 12); -- Venom Snake
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (5, 13); -- Quiet

INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (6, 1); -- Solid Snake
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (6, 2); -- Big Boss
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (6, 8); -- Kaz

INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (7, 1); -- Solid Snake
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (7, 2); -- Big Boss
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (7, 8); -- Kaz

INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (8, 3); -- Raiden
INSERT INTO games_mgscharacters (game_id, mgs_character_id) VALUES (8, 4); -- Jetstream Sam

INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_USER');
INSERT INTO roles (id, name) VALUES (3, 'ROLE_GUEST');

INSERT INTO users (id, name, email, password, role_id) VALUES (1, 'nabil', 'nabil14716@gmail.com', '1q2w3e4r', 1);
INSERT INTO users (id, name, email, password, role_id) VALUES (2, 'alejandro t.', 'atprod@gmail.com', '1q2w3e4r', 2);