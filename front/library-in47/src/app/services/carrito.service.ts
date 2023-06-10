import { Observable } from "rxjs";
import { ElementoCarrito } from "../models/elementoCarrito";
import { Product } from "../models/product";
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";


@Injectable({
  providedIn: 'root'
})
export class CarritoService {

  private url: string = "http://localhost:8000/api";


  public elementosCarrito: ElementoCarrito[] = [];
  public cantidadProductos: number = 0;
  private carritoKey = 'carrito';

  constructor(private http: HttpClient) {
    // Al inicializar el servicio, intenta cargar los elementos del carrito almacenados en localStorage
    const carritoData = localStorage.getItem(this.carritoKey);
    if (carritoData) {
      this.elementosCarrito = JSON.parse(carritoData);
      this.actualizarCantidadProductos();
    }
  }

  agregarAlCarrito(libro: Product): void {
    const elemento = this.elementosCarrito.find(e => e.libro.id_libro === libro.id_libro);
    if (elemento) {
      elemento.cantidad++;
    } else {
      this.elementosCarrito.push({ libro: libro, cantidad: 1, id_elementos_carrito: 0, id_carrito_id: 0, id_libro_id: libro.id_libro });
    }
    this.guardarCarrito();
    this.actualizarCantidadProductos();
  }

  incrementarCantidad(id_libro: number): void {
    const elemento = this.elementosCarrito.find(e => e.libro.id_libro === id_libro);
    if (elemento) {
      elemento.cantidad++;
      this.guardarCarrito();
    }
  }

  decrementarCantidad(id_libro: number): void {
    const elemento = this.elementosCarrito.find(e => e.libro.id_libro === id_libro);
    if (elemento && elemento.cantidad > 1) {
      elemento.cantidad--;
      this.guardarCarrito();
    }
  }

  eliminarElemento(id_libro: number): void {
    const indice = this.elementosCarrito.findIndex(e => e.libro.id_libro === id_libro);
    if (indice !== -1) {
      this.elementosCarrito.splice(indice, 1);
      this.guardarCarrito();
      this.actualizarCantidadProductos();
    }
  }

  getElementosCarrito(): ElementoCarrito[] {
    return this.elementosCarrito;
  }

  getCantidadProductos(): number {
    return this.cantidadProductos;
  }

  private guardarCarrito(): void {
    localStorage.setItem(this.carritoKey, JSON.stringify(this.elementosCarrito));
  }

  private actualizarCantidadProductos(): void {
    this.cantidadProductos = this.elementosCarrito.reduce((total, producto) => total + producto.cantidad, 0);
  }

  enviarCompra(compra: any): Observable<any> {
    return this.http.post<any>(`${this.url}/comprar/`, compra);
  }
}