CREATE DATABASE libreria_in47;
USE libreria_in47;

CREATE TABLE paises (
  id INT NOT NULL AUTO_INCREMENT,
  nombre_pais VARCHAR(200) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE autores (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  apellido VARCHAR(100) NOT NULL,
  pais INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (pais) REFERENCES paises(id)
);

CREATE TABLE editoriales (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  pais INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (pais) REFERENCES paises(id)
);

CREATE TABLE idiomas (
  id INT NOT NULL AUTO_INCREMENT,
  nombre_idioma VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
  );
  
CREATE TABLE formatos (
  id INT NOT NULL AUTO_INCREMENT,
  tipo_formato VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE categorias (
  id INT NOT NULL AUTO_INCREMENT,
  nombre_categoria VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE novedades (
  id INT NOT NULL AUTO_INCREMENT,
  es_novedad BOOLEAN NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE ranking (
  id INT NOT NULL AUTO_INCREMENT,
  es_mas_vendido BOOLEAN NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE libros (
  isbn VARCHAR(100) NOT NULL,
  titulo VARCHAR(200) NOT NULL,
  subtitulo VARCHAR(200) NOT NULL,
  cantidad INT NOT NULL,
  paginas INT NOT NULL,
  peso FLOAT NOT NULL,
  anio INT NOT NULL,
  resenia VARCHAR(250) NOT NULL,
  precio FLOAT NOT NULL,
  autor INT NOT NULL,
  editorial INT NOT NULL,
  idioma INT NOT NULL,
  formato INT NOT NULL,
  categoria INT NOT NULL,
  novedad INT NOT NULL,
  ranking INT NOT NULL,
  PRIMARY KEY (isbn),
  FOREIGN KEY (autor) REFERENCES autores(id),
  FOREIGN KEY (editorial) REFERENCES editoriales(id),
  FOREIGN KEY (idioma) REFERENCES idiomas(id),
  FOREIGN KEY (formato) REFERENCES formatos(id),
  FOREIGN KEY (categoria) REFERENCES categorias(id),
  FOREIGN KEY (novedad) REFERENCES novedades(id),
  FOREIGN KEY (ranking) REFERENCES ranking(id)
);

CREATE TABLE provincias (
  id INT NOT NULL AUTO_INCREMENT,
  nombre_provincia VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE localidades (
  id INT NOT NULL AUTO_INCREMENT,
  nombre_localidad VARCHAR(100) NOT NULL,
  codigo_postal VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE direcciones (
  id INT NOT NULL AUTO_INCREMENT,
  provincia INT NOT NULL,
  localidad INT NOT NULL,
  calle VARCHAR(100) NOT NULL,
  numero VARCHAR(100) NOT NULL,
  piso VARCHAR(50),
  depto VARCHAR(50),
  telefono VARCHAR(100) NOT NULL,
  dni_destinatario VARCHAR(100) NOT NULL, 
  PRIMARY KEY (id),
  FOREIGN KEY (provincia) REFERENCES provincias(id),
  FOREIGN KEY (localidad) REFERENCES localidades(id)
);

CREATE TABLE estados (
  id INT NOT NULL AUTO_INCREMENT,
  tipo_estado VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE generos (
  id INT NOT NULL AUTO_INCREMENT,
  tipo_genero BOOLEAN NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE roles (
  id INT NOT NULL AUTO_INCREMENT,
  es_usuario BOOLEAN NOT NULL,
  es_admin BOOLEAN NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE datos_adicionales (
  id INT NOT NULL AUTO_INCREMENT,
  genero INT NOT NULL,
  direccion INT NOT NULL,
  fecha_nacimiento DATE NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (direccion) REFERENCES direcciones(id),
  FOREIGN KEY (genero) REFERENCES generos(id)
);

CREATE TABLE personas (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  apellido VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  clave VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE usuarios (
  id INT NOT NULL AUTO_INCREMENT,
  datos_adicionales INT NOT NULL,
  rol INT NOT NULL,
  persona INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (datos_adicionales) REFERENCES datos_adicionales(id),
  FOREIGN KEY (rol) REFERENCES roles(id),
  FOREIGN KEY (persona) REFERENCES personas(id)
);

CREATE TABLE carritos (
  id INT NOT NULL AUTO_INCREMENT,
  id_usuario INT NOT NULL,
  isbn_libro VARCHAR(100) NOT NULL,
  precio_libro FLOAT NOT NULL,
  cantidad_libro INT NOT NULL,
  subtotal FLOAT NOT NULL,
  estado INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
  FOREIGN KEY (isbn_libro) REFERENCES libros(isbn),
  FOREIGN KEY (estado) REFERENCES estados(id)
);

CREATE TABLE pedidos (
  id INT NOT NULL AUTO_INCREMENT,
  monto_total FLOAT NOT NULL,
  direccion_usuario INT NOT NULL,
  comprobante_pago VARCHAR(100) NOT NULL,
  id_carrito INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (direccion_usuario) REFERENCES direcciones(id),
  FOREIGN KEY (id_carrito) REFERENCES carritos(id)
);

CREATE TABLE orden_compras (
  id INT NOT NULL AUTO_INCREMENT,
  id_carrito INT NOT NULL,
  estado INT NOT NULL,
  pedido INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_carrito) REFERENCES carritos(id),
  FOREIGN KEY (estado) REFERENCES estados(id),
  FOREIGN KEY (pedido) REFERENCES pedidos(id)
);

CREATE TABLE envios (
  id INT NOT NULL AUTO_INCREMENT,
  numero_seguimiento VARCHAR(200),
  estado INT NOT NULL,
  numero_pedido INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (estado) REFERENCES estados(id),
  FOREIGN KEY (numero_pedido) REFERENCES pedidos(id)
);
