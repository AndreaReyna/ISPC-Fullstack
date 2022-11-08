import usuario

class DatosAdicionales(usuario):

    def __init__(self, id, genero, direccion, fechaNac):
        self._id = id
        self._genero = genero
        self._direccion = direccion
        self._fechaNac = fechaNac
    
    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value):
        self._id = value

    @property
    def genero(self):
        return self._genero

    @genero.setter
    def genero(self, value):
        self._genero = value

    @property
    def direccion(self):
        return self._direccion

    @direccion.setter
    def direccion(self, value):
        self._direccion = value

    @property
    def fechaNac(self):
        return self._fechaNac

    @fechaNac.setter
    def fechaNac(self, value):
        self._fechaNac = value

    def crearDatosAdicionales(self):
        pass

    def mostrarDatosAdicionales(self):
        pass

    def actualizarDatosAdicional(self):
        pass

    def eliminarDatosAdicional(self):
        pass
