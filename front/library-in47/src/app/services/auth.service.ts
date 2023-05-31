import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private url: string = "http://localhost:3000/auth";

  constructor(private http: HttpClient) { }

  login(email: string, password: string): Observable<User> {
    const credentials = {
      email: email,
      password: password
    };
    return this.http.post<User>(`${this.url}/login`, credentials);
  }

  logout(): Observable<any> {
    return this.http.post<any>(`${this.url}/logout`, null);
  }
}