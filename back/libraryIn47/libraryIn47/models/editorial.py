from django.db import models

class Editorial(models.Model):
    id_editorial = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=45)

    class Meta:
        db_table = 'editorial'

    def __str__(self):
        return self.nombre