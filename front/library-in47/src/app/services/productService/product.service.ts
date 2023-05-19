import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../../product/product-detail/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private url:string = "http://localhost:3000/libros";

  constructor(private http: HttpClient) { }

  getAll():Observable<Product[]>{
    return this.http.get<Product[]>(this.url);
  }

  get(id:number):Observable<Product>{
    return this.http.get<Product>(this.url+'/'+id);
  }
}
