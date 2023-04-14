import libro
import pais

class Editorial(libro, pais):

    def __init__(self, id, nombre, pais):
        self._id = id
        self._nombre = nombre
        self._pais = pais

    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value):
        self._id = value

    @property
    def nombre(self):
        return self._nombre
    
    @nombre.setter
    def nombre(self, value):
        self._nombre = value
   
    def crearEditorial(self):
        pass

    def mostrarEditorial(self):
        pass

    def mostrarEditoriales(self):
        pass

    def actualizarEditorial(self):
        pass

    def eliminarEditorial(self):
        pass
    