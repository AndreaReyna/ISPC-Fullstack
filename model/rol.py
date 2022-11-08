class rol:

    def __init__(self, id, esUsuario, esAdmin):
        self._id = id
        self._esUsuario = esUsuario
        self._esAdmin = esAdmin

    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value):
        self._id = value

    @property
    def esUsuario(self):
        return self._esUsuario
    
    @esUsuario.setter
    def esUsuario(self, value):
        self._esUsuario = value

    @property
    def esAdmin(self):
        return self._esAdmin

    @esAdmin.setter
    def esAdmin(self, value):
        self._esAdmin = value

    def crearRol(self):
        pass

    def verRoles(self):
        pass
    
    def actualizarRol(self):
        pass

    def eliminarRol(self):
        pass
    