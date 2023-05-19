from django.db import models
from .provincia import Provincia
from .localidad import Localidad

class Direccion(models.Model):
    id_direccion = models.AutoField(primary_key=True)
    calle_nro = models.CharField(max_length=100)
    provincia = models.ForeignKey(Provincia, on_delete=models.DO_NOTHING)
    localidad = models.ForeignKey(Localidad, on_delete=models.DO_NOTHING)
   
    class Meta:
        db_table = 'direccion'

    def __str__(self):
        return f'{self.calle_nro}, {self.localidad}, {self.provincia}'