USE library_db;

-- Insertar datos en la tabla 'autor'
INSERT INTO autor (nombre, apellido) VALUES
('Antoine', 'de Saint-Exupéry'),
('Neil', 'deGrasse Tyson'),
('Peter', 'Wohlleben'),
('Eckhart', 'Tolle'),
('Emily', 'Brontë'),
('J.R.R.', 'Tolkien'),
('Fyodor', 'Dostoevsky'),
('William', 'Faulkner'),
('Edgar Allan', 'Poe'),
('Virginia', 'Woolf'),
('Oscar', 'Wilde'),
('Mark', 'Twain'),
('Charles', 'Dickens'),
('Jane', 'Austen'),
('Ernest', 'Hemingway');

-- Insertar datos en la tabla 'editorial'
INSERT INTO editorial (nombre) VALUES
('Pluma Brillante Editorial'),
('Bosque Encantado Publicaciones'),
('Vuelo Literario Ediciones'),
('Libros del Horizonte'),
('Destellos Literarios Publicaciones'),
('Universo de Páginas Ediciones'),
('Mar de Historias Ediciones'),
('Libros del Horizonte'),
('Linterna de Papel Editorial'),
('Viajero del Tiempo Editorial'),
('Sinfonía de Palabras Publicaciones'),
('Fábrica de Fantasía Editorial'),
('Sinfonía de Palabras Publicaciones'),
('Viajero del Tiempo Editorial');

-- Insertar datos en la tabla 'formato'
INSERT INTO formato (nombre) VALUES
('Libro de bolsillo'),
('Tapa dura'),
('Ebook'),
('Audio libro');

-- Insertar datos en la tabla 'idioma'
INSERT INTO idioma (nombre) VALUES
('ES'),
('EN'),
('FR'),
('DE'),
('IT'),
('PT'),
('RU'),
('ZH'),
('JA'),
('AR');

-- Insertar datos en la tabla 'categoria'
INSERT INTO categoria (nombre) VALUES
('Novela'),
('Ciencia'),
('Naturaleza'),
('Autoayuda'),
('Aventura'),
('Cocina'),
('Historia'),
('Filosofía');


-- Insertar libros
INSERT INTO libro (isbn, titulo, subtitulo, paginas, peso, edicion, resenia, precio, stock, id_autor_id, id_editorial_id, id_formato_id, id_idioma_id, id_categoria_id, img_url) VALUES
(9782070612758, 'El Principito', 'El Secreto de la Ciudad Olvidada', 500, 700, '2022', 'Una misteriosa novela de intriga y romance ambientada en la Barcelona de posguerra.', 2654.99, 100, 1, 1, 1, 1, 1, 'https://m.media-amazon.com/images/I/51qrVjSm1mL._SX578_BO1,204,203,200_.jpg'),
(9781234567891, 'Cuando no queden más estrellas que contar', 'Un Viaje por el Cosmos', 300, 500, '2023', 'Un fascinante recorrido por el universo y los misterios de la ciencia moderna.', 2900.99, 80, 2, 2, 2, 1, 2, 'https://http2.mlstatic.com/D_NQ_NP_859079-MLA49255030580_032022-O.jpg'),
(9781234567892, 'La Vida Secreta de los Árboles', 'Lo que Sienten, Cómo se Comunican', 250, 400, '2023', 'Un sorprendente viaje al corazón de los bosques, revelando sus secretos más insondables.', 1956.99, 120, 3, 3, 1, 1, 3, 'https://www.terra.org/sites/default/files/terra/vidasecreta.jpg'),
(9781234567893, 'El Juego de la Vida', 'Meditaciones para el Siglo XXI', 200, 300, '2022', 'Una colección de reflexiones y meditaciones para navegar los desafíos de la vida moderna.', 1476.99, 50, 4, 1, 1, 1, 4, 'https://pictures.abebooks.com/isbn/9789706660008-es.jpg'),
(9781234567894, 'La Gran Travesía', 'Un Viaje a lo Desconocido', 600, 800, '2023', 'Una épica aventura de supervivencia y descubrimiento en los confines del mundo.', 8734.99, 30, 5, 4, 3, 1, 5, 'https://www.nocturnaediciones.com/imagenes/biblioteca/170_alta.jpg'),
(9781234567895, 'El Secreto de la Felicidad', 'Claves para una Vida Plena', 200, 350, '2022', 'Un manual inspirador que explora las prácticas y los hábitos para alcanzar la felicidad auténtica.', 8714.99, 75, 6, 5, 1, 1, 6, 'https://images.cdn3.buscalibre.com/fit-in/360x360/c1/31/c131715e0a4f489bed8625690d1a38c3.jpg'),
(9781234567896, 'Caminos Cruzados', 'Destinos Entrelazados', 350, 500, '2023', 'Una conmovedora novela de amor y sacrificio, en la que los caminos de dos extraños se entrecruzan de manera inesperada.', 25674.99, 90, 7, 4, 2, 1, 5, 'https://contentv2.tap-commerce.com/cover/large/9788467032574_1.jpg?id_com=1156'),
(9781234567897, 'Cocina Saludable', 'Recetas para una Vida Equilibrada', 220, 450, '2023', 'Un libro de recetas deliciosas y nutritivas para llevar una vida más saludable.', 1789.99, 200, 8, 6, 1, 1, 8, 'https://http2.mlstatic.com/D_NQ_NP_712887-MLA43135955735_082020-O.jpg'),
(9781234567898, 'En el Corazón de la Selva', 'Un Relato de Aventura y Descubrimiento', 450, 600, '2022', 'Una historia de aventuras y descubrimientos en la selva amazónica llena de misterio y emoción.', 2454.99, 60, 9, 1, 1, 1, 5, 'https://imagessl9.casadellibro.com/a/l/t5/69/9788418641169.jpg'),
(9781234567899, 'La Esencia del Tiempo', 'Una Perspectiva Filosófica', 300, 400, '2023', 'Un profundo análisis filosófico de la naturaleza del tiempo y nuestro lugar en el universo.', 2459.99, 40, 10, 11, 2, 1, 6, 'https://pictures.abebooks.com/inventory/md/md30188300367.jpg'),
(9781234567800, 'Cuentos de la Luna Azul', 'Leyendas y Mitos', 250, 350, '2023', 'Una colección fascinante de mitos y leyendas de todo el mundo relacionadas con la luna.', 1945.99, 120, 11, 12, 1, 1, 7, 'https://m.media-amazon.com/images/I/41gs9t8bsoL._AC_UF1000,1000_QL80_.jpg'),
(9781234567802, 'El Arte de la Guerra Moderna', 'Estrategias del Siglo XXI', 260, 360, '2023', 'Un análisis profundo de las estrategias y tácticas usadas en los conflictos modernos.', 6729.99, 70, 13, 14, 1, 1, 8, 'https://www.esferalibros.com/wp-content/uploads/2022/10/el-nuevo-arte-de-la-guerra-scaled.jpg'),
(9781234567803, 'Ecos del Pasado', 'Historias de un Mundo Olvidado', 320, 450, '2023', 'Una compilación de cuentos históricos que nos lleva a tiempos y lugares lejanos.', 7824.99, 65, 14, 12, 2, 1, 8, 'https://2.bp.blogspot.com/-JNgJjxIoWqg/W8VZ9eeuZvI/AAAAAAAAFiE/LGVJdanT284SrayH7GcJtEbPrd47iYQbwCLcBGAs/s1600/44042053_676485059402118_6013615849816981504_n.jpg');


