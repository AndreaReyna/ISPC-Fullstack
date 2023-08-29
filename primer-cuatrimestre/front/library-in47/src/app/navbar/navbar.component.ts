import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { CarritoService } from '../services/carrito.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  
  constructor(private authService: AuthService, public carritoService: CarritoService) {}

  ngOnInit(): void {
  }

  get logIn(): boolean {
    return this.authService.isLoggedIn;
  }

  logout(): void {
    this.authService.logout().subscribe(
      () => {
        // Logout successful
        this.authService.isLoggedIn = false; // Set isLoggedIn to false on successful logout
      },
      (error) => {
        // Logout failed
        console.error('Logout failed:', error);
      }
    );
  }
}