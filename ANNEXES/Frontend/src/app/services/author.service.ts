import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class AuthorService {
  private urlAuthor = 'http://localhost:8082/author';
  constructor(private http: HttpClient) {}

  getAuthor(): Observable<any[]> {
    return this.http.get<any[]>(this.urlAuthor);
  }
  postAuthor(author: any): Observable<any> {
    return this.http.post<any>(`${this.urlAuthor}`, author);
  }
  updateAuthor(authorId: number, authorData: any): Observable<any> {
    return this.http.patch<any>(`${this.urlAuthor}/${authorId}`, authorData);
  }
  deleteAuthorById(id: number):Observable<any>{
    return this.http.delete<any>(`${this.urlAuthor}/${id}`)
  }
}
