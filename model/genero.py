import datosadicionales

class Genero(datosadicionales):

    def __init__(self, id, tipoGenero):
        self._id = id
        self._tipoGenero = tipoGenero

    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value):
        self._id = value

    @property
    def tipoGenero(self):
        return self._tipoGenero

    @tipoGenero.setter
    def tipoGenero(self, value):
        self._tipoGenero = value
    
    def crearGenero(self):
        pass

    def modificarGenero(self):
        pass

    def eliminarGenero(self):
        pass

    def promedioDeVentasPorGenero(self):
        pass

    def mostrarGeneros(self):
        pass
    