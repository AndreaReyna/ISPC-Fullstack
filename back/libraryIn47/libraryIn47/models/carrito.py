from django.db import models
from .cliente import Cliente

class Carrito(models.Model):
    id_carrito = models.AutoField(primary_key=True)
    fecha_creacion = models.DateField(auto_now_add=True)
    cliente = models.ForeignKey(Cliente, on_delete=models.DO_NOTHING)

    class Meta:
        db_table = 'carrito'

    def __str__(self):
        return f"Carrito {self.id_carrito} de {self.cliente}"