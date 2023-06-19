import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactComponent } from './contact/contact/contact.component';
import { HomeComponent } from './home/home/home.component';
import { LoginComponent } from './login/login/login.component';
import { RegisterComponent } from './register/register/register.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { HelpComponent } from './help-center/help/help.component';
import { ProductDetailComponent } from './product/product-detail/product-detail.component';
import { UserComponent } from './user/user/user.component';
import { PanelDeControlComponent } from './panel-de-control/panel-de-control.component';
import { AgregarComponent } from './panel-de-control/agregar/agregar.component';
import { ModificarComponent } from './panel-de-control/modificar/modificar.component';
import { EliminarComponent } from './panel-de-control/eliminar/eliminar.component';
import { VentasComponent } from './panel-de-control/ventas/ventas.component';
import { CategoriasComponent } from './panel-de-control/categorias/categorias.component';
import { EntradasComponent } from './panel-de-control/entradas/entradas.component';
import { UsuariosComponent } from './panel-de-control/usuarios/usuarios.component';
import { CartComponent } from './cart/cart/cart.component';
import { EstadoCompraComponent } from './estado-compra/estado-compra/estado-compra.component';
import { FormularioPagoComponent } from './pagar-compra/formulario-pago/formulario-pago.component';


const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'home', component: HomeComponent},
  { path: 'contact', component: ContactComponent},
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'about-us', component: AboutUsComponent},
  { path: 'help', component: HelpComponent},
  { path: 'details', component: ProductDetailComponent},
  { path: 'user', component: UserComponent},
  { path: 'panelDeControl', component: PanelDeControlComponent},
  { path: 'agregarAdmin', component: AgregarComponent},
  { path: 'modificarAdmin', component: ModificarComponent},
  { path: 'eliminarAdmin', component: EliminarComponent},
  { path: 'estadoVentas', component: VentasComponent},
  { path: 'categoriasAdmin', component: CategoriasComponent},
  { path: 'entradasAdmin', component: EntradasComponent},
  { path: 'admin/usuarios', component: UsuariosComponent},
  { path: 'libro/:id', component: ProductDetailComponent},
  { path: 'cart', component: CartComponent},
  { path: 'purchase-status', component: EstadoCompraComponent},
  { path: 'pagar-compra', component: FormularioPagoComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
