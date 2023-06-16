import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-estado-compra',
  templateUrl: './estado-compra.component.html',
  styleUrls: ['./estado-compra.component.css']
})
export class EstadoCompraComponent implements OnInit{
  purchaseStatus: string | undefined;

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id !== null) {
      // Lógica para obtener el estado de compra usando el id proporcionado
      // Puede ser una llamada a un servicio o cualquier otra forma de obtener los datos
      this.purchaseStatus = this.getPurchaseStatusById(Number(id));
    }
  }

  getPurchaseStatusById(id: number): string {
    // Lógica para obtener el estado de compra según el id proporcionado
    // Puede ser una llamada a un servicio o cualquier otra forma de obtener los datos
    // Por simplicidad, este ejemplo retorna un estado de compra estático
    return 'Pago confirmado, en proceso de envío';
  }
}

