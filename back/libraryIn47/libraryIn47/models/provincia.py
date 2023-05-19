from django.db import models

class Provincia(models.Model):
    id_provincia = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=45, unique=True)

    class Meta:
        db_table = 'provincia'

    def __str__(self):
        return self.nombre 