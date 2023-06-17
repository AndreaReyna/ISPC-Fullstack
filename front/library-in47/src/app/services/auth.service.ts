import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { User } from '../models/user';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private url: string = "http://localhost:8000/api/auth";
  private _isLoggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  constructor(private http: HttpClient) { }

  login(email: string, password: string): Observable<User> {
    const credentials = {
      email: email,
      password: password
    };
    const httpOptions = {
      headers: new HttpHeaders({
            'Content-Type':  'application/json',
            'Cookie': ` X-CSRFToken=${this.getCookie('csrftoken')}`,
            'X-Requested-With': 'XMLHttpRequest'
        }),
        withCredentials: true
    };
    return this.http.post<User>(`${this.url}/login/`, credentials);
  }  
  
  logout(): Observable<any> {
    const httpOptions = {
        headers: new HttpHeaders({
            'Content-Type':  'application/json',
            'Cookie': `sessionid=${this.getCookie('sessionid')}; csrftoken=${this.getCookie('csrftoken')}`,
            'X-Requested-With': 'XMLHttpRequest'
        }),
        withCredentials: true
    };
    return this.http.post<any>(`${this.url}/logout/`, null); 
  }

  getCookie(name: string): string {
    let cookieValue = "";
    if (document.cookie && document.cookie !== '') {
        const cookies = document.cookie.split(';');
        for (let i = 0; i < cookies.length; i++) {
            const cookie = cookies[i].trim();
            if (cookie.substring(0, name.length + 1) === (name + '=')) {
                cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                break;
            }
        }
    }
    return cookieValue;
  }

  set isLoggedIn(value: boolean) {
    this._isLoggedIn.next(value);
  }

  get isLoggedIn(): boolean {
    return this._isLoggedIn.getValue();
  }

  getIsLoggedIn(): Observable<boolean> {
    return this._isLoggedIn.asObservable();
  }
}