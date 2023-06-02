import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  alertVisible: boolean;
  alertMessage: string;

  constructor(private authService: AuthService, private router: Router) {
    this.alertVisible = false;
    this.alertMessage = '';
  }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)]),
    });
  }

  get email() {
    return this.loginForm.get('email');
  }

  get password() {
    return this.loginForm.get('password');
  }

  onSubmit(): void {
    if (this.loginForm.valid) {
      const email = this.loginForm.value.email;
      const password = this.loginForm.value.password;

      this.authService.login(email, password).subscribe(
        () => {
          // Login successful
          console.log('Login successful');
          this.authService.isLoggedIn = true; // Set isLoggedIn to true on successful login
          this.router.navigate(['/']);
        },
        (error) => {
          // Login failed
          console.error('Login failed:', error);
          this.showAlert('Error al iniciar sesión. Por favor, verifica tus credenciales.');
        }
      );
    } else {
      this.showAlert('Por favor, revisa el formulario.');

      if (this.email !== null) {
        this.email.markAsDirty();
        this.email.markAsTouched();
      }

      if (this.password !== null) {
        this.password.markAsDirty();
        this.password.markAsTouched();
      }
    }
  }

  showAlert(message: string): void {
    let errorMessage = message;

    if (this.email?.invalid) {
      errorMessage += '<br/>- Correo electrónico inválido.';
    }

    if (this.password?.invalid) {
      errorMessage += '<br/>- Contraseña inválida.';
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