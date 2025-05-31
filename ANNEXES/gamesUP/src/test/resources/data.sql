
INSERT INTO utilisateur (id, nom, email, role, password, repassword) VALUES
(1, 'VISIPLUS', 'visiplus@email.com', 'administrateur', 'visiplus2025', 'visiplus2025'),
(2, 'ISCOD', 'iscod@email.com', 'client', 'iscod2025', 'iscod2025');

INSERT INTO game (
    id,
    nom,
    image,
    genre,
    description,
    num_edition,
    author_id,
    category_id,
    publisher_id
) VALUES (
    1,
    'Everspace',
    'https://gaming-cdn.com/images/products/9495/616x353/everspace-xbox-one-jeu-microsoft-store-europe-cover.jpg?v=1738771868',
    'Action',
    'EVERSPACE est un jeu de tir spatial solo à l''action trépidante combinant des éléments de rogue-like avec des graphismes à couper le souffle et une histoire captivante.',
    2016,  1,  1, 1  
);
INSERT INTO author (id, name) VALUES (1, 'auteur');
INSERT INTO category (id, type) VALUES (1, 'category');
INSERT INTO publisher (id, name) VALUES (1, 'Jordy AKRA MESCHEBA');
INSERT INTO avis (id, note, commentaire) VALUES (1, 10, 'commentaire');

INSERT INTO purchase (id, date, paid, delivered, archived)
VALUES (1, CURRENT_DATE, TRUE, FALSE, FALSE);
INSERT INTO purchase_line (id, prix, jeu_id, utilisateur_id, purchase_id, game_id)
VALUES (1, 59.99, 1, 123, 1, 1);

INSERT INTO wishlist (id, name) VALUES (1,  'wishlist');