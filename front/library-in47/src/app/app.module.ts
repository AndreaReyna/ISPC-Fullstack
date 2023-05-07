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
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './register/register/register.component';
import { HelpCenterModule } from './help-center/help-center.module';
import { ProductDetailComponent } from './product/product-detail/product-detail.component';
import { NavBarControlPanelComponent } from './panel-de-control/nav-bar-control-panel/nav-bar-control-panel.component';
import { FooterControlPanelComponent } from './panel-de-control/footer-control-panel/footer-control-panel.component';

const routes: Routes = [
  {
    path: 'home',
    component: AppComponent
  },
  {
    path: 'panelDeControl',
    component: PanelDeControlComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'about-us',
    component: AboutUsComponent
  },
  {
    path: 'contact',
    component: ContactComponent
  },
  {
    path: 'help',
    component: HelpCenterModule
  },
  {
    path: 'product',
    component: ProductDetailComponent
  },
  {
    path: 'agregarAdmin',
    component: AgregarComponent
  },
  {
    path: 'modificarAdmin',
    component: ModificarComponent
  },
  {
    path: 'eliminarAdmin',
    component: EliminarComponent
  },
  {
    path: 'estadoVentas',
    component: VentasComponent
  },
  {
    path: 'categoriasAdmin',
    component: CategoriasComponent
  },
  {
    path: 'usuarios',
    component: UsuariosComponent
  },
  {
    path: 'entradasAdmin',
    component: EntradasComponent
  },
];

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
    RouterModule.forRoot(routes)

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
