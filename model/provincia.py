from turtle import RawTurtle
import direccion

class Provincia(direccion):

    def __init__(self, id, nombreProvincia):
        self._id = id
        self._nombreProvincia = nombreProvincia

    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value):
        self._id = value

    @property
    def nombreProvincia(self):
        return self._nombreProvincia

    @nombreProvincia.setter
    def nombreProvincia(self, value):
        self._nombreProvincia = value
    
    def registrarProvincia(self):
        pass

    def modificarProvincia(self):
        pass

    def eliminarProvincia(self):
        pass
    