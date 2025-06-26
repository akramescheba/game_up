import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Publisher} from '../models/models';

@Injectable({
  providedIn: 'root'
})
export class PublisherService {

  constructor(private http: HttpClient) { }
  private urlAllPublishers = 'http://localhost:8082/publishers'

  getAllPublishers(): Observable<Publisher[]>{
    return this.http.get<Publisher[]>(`${this.urlAllPublishers}`)

  }
}
