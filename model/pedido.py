import direccion
import carrito

class Pedido(carrito, direccion):

    def __init__(self, id, montoTotal, direccionUsuario, comprobantePago,
                 idCarrito):
        self._id = id
        self._montoTotal = montoTotal
        self._direccionUsuario = direccionUsuario
        self._comprobantePago = comprobantePago
        self._idCarrito = idCarrito

    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value):
        self._id = value

    @property
    def montoTotal(self):
        return self._montoTotal

    @montoTotal.setter
    def montoTotal(self, value):
        self._montoTotal = value

    @property
    def direccionUsuario(self):
        return self._direccionUsuario

    @direccionUsuario.setter
    def direccionUsuario(self, value):
        self._direccionUsuario = value

    @property
    def comprobantePago(self):
        return self._comprobantePago

    @comprobantePago.setter
    def comprobantePago(self, value):
        self._comprobantePago = value

    @property
    def idCarrito(self):
        return self._idCarrito

    @idCarrito.setter
    def idCarrito(self, value):
        self._idCarrito = value

    def crearPedido(self):
        pass

    def modificarPedido(self):
        pass

    def eliminarPedido(self):
        pass

    def mostrarPedido(self):
        pass
