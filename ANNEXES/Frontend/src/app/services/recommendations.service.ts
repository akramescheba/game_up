import { Injectable } from '@angular/core';
import{Observable} from "rxjs";
import{Recommendations} from '../models/models';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RecommendationsService {

  private urlApiPython = "http://localhost:8082/recommendations";
  

  constructor(private http:HttpClient) { }

  getRecommendation(recommendationId: number): Observable<Recommendations[]>{
    return this.http.get<Recommendations[]>(`${this.urlApiPython}/${recommendationId}`);
  }

}
