import datosadicionales

class Direccion(datosadicionales):

    def __init__(self, id, provincia, localidad, calle, numero, piso, depto,
                 telefono, dniDestinatario):
        self._id = id
        self._provincia = provincia
        self._localidad = localidad
        self._calle = calle
        self._numero = numero
        self._piso = piso
        self._depto = depto
        self._telefono = telefono
        self._dniDestinatario = dniDestinatario

    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value):
        self._id = value

    @property
    def provincia(self):
        return self._provincia
    
    @provincia.setter
    def provincia(self, value):
        self._provincia = value

    @property
    def localidad(self):
        return self._localidad

    @localidad.setter
    def localidad(self, value):
        self._localidad = value

    @property
    def calle(self):
        return self._calle
    
    @calle.setter
    def calle(self, value):
        self._calle = value

    @property
    def numero(self):
        return self._numero

    @numero.setter
    def numero(self, value):
        self._numero = value

    @property
    def piso(self):
        return self._piso
    
    @piso.setter
    def piso(self, value):
        self._piso = value

    @property
    def depto(self):
        return self._depto

    @depto.setter
    def depto(self, value):
        self._depto = value

    @property
    def telefono(self):
        return self._telefono

    @telefono.setter
    def telefono(self, value):
        self._telefono = value

    @property
    def dniDestinatario(self):
        return self._dniDestinatario

    @dniDestinatario.setter
    def dniDestinatario(self, value):
        self._dniDestinatario = value

    def registrarDireccion(self):
        pass

    def modificarDireccion(self):
        pass

    def eliminarDireccion(self):
        pass
    
