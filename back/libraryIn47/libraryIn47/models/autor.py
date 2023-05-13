from django.db import models

class Autor(models.Model):
    id_autor = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=45)
    apellido = models.CharField(max_length=45)

    class Meta:
        db_table = 'autor'

    def __str__(self):
        return f'{self.nombre} {self.apellido}'