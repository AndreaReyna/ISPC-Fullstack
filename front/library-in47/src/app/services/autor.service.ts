import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Autor } from '../models/autor';

@Injectable({
  providedIn: 'root'
})
export class AutorService {

  private url: string = "http://localhost:8000/api/autor";

  constructor(private http: HttpClient) { }

  getAll(): Observable<Autor[]> {
    return this.http.get<Autor[]>(this.url);
  }

  get(id: number): Observable<Autor> {
    return this.http.get<Autor>(`${this.url}/${id}`);
  }

  create(autor: Autor): Observable<Autor> {
    return this.http.post<Autor>(this.url, autor);
  }

  update(id: number, autor: Autor): Observable<Autor> {
    return this.http.put<Autor>(`${this.url}/${id}`, autor);
  }

  delete(id: number): Observable<any> {
    return this.http.delete<any>(`${this.url}/${id}`);
  }
}