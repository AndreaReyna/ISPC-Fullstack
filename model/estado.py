
class Estado:

    def __init__(self, id, tipoEstado):
        self._id = id
        self._tipoEstado = tipoEstado
    
    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value):
        self._id = value

    @property
    def tipoEstado(self):
        return self._tipoEstado

    @tipoEstado.setter
    def tipoEstado(self, value):
        self._tipoEstado = value
    
    def mostrarEstado(self):
        pass
    