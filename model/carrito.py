import libro
import estado

class Carrito(libro, estado):

    def __init__(self, id, idUsuario, isbnLibro, precioLibro, cantidadLibros,
                 subtotal, estado):
        self._id = id
        self._idUsuario = idUsuario
        self._isbnLibro = isbnLibro
        self._precioLibro = precioLibro
        self._cantidadLibros = cantidadLibros
        self._subtotal = subtotal
        self._estado = estado

    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value):
        self._id = value

    @property
    def idUsuario(self):
        return self._idUsuario

    @idUsuario.setter
    def idUsuario(self, value):
        self._idUsuario = value

    @property
    def isbnLibro(self):
        return self._isbnLibro
    
    @isbnLibro.setter
    def isbnLibro(self, value):
        self._isbnLibro = value

    @property
    def precioLibro(self):
        return self._precioLibro

    @precioLibro.setter
    def precioLibro(self, value):
        self._precioLibro = value

    @property
    def cantidadLibros(self):
        return self._cantidadLibros

    @cantidadLibros.setter
    def cantidadLibros(self, value):
        self._cantidadLibros = value

    @property
    def subtotal(self):
        return self._subtotal

    @subtotal.setter
    def subtotal(self, value):
        self._subtotal = value

    @property
    def estado(self):
        return self._estado

    @estado.setter
    def estado(self, value):
        self._estado = value

    def crearCarrito(self):
        pass

    def modificarCarrito(self):
        pass

    def eliminarCarrito(self):
        pass

    def mostrarProducto(self):
        pass
    