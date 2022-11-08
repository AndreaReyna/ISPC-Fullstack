import libro

class Categoria(libro):

    def __init__(self, id, nombreCategoria):
        self._id = id
        self._nombreCategoria = nombreCategoria

    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value):
        self._id = value

    @property
    def nombreCategoria(self):
        return self._nombreCategoria

    @nombreCategoria.setter
    def nombreCategoria(self, value):
        self._nombreCategoria = value
    
    def crearCategoria(self):
        pass

    def modificarCategoria(self):
        pass

    def eliminarCategoria(self):
        pass

    def obtenerCategoria(self):
        pass

    def obtenerCategoriaPorNombre(self):
        pass

    def obtenerCategorias(self):
        pass
    