from django.contrib import admin
from django.contrib.auth.admin import UserAdmin
from .models import *
from django.contrib.auth import get_user_model

@admin.register(get_user_model())
class CustomUserAdmin(UserAdmin):
    pass

# Register your models here.

class ClienteAdmin(admin.ModelAdmin):
    list_display = ('id_cliente', 'nombre', 'apellido', \
                    'password', 'email', 'dni', 'fecha_nac', \
                    'telefono', 'id_direccion')

class DireccionAdmin(admin.ModelAdmin):
    list_display = ('id_direccion', 'calle_nro', 'id_provincia', \
                    'id_localidad')
    
class ProvinciaAdmin(admin.ModelAdmin):
    list_display = ('id_provincia', 'nombre')

class LocalidadAdmin(admin.ModelAdmin):
    list_display = ('id_localidad', 'nombre', 'codigo_postal')

class CarritoAdmin(admin.ModelAdmin):
    list_display = ('id_carrito', 'fecha_creacion')

class ElementosCarritoAdmin(admin.ModelAdmin):
    list_display = ('id_elementos_carrito', 'id_carrito', 'id_libro', \
                    'cantidad')
    
class LibroAdmin(admin.ModelAdmin):
    list_display = ('id_libro', 'isbn', 'titulo', 'subtitulo', \
                    'paginas', 'peso', 'edicion', 'resenia', \
                    'precio', 'stock', 'id_autor', 'id_idioma', \
                    'id_formato', 'id_editorial', 'id_categoria')

class IdiomaAdmin(admin.ModelAdmin):
    list_display = ('id_idioma', 'nombre')

class CategoriaAdmin(admin.ModelAdmin):
    list_display = ('id_categoria', 'nombre')

class EditorialAdmin(admin.ModelAdmin):
    list_display = ('id_editorial', 'nombre')

class FormatoAdmin(admin.ModelAdmin):
    list_display = ('id_formato', 'nombre')

class AutorAdmin(admin.ModelAdmin):
    list_display = ('id_autor', 'nombre', 'apellido')

class DetallePedidoAdmin(admin.ModelAdmin):
    list_display = ('id_detalle_pedido', 'cantidad', 'id_pedido', \
                    'id_libro')
    
class PedidoAdmin(admin.ModelAdmin):
    list_display = ('id_pedido', 'seguimiento', 'id_cliente', \
                    'fecha', 'id_orden', 'nro_tracking')

class OrdenAdmin(admin.ModelAdmin):
    list_display = ('id_orden', 'fecha_creacion', 'total', \
                    'id_cliente', 'id_estado')
    
class EstadoAdmin(admin.ModelAdmin):
    list_display = ('id_estado', 'estado')

class PagoAdmin(admin.ModelAdmin):
    list_display = ('id_pago', 'fecha_pago', 'monto', \
                    'info_adicional', 'id_orden')


admin.site.register(Direccion,DireccionAdmin)
admin.site.register(Provincia,ProvinciaAdmin)
admin.site.register(Localidad,LocalidadAdmin)
admin.site.register(Carrito,CarritoAdmin)
admin.site.register(ElementosCarrito,ElementosCarritoAdmin)
admin.site.register(Libro,LibroAdmin)
admin.site.register(Idioma,IdiomaAdmin)
admin.site.register(Categoria,CategoriaAdmin)
admin.site.register(Editorial,EditorialAdmin)
admin.site.register(Formato,FormatoAdmin)
admin.site.register(Autor,AutorAdmin)
admin.site.register(DetallePedido,DetallePedidoAdmin)
admin.site.register(Pedido,PedidoAdmin)
admin.site.register(Orden,OrdenAdmin)
admin.site.register(Estado,EstadoAdmin)
admin.site.register(Pago,PagoAdmin)
