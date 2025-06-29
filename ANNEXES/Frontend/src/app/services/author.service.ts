import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class AuthorService {
  private urlAuthor = 'http://localhost:8082/author';
    private urlAllAuthors = 'http://localhost:8082/authors';
  
  constructor(private http: HttpClient) {}

  getAllAuthors(): Observable<any[]> {
    return this.http.get<any[]>(this.urlAllAuthors);
  }
  postAuthor(author: any): Observable<any> {
    return this.http.post(`${this.urlAuthor}`, author);
  }
  updateAuthor(authorId: number, authorData: any): Observable<any> {
    return this.http.patch(`${this.urlAuthor}/${authorId}`, authorData);
  }
  deleteAuthorById(id: number):Observable<any>{
    return this.http.delete(`${this.urlAuthor}/${id}`)
  }
}
