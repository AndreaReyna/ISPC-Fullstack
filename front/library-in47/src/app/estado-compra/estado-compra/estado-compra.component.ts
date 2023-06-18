import { Component} from '@angular/core';




@Component({
  selector: 'app-estado-compra',
  templateUrl: './estado-compra.component.html',
  styleUrls: ['./estado-compra.component.css']
})
export class EstadoCompraComponent{
  orders = [
    {
      id: 1,
      status: 'In Progress',
      date: '2023-06-17',
      items: [
        {
          name: 'Product 1',
          price: 10,
          image: './assets/img/logos-1.jpg',
          quantity: 1
        },
        {
          name: 'Product 2',
          price: 20,
          image: 'path/to/product2.jpg',
          quantity: 2
        }
      ]
    }
  ];
  increaseQuantity(item: any) {
    item.quantity++;
  }
  
  decreaseQuantity(item: any) {
    if (item.quantity > 1) {
      item.quantity--;
    }
  }
  
  cancelOrder(order: any) {
    // Lógica para cancelar la orden
  }

}



