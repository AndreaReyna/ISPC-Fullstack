from django.db import models
from .pedido import Pedido

class DetallePedido(models.Model):
    id_detalle_pedido = models.AutoField(primary_key=True)
    cantidad = models.CharField(max_length=45, null=True)
    pedido = models.ForeignKey(Pedido, models.DO_NOTHING, db_column='pedido_id_pedido')

    class Meta:
        db_table = 'detalle_pedido'

    def __str__(self):
        return str(self.id_detalle_pedido)