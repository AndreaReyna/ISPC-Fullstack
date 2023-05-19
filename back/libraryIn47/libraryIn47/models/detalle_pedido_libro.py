from django.db import models
from .detalle_pedido import DetallePedido
from .libro import Libro

class DetallePedidoLibro(models.Model):
    detalle_pedido = models.ForeignKey(DetallePedido, models.DO_NOTHING, db_column='detalle_pedido_id_detalle_pedido')
    libro = models.ForeignKey(Libro, models.DO_NOTHING, db_column='libro_id_libro')

    class Meta:
        db_table = 'detalle_pedido_libro'
        unique_together = (('detalle_pedido', 'libro'),)

    def __str__(self):
        return f'{self.detalle_pedido_id} - {self.libro_id}'