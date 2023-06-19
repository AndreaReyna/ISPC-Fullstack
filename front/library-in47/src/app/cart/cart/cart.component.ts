import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ElementoCarrito } from 'src/app/models/elementoCarrito';
import { AuthService } from 'src/app/services/auth.service';
import { CarritoService } from 'src/app/services/carrito.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {
  elementosCarrito: ElementoCarrito[] = [];
  total: number = 0;
  cantidadTotalElementos: number = 0;
  precioTotalCompra: number = 0;

  constructor(private authService: AuthService, public carritoService: CarritoService, private router :Router) { }

  ngOnInit(): void {
    this.elementosCarrito = this.carritoService.elementosCarrito;
    this.total = this.calcularTotal();
    this.cantidadTotalElementos = this.calcularCantidadTotalElementos();
    this.precioTotalCompra = this.calcularPrecioTotalCompra();
  }

  incrementarCantidad(id_libro: number): void {
    this.carritoService.incrementarCantidad(id_libro);
    this.total = this.calcularTotal();
    this.cantidadTotalElementos = this.calcularCantidadTotalElementos();
    this.precioTotalCompra = this.calcularPrecioTotalCompra();
  }

  decrementarCantidad(id_libro: number): void {
    this.carritoService.decrementarCantidad(id_libro);
    this.total = this.calcularTotal();
    this.cantidadTotalElementos = this.calcularCantidadTotalElementos();
    this.precioTotalCompra = this.calcularPrecioTotalCompra();
  }

  eliminarElemento(id_libro: number): void {
    this.carritoService.eliminarElemento(id_libro);
    this.elementosCarrito = this.carritoService.elementosCarrito;
    this.total = this.calcularTotal();
    this.cantidadTotalElementos = this.calcularCantidadTotalElementos();
    this.precioTotalCompra = this.calcularPrecioTotalCompra();
  }

  private calcularTotal(): number {
    return this.carritoService.elementosCarrito.reduce((total, producto) => total + parseFloat(producto.libro.precio) * producto.cantidad, 0);
  }

  private calcularCantidadTotalElementos(): number {
    return this.carritoService.elementosCarrito.reduce((total, producto) => total + producto.cantidad, 0);
  }

  private calcularPrecioTotalCompra(): number {
    return this.carritoService.elementosCarrito.reduce((total, producto) => total + (parseFloat(producto.libro.precio) * producto.cantidad), 0);
  }

  convertirPrecio(precio: string): number {
    return parseFloat(precio);
  }

  get logIn(): boolean {
    return this.authService.isLoggedIn;
  }

  finalizarCompra() {
    const elementosConCantidad = this.elementosCarrito.map(elemento => ({
      libro: elemento.libro,
      cantidad: elemento.cantidad
    }));

    const compra = {
      elementos: elementosConCantidad,
      cantidadTotal: this.cantidadTotalElementos,
      precioTotal: this.precioTotalCompra
    };
    console.log(compra)
    this.carritoService.enviarCompra(compra)
      .subscribe(
        response => {
          console.log('Orden procesada exitosamente');
          Swal.fire(
            'Orden procesada exitosamente',
            '',
            'success'
            ).then(() => {
              this.router.navigateByUrl('/pagar-compra');
            });
        },
        error => {
          console.error('Error al procesar la orden', error);
        }
      );
  }
}