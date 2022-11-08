import libro

class Pais(libro):

    def __init__(self, id, nombrePais):
        self._id = id
        self._nombrePais = nombrePais

    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value):
        self._id = value

    @property
    def nombrePais(self):
        return self._nombrePais

    @nombrePais.setter
    def nombrePais(self, value):
        self._nombrePais = value

    def crearPais(self):
        pass

    def actualizarPais(self):
        pass

    def eliminiarPais(self):
        pass

    def mostrarPaisPorId(self):
        pass

    def mostrarPaises(self):
        pass
    