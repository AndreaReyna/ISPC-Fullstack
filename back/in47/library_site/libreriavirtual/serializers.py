from rest_framework import serializers
from django.contrib.auth import get_user_model
from django.contrib.auth.hashers import make_password
from .models import *
from rest_framework.exceptions import AuthenticationFailed
from rest_framework.serializers import ValidationError


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
        fields=['cantidad', 'id_pedido', 'id_libro']

class PedidoSerializer(serializers.ModelSerializer):

    class Meta:
        model= Pedido
        fields = ['id_cliente', 'nro_tracking', 'id_orden']

class EstadoSerializer(serializers.ModelSerializer):

    class Meta:
        model= Estado
        fields='__all__'

class PagoSerializer(serializers.ModelSerializer):

    class Meta:
        model= Pago
        fields = ['monto', 'info_adicional', 'id_orden']


#
# Serializador completo para recibir todos los datos de la compra /
# y poder distribuir en varios modelos a la vez
# 

class PagosSerializer(serializers.ModelSerializer):
        id_cliente = serializers.ReadOnlyField(source='context["request"].session.get("id_cliente")')

        class Meta:
            model = Pagos
            fields = ['id_cliente', 'code', 'dni', 'email', 'tarjeta', 'titular', 'vencimiento']


class ElementosSerializer(serializers.Serializer):
    libro = serializers.DictField()
    cantidad = serializers.IntegerField()

    def create(self, validated_data):
        libro_data = validated_data['libro']
        libro_instance = Libro.objects.get(id_libro=libro_data['id_libro'])
        elemento = ElementosCarrito.objects.create(libro=libro_instance, cantidad=validated_data['cantidad'])
        return elemento


class OrdenSerializer(serializers.ModelSerializer):
    elementos = serializers.ListField(child=ElementosSerializer(), read_only=True)
    precioTotal = serializers.DecimalField(decimal_places=2, max_digits=7, write_only=True)
    id_cliente = serializers.PrimaryKeyRelatedField(read_only=True)
    id_estado = serializers.PrimaryKeyRelatedField(read_only=True)
    total = serializers.DecimalField(decimal_places=2, max_digits=7, read_only=True)

    class Meta:
        model = Orden
        fields = ['id_orden', 'fecha_creacion', 'total', 'id_cliente', 'id_estado', 'elementos', 'precioTotal']
        extra_kwargs = {
            'total': {'write_only': True},
        }