import libro

class Ranking(libro):

    def __init__(self, id, esMasVendido):
        self._id = id
        self._esMasVendido = esMasVendido

    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value):
        self._id = value

    @property
    def esMasVendido(self):
        return self._esMasVendido

    @esMasVendido.setter
    def esMasVendido(self, value):
        self._esMasVendido = value

    def mostrarMasVendidos(self):
        pass

    def mostrarTopTen(self):
        pass
    