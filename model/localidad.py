from multiprocessing import set_forkserver_preload
import direccion

class Localidad(direccion):

    def __init__(self, id, nombreLocalidad, codigoPostal):
        self._id = id
        self._nombreLocalidad = nombreLocalidad
        self._codigoPostal = codigoPostal

    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value):
        self._id = value

    @property
    def nombreLocalidad(self):
        return self._nombreLocalidad

    @nombreLocalidad.setter
    def nombreLocalidad(self, value):
        self._nombreLocalidad = value

    @property
    def codigoPostal(self):
        return self._codigoPostal

    @codigoPostal.setter
    def codigoPostal(self, value):
        self._codigoPostal = value

    def registrarLocalidad(self):
        pass

    def modificarLocalidad(self):
        pass

    def eliminarLocalidad(self):
        pass
    