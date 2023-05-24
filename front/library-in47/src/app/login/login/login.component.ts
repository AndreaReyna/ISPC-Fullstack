import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  alertVisible: boolean;
  alertMessage: string;

  constructor() {
    this.alertVisible = false;
    this.alertMessage = '';
  }

  ngOnInit(): void {
    
    this.loginForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      pass: new FormControl('', [Validators.required, Validators.minLength(6)]),
  
    });   
  }

  get email() {
    return this.loginForm.get('email');
  }
  get pass() {
    return this.loginForm.get('pass');
  }
  onSubmit(): void {
    if (
      this.pass !== null &&
      this.loginForm.valid
    ) {
      this.hideAlert();
      alert('Registro exitoso!');
    } else {
      this.showAlert('Por favor, revisa el formulario ');

      if (this.email !== null) {
        this.email.markAsDirty();
        this.email.markAsTouched();
      }

      if (this.pass !== null) {
        this.pass.markAsDirty();
        this.pass.markAsTouched();
      }
    }
  }

  showAlert(message: string): void {
    let errorMessage = message;

    if (this.email?.invalid) {
      errorMessage += '<br/>-Correo electrónico inválido.';
    }
    
    if (this.pass?.invalid) {
      errorMessage += '<br/>-Contraseña inválida.';
    }
  
    this.alertMessage = errorMessage;
    this.alertVisible = true;
    setTimeout(() => this.hideAlert(), 3900);
  }
  

  hideAlert(): void {
    this.alertVisible = false;
    this.alertMessage = '';
  }
}