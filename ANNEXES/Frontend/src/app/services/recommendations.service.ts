import { Injectable } from '@angular/core';
import{Observable} from "rxjs";
import{Recommendations} from '../models/models';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class RecommendationsService {
  private urlApiPython = 'http://localhost:8082/recommendations';

  constructor(private http: HttpClient) {}
  
  getRecommendation(recommendation: number): Observable<Recommendations[]> {
    const userId= 1
    const urlRecommendation = `${this.urlApiPython}/${userId}`;
    return this.http.get<Recommendations[]>(urlRecommendation);
  }
}



