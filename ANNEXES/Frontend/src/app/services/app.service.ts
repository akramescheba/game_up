import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AppService {
  private urlApiAllGame = 'http://localhost:8082/jeux';
  private urlApiAllUsers = 'http://localhost:8082/users';
  private urlApiAllUserById = 'http://localhost:8082/user';

  isBtnShow: boolean = false;
  isButtonShow() {
    this.isBtnShow = !this.isBtnShow;
  }

  constructor(private http: HttpClient) {}

  getAllGame(): Observable<any[]> {
    return this.http.get<any[]>(this.urlApiAllGame);
  }
  getAllUsers(): Observable<any[]> {
    return this.http.get<any[]>(this.urlApiAllUsers);
  }
  getUserById(id: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.urlApiAllUsers}/${id}`);
  }
}
