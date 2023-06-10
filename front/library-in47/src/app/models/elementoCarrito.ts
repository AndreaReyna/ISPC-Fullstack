import { Product } from "./product";

export class ElementoCarrito {
    id_elementos_carrito!: number;
    cantidad!: number;
    id_carrito_id!: number;
    id_libro_id!: number;
    libro !: Product;
  }