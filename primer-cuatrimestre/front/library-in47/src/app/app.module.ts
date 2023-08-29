import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home/home.component';
import { ContactComponent } from './contact/contact/contact.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { PanelDeControlComponent } from './panel-de-control/panel-de-control.component';
import { AgregarComponent } from './panel-de-control/agregar/agregar.component';
import { CategoriasComponent } from './panel-de-control/categorias/categorias.component';
import { EliminarComponent } from './panel-de-control/eliminar/eliminar.component';
import { EntradasComponent } from './panel-de-control/entradas/entradas.component';
import { ModificarComponent } from './panel-de-control/modificar/modificar.component';
import { UsuariosComponent } from './panel-de-control/usuarios/usuarios.component';
import { VentasComponent } from './panel-de-control/ventas/ventas.component';
import { RegisterComponent } from './register/register/register.component';
import { HelpCenterModule } from './help-center/help-center.module';
import { ProductDetailComponent } from './product/product-detail/product-detail.component';
import { NavBarControlPanelComponent } from './panel-de-control/nav-bar-control-panel/nav-bar-control-panel.component';
import { FooterControlPanelComponent } from './panel-de-control/footer-control-panel/footer-control-panel.component';
import { RegisterModule } from './register/register.module';
import { LoginModule } from './login/login.module';
import { HttpClientModule, HttpClientXsrfModule} from '@angular/common/http';
import { CartModule } from './cart/cart.module';
import { CarritoService } from './services/carrito.service';
import { PagarCompraModule } from './pagar-compra/pagar-compra.module';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    HeaderComponent,
    HomeComponent,
    ContactComponent,
    AboutUsComponent,
    PanelDeControlComponent,
    AgregarComponent,
    CategoriasComponent,
    EliminarComponent,
    EntradasComponent,
    ModificarComponent,
    UsuariosComponent,
    VentasComponent,
    NavBarControlPanelComponent,
    FooterControlPanelComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RegisterModule,
    LoginModule,
    HttpClientModule,
    CartModule,
    HttpClientModule,
    PagarCompraModule,
  ],
  providers: [CarritoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
