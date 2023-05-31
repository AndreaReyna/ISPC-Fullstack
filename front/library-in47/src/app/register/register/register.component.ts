import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm!: FormGroup;
  alertVisible: boolean;
  alertMessage: string;

  constructor(private userService: UserService, private router: Router) {
    this.alertVisible = false;
    this.alertMessage = '';
  }

  ngOnInit(): void {
    this.registerForm = new FormGroup({
      name: new FormControl('', [Validators.required, Validators.minLength(3)]),
      lastname: new FormControl('', [Validators.required, Validators.minLength(3)]),
      email: new FormControl('', [Validators.required, Validators.email]),
      pass: new FormControl('', [Validators.required, Validators.minLength(6)]),
      pass2: new FormControl('', [Validators.required, Validators.minLength(6)]),
      check: new FormControl(false, Validators.requiredTrue)
    });
  }

  get name() {
    return this.registerForm.get('name');
  }

  get lastname() {
    return this.registerForm.get('lastname');
  }

  get email() {
    return this.registerForm.get('email');
  }

  get pass() {
    return this.registerForm.get('pass');
  }

  get pass2() {
    return this.registerForm.get('pass2');
  }

  get check() {
    return this.registerForm.get('check');
  }

  onSubmit(): void {
    if (
      this.pass !== null &&
      this.pass2 !== null &&
      this.registerForm.valid &&
      this.pass.value === this.pass2.value &&
      this.name !== null &&
      this.lastname !== null &&
      this.email !== null
    ) {
      const user = {
        id : 6, // por el momento necesitamos setear el id manualmente
        name: this.name.value!,
        lastname: this.lastname.value!,
        email: this.email.value!,
        pass: this.pass.value!
      };

      this.userService.create(user).subscribe(
        (createdUser) => {
          // Registro exitoso
          console.log('Registro exitoso:', createdUser);
          // Realiza alguna acción adicional o navega a otra página
          alert('Registro exitoso!');
          this.router.navigate(['/home']);
        },
        (error) => {
          // Error al crear el usuario
          console.error('Error al crear el usuario:', error);
          this.showAlert('Error al registrar el usuario. Por favor, intenta nuevamente.');
        }
      );

      this.hideAlert();
    } else {
      this.showAlert('Por favor, revisa el formulario.');

      if (this.name !== null) {
        this.name.markAsDirty();
        this.name.markAsTouched();
      }

      if (this.lastname !== null) {
        this.lastname.markAsDirty();
        this.lastname.markAsTouched();
      }

      if (this.email !== null) {
        this.email.markAsDirty();
        this.email.markAsTouched();
      }

      if (this.pass !== null) {
        this.pass.markAsDirty();
        this.pass.markAsTouched();
      }

      if (this.pass2 !== null) {
        this.pass2.markAsDirty();
        this.pass2.markAsTouched();
      }

      if (this.check !== null) {
        this.check.markAsDirty();
        this.check.markAsTouched();
      }
    }
  }

  showAlert(message: string): void {
    let errorMessage = message;

    if (this.name?.invalid) {
      errorMessage += '<br/>- Nombre inválido.';
    }

      if (this.lastname?.invalid) {
        errorMessage += '<br/>- Apellido inválido.';
      }
  
      if (this.email?.invalid) {
        errorMessage += '<br/>- Correo electrónico inválido.';
      }
  
      if (this.pass?.invalid) {
        errorMessage += '<br/>- Contraseña inválida.';
      }
  
      if (this.pass2?.invalid) {
        errorMessage += '<br/>- Contraseña inválida.';
      }
  
      if (this.pass?.value !== this.pass2?.value) {
        errorMessage += '<br/>- Las contraseñas no coinciden.';
      }
  
      if (this.check?.invalid) {
        errorMessage += '<br/>- Debes aceptar los términos y condiciones.';
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