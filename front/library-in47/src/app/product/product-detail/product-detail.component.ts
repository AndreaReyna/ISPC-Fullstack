import { Component, OnInit } from '@angular/core';
import { Product } from '../../models/product';
import { ProductService } from 'src/app/services/product.service';
import { ActivatedRoute } from '@angular/router';
import { ViewportScroller } from '@angular/common';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
    libro !: Product;

    constructor(private route: ActivatedRoute, private productService:ProductService, private viewportScroller: ViewportScroller){ }

    ngOnInit(): void {
      const id = this.route.snapshot.paramMap.get('id');
      if (id !== null) {
        this.productService.get(Number(id)).subscribe((data) => {
          this.libro = data;
        });
        this.viewportScroller.scrollToPosition([0, 0]);
    }
  }
}
