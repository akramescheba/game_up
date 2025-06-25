import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class CategoriesService {
  private urlApiCategories = 'http://localhost:8082/categories';
  private urlApiCategoryById = 'http://localhost:8082/category';

  constructor(private http: HttpClient) {}
  /*Méthode d'affichage, de création, de mise àjourt et de suppression des catégories dépuis la base des données */
  getAllCategories(): Observable<any[]> {
    return this.http.get<any[]>(this.urlApiCategories);
  }
  postCategory(category: any): Observable<any> {
    return this.http.post(this.urlApiCategoryById, category);
  }
  updateCategory(categoryId: number,categoryData: any): Observable<any>{
    return this.http.patch(`${this.urlApiCategoryById}/${categoryId}` , categoryData)
  }
  deleteCategory(categoryId: number): Observable<any>{
    return this.http.delete(`${this.urlApiCategoryById}/${categoryId}`)
  }
}
