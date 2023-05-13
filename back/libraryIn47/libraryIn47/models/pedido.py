from django.db import models
from .cliente import Cliente
from .orden import Orden
from .seguimiento import Seguimiento

class Pedido(models.Model):
    id_pedido = models.AutoField(primary_key=True)
    nro_seguimiento = models.CharField(max_length=45, unique=True, null=True)
    cliente = models.ForeignKey(Cliente, models.DO_NOTHING, db_column='cliente_id_usuario')
    fecha = models.DateField(null=True)
    orden = models.ForeignKey(Orden, models.DO_NOTHING, db_column='orden_id_orden')
    seguimiento = models.ForeignKey(Seguimiento, models.DO_NOTHING, db_column='seguimiento_id_seguimiento')

    class Meta:
        db_table = 'pedido'
        unique_together = (('nro_seguimiento',),)

    def __str__(self):
        return str(self.id_pedido)