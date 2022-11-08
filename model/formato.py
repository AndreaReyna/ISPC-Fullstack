import libro

class Formato(libro):

    def __init__(self, id, tipoFormato):
        self._id = id
        self._tipoFormato = tipoFormato

    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value):
        self._id = value

    @property
    def tipoFormato(self):
        return self._tipoFormato

    @tipoFormato.setter
    def tipoFormato(self, value):
        self._tipoFormato = value

    def mostrarFormato(self):
        pass

    def ocultarFormato(self):
        pass
    