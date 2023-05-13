from django.db import models
from .cliente import Cliente
from .estado import Estado

class Orden(models.Model):
    id_orden = models.AutoField(primary_key=True)
    fecha_creacion = models.DateField(null=True)
    total = models.FloatField(null=True)
    cliente = models.ForeignKey(Cliente, on_delete=models.DO_NOTHING)
    estado = models.ForeignKey(Estado, on_delete=models.DO_NOTHING)

    class Meta:
        db_table = 'orden'

    def __str__(self):
        return f"Orden {self.id_orden} de {self.cliente}"