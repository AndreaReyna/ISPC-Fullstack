import libro
import pais

class Autor(libro, pais):

    def __init__(self, id, nombre, apellido, pais):
        self._id = id
        self._nombre = nombre
        self._apellido = apellido
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

    @property
    def apellido(self):
        return self._apellido

    @apellido.setter
    def apellido(self, value):
        self._apellido = value
    
    def crearAutor(self):
        pass

    def mostrarAutor(self):
        pass

    def mostrarAutores(self):
        pass

    def actualizarAutor(self):
        pass

    def eliminarAutor(self):
        pass

    def filtrarMasLeidos(self):
        pass
