CREATE TABLE artists (
    artist_id INT AUTO_INCREMENT NOT NULL,
    full_name VARCHAR(255),
    deleted_at DATETIME DEFAULT NULL,
    PRIMARY KEY (artist_id)
);

CREATE TABLE directors (
    director_id INT AUTO_INCREMENT NOT NULL,
    full_name VARCHAR(255),
    deleted_at DATETIME DEFAULT NULL,
    PRIMARY KEY (director_id)
);

CREATE TABLE games (
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255),
    director_director_id INT,
    deleted_at DATETIME DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (director_director_id) REFERENCES directors(director_id) ON DELETE SET NULL
);

CREATE TABLE games_mgscharacters (
    game_id INT NOT NULL,
    mgs_character_id INT NOT NULL,
    deleted_at DATETIME DEFAULT NULL,
    PRIMARY KEY (game_id, mgs_character_id),
    FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE CASCADE,
    FOREIGN KEY (mgs_character_id) REFERENCES mgscharacters(id) ON DELETE CASCADE
);

CREATE TABLE mgscharacters (
    id INT AUTO_INCREMENT NOT NULL,
    age INT NOT NULL,
    codename VARCHAR(255),
    name VARCHAR(255),
    status BOOLEAN NOT NULL,
    artist_artist_id INT,
    deleted_at DATETIME DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (artist_artist_id) REFERENCES artists(artist_id) ON DELETE SET NULL
);

CREATE TABLE roles (
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255),
    deleted_at DATETIME DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE users (
    id INT AUTO_INCREMENT NOT NULL,
    email VARCHAR(255),
    name VARCHAR(255),
    password VARCHAR(255),
    role_id INT,
    deleted_at DATETIME DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE SET NULL
);
