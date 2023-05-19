from django.db import models
from models import SEGUIMIENTO_CHOICES

class Seguimiento(models.Model):
    id_seguimiento = models.AutoField(primary_key=True)
    estado = models.IntegerField(choices=SEGUIMIENTO_CHOICES)

    class Meta:
        db_table = 'seguimiento'

    def __str__(self):
        return self.get_estado_display()