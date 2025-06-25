import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UsersService {
  private urlApiAllUsers = 'http://localhost:8082/users';
  private urlApiAllUserById = 'http://localhost:8082/user';

  constructor(private http: HttpClient) {}
  getAllUsers(): Observable<any[]> {
    return this.http.get<any[]>(this.urlApiAllUsers);
  }
  getUserById(id: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.urlApiAllUsers}/${id}`);
  }
  postUser(userData:any): Observable<any>{
    return this.http.post(`${this.urlApiAllUserById}`, userData);
  }
  patchUser(userId:number, userData:any): Observable<any>{
    return this.http.patch(`${this.urlApiAllUserById}/${userId}`, userData);
  }
  deleteUser(userId: number):Observable<any>{
    return this.http.delete(`${this.urlApiAllUserById}/${userId}`)
  }
}
