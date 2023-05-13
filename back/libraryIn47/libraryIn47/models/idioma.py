from django.db import models
from .enum_categoria import IDIOMA_CHOICES


class Idioma(models.Model):
    id_idioma = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=2, choices=IDIOMA_CHOICES)

    class Meta:
        db_table = 'idioma'

    def __str__(self):
        return self.get_nombre_display()