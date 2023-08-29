import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { ProductService } from '../services/product.service';


@NgModule({
  declarations: [
    ProductDetailComponent
  ],
  imports: [
    CommonModule
  ],
  providers: [ProductService]
})
export class ProductModule { }
