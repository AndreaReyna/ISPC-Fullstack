from django.db import models
from .direccion import Direccion

class Cliente(models.Model):
    id_usuario = models.AutoField(primary_key=True)
    nombre = models.CharField(max_length=60)
    apellido = models.CharField(max_length=60)
    password = models.CharField(max_length=20)
    tipo_usuario = models.PositiveSmallIntegerField()  # 0 for user, 1 for admin
    email = models.EmailField(max_length=60)
    dni = models.CharField(max_length=8, blank=True, null=True)
    fecha_nac = models.DateField(blank=True, null=True)
    telefono = models.CharField(max_length=12, blank=True, null=True)
    direccion = models.ForeignKey(Direccion, on_delete=models.DO_NOTHING)

    class Meta:
        db_table = 'cliente'

    def __str__(self):
        return f'{self.nombre} {self.apellido} ({self.email})'