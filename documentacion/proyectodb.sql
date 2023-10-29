-- Table structure for table `autor`
CREATE TABLE IF NOT EXISTS `autor` (
  `id_autor` INTEGER PRIMARY KEY AUTOINCREMENT,
  `nombre` TEXT NOT NULL,
  `apellido` TEXT NOT NULL
);

-- Table structure for table `calificaciones`
CREATE TABLE IF NOT EXISTS `calificaciones` (
  `id_calificacion` INTEGER PRIMARY KEY AUTOINCREMENT,
  `libro_id` INTEGER NOT NULL,
  `usuario_id` INTEGER NOT NULL,
  `puntuacion` INTEGER NOT NULL
);

-- Table structure for table `categoria`
CREATE TABLE IF NOT EXISTS `categoria` (
  `id_categoria` INTEGER PRIMARY KEY AUTOINCREMENT,
  `tipo` TEXT NOT NULL
);

-- Table structure for table `cliente`
CREATE TABLE IF NOT EXISTS `cliente` (
  `id_usuario` INTEGER PRIMARY KEY AUTOINCREMENT,
  `nombre` TEXT NOT NULL,
  `apellido` TEXT NOT NULL,
  `password` TEXT NOT NULL,
  `tipo_usuario` INTEGER NOT NULL,
  `email` TEXT NOT NULL,
  `dni` TEXT,
  `fecha_nac` DATE,
  `telefono` TEXT,
  `fecha_creacion` DATE NOT NULL,
  `fecha_modificacion` DATE
);

-- Table structure for table `direccion`
CREATE TABLE IF NOT EXISTS `direccion` (
  `id_direccion` INTEGER PRIMARY KEY AUTOINCREMENT,
  `calle_nro` TEXT NOT NULL,
  `provincia_id_provincia` INTEGER NOT NULL,
  `localidad_id_localidad` INTEGER NOT NULL
);

-- Table structure for table `editorial`
CREATE TABLE IF NOT EXISTS `editorial` (
  `id_editorial` INTEGER PRIMARY KEY AUTOINCREMENT,
  `nombre` TEXT NOT NULL
);

-- Table structure for table `elementos_wishlist`
CREATE TABLE IF NOT EXISTS `elementos_wishlist` (
  `id_elementos_wishlist` INTEGER PRIMARY KEY AUTOINCREMENT,
  `wishlist_id_wishlist` INTEGER NOT NULL,
  `libro_id_libro` INTEGER NOT NULL,
  `cantidad` INTEGER
);

-- Table structure for table `formato`
CREATE TABLE IF NOT EXISTS `formato` (
  `id_formato` INTEGER PRIMARY KEY AUTOINCREMENT,
  `tipo` TEXT NOT NULL
);

-- Table structure for table `idioma`
CREATE TABLE IF NOT EXISTS `idioma` (
  `id_idioma` INTEGER PRIMARY KEY AUTOINCREMENT,
  `nombre` TEXT
);

-- Table structure for table `libro`
CREATE TABLE IF NOT EXISTS `libro` (
  `id_libro` INTEGER PRIMARY KEY AUTOINCREMENT,
  `isbn` TEXT NOT NULL,
  `titulo` TEXT NOT NULL,
  `subtitulo` TEXT,
  `descripcion` TEXT,
  `comentarios` TEXT,
  `autor_id_autor` INTEGER NOT NULL,
  `idioma_id_idioma` INTEGER NOT NULL,
  `formato_id_formato` INTEGER NOT NULL,
  `editorial_id_editorial` INTEGER NOT NULL,
  `categoria_id_categoria` INTEGER NOT NULL,
  `calificacion_promedio` REAL DEFAULT 0,
  `numero_calificaciones` INTEGER DEFAULT 0
);

-- Table structure for table `localidad`
CREATE TABLE IF NOT EXISTS `localidad` (
  `id_localidad` INTEGER PRIMARY KEY AUTOINCREMENT,
  `nombre` TEXT NOT NULL,
  `codigo_postal` TEXT NOT NULL
);

-- Table structure for table `provincia`
CREATE TABLE IF NOT EXISTS `provincia` (
  `id_provincia` INTEGER PRIMARY KEY AUTOINCREMENT,
  `nombre` TEXT NOT NULL
);

-- Table structure for table `wishlist`
CREATE TABLE IF NOT EXISTS `wishlist` (
  `id_wishlist` INTEGER PRIMARY KEY AUTOINCREMENT,
  `fecha_creacion` TEXT,
  `cliente_id_usuario` INTEGER NOT NULL,
  `fecha_modificacion` DATE
);
