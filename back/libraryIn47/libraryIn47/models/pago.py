from django.db import models
from .orden import Orden

class Pago(models.Model):
    id_pago = models.AutoField(primary_key=True)
    fecha = models.DateField()
    monto = models.FloatField()
    info_adic = models.CharField(max_length=45, comment='almacena los 4 ultimos digitos del medio de pago')
    orden = models.ForeignKey(Orden, models.DO_NOTHING, db_column='orden_id_orden')

    class Meta:
        db_table = 'pago'

    def __str__(self):
        return str(self.id_pago)