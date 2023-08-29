
class Libro:
    def __init__(self, isbn, titulo, subtitulo, cantidad, paginas, peso, anio,
                 resenia, precio, autor, editorial, idioma, formato, categoria, 
                 novedad, ranking):
        self._isbn = isbn
        self._titulo = titulo
        self._subtitulo = subtitulo
        self._cantidad = cantidad
        self._paginas = paginas
        self._peso = peso
        self._anio = anio
        self._resenia = resenia
        self._precio = precio
        self._autor = autor
        self._editorial = editorial
        self._idioma = idioma
        self._formato = formato
        self._categoria = categoria
        self._novedad = novedad
        self._ranking = ranking

    @property
    def isbn(self):
        return self._isbn

    @isbn.setter
    def isbn(self, value):
        self._isbn = value

    @property
    def titulo(self):
        return self._titulo

    @titulo.setter
    def titulo(self, value):
        self._titulo = value

    @property
    def subtitulo(self):
        return self._subtitulo

    @subtitulo.setter
    def subtitulo(self, value):
        self._subtitulo = value

    @property
    def cantidad(self):
        return self._cantidad

    @cantidad.setter
    def cantidad(self, value):
        self._cant = value

    @property
    def paginas(self):
        return self._paginas

    @paginas.setter
    def paginas(self, value):
        self._paginas = value

    @property
    def peso(self):
        return self._peso

    @peso.setter
    def peso(self, value):
        self._peso = value

    @property
    def anio(self):
        return self._anio

    @anio.setter
    def anio(self, value):
        self._anio = value

    @property
    def resenia(self):
        return self._resenia

    @resenia.setter
    def resenia(self, value):
        self._resenia = value

    @property
    def precio(self):
        return self._precio

    @precio.setter
    def precio(self, value):
        self._precio = value

    @property
    def autor(self):
        return self._autor

    @autor.setter
    def autor(self, value):
        self._autor = value

    @property
    def editorial(self):
        return self._editorial

    @editorial.setter
    def editorial(self, value):
        self._editorial = value

    @property
    def idioma(self):
        return self._idioma

    @idioma.setter
    def idioma(self, value):
        self._idioma = value

    @property
    def formato(self):
        return self._formato

    @formato.setter
    def formato(self, value):
        self._formato = value

    @property
    def categoria(self):
        return self._categoria

    @categoria.setter
    def categoria(self, value):
        self._categoria = value

    @property
    def novedad(self):
        return self._novedad

    @novedad.setter
    def novedad(self, value):
        self._novedad = value

    @property
    def ranking(self):
        return self._ranking

    @ranking.setter
    def ranking(self, value):
        self._ranking = value

    def crearLibro():
        pass

    def mostrarLibroPorId():
        pass

    def mostrarLibros():
        pass

    def actualizarLibros():
        pass

    def eliminiarLibros():
        pass

    def buscarLibroPorNombre():
        pass
