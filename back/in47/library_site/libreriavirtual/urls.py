#URLS APP

from django.urls import path, include
from .views import LoginView, LogoutView, SignupView, ProfileView, ComprarView, DetallePedidoView, PagosView
from rest_framework import routers
from libreriavirtual import views

# Api router
router = routers.DefaultRouter()

router.register(r'customuser',views.CustomUserViewSet)
router.register(r'direccion',views.DireccionViewSet)
router.register(r'provincia',views.ProvinciaViewSet)
router.register(r'localidad',views.LocalidadViewSet)
router.register(r'carrito',views.CarritoViewSet)
router.register(r'elementoscarrito',views.ElementosCarritoViewSet)
router.register(r'libro',views.LibroViewSet)
router.register(r'idioma',views.IdiomaViewSet)
router.register(r'categoria',views.CategoriaViewSet)
router.register(r'editorial',views.EditorialViewSet)
router.register(r'formato',views.FormatoViewSet)
router.register(r'autor',views.AutorViewSet)
#router.register(r'detallepedido',views.DetallePedidoViewSet)
router.register(r'pedido',views.PedidoViewSet)
router.register(r'orden',views.OrdenViewSet)
router.register(r'estado',views.EstadoViewSet)
router.register(r'pago',views.PagoViewSet)
router.register(r'admin_provincia',views.ProvinciaAdmin)
router.register(r'admin_direccion',views.DireccionAdmin)
router.register(r'admin_localidad',views.LocalidadAdmin)
router.register(r'admin_libro',views.LibroAdmin)
router.register(r'admin_idioma',views.IdiomaAdmin)
router.register(r'admin_categoria',views.CategoriaAdmin)
router.register(r'admin_editorial',views.EditorialAdmin)
router.register(r'admin_formato',views.FormatoAdmin)
router.register(r'admin_autor',views.AutorAdmin)
router.register(r'admin_detalle',views.DetallePedidoAdmin)
router.register(r'admin_pedido',views.PedidoAdmin)
router.register(r'admin_orden',views.OrdenAdmin)
router.register(r'admin_estado',views.EstadoAdmin)
router.register(r'admin_pago',views.PagoAdmin)
router.register(r'admin_carrito',views.CarritoAdmin)
router.register(r'admin_elementoscarrito',views.ElementosCarritoAdmin)
#router.register(r'comprar',views.ComprarView, basename='comprar')

urlpatterns = [
    
     path('', include(router.urls)),

    # views
     path('auth/login/',
         LoginView.as_view(), name='auth_login'),

     path('auth/logout/',
         LogoutView.as_view(), name='auth_logout'),
     
     path('auth/signup/',
          SignupView.as_view(), name='auth_signup'),
     
     path('profile/',
         ProfileView.as_view(), name='user_profile'),
    
     path('comprar/',
         ComprarView.as_view(), name='comprar'),

     path('detalle_pedido/',
         DetallePedidoView.as_view(), name='detalle_pedido'),
         
     path('pagos/',
         PagosView.as_view(), name='pagos'),
        
]

