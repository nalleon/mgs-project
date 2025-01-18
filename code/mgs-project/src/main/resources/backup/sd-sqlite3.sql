CREATE TABLE artists (
    artist_id INTEGER NOT NULL PRIMARY KEY,
    full_name VARCHAR(255),
    deleted_at DATETIME DEFAULT NULL
);

CREATE TABLE directors (
    director_id INTEGER NOT NULL PRIMARY KEY,
    full_name VARCHAR(255),
    deleted_at DATETIME DEFAULT NULL
);

CREATE TABLE games (
    id INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(255),
    director_director_id INTEGER,
    deleted_at DATETIME DEFAULT NULL,
    FOREIGN KEY (director_director_id) REFERENCES directors(director_id) ON DELETE SET NULL
);

CREATE TABLE games_mgscharacters (
    game_id INTEGER NOT NULL,
    mgs_character_id INTEGER NOT NULL,
    deleted_at DATETIME DEFAULT NULL,
    PRIMARY KEY (game_id, mgs_character_id),
    FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE CASCADE,
    FOREIGN KEY (mgs_character_id) REFERENCES mgscharacters(id) ON DELETE CASCADE
);

CREATE TABLE mgscharacters (
    id INTEGER NOT NULL PRIMARY KEY,
    age INTEGER NOT NULL,
    codename VARCHAR(255),
    name VARCHAR(255),
    status BOOLEAN NOT NULL,
    artist_artist_id INTEGER,
    deleted_at DATETIME DEFAULT NULL,
    FOREIGN KEY (artist_artist_id) REFERENCES artists(artist_id) ON DELETE SET NULL
);

CREATE TABLE roles (
    id INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(255),
    deleted_at DATETIME DEFAULT NULL
);

CREATE TABLE users (
    id INTEGER NOT NULL PRIMARY KEY,
    email VARCHAR(255),
    name VARCHAR(255),
    password VARCHAR(255),
    role_id INTEGER,
    deleted_at DATETIME DEFAULT NULL,
    FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE SET NULL
);
