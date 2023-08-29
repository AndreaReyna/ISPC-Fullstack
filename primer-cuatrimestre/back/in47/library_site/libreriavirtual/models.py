from django.conf import settings
from django.utils.translation import gettext_lazy as _
from django.db import models
from django.contrib.auth.models import AbstractUser

# Create your models here.

class CustomUser(AbstractUser):

    email = models.EmailField(
        max_length=150,
        unique=True
    )   
    dni = models.CharField(
        max_length=8,
        help_text='Maximo 8 caracteres',
        null=True
        )
    fecha_nac = models.DateField(
        null=True
        )
    telefono = models.CharField(
        max_length=12,
        help_text='Maximo 12 caracteres',
        null=True
        )
    id_direccion = models.ForeignKey(
        'Direccion',
        to_field='id_direccion',
        on_delete=models.CASCADE,
        null=True
        )
    id_carrito = models.ForeignKey(
        'Carrito',
        on_delete=models.SET_NULL,
        null=True,
        related_name='customuser'
    )

    USERNAME_FIELD = 'email'
    REQUIRED_FIELDS = ['username', 'password']


class Direccion(models.Model):

    id_direccion = models.AutoField(
        primary_key=True,
        unique=True,
        db_index=True
        )
    calle_nro = models.CharField(
        max_length=100,
        help_text='Calle, numero, piso, departamento'
        )
    id_provincia = models.ForeignKey(
        'Provincia',
        to_field='id_provincia',
        null=False,
        on_delete=models.CASCADE
        )
    id_localidad = models.ForeignKey(
        'Localidad',
        to_field='id_localidad',
        null=False,
        on_delete=models.CASCADE
        )
    
    class Meta:
        db_table = 'direccion'
        verbose_name = ('Detalle Direccion')
        verbose_name_plural = ('Detalles de Direcciones')

    def __unicode__(self):
        return self.id_direccion
    
    def __str__(self):
        return self.calle_nro
    

class Provincia(models.Model):

    class Provincias(models.TextChoices):
        BUENOS_AIRES = 'BA',
        CATAMARCA = 'CT',
        CHACO = 'CH',
        CHUBUT = 'CB',
        CORDOBA = 'CD',
        CORRIENTES = 'CR',
        ENTRE_RIOS = 'ER',
        FORMOSA = 'FO',
        JUJUY = 'JY',
        LA_PAMPA = 'LP',
        LA_RIOJA = 'LR',
        MENDOZA = 'MZ',
        MISIONES = 'MN',
        NEUQUEN = 'NQ',
        RIO_NEGRO = 'RN',
        SALTA = 'SA',
        SAN_JUAN = 'SJ',
        SAN_LUIS = 'SL',
        SANTA_CRUZ = 'SC',
        SANTA_FE = 'SF',
        SANTIAGO_DEL_ESTERO = 'SE',
        TIERRA_DEL_FUEGO = 'TF',
        TUCUMAN = 'TM'

    id_provincia = models.AutoField(
        primary_key=True,
        unique=True,
        db_index=True
        )
    nombre = models.CharField(
        max_length=2,
        choices=Provincias.choices,
        default=Provincias.BUENOS_AIRES
        )

    class Meta:
        db_table = 'provincia'
        verbose_name = ('Nombre de Provincia')
        verbose_name_plural = ('Nombres de Provincias')

    def __unicode__(self):
        return self.id_provincia
    
    def __str__(self):
        return self.nombre
    

class Localidad(models.Model):

    id_localidad = models.AutoField(
        primary_key=True,
        unique=True,
        db_index=True
        )
    nombre = models.CharField(
        max_length=100,
        help_text='Maximo 100 caracteres'
        )
    codigo_postal = models.CharField(
        max_length=8,
        help_text='Codigo postal de 8 caracteres'
        )
    
    class Meta:
        db_table = 'localidad'
        verbose_name = ('Nombre de Localidad')
        verbose_name_plural = ('Nombres de Localidades')

    def __unicode__(self):
        return self.id_localidad
    
    def __str__(self):
        return self.nombre
    

class Carrito(models.Model):

    id_carrito = models.AutoField(
        primary_key=True,
        unique=True,
        db_index=True
        )
    fecha_creacion = models.DateTimeField(
        auto_now=True,
        db_comment= 'The field is only automatically updated when calling Model.save()'
        )

    class Meta:
        db_table = 'carrito'
        verbose_name = ('Id del Carrito')
        verbose_name_plural = ('Ids de los Carritos')

    def __unicode__(self):
        return self.id_carrito
    
    def __str__(self):
        return self.id_carrito
    

class ElementosCarrito(models.Model):

    id_elementos_carrito = models.AutoField(
        primary_key=True,
        unique=True,
        db_index=True
        )
    id_carrito = models.ForeignKey(
        'Carrito',
        to_field='id_carrito',
        on_delete=models.CASCADE
        )
    id_cliente = models.ForeignKey(
        settings.AUTH_USER_MODEL,
        to_field='id',
        on_delete=models.CASCADE
        )
    id_libro = models.ForeignKey(
        'Libro',
        to_field='id_libro',
        on_delete=models.CASCADE
        )
    cantidad = models.PositiveSmallIntegerField(
        )

    class Meta:
        db_table = 'elementos_carrito'
        verbose_name = ('Elemento del Carrito')
        verbose_name_plural = ('Elementos de los Carritos')

    def __unicode__(self):
        return self.id_elementos_carrito
    
    def __str__(self):
        return f'{self.cantidad} de \
            {self.id_libro} perteneciente a \
            {self.id_carrito} de usuario \
            {self.id_cliente}'
    

class Libro(models.Model):

    id_libro = models.AutoField(
        primary_key=True,
        unique=True,
        db_index=True
        )
    isbn = models.CharField(
        max_length=17,
        unique=True,
        help_text='Maximo 17 caracteres incluido guiones'
        )
    titulo = models.CharField(
        max_length=200,
        help_text='Maximo 200 caracteres'
        )
    subtitulo = models.CharField(
        max_length=200,
        help_text='Maximo 200 caracteres'
        )
    paginas = models.PositiveSmallIntegerField(
        )
    peso = models.DecimalField(
        max_digits=6,
        decimal_places=2
        )
    edicion = models.CharField(
        max_length=4,
        help_text='Anio de edicion'
        )
    resenia = models.CharField(
        max_length=1000,
        help_text='Maximo 1000 caracteres'
        )
    precio = models.DecimalField(
        max_digits=7,
        decimal_places=2
        )
    stock = models.PositiveSmallIntegerField(
        )
    img_url = models.URLField(
        max_length = 200,
        default='https://unrulyguides.com/wp-content/uploads/2011/12/generic-cover.jpg'
    )
    id_autor = models.ForeignKey(
        'Autor',
        to_field='id_autor',
        on_delete=models.CASCADE
        )
    id_idioma = models.ForeignKey(
        'Idioma',
        to_field='id_idioma',
        on_delete=models.CASCADE
        )
    id_formato = models.ForeignKey(
        'Formato',
        to_field='id_formato',
        on_delete=models.CASCADE
        )
    id_editorial = models.ForeignKey(
        'Editorial',
        to_field='id_editorial',
        on_delete=models.CASCADE
        )
    id_categoria = models.ForeignKey(
        'Categoria',
        to_field='id_categoria',
        on_delete=models.CASCADE
        )
    
    class Meta:
        db_table = 'libro'
        verbose_name = ('Libro')
        verbose_name_plural = ('Libros')

    def __unicode__(self):
        return self.id_libro
    
    def __str__(self):
        return f'{self.titulo} \
            formato {self.id_formato} \
            ISBN {self.isbn} \
            precio {self.precio}'


class Idioma(models.Model):
    
    class Idiomas(models.TextChoices):
            INGLES = 'EN',
            ESPANIOL = 'ES',
            FRANCES = 'FR',
            ITALIANO = 'IT',
            ALEMAN = 'DE',
            CHINO = 'ZH',
            JAPONES = 'JA',
            PORTUGUES = 'PT',
            RUSO = 'RU',
            ARABE = 'AR'

    id_idioma = models.AutoField(
        primary_key=True,
        unique=True,
        db_index=True
        )
    nombre = models.CharField(
        max_length=2,
        choices=Idiomas.choices,
        default=Idiomas.ESPANIOL
        )
    
    class Meta:
        db_table = 'idioma'
        verbose_name = ('Idioma')
        verbose_name_plural = ('Idiomas')

    def __unicode__(self):
        return self.id_idioma
    
    def __str__(self):
        return self.nombre
    

class Categoria(models.Model):

    id_categoria = models.AutoField(
        primary_key=True,
        unique=True,
        db_index=True
        )
    #Not an enum because you can add new categories anytime
    nombre = models.CharField(
        max_length=50,
        help_text='Maximo 50 caracteres'
        )
    
    class Meta:
        db_table = 'categoria'
        verbose_name = ('Categoria')
        verbose_name_plural = ('Categorias')

    def __unicode__(self):
        return self.id_categoria
    
    def __str__(self):
        return self.nombre
    

class Editorial(models.Model):

    id_editorial = models.AutoField(
        primary_key=True,
        unique=True,
        db_index=True
        )
    nombre = models.CharField(
        max_length=50,
        help_text='Maximo 50 caracteres'
        )
    
    class Meta:
        db_table = 'editorial'
        verbose_name = ('Editorial')
        verbose_name_plural = ('Editoriales')

    def __unicode__(self):
        return self.id_editorial
    
    def __str__(self):
        return self.nombre
    

class Formato(models.Model):

    id_formato = models.AutoField(
        primary_key=True,
        unique=True,
        db_index=True
        )
    #Not an enum because you can add new types of formats
    nombre = models.CharField(
        max_length=50,
        help_text='Maximo 50 caracteres'
        )
    
    class Meta:
        db_table = 'formato'
        verbose_name = ('Formato')
        verbose_name_plural = ('Formatos')

    def __unicode__(self):
        return self.id_formato
    
    def __str__(self):
        return self.nombre


class Autor(models.Model):

    id_autor = models.AutoField(
        primary_key=True,
        unique=True,
        db_index=True
        )
    nombre = models.CharField(
        max_length=50,
        help_text='Maximo 50 caracteres'
        )
    apellido = models.CharField(
        max_length=50,
        help_text='Maximo 50 caracteres'
        )
    
    class Meta:
        db_table = 'autor'
        verbose_name = ('Autor')
        verbose_name_plural = ('Autores')

    def __unicode__(self):
        return self.id_autor
    
    def __str__(self):
        return f'{self.nombre} \
            {self.apellido}'
    

class DetallePedido(models.Model):

    id_detalle_pedido = models.AutoField(
        primary_key=True,
        unique=True,
        db_index=True
        )
    cantidad = models.PositiveSmallIntegerField(
        )
    id_pedido = models.ForeignKey(
        'Pedido',
        to_field='id_pedido',
        on_delete=models.CASCADE
        )
    id_libro = models.ForeignKey(
        'Libro',
        to_field='id_libro',
        on_delete=models.CASCADE
        )
    
    class Meta:
        db_table = 'detalle_pedido'
        verbose_name = ('Detalle del Pedido')
        verbose_name_plural = ('Detalles de los Pedidos')

    def __unicode__(self):
        return self.id_detalle_pedido
    
    def __str__(self):
        return f'nro de pedido {self.id_pedido} \
            contiene {self.cantidad} \
            de producto {self.id_libro}'
    

class Pedido(models.Model):

    class Seguimientos(models.TextChoices):
            EN_CAMINO = 'CC',
            ARMANDO_PEDIDO = 'AA',
            ENTREGADO = 'EE',
            DEVOLUCION = 'DV'
            
    id_pedido = models.AutoField(
        primary_key=True,
        unique=True,
        db_index=True
        )
    seguimiento = models.CharField(
        max_length=2,
        choices=Seguimientos.choices,
        default=Seguimientos.ARMANDO_PEDIDO
        )
    id_cliente = models.ForeignKey(
        settings.AUTH_USER_MODEL,
        to_field='id',
        on_delete=models.CASCADE
        )
    fecha = models.DateTimeField(
        #Create date of Invoice
        auto_now_add=True,
        db_comment= 'The field is only automatically updated when calling Model.save()'
        )
    id_orden = models.ForeignKey(
        'Orden',
        to_field='id_orden',
        on_delete=models.CASCADE
        )
    nro_tracking = models.CharField(
        max_length=40,
        help_text='Maximo 40 caracteres'
        )
    
    class Meta:
        db_table = 'pedido'
        verbose_name = ('Pedido')
        verbose_name_plural = ('Pedidos')

    def __unicode__(self):
        return self.id_pedido
    
    def __str__(self):
        return f'nro de pedido {self.id_pedido} \
            estado {self.seguimiento} \
            tracking {self.nro_tracking}'
    

