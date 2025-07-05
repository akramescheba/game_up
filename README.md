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

` Java openjdk 21.0.6 ou supérieur`

`Apache Maven 3.9.9  ou supérieur`

`Node.js 22.13.0 ou supérieur`

`Angular CLI 18.2.14 ou supérieur`

`MySQL 8.0.21 ou supérieur`

` Python 3.11.4 ou supérieur`
## Installations
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
4. Télécharger [Python](https://www.python.org/downloads/) et suivre les insctructions d'installation

- Verifiez l'installation avec la commande: 

```bash
     python --version
```

5. Installer [Angular ](https://angular.dev/installation) avec la ligne de commande suivante:
- Verifiez l'installation avec la commande: 

```bash
    npm install -g @angular/cli@18.2.14
    ng --version
```

6. Télécharger [MySQL installer](https://dev.mysql.com/downloads/installe) et suivre les insctructions d'installation de MySQL Workbench.
## Configuration de la BD

1. Après avoir installé MySQL Workbench, vous devez créer une base de données que vous devez nommer **game_up** en suivant les indiquations sur les images suivantes: 

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

3. Vous devez maintenant accèder au nouveau sercer que vous venez de créer pour créer une nouvelle base des données, et y rajouter des données de test.
image
![accèt server](https://i.postimg.cc/0jZhX6rB/connexion-au-server-game-up.png)


4. Une fois accedez à la connection, vous accedez à la page vous permettant de faire des requettes SQL.

image

La requette suivante permet de créer une nouvelle base des données.

```bash
    CREATE DATABASE game_up ;
```
![CREATE DATABASE game_up](https://i.postimg.cc/0jZhX6rB/connexion-au-server-game-up.png)

Après l'exécution de la requette SQL, on observe l'apparition de la base des données "game_up" suite à sa création comme sur l'image suivante :

image
Pour sélectionner la bas de données et y introduire des données de test, vous devez exécuter la commande suivante:
```bash
    USE game_up ; 
```
![Use game_up](https://i.postimg.cc/QdSVgSXQ/use-game-up.png)

Vous devez procédez à la création de la table user, qui contiendra la liste des utilisateurs et leurs données personnelles. 

```bash
    CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email INT NOT NULL,
    nom VARCHAR (50) NOT NULL,
    prenom VARCHAR (50) NOT NULL,
    mdp VARCHAR (50) NOT NULL,);
```
image

Vous devez actuellement ajouter des données de test contenant les informations au format nom.

Requête d'ajout des données à la base:

```bash
    INSERT INTO user (id, nom, prenom, vote) 
VALUES ();

```
image
## Affichage des données de la base des données
Avec la commande suivante, vous accèdez à toutes les données de la base sous forme de tableau.

image
## Clonage du projet

Créer un répertoire sur le bureau et ouvrez ce répertoire dans VS Code.
Cloner le projet avec la commande 

```bash
  git clone https://github.com/akramescheba/game_up.git
```
## Lancement de l'API Python
 1. Ouvrez un nouveau Terminal à la racine du projet puis naviguez vers le dossier **CodeApiPython**, et lancez le script suivant:
 
 ```bash
    pip install -r data/requirements.txt
```
Cette commande permet d'installer toutes les dépendance nécéssaires au lancement de l'API Python. 

2. Ensuite, la commande suivante permet de lancer l'API sur le port 8000
```bash
   uvicorn main:app --reload 
```
3. Pour vérifier que l'API fonctionne vous pouvez le tester sur postman, insmnia ou dans un navigateur avec le endpoint : [http://localhost:8000](http://localhost:8000). 


## Lancement du backend 
 1. Ouvrez un nouveau Terminal à la racine du projet puis naviguez vers le dossier **game_up**, et lancez le script suivant:

```bash
   mvn spring-boot:run  
```
2.  Pour vérifier que l'API fonctionne vous pouvez le tester sur postman, insmnia ou dans un navigateur avec le endpoint : [http://localhost:8082/jeux](http://localhost:8082/jeux). 



## Lancement du frontend

1. Naviguer vers le dossier **frontend**, dans le terminal, puis lancer le script suivant:

Installation des dépendences
```bash
  npm install
  
```

2. Lancer le server pour lancer le projet

```bash
  ng serve
```

3.  Pour vérifier que l'API fonctionne vous pouvez le tester sur postman, insmnia ou dans un navigateur avec le endpoint : [http://localhost:4200](http://localhost:4200), pour acceder à la page d'authentification ci-après:

![connexion](https://github.com/user-attachments/assets/f098dbac-a843-4424-a7a9-7923a4bc87a0)
## Les APIs de références 

#### Affichage des utilisateurs et jeux API spring-boot

| Description | Type     |       Endpoint                 |
| :-------- | :------- | :-------------------------------- |
| `Liste des users`      | `string` | ` http://localhost:8082/users` |
| `Liste des jeux`      | `string` | ` http://localhost:8082/jeux` |

#### Affichage des recommendations API Python
| Description | Type     |       Endpoint                 |
| :-------- | :------- | :-------------------------------- |
| `Liste des recommendations`      | `string` | ` http://localhost:8082/recommendations/id` |

#### Affichage des pages du frontend
| Description | Type     |       Endpoint                 |
| :-------- | :------- | :-------------------------------- |
| `Page d'accueil`      | `string` | ` http://localhost:4200` |
| `Page  d'authentification`      | `string` | ` http://localhost:4200/auth` |

## Les APIs de tests 

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
 
  
## Logo de Game Up
 ![game_up](https://github.com/user-attachments/assets/0676568c-3e93-4c39-a342-96c18d2b3fdc)
 
 ## Link

 [![linkedin](https://img.shields.io/badge/Linkedin-0A66C2%20?style=for-the-badge&logo=linkedin&logoColor=white&label=%40jordy-akra-mescheba&color=blue)](https://www.linkedin.com/in/jordy-akra-mescheba/)
 
  [![@akramescheba](https://img.shields.io/badge/%40akramescheba-0A66C2?style=for-the-badge&logo=github&logoColor=white&color=black)](https://github.com/akramescheba) 

[![Portfolio](https://i.postimg.cc/7YCPpDMW/banni-re-portfolio.png) ](https://portfoli-iscod.web.app/)
