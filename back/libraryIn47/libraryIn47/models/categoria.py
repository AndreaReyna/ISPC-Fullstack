from django.db import models
from .enum_categoria import CATEGORIA_CHOICES


class Categoria(models.Model):
    id_categoria = models.AutoField(primary_key=True)
    tipo = models.CharField(max_length=3, choices=CATEGORIA_CHOICES)

    class Meta:
        db_table = 'categoria'

    def __str__(self):
        return self.get_tipo_display()