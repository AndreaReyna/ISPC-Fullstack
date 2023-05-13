from django.db import models
from .carrito import Carrito
from .libro import Libro

class ElementosCarrito(models.Model):
    id_elementos_carrito = models.AutoField(primary_key=True)
    carrito = models.ForeignKey(Carrito, on_delete=models.DO_NOTHING)
    libro = models.ForeignKey(Libro, on_delete=models.DO_NOTHING)
    cantidad = models.IntegerField(null=True)

    class Meta:
        db_table = 'elementos_carrito'

    def __str__(self):
        return f"{self.cantidad} de {self.libro} en carrito {self.carrito}"