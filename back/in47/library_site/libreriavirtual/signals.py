from django.db.models.signals import post_migrate
from django.dispatch import receiver
from django.apps import apps

@receiver(post_migrate)
def inicializar_estados(sender, **kwargs):
    if sender.name == 'libreriavirtual':
        Estado = apps.get_model('libreriavirtual', 'Estado')
        estados = [
            Estado(estado=Estado.Estados.PAGADO),
            Estado(estado=Estado.Estados.RECHAZADO),
            Estado(estado=Estado.Estados.ESPERANDO_AUTORIZACION),
        ]
        Estado.objects.bulk_create(estados)

@receiver(post_migrate)
def inicializar_idiomas(sender, **kwargs):
    if sender.name == 'libreriavirtual':
        Idioma = apps.get_model('libreriavirtual', 'Idioma')
        idiomas = [choice[0] for choice in Idioma.Idiomas.choices]
        for idioma in idiomas:
            Idioma.objects.get_or_create(nombre=idioma)

@receiver(post_migrate)
def inicializar_provincinas(sender, **kwargs):
    if sender.name == 'libreriavirtual':
        Provincia = apps.get_model('libreriavirtual', 'Provincia')
        provincias = [choice[0] for choice in Provincia.Provincias.choices]
        for provincia in provincias:
            Provincia.objects.get_or_create(nombre=provincia)