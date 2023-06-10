import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Editorial } from '../models/editorial';

@Injectable({
  providedIn: 'root'
})
export class EditorialService {

  private url: string = "http://localhost:8000/api/editorial";

  constructor(private http: HttpClient) { }

  getAll(): Observable<Editorial[]> {
    return this.http.get<Editorial[]>(this.url);
  }

  get(id: number): Observable<Editorial> {
    return this.http.get<Editorial>(`${this.url}/${id}`);
  }

  create(editorial: Editorial): Observable<Editorial> {
    return this.http.post<Editorial>(this.url, editorial);
  }

  update(id: number, editorial: Editorial): Observable<Editorial> {
    return this.http.put<Editorial>(`${this.url}/${id}`, editorial);
  }

  delete(id: number): Observable<any> {
    return this.http.delete<any>(`${this.url}/${id}`);
  }
}