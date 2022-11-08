import persona
import rol

class Administrador(persona, rol):

    def __init__(self, id, rol):
        self._id = id
        self._rol = rol
    
    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value):
        self._id = value

    @property
    def rol(self):
        return self._rol

    @rol.setter
    def rol(self, value):
        self._rol = value

    def crearProducto(self):
        pass

    def mostrarProducto(self):
        pass

    def actualizarProducto(self):
        pass

    def eliminarProducto(self):
        pass

    def agregarOferta(self):
        pass

    def gestionarVentas(self):
        pass

    def adjuntarFacturas(self):
        pass

    def actualizarTracking(self):
        pass

    def gestionarNovedades(self):
        pass

    def gestionarMasVendidos(self):
        pass

    def cambiarRol(self):
        pass

    def asignarCategoria(self):
        pass
    