import carrito
import estado
import pedido

class OrdenDeCompra(carrito, estado, pedido):

    def __init__(self, id, idCarrito, estado, pedido):
        self._id = id
        self._idCarrito = idCarrito
        self._estado = estado
        self._pedido = pedido

    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value):
        self._id = value

    @property
    def idCarrito(self):
        return self._idCarrito

    @idCarrito.setter
    def idCarrito(self, value):
        self._idCarrito = value

    @property
    def estado(self):
        return self._estado
    
    @estado.setter
    def estado(self, value):
        self._estado = value

    @property
    def pedido(self):
        return self._pedido

    @pedido.setter
    def pedido(self, value):
        self._pedido = value
    
    def crearOrdenDeCompra(self):
        pass

    def mostrarOrdenDeCompra(self):
        pass

    def actualizarOrdenDeCompra(self):
        pass

    def eliminarOrdenDeCompra(self):
        pass

    def filtrarOrdenDeCompra(self):
        pass
    