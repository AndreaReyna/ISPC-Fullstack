import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/product/product-detail/product';
import { ProductService } from 'src/app/services/productService/product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  libros !: Product[];

  constructor(private productService:ProductService){ }

  ngOnInit(): void {
    this.productService.getAll().subscribe(
      libro => this.libros=libro
      );  
  }
}
