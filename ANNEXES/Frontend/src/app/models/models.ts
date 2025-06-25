/*MODELS DES CLASSES GAME,USER,CATEGORY,AUTHOR, PUBLISHER,AVIS,WISHLIST*/
export interface UserList {
  id: number;
  nom: string;
  email: string;
  role: string;
  password: string;
  repassword: string;
}
export interface GameList {
  id: number;
  nom: string;
  image: string;
  genre: string;
  description: string;
  numEdition: number;
  author:Author;
  category: Category;
  publisher: Publisher;
}

export interface Category {
  id: number;
  type: string;
  games: GameList[];
}
export interface Author {
  id: number;
  name: string;
  games: GameList[];
}
export interface Publisher {
  id: number;
  name: string;
  games: GameList[];
}
export interface ListAvis {
  id: number;
  note: number;
  date: Date|string;
  name: string;
  commentaire: string;
}
export interface WishList{
  id: number;
  name: string;
  games: GameList[];
}
