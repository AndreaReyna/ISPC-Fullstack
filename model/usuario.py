import persona
import rol

class Usuario(persona, rol):

    def __init__(self, id, datosAdicionales, rol):
        self._id = id
        self._datosAdicionales = datosAdicionales
        self._rol = rol

    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value):
        self._id = value

    @property
    def datosAdicionales(self):
        return self._datosAdicionales

    @datosAdicionales.setter
    def datosAdicionales(self, value):
        self._datosAdicionales = value

    @property
    def rol(self):
        return self._rol

    @rol.setter
    def rol(self, value):
        self._rol = value
    
    def agregarDatosAdicionales(self):
        pass
