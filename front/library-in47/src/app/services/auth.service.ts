import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { User } from '../models/user';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  user: User | null = null;

  private url: string = "http://localhost:8000/api/";
  private _isLoggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  private _currentUser: BehaviorSubject<User | null> = new BehaviorSubject<User | null>(null);

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
    return this.http.post<User>(`${this.url}auth/login/`, credentials).pipe(
      map(user => {
        this.user = user;
        this.isLoggedIn = true;
        return user;
      })
    );
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
    return this.http.post<any>(`${this.url}auth/logout/`, null).pipe(
      map(response => {
        this.user = null;
        this.isLoggedIn = false;
        return response;
      })
    );
  }
  getProfile(): Observable<User> {
    const httpOptions = {
      headers: new HttpHeaders({
          'Content-Type':  'application/json',
          'Cookie': `sessionid=${this.getCookie('sessionid')}; csrftoken=${this.getCookie('csrftoken')}`,
          'X-Requested-With': 'XMLHttpRequest'
      }),
      withCredentials: true
  };
    return this.http.get<User>(`${this.url}profile/`, httpOptions);
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

  getUser(): User | null {
    return this.user;
  }
  
}