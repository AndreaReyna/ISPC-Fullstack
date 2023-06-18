import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url: string = "http://localhost:8000/api/";

  constructor(private http: HttpClient) { }

  getAll(): Observable<User[]> {
    return this.http.get<User[]>(this.url+"users/");
  }

  create(user: User): Observable<User> {
    return this.http.post<User>(this.url+"auth/signup/", user);
  }
}