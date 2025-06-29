import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class AvisService {
  private urlAvis = 'http://localhost:8082/avis';
  constructor(private http: HttpClient) {}
  getAvis(): Observable<any[]> {
    return this.http.get<any[]>(this.urlAvis);
  }
  createAvis(avis: string ): Observable<any> {
    const log = {avis, date: new Date()}
    return  this.http.post<any>(this.urlAvis, avis);
  }
  deleteAvisById(avisId: number): Observable<any>{
   return this.http.delete(`${this.urlAvis}/${avisId}`)

  }
}
