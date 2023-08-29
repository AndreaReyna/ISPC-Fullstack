import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { FormularioPagoComponent } from './formulario-pago/formulario-pago.component';

@NgModule({
  declarations: [
    FormularioPagoComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  exports: [FormularioPagoComponent]
})
export class PagarCompraModule { }
