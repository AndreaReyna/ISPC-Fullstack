import pedido
import estado

class Envio(pedido, estado):

    def __init__(self, id, pedido, numeroSeguimiento, estado):
        self._id = id
        self._pedido = pedido
        self._numeroSeguimiento = numeroSeguimiento
        self._estado = estado

    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value):
        self._id = value

    @property
    def pedido(self):
        return self._pedido

    @pedido.setter
    def pedido(self, value):
        self._pedido = value

    @property
    def numeroSeguimiento(self):
        return self._numeroSeguimiento

    @numeroSeguimiento.setter
    def numeroSeguimiento(self, value):
        self._numeroSeguimiento = value

    @property
    def estado(self):
        return self._estado

    @estado.setter
    def estado(self, value):
        self._estado = value

    def crearEnvio(self):
        pass

    def mostrarEnvio(self):
        pass

    def actualizarEnvios(self):
        pass

    def eliminarEnvios(self):
        pass

    def seguimientoEnvios(self):
        pass

    def modificarEstado(self):
        pass
    