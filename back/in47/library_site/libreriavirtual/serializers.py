from rest_framework import serializers
from django.contrib.auth import get_user_model
from django.contrib.auth.hashers import make_password
from .models import *


def validate_password(self, value):
    return make_password(value)


class UserSerializer(serializers.ModelSerializer):
    email = serializers.EmailField(
        required=True)
    username = serializers.CharField(
        required=True)
    password = serializers.CharField(
        min_length=8)
    
    class Meta:
        model = get_user_model()
        #fields = ('email', 'username', 'password')
        fields='__all__'

class DireccionSerializer(serializers.ModelSerializer):

    class Meta:
        model= Direccion
        fields='__all__'

class ProvinciaSerializer(serializers.ModelSerializer):

    class Meta:
        model= Provincia
        fields='__all__'

class LocalidadSerializer(serializers.ModelSerializer):

    class Meta:
        model= Localidad
        fields='__all__'

class CarritoSerializer(serializers.ModelSerializer):

    class Meta:
        model= Carrito
        fields='__all__'

class ElementosCarritoSerializer(serializers.ModelSerializer):

    class Meta:
        model= ElementosCarrito
        fields='__all__'

class LibroSerializer(serializers.ModelSerializer):

    class Meta:
        model= Libro
        fields='__all__'

class IdiomaSerializer(serializers.ModelSerializer):

    class Meta:
        model= Idioma
        fields='__all__'

class CategoriaSerializer(serializers.ModelSerializer):

    class Meta:
        model= Categoria
        fields='__all__'

class EditorialSerializer(serializers.ModelSerializer):

    class Meta:
        model= Editorial
        fields='__all__'

class FormatoSerializer(serializers.ModelSerializer):

    class Meta:
        model= Formato
        fields='__all__'

class AutorSerializer(serializers.ModelSerializer):

    class Meta:
        model= Autor
        fields='__all__'

class DetallePedidoSerializer(serializers.ModelSerializer):

    class Meta:
        model= DetallePedido
        fields='__all__'

class PedidoSerializer(serializers.ModelSerializer):

    class Meta:
        model= Pedido
        fields='__all__'

class OrdenSerializer(serializers.ModelSerializer):

    class Meta:
        model= Orden
        fields='__all__'

class EstadoSerializer(serializers.ModelSerializer):

    class Meta:
        model= Estado
        fields='__all__'

class PagoSerializer(serializers.ModelSerializer):

    class Meta:
        model= Pago
        fields='__all__'
