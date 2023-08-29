from django.apps import AppConfig
from . import signals

class LibreriavirtualConfig(AppConfig):
    default_auto_field = "django.db.models.BigAutoField"
    name = "libreriavirtual"

    def ready(self):
        # Importa las señales de tu aplicación
        import libreriavirtual.signals
