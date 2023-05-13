from django.db import models
from .enum_categoria import ESTADO_CHOICES


class Estado(models.Model):
    id_estado = models.AutoField(primary_key=True)
    estado = models.CharField(max_length=2, choices=ESTADO_CHOICES)

    class Meta:
        db_table = 'estado'

    def __str__(self):
        return self.get_nombre_display()