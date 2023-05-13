from django.db import models

class Localidad(models.Model):
    id_localidad = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=45, unique=True)
    codigo_postal = models.CharField(max_length=45)

    class Meta:
        db_table = 'localidad'

    def __str__(self):
        return self.nombre