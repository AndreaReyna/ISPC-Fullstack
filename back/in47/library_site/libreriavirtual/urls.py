#URLS APP

from django.urls import path, include
from .views import LoginView, LogoutView, SignupView
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
router.register(r'detallepedido',views.DetallePedidoViewSet)
router.register(r'pedido',views.PedidoViewSet)
router.register(r'orden',views.OrdenViewSet)
router.register(r'estado',views.EstadoViewSet)
router.register(r'pago',views.PagoViewSet)

urlpatterns = [
    
    path('', include(router.urls)),

    # Auth views
    path('auth/login/',
         LoginView.as_view(), name='auth_login'),

    path('auth/logout/',
         LogoutView.as_view(), name='auth_logout'),
     
    path('auth/signup/',
          SignupView.as_view(), name='auth_signup'),
]