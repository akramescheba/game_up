CREATE TABLE utilisateur (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    role VARCHAR(50),
    password VARCHAR(255),
    repassword VARCHAR(255)
);


CREATE TABLE IF NOT EXISTS game (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255),
    image VARCHAR(255),
    description TEXT,
    genre VARCHAR(255),
    num_edition INTEGER,
    category_id BIGINT,
    publisher_id BIGINT,
    author_id BIGINT,
    wishlist_id BIGINT
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
CREATE TABLE IF NOT EXISTS avis (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    commentaire TEXT,
    note INTEGER NOT NULL CHECK (note BETWEEN 0 AND 5),
    date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE purchase (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    date DATE,
    paid BOOLEAN,
    delivered BOOLEAN,
    archived BOOLEAN,
       user_id BIGINT,
     FOREIGN KEY (user_id) REFERENCES utilisateur(id)
    
);

CREATE TABLE purchase_line (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    prix DOUBLE,
    jeu_id BIGINT,
    utilisateur_id BIGINT,
    rating DOUBLE,
    purchase_id BIGINT,
    game_id BIGINT,
    FOREIGN KEY (purchase_id) REFERENCES purchase(id)      
);

CREATE TABLE wishlist (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES utilisateur(id)
);

CREATE TABLE wishlist_games (
    wishlist_id BIGINT NOT NULL,
    game_id BIGINT NOT NULL,
    PRIMARY KEY (wishlist_id, game_id)

);

CREATE TABLE IF NOT EXISTS inventory (
    id BIGINT PRIMARY KEY,
    user_id BIGINT UNIQUE 
    );

CREATE TABLE IF NOT EXISTS inventory_line (
    id BIGINT PRIMARY KEY,
    game_id BIGINT NOT NULL,
    inventory_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (game_id) REFERENCES game(id),
    FOREIGN KEY (inventory_id) REFERENCES inventory(id)
);
CREATE TABLE IF NOT EXISTS avis (
    id BIGINT PRIMARY KEY,
    note INTEGER NOT NULL CHECK (note BETWEEN 0 AND 5),
    name VARCHAR(255),
    commentaire TEXT,
    date TIMESTAMP NOT NULL

);