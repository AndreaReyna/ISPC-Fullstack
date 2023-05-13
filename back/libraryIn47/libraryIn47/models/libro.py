from django.db import models
from .autor import Autor
from .idioma import Idioma
from .formato import Formato
from .editorial import Editorial
from .categoria import Categoria

class Libro(models.Model):
    id_libro = models.AutoField(primary_key=True)
    isbn = models.IntegerField()
    titulo = models.CharField(max_length=100)
    subtitulo = models.CharField(max_length=100, blank=True, null=True)
    paginas = models.IntegerField(blank=True, null=True)
    peso = models.IntegerField(blank=True, null=True)
    edicion = models.DateField(blank=True, null=True)
    resenia = models.CharField(max_length=1000, blank=True, null=True)
    precio = models.FloatField()
    stock = models.IntegerField()
    autor = models.ForeignKey(Autor, on_delete=models.DO_NOTHING)
    idioma = models.ForeignKey(Idioma, on_delete=models.DO_NOTHING)
    formato = models.ForeignKey(Formato, on_delete=models.DO_NOTHING)
    editorial = models.ForeignKey(Editorial, on_delete=models.DO_NOTHING)
    categoria = models.ForeignKey(Categoria, on_delete=models.DO_NOTHING)

    class Meta:
        db_table = 'libro'

    def __str__(self):
        return self.titulo