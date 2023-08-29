import libro

class Novedades(libro):

    def __init__(self, id, esNovedad):
        self._id = id
        self._esNovedad = esNovedad

    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value):
        self._id = value

    @property
    def esNovedad(self):
        return self._esNovedad

    @esNovedad.setter
    def esNovedad(self, value):
        self._esNovedad = value

    def registrarNovedades(self):
        pass

    def filtrarNovedad(self):
        pass
    