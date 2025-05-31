

CREATE TABLE utilisateur (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    role VARCHAR(50),
    password VARCHAR(255),
    repassword VARCHAR(255)
);

CREATE TABLE game (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    image VARCHAR(255) NOT NULL,
    genre VARCHAR(255) NOT NULL,
    num_edition BIGINT NOT NULL,
    description VARCHAR(255) NOT NULL,
    author_id BIGINT,
    category_id BIGINT,
    publisher_id BIGINT
);

CREATE TABLE author (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(255) NOT NULL
);
CREATE TABLE publisher (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
CREATE TABLE avis (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    note BIGINT NOT NULL,
     commentaire VARCHAR(255) NOT NULL
);

CREATE TABLE purchase (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    date DATE,
    paid BOOLEAN,
    delivered BOOLEAN,
    archived BOOLEAN
);

CREATE TABLE purchase_line (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    prix DOUBLE,
    jeu_id BIGINT,
    utilisateur_id BIGINT,
    purchase_id BIGINT,
    game_id BIGINT,
    FOREIGN KEY (purchase_id) REFERENCES purchase(id)
);

CREATE TABLE wishlist (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);