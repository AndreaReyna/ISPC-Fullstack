import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FormPagoService {
  private apiUrl = 'http://localhost:8000/api/pagos/';

  constructor(private http: HttpClient) { }

  enviarDatosPago(datosPago: any) {
    const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type':  'application/json',
          'X-Requested-With': 'XMLHttpRequest',
          'X-CSRFToken': this.getCookie('csrftoken'),
      }),
      withCredentials: true
      };
    return this.http.post(this.apiUrl, datosPago, httpOptions);
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
}