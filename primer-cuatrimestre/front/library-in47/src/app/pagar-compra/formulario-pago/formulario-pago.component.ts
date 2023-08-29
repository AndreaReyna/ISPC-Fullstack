import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { FormPagoService } from 'src/app/services/pago.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-formulario-pago',
  templateUrl: './formulario-pago.component.html',
  styleUrls: ['./formulario-pago.component.css']
})
export class FormularioPagoComponent implements OnInit {
  formPago!: FormGroup;
  mostrarMensajeExito: boolean = false;
  userEmail: string = '';

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private servPago: FormPagoService,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.formPago = this.formBuilder.group({
      tarjeta: ['', [Validators.required, Validators.pattern('^[0-9]{16}$')]],
      titular: ['', [Validators.required]],
      vencimiento: ['', [Validators.required, Validators.pattern('^(0[1-9]|1[0-2])\/(20[2-9][0-9])$')]],
      code: ['', [Validators.required, Validators.pattern('^[0-9]{3}$')]],
      dni: ['', [Validators.required, Validators.pattern('^[0-9]+$')]],
    }); 
    this.authService.getProfile().subscribe(
      (user: User) => {
        this.userEmail = user.email;
      },
    )
 }

  get tarjeta_GET() {
    return this.formPago.get('tarjeta');
  }

  get titular_GET() {
    return this.formPago.get('titular');
  }

  get vencimiento_GET() {
    return this.formPago.get('vencimiento');
  }

  get code_GET() {
    return this.formPago.get('code');
  }

  get dni_GET() {
    return this.formPago.get('dni');
  }

  sendFormPago() {
    if (this.formPago.valid) {
      const datosPago = {
        email: this.userEmail,
        ...this.formPago.value
      };
      this.servPago.enviarDatosPago(datosPago).subscribe(
        (response) => {
          Swal.fire(
            'Tu compra se realizó exitosamente!',
            '',
            'success'
          );
          this.mostrarMensajeExito = true;
          setTimeout(() => {
            this.mostrarMensajeExito = false;
            this.router.navigateByUrl('/');
          }, 3000);
        },
        (error) => {
          console.error('Error al enviar los datos del pago', error);
        }
      );
    }
  }


  validarNumeros(event: any) {
    const pattern = /^[0-9]*$/;
    const inputChar = String.fromCharCode(event.charCode);
    if (!pattern.test(inputChar)) {
      event.preventDefault();
    }
  }
}