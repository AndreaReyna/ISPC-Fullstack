import libro

class Idioma(libro):

    def __init__(self, id, nombreIdioma):
        self._id = id
        self._nombreIdioma = nombreIdioma

    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value):
        self._id = value

    @property
    def nombreIdioma(self):
        return self._nombreIdioma

    @nombreIdioma.setter
    def nombreIdioma(self, value):
        self._nombreIdioma = value

    def cargarIdioma(self):
        pass

    def actualizarIdioma(self):
        pass

    def mostrarIdioma(self):
        pass

    def eliminarIdioma(self):
        pass
    