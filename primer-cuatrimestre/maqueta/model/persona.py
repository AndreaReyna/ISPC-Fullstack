
class Persona:
    
    def __init__(self, id, nombre, apellido, email, password):
        self._id = id
        self._nombre = nombre
        self._apellido = apellido
        self._email = email
        self._password = password

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

    @property
    def email(self):
        return self._email

    @email.setter
    def email(self, value):
        """
        Valida el email
        :param value:
        :return:
        """
        pattern = r'\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Z|a-z]{2,}\b'
        if re.fullmatch(pattern, value):
            self._email = value
        else:
            raise ValueError(f'Email invalido: {value}')
    
    @property
    def password(self):
        return self._password

    @password.setter
    def password(self, value):
        self._password = value

    def agregarUsuario(self):
        pass

    def buscarUsuario(self):
        pass

    def eliminiarUsuario(self):
        pass

    def validarLogin(self):
        pass