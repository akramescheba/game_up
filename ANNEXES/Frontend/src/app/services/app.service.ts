import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AppService {
  private urlApiAllGame = 'http://localhost:8082/jeux';
  private urlApiGame = 'http://localhost:8082/jeu';

  isBtnShow: boolean = false;
  isButtonShow() {
    this.isBtnShow = !this.isBtnShow;
  }

  constructor(private http: HttpClient) {}
  /*Méthode d'affichage, de création, de mise à jour et de suppression des jeux dépuis la base des données */
  reload() {
    setTimeout(function () {
      location.reload();
    }, 500);
  }

  getAllGame(): Observable<any[]> {
    return this.http.get<any[]>(this.urlApiAllGame);
  }
  postGame(game: any): Observable<any> {
    return this.http.post(this.urlApiGame, game);
  }
  updatePartialGame(gameId: number, patchGame: any): Observable<any> {
    return this.http.patch(`${this.urlApiGame}/${gameId}`, patchGame);
  }
  deleteGame(gameId: number): Observable<any> {
    return this.http.delete(`${this.urlApiGame}/${gameId}`);
  }
}