class Orden(models.Model):

    id_orden = models.AutoField(
        primary_key=True,
        unique=True,
        db_index=True
        )
    fecha_creacion = models.DateTimeField(
        #Create date of Quote
        auto_now_add=True,
        db_comment= 'The field is only automatically updated when calling Model.save()'
        )
    total = models.DecimalField(
        max_length=99999,
        decimal_places=2,
        max_digits=7
        )
    id_cliente = models.ForeignKey(
        settings.AUTH_USER_MODEL,
        to_field='id',
        on_delete=models.CASCADE
        )
    id_estado = models.ForeignKey(
        'Estado',
        to_field='id_estado',
        on_delete=models.CASCADE
        )
    
    class Meta:
        db_table = 'orden'
        verbose_name = ('Orden')
        verbose_name_plural = ('Ordenes')

    def __unicode__(self):
        return self.id_orden
    
    def __str__(self):
        return f'nro de orden {self.id_orden} \
            estado {self.id_estado} \
            total {self.total}'
    

class Estado(models.Model):

    class Estados(models.TextChoices):
            PAGADO = 'PP',
            RECHAZADO = 'RR',
            ESPERANDO_AUTORIZACION = 'AA'            
    
    id_estado = models.AutoField(
        primary_key=True,
        unique=True,
        db_index=True
        )
    estado = models.CharField(
        max_length=2,
        choices=Estados.choices,
        default=Estados.ESPERANDO_AUTORIZACION
        )
    
    class Meta:
        db_table = 'estado'
        verbose_name = ('Estado')
        verbose_name_plural = ('Estados')

    def __unicode__(self):
        return self.id_estado
    
    def __str__(self):
        return self.get_estado_display()


class Pago(models.Model):

    id_pago = models.AutoField(
        primary_key=True,
        unique=True,
        db_index=True
        )
    
    fecha_pago = models.DateTimeField(
        #Create date of payment
        auto_now_add=True,
        db_comment= 'The field is only automatically updated when calling Model.save()'
        )
    monto = models.DecimalField(
        max_length=99999,
        decimal_places=2,
        max_digits=7
        )
        #Save last 4 digits of credit card, etc
    info_adicional = models.CharField(
        max_length=200,
        help_text='Maximo 200 caracteres'
        )
    
    id_orden = models.ForeignKey(
        'Orden',
        to_field='id_orden',
        on_delete=models.CASCADE
        )
    
    class Meta:
        db_table = 'pago'
        verbose_name = ('Pago')
        verbose_name_plural = ('Pagos')

    def __unicode__(self):
        return self.id_pago
    
    def __str__(self):
        return f'registrado {self.fecha_pago} \
        monto {self.monto} \
        info {self.info_adicional}'
    

class Pagos(models.Model):

    id_pagos = models.AutoField(
        primary_key=True,
        unique=True,
        db_index=True
        )
    
    id_cliente = models.ForeignKey(
        settings.AUTH_USER_MODEL,
        to_field='id',
        on_delete=models.CASCADE
        )
    
    fecha_pago = models.DateTimeField(
        #Create date of payment
        auto_now_add=True,
        db_comment= 'The field is only automatically updated when calling Model.save()'
        )
    
    code = models.CharField(
        max_length=200,
        help_text='Maximo 200 caracteres'
        )
    
    dni = models.CharField(
        max_length=200,
        help_text='Maximo 200 caracteres'
        )
    
    email = models.CharField(
        max_length=200,
        help_text='Maximo 200 caracteres'
        )
    
    tarjeta = models.CharField(
        max_length=200,
        help_text='Maximo 200 caracteres'
        )
    
    titular = models.CharField(
        max_length=200,
        help_text='Maximo 200 caracteres'
        )
    
    vencimiento = models.CharField(
        max_length=200,
        help_text='Maximo 200 caracteres'
        )

    class Meta:
        db_table = 'pagos'
        verbose_name = ('Pagos')
        verbose_name_plural = ('Datos generales de Pagos')

    def __unicode__(self):
        return self.id_pagos