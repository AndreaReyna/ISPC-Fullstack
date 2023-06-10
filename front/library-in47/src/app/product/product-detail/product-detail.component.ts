import { Component, OnInit } from '@angular/core';
import { Product } from '../../models/product';
import { Autor } from '../../models/autor';
import { Editorial } from '../../models/editorial';
import { ProductService } from 'src/app/services/product.service';
import { AutorService } from 'src/app/services/autor.service';
import { EditorialService } from 'src/app/services/editorial.service';
import { ActivatedRoute } from '@angular/router';
import { ViewportScroller } from '@angular/common';
import { CarritoService } from 'src/app/services/carrito.service';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
  libro!: Product;
  autor!: Autor;
  editorial!: Editorial;

  constructor(
    private route: ActivatedRoute,
    private productService: ProductService,
    private autorService: AutorService,
    private editorialService: EditorialService,
    private viewportScroller: ViewportScroller,
    private carritoService: CarritoService
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id !== null) {
      this.productService.get(Number(id)).subscribe((data) => {
        this.libro = data;
        this.autorService.get(data.id_autor).subscribe((autorData) => {
          this.autor = autorData;
        });
        this.editorialService.get(data.id_editorial).subscribe((editorialData) => {
          this.editorial = editorialData;
        });
      });
      this.viewportScroller.scrollToPosition([0, 0]);
    }
  }

  agregarAlCarrito(libro: Product){
    this.carritoService.agregarAlCarrito(libro);
  }

}