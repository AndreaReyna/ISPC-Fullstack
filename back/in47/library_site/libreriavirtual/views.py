from django.shortcuts import render
from django.contrib.auth import authenticate, login, logout
from rest_framework import status, generics, viewsets
from rest_framework.response import Response
from rest_framework.views import APIView
from rest_framework.permissions import IsAdminUser, AllowAny, IsAuthenticated
from .serializers import *
from .models import *

# Create your views here.

class SignupView(generics.CreateAPIView):
    permission_classes = [AllowAny]
    serializer_class = UserSerializer

class LoginView(APIView):
    permission_classes = [AllowAny]
    def post(self, request): #def post(request): usa HTTP POST
        # Recuperamos las credenciales y autenticamos al usuario
        email = request.data.get('email', None)
        password = request.data.get('password', None)
        # user guarda un objeto User con las credenciales validas
        user = authenticate(request, email=email, password=password) #se le agrego REQUEST. Si no funciona, borrar!

        # Si es correcto aniadimos a la request la informacion de sesion
        if user:
            login(request, user)
            
            # Verificar si el usuario ya tiene un carrito asociado
            if not user.id_carrito:
                # Si no tiene un carrito, crear uno nuevo y asociarlo al usuario
                carrito = Carrito.objects.create()
                user.id_carrito = carrito
                user.save()
                
            return Response(
                UserSerializer(user).data,
                status=status.HTTP_200_OK)
        
        # Si no es correcto devolvemos un error en la peticion
        return Response(
            status=status.HTTP_404_NOT_FOUND)
        

class LogoutView(APIView):
    permission_classes = [AllowAny]
    def post(self, request):
        # Borramos de la request la informacion de sesion
        logout(request)

        # Devolvemos la respuesta al cliente
        return Response(status=status.HTTP_200_OK)
    
class CustomUserViewSet(viewsets.ModelViewSet):
    permission_classes = [IsAdminUser]
    queryset = CustomUser.objects.all()
    serializer_class = UserSerializer
    def list(self, request):
        queryset = self.get_queryset()
        serializer = UserSerializer(queryset, many=True)
        if self.request.user.is_authenticated:
            return Response(serializer.data)

#Perfil de usuarios
class ProfileView(generics.RetrieveUpdateAPIView):
    permission_classes = [IsAuthenticated] #Solo usuario logueado puede ver.
    serializer_class = UserSerializer
    http_method_names = ['get', 'patch']
    def get_object(self):
        if self.request.user.is_authenticated:
            return self.request.user

#endopoint para comprar
class ComprarView(APIView):
    def post(self, request):
        elementos_serializer = ElementosSerializer(data=request.data.get('elementos', []), many=True, context={'request': request})
        orden_serializer = OrdenSerializer(data={
            'total': request.data.get('precioTotal'),
            'id_cliente': request.user.id,
        }, context={'request': request})

        if elementos_serializer.is_valid() and orden_serializer.is_valid():
            elementos = elementos_serializer.save()
            orden = orden_serializer.save()
            return Response({'elementos': elementos_serializer.data, 'orden': orden_serializer.data}, status=status.HTTP_201_CREATED)

        errors = {}
        if not elementos_serializer.is_valid():
            errors['elementos'] = elementos_serializer.errors
        if not orden_serializer.is_valid():
            errors['orden'] = orden_serializer.errors

        return Response(errors, status=status.HTTP_400_BAD_REQUEST)


########################################################################

class DireccionViewSet(viewsets.ModelViewSet):  #direccion editable por usuario logueado
    permission_classes = [IsAuthenticated]
    queryset = Direccion.objects.all()
    serializer_class = DireccionSerializer

class DireccionAdmin(viewsets.ModelViewSet):    #direccion editable
    permission_classes = [IsAdminUser]
    queryset = Direccion.objects.all()
    serializer_class = DireccionSerializer
   
class ProvinciaViewSet(viewsets.ReadOnlyModelViewSet):  #provincia solo vista. Llenar antes de opciones.
    permission_classes = [AllowAny]
    queryset = Provincia.objects.all()
    serializer_class = ProvinciaSerializer

class ProvinciaAdmin(viewsets.ModelViewSet):    #provincia editable
    permission_classes = [IsAdminUser]
    queryset = Provincia.objects.all()
    serializer_class = ProvinciaSerializer

class LocalidadViewSet(viewsets.ReadOnlyModelViewSet):  #localidad solo vista. Llenar antes de opciones.
    permission_classes = [AllowAny]
    queryset = Localidad.objects.all()
    serializer_class = LocalidadSerializer

class LocalidadAdmin(viewsets.ModelViewSet):    #localidad editable
    permission_classes = [IsAdminUser]
    queryset = Localidad.objects.all()
    serializer_class = LocalidadSerializer

class CarritoViewSet(viewsets.ModelViewSet):    #carrito editable por usuario logueado
    permission_classes = [IsAuthenticated]
    queryset = Carrito.objects.all()
    serializer_class = CarritoSerializer

class CarritoAdmin(viewsets.ModelViewSet): #carrito editable
    permission_classes = [IsAdminUser]
    queryset = Carrito.objects.all()
    serializer_class = CarritoSerializer

class ElementosCarritoViewSet(viewsets.ModelViewSet):   #elementos carrito editable por usuario logueado
    permission_classes = [IsAuthenticated]
    queryset = ElementosCarrito.objects.all()
    serializer_class = ElementosCarritoSerializer

class ElementosCarritoAdmin(viewsets.ModelViewSet): #elementos carrito editable
    permission_classes = [IsAdminUser]
    queryset = ElementosCarrito.objects.all()
    serializer_class = ElementosCarritoSerializer

class LibroViewSet(viewsets.ReadOnlyModelViewSet):  #libro solo vista
    permission_classes = [AllowAny]
    queryset = Libro.objects.all()
    serializer_class = LibroSerializer

class LibroAdmin(viewsets.ModelViewSet):    #libro editable
    permission_classes = [IsAdminUser]
    queryset = Libro.objects.all()
    serializer_class = LibroSerializer

class IdiomaViewSet(viewsets.ReadOnlyModelViewSet): #idioma solo vista
    permission_classes = [AllowAny]
    queryset = Idioma.objects.all()
    serializer_class = IdiomaSerializer

class IdiomaAdmin(viewsets.ModelViewSet):   #idioma editable
    permission_classes = [IsAdminUser]
    queryset = Idioma.objects.all()
    serializer_class = IdiomaSerializer

class CategoriaViewSet(viewsets.ReadOnlyModelViewSet):  #categoria solo vista
    permission_classes = [AllowAny]
    queryset = Categoria.objects.all()
    serializer_class = CategoriaSerializer

class CategoriaAdmin(viewsets.ModelViewSet):    #categoria editable
    permission_classes = [IsAdminUser]
    queryset = Categoria.objects.all()
    serializer_class = CategoriaSerializer

class EditorialViewSet(viewsets.ReadOnlyModelViewSet): #editorial solo vista
    permission_classes = [AllowAny]
    queryset = Editorial.objects.all()
    serializer_class = EditorialSerializer

class EditorialAdmin(viewsets.ModelViewSet):    #editorial editable
    permission_classes = [IsAdminUser]
    queryset = Editorial.objects.all()
    serializer_class = EditorialSerializer

class FormatoViewSet(viewsets.ReadOnlyModelViewSet):    #formato solo vista
    permission_classes = [AllowAny]
    queryset = Formato.objects.all()
    serializer_class = FormatoSerializer

class FormatoAdmin(viewsets.ModelViewSet):  #formato editable
    permission_classes = [IsAdminUser]
    queryset = Formato.objects.all()
    serializer_class = FormatoSerializer

class AutorViewSet(viewsets.ReadOnlyModelViewSet):  #autor solo vista
    permission_classes = [AllowAny]
    queryset = Autor.objects.all()
    serializer_class = AutorSerializer

class AutorAdmin(viewsets.ModelViewSet):    #autor editable
    permission_classes = [IsAdminUser]
    queryset = Autor.objects.all()
    serializer_class = AutorSerializer

class DetallePedidoAdmin(viewsets.ModelViewSet):  #detalle editable
    permission_classes = [IsAdminUser]
    queryset = DetallePedido.objects.all()
    serializer_class = DetallePedidoSerializer

class DetallePedidoViewSet(viewsets.ModelViewSet):  #detalle editable por usuario logueado
    permission_classes = [IsAuthenticated]
    queryset = DetallePedido.objects.all()
    serializer_class = DetallePedidoSerializer

class PedidoAdmin(viewsets.ModelViewSet): #pedido editable
    permission_classes = [IsAdminUser]
    queryset = Pedido.objects.all()
    serializer_class = PedidoSerializer

class PedidoViewSet(viewsets.ModelViewSet): #pedido editable por usuario logueado
    permission_classes = [IsAuthenticated]
    queryset = Pedido.objects.all()
    serializer_class = PedidoSerializer

class OrdenAdmin(viewsets.ModelViewSet):    #orden editable
    permission_classes = [IsAdminUser]
    queryset = Orden.objects.all()
    serializer_class = OrdenSerializer

class OrdenViewSet(viewsets.ModelViewSet):  #orden editable por usuario logueado  
    permission_classes = [IsAuthenticated]
    queryset = Orden.objects.all()
    serializer_class = OrdenSerializer

class EstadoViewSet(viewsets.ReadOnlyModelViewSet): #estado solo vista. Llenar los estados antes
    permission_classes = [IsAuthenticated]
    queryset = Estado.objects.all()
    serializer_class = EstadoSerializer

class EstadoAdmin(viewsets.ModelViewSet):   #estado editable
    permission_classes = [IsAdminUser]
    queryset = Estado.objects.all()
    serializer_class = EstadoSerializer

class PagoAdmin(viewsets.ModelViewSet): #pago editable por usuario logueado
    permission_classes = [IsAuthenticated]
    queryset = Pago.objects.all()
    serializer_class = PagoSerializer

class PagoViewSet(viewsets.ModelViewSet):   #pago editable
    permission_classes = [IsAdminUser]
    queryset = Pago.objects.all()
    serializer_class = PagoSerializer
