import { Injectable } from '@angular/core';

interface GameList {
  id: number;
  nom: string;
  image: string;
  author: string;
  genre: string;
  description: string;
  numEdition: number;
}
@Injectable({ providedIn: 'root' })
export class WishlistService {
  private wishlist: GameList[] = [];

   getWishlist(): GameList[] {
    return this.wishlist;
  }
  dejaDansWishList(wishlist: GameList): boolean{
    return this.wishlist.some(p => p.id===wishlist.id)

  }

  ajouterWishList(wishlist: GameList): void {
    if (!this.dejaDansWishList(wishlist)) {
      this.wishlist.push(wishlist);
    }
    console.log('Panier actuel:', this.wishlist);
  }
  retirerDeWishlist(wishlist: GameList): void {
    this.wishlist = this.wishlist.filter(p => p.id !== wishlist.id);
  }

  ajouterRetirerWishlist(wishlist: GameList): void{
    this.dejaDansWishList(wishlist)?this.retirerDeWishlist(wishlist): this.ajouterWishList(wishlist);
  }
}
