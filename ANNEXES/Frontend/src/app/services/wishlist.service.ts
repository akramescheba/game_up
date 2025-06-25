import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GameList, WishList } from '../models/models';

@Injectable({ providedIn: 'root' })
export class WishlistService {
  private urlGetAllWishLists = 'http://localhost:8082/wishlists';
  private urlWishList = 'http://localhost:8082/wishlist';


  constructor(private http: HttpClient) {}
  getAllWishlist(): Observable<WishList[]> {
   return this.http.get<WishList[]>(`${this.urlGetAllWishLists}`);
  }

  ajoutWishList(game: GameList): Observable<any> {
    return this.http.post(`${this.urlWishList}`, game);
  }

  retraitWishList(gameId: number): Observable<any> {
    return this.http.delete(`${this.urlWishList}/${gameId}`);
  }
}
