from rest_framework import serializers
from django.contrib.auth import get_user_model
from django.contrib.auth.hashers import make_password
from .models import *
from rest_framework.exceptions import AuthenticationFailed


class UserSerializer(serializers.ModelSerializer):
    email = serializers.EmailField(
        required=True)
    username = serializers.CharField(
        required=True)
    password = serializers.CharField(
        min_length=8)

    def validate_password(self, value):
        return make_password(value)


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

class EstadoSerializer(serializers.ModelSerializer):

    class Meta:
        model= Estado
        fields='__all__'

class PagoSerializer(serializers.ModelSerializer):

    class Meta:
        model= Pago
        fields='__all__'


#
# Serializador completo para recibir todos los datos de la compra /
# y poder distribuir en varios modelos a la vez
# 


class ElementosSerializer(serializers.ModelSerializer):
    id_libro = serializers.PrimaryKeyRelatedField(queryset=Libro.objects.all(), source='id_libro.id_libro')
    cantidad = serializers.IntegerField()

    class Meta:
        model = ElementosCarrito
        fields = ['id_elementos_carrito', 'id_carrito', 'id_cliente', 'id_libro', 'cantidad']

    def create(self, validated_data):
        
        # Obtener el usuario autenticado
        user = self.context['request'].user
        if user.is_authenticated:
            # Obtener el carrito asociado al usuario
            carrito = user.id_carrito
            # Agregar los IDs del usuario y el carrito a los datos validados
            validated_data['id_carrito'] = carrito.id_carrito
            validated_data['id_cliente'] = user.id
            return ElementosCarrito.objects.create(**validated_data)    
        else:
            raise AuthenticationFailed("El usuario no está autenticado")

class OrdenSerializer(serializers.ModelSerializer):
    precioTotal = serializers.DecimalField(decimal_places=2, max_digits=7, write_only=True)

    class Meta:
        model = Orden
        fields = ['id_orden', 'fecha_creacion', 'total', 'id_cliente', 'id_estado', 'precioTotal']

    def create(self, validated_data):
        # Obtener el usuario autenticado
        user = self.context['request'].user
        if user.is_authenticated:
            # Obtener el carrito asociado al usuario
            carrito = user.id_carrito
            # Agregar los IDs del usuario y el carrito a los datos validados
            validated_data['id_cliente'] = user.id
            precio_total = validated_data.pop('precioTotal', None)
            orden = Orden.objects.create(total=precio_total, id_carrito=carrito, **validated_data)
            return orden
        else:
            raise AuthenticationFailed("El usuario no está autenticado")