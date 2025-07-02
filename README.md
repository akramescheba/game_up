
# GameUp

GameUp, une plateforme de vente de jeux de société en ligne. La plateforme GameUp permet de gérer un catalogue de jeux de sociétés, d'enregistrer les  utilisateurs et leurs achats et enfin de faire des recommandations des jeux aux clients en fonction des articles visités par chaque client sur le site. 

La problématique est que la plateforme connaît quelques bugs depuis quelques temps, empêchant les clients de l’utiliser et ainsi de bénéficier de l'entièreté des fonctionnalités et cela fait baisser les ventes sur le site.

Le backend du site est devenu obsolète et il va falloir le refondre pour faire fonctionner toutes les fonctionnalités CRUD.


## Prérequis

 - [Utiliser un éditeur de code](https://code.visualstudio.com/)
- [Connaissance en Angular, et du concept MVC ](./)
 - [Connaissance en JAVA, SpringBoot et Maven ](./)
 - [Connaissance en de Git et Github](./)
## Environnement de développement

- J'ai utilisé VS Code comme éditeur de code pour ce projet. Le projet est développé avec springboot maven et angular. L'api du Machine Learning est quant à elle développer en python. Pour cela, qulques configuration sont nécessaires pour votre environnement de développement afin de faire fonctionner tout le projet.
- Pour configurer votre environnement de développement, vous devez installer les outils suivants:

` Java 23.0.1 ou supérieur`

`Maven 3.9.9  ou supérieur`

`Node.js 22.13.0 ou supérieur`

`Angular CLI 18.2.14 ou supérieur`

` MySQL 8.0.21 ou supérieur`
## Installation

1. Télécharger  le [ JDK 8 ou 11 ](  https://www.oracle.com/java/technologies/downloads/) et suivre les insctructions d'installation

- Verifiez l'installation avec la commande: 

```bash
    java -version
```
2. Télécharger [ Maven](https://maven.apache.org/install.html) et suivre les insctructions d'installation

Verifiez l'installation avec la commande: 

```bash
    mvn --version
```
3. Télécharger [Node.js](https://nodejs.org/en/download/) et suivre les insctructions d'installation

- Verifiez l'installation avec la commande: 

```bash
    node -v ou node --version
```
4. Installer [Angular ](https://angular.dev/installation) avec la ligne de commande suivante:
- Verifiez l'installation avec la commande: 

```bash
    npm install -g @angular/cli@18.2.14
    ng --version
```

5. Télécharger [MySQL installer](https://dev.mysql.com/downloads/installe) et suivre les insctructions d'installation de MySQL Workbench.

## Configuration de la BD

1. Après avoir installé MySQL Workbench, vous devez créer une base de données que vous devez nommer **innotechdata** en suivant les indiquations sur les images suivantes: 

Pour cela, vous devez créer un nouveau serveur en suivant les indications sur l'image suivante : 
![MySQL](http://github.com/user-attachments/assets/7e735cfd-fff5-4c0b-b7aa-658cc8520883)
Veillez à bien remplir ces champs:

- Connection name : Définier un nom pour la connection
- Hostname : 127.0.0.1 ou localhost
- Username : root
- Password : Saisir le mot de passe que vous avez défini lors de l'installation de MySQL Workbench.

2. Après avoir configuré la connection,clique sur le bouton Test de connection :

![test de connexion](https://github.com/user-attachments/assets/a650eeb6-5ea7-483d-a068-dad87a93e457)

La fenêtre ci-dessus s'affiche vous informant que le test de connection a réussie.

3. Vous devez maintenant accèder à la connection que vous venez de créer pour créer une nouvelle base des données, et y rajouter des données de test.

![server](https://github.com/user-attachments/assets/3fb23178-27ff-42a1-86be-266379592df6)

4. Une fois accedez à la connection, vous accedez à la page vous permettant de faire des requettes SQL.

![creer une base de donnees](http://github.com/user-attachments/assets/0a295fe7-471b-4c65-9843-6bd18e7da263)

La requette suivante permet de créer une nouvelle base des données.

```bash
    CREATE DATABASE game_up ;
```

![create database](http://github.com/user-attachments/assets/fd0fb6e5-d384-41ab-bab6-b8d894834997)

Après l'exécution de la requette SQL, on observe l'apparition de la base des données "game_up" suite à sa création comme sur l'image suivante :

![database](http://github.com/user-attachments/assets/639b5fd4-130a-4237-9c79-65eb096b9f28)

Pour sélectionner la bas de données et y introduire des données de test, vous devez exécuter la commande suivante:
```bash
    USE game_up ; 
```
![use database](http://github.com/user-attachments/assets/c026dfbf-29a8-4e1d-967d-9bfc97959b5e)

Vous devez procédez à la création de la table user, qui contiendra la liste des utilisateurs et leurs données personnelles. 

```bash
    CREATE TABLE membre (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email INT NOT NULL,
    nom VARCHAR (50) NOT NULL,
    prenom VARCHAR (50) NOT NULL,
    mdp VARCHAR (50) NOT NULL,);
```
![create table](http://github.com/user-attachments/assets/3a98d6fc-12bb-416a-9416-f711eb401df9)

Vous devez actuellement ajouter des données de test contenant les informations au format nom.

Requête d'ajout des données à la base:

```bash
    INSERT INTO user (id, nom, prenom, vote) 
VALUES ();

```
![insert des donnees](http://github.com/user-attachments/assets/58450fec-2f40-4f86-a5c8-9866350283d5)
## Affichage des données de la base des données
Avec la commande suivante, vous accèdez à toutes les données de la base sous forme de tableau.

![affichage des donnees](http://github.com/user-attachments/assets/3c7365f3-ccf5-465f-b8c2-30e9d7ec7525)

## Clonage du projet
Créer un répertoire sur le bureau et ouvrez ce répertoire dans VS Code.
Cloner le projet avec la commande 

```bash
  git clone https://github.com/akramescheba/game_up.git
```

## Lancement du backend 
 1. Ouvrez un nouveau Terminal à la racine du projet puis naviguez vers le dossier backend, et lancez le script suivant:

```bash
   mvn spring-boot:run  
```
2. Ouvrez un navigateur et naviguer vers : [http://localhost:8082/jeux](http://localhost:8082/jeux). 

## Lancement de l'API Python
 1. Ouvrez un nouveau Terminal à la racine du projet puis naviguez vers le dossier CodeApiPython, et lancez le script suivant:

```bash
   uvicorn main:app --reload 
```
2. Ouvrez un navigateur et naviguer vers : [http://localhost:8082/recommendations/1](http://localhost:8082/recommendations/1). 

## Lancement du frontend

1. Naviguer vers le dossier frontend, dans le terminal, puis lancer le script suivant:

Installation des dépendences
```bash
  npm install
  
```

Lancer le server

```bash
  ng serve
```

Ouvrez un navigateur et naviguer vers : 
[http://localhost:4200](http://localhost:4200), pour cceder au frontend.

## Références API


#### Affichage d'un jeu par Id
```http
  http://localhost:8082/jeu/id
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `jeu/id`      | `string` | Affichage d'un jeu par Id|

#### Affichage de tous les jeux

```http
 http://localhost:8082/jeux
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `jeux` | `string` | Liste de tous les jeux |


| `Endpoints` | `GET, PUT PATCH by Id et POST ` | `GET de liste`|
| :-------- | :------- | :------------------------- |
 | `Author` | ` http://localhost:8082/author` | ` http://localhost:8082/author` |
| `Avis` | ` http://localhost:8082/avis` | ` http://localhost:8082/avis` |
| `Category` | ` http://localhost:8082/category` | ` http://localhost:8082/categories` |
| `Game` | ` http://localhost:8082/jeu` | ` http://localhost:8082/jeux` |
| `Inventory` | ` http://localhost:8082/inventory` | ` http://localhost:8082/inventories` |
  | `Publisher` | ` http://localhost:8082/publisher` | ` http://localhost:8082/publishers` |
  | `Purchase` | ` http://localhost:8082/purchase` | ` http://localhost:8082/purchases` |
  | `Recommendations` | ` http://localhost:8082/recommendations` | ` http://localhost:8082/recommendations` |
  | `Users`| ` http://localhost:8082/user` | ` http://localhost:8082/users` |
  | `Wishlist` | ` http://localhost:8082/wishlist` | ` http://localhost:8082/wishlists` |
  
  
  

   
   
