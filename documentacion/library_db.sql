-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 17, 2023 at 09:49 PM
-- Server version: 8.0.33
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `auth_group`
--

DROP TABLE IF EXISTS `auth_group`;
CREATE TABLE IF NOT EXISTS `auth_group` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `auth_group_permissions`
--

DROP TABLE IF EXISTS `auth_group_permissions`;
CREATE TABLE IF NOT EXISTS `auth_group_permissions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `group_id` int NOT NULL,
  `permission_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `auth_group_permissions_group_id_permission_id_0cd325b0_uniq` (`group_id`,`permission_id`),
  KEY `auth_group_permissions_group_id_b120cbf9` (`group_id`),
  KEY `auth_group_permissions_permission_id_84c5c92e` (`permission_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `auth_permission`
--

DROP TABLE IF EXISTS `auth_permission`;
CREATE TABLE IF NOT EXISTS `auth_permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `content_type_id` int NOT NULL,
  `codename` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `auth_permission_content_type_id_codename_01ab375a_uniq` (`content_type_id`,`codename`),
  KEY `auth_permission_content_type_id_2f476e4b` (`content_type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=93 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `auth_permission`
--

INSERT INTO `auth_permission` (`id`, `name`, `content_type_id`, `codename`) VALUES
(1, 'Can add log entry', 1, 'add_logentry'),
(2, 'Can change log entry', 1, 'change_logentry'),
(3, 'Can delete log entry', 1, 'delete_logentry'),
(4, 'Can view log entry', 1, 'view_logentry'),
(5, 'Can add permission', 2, 'add_permission'),
(6, 'Can change permission', 2, 'change_permission'),
(7, 'Can delete permission', 2, 'delete_permission'),
(8, 'Can view permission', 2, 'view_permission'),
(9, 'Can add group', 3, 'add_group'),
(10, 'Can change group', 3, 'change_group'),
(11, 'Can delete group', 3, 'delete_group'),
(12, 'Can view group', 3, 'view_group'),
(13, 'Can add content type', 4, 'add_contenttype'),
(14, 'Can change content type', 4, 'change_contenttype'),
(15, 'Can delete content type', 4, 'delete_contenttype'),
(16, 'Can view content type', 4, 'view_contenttype'),
(17, 'Can add session', 5, 'add_session'),
(18, 'Can change session', 5, 'change_session'),
(19, 'Can delete session', 5, 'delete_session'),
(20, 'Can view session', 5, 'view_session'),
(21, 'Can add user', 6, 'add_customuser'),
(22, 'Can change user', 6, 'change_customuser'),
(23, 'Can delete user', 6, 'delete_customuser'),
(24, 'Can view user', 6, 'view_customuser'),
(25, 'Can add Autor', 7, 'add_autor'),
(26, 'Can change Autor', 7, 'change_autor'),
(27, 'Can delete Autor', 7, 'delete_autor'),
(28, 'Can view Autor', 7, 'view_autor'),
(29, 'Can add Id del Carrito', 8, 'add_carrito'),
(30, 'Can change Id del Carrito', 8, 'change_carrito'),
(31, 'Can delete Id del Carrito', 8, 'delete_carrito'),
(32, 'Can view Id del Carrito', 8, 'view_carrito'),
(33, 'Can add Categoria', 9, 'add_categoria'),
(34, 'Can change Categoria', 9, 'change_categoria'),
(35, 'Can delete Categoria', 9, 'delete_categoria'),
(36, 'Can view Categoria', 9, 'view_categoria'),
(37, 'Can add Editorial', 10, 'add_editorial'),
(38, 'Can change Editorial', 10, 'change_editorial'),
(39, 'Can delete Editorial', 10, 'delete_editorial'),
(40, 'Can view Editorial', 10, 'view_editorial'),
(41, 'Can add Estado', 11, 'add_estado'),
(42, 'Can change Estado', 11, 'change_estado'),
(43, 'Can delete Estado', 11, 'delete_estado'),
(44, 'Can view Estado', 11, 'view_estado'),
(45, 'Can add Formato', 12, 'add_formato'),
(46, 'Can change Formato', 12, 'change_formato'),
(47, 'Can delete Formato', 12, 'delete_formato'),
(48, 'Can view Formato', 12, 'view_formato'),
(49, 'Can add Idioma', 13, 'add_idioma'),
(50, 'Can change Idioma', 13, 'change_idioma'),
(51, 'Can delete Idioma', 13, 'delete_idioma'),
(52, 'Can view Idioma', 13, 'view_idioma'),
(53, 'Can add Nombre de Localidad', 14, 'add_localidad'),
(54, 'Can change Nombre de Localidad', 14, 'change_localidad'),
(55, 'Can delete Nombre de Localidad', 14, 'delete_localidad'),
(56, 'Can view Nombre de Localidad', 14, 'view_localidad'),
(57, 'Can add Orden', 15, 'add_orden'),
(58, 'Can change Orden', 15, 'change_orden'),
(59, 'Can delete Orden', 15, 'delete_orden'),
(60, 'Can view Orden', 15, 'view_orden'),
(61, 'Can add Nombre de Provincia', 16, 'add_provincia'),
(62, 'Can change Nombre de Provincia', 16, 'change_provincia'),
(63, 'Can delete Nombre de Provincia', 16, 'delete_provincia'),
(64, 'Can view Nombre de Provincia', 16, 'view_provincia'),
(65, 'Can add Pedido', 17, 'add_pedido'),
(66, 'Can change Pedido', 17, 'change_pedido'),
(67, 'Can delete Pedido', 17, 'delete_pedido'),
(68, 'Can view Pedido', 17, 'view_pedido'),
(69, 'Can add Pago', 18, 'add_pago'),
(70, 'Can change Pago', 18, 'change_pago'),
(71, 'Can delete Pago', 18, 'delete_pago'),
(72, 'Can view Pago', 18, 'view_pago'),
(73, 'Can add Libro', 19, 'add_libro'),
(74, 'Can change Libro', 19, 'change_libro'),
(75, 'Can delete Libro', 19, 'delete_libro'),
(76, 'Can view Libro', 19, 'view_libro'),
(77, 'Can add Elemento del Carrito', 20, 'add_elementoscarrito'),
(78, 'Can change Elemento del Carrito', 20, 'change_elementoscarrito'),
(79, 'Can delete Elemento del Carrito', 20, 'delete_elementoscarrito'),
(80, 'Can view Elemento del Carrito', 20, 'view_elementoscarrito'),
(81, 'Can add Detalle Direccion', 21, 'add_direccion'),
(82, 'Can change Detalle Direccion', 21, 'change_direccion'),
(83, 'Can delete Detalle Direccion', 21, 'delete_direccion'),
(84, 'Can view Detalle Direccion', 21, 'view_direccion'),
(85, 'Can add Detalle del Pedido', 22, 'add_detallepedido'),
(86, 'Can change Detalle del Pedido', 22, 'change_detallepedido'),
(87, 'Can delete Detalle del Pedido', 22, 'delete_detallepedido'),
(88, 'Can view Detalle del Pedido', 22, 'view_detallepedido'),
(89, 'Can add Password Reset Token', 23, 'add_resetpasswordtoken'),
(90, 'Can change Password Reset Token', 23, 'change_resetpasswordtoken'),
(91, 'Can delete Password Reset Token', 23, 'delete_resetpasswordtoken'),
(92, 'Can view Password Reset Token', 23, 'view_resetpasswordtoken');

-- --------------------------------------------------------

--
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
CREATE TABLE IF NOT EXISTS `autor` (
  `id_autor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `apellido` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_autor`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `autor`
--

INSERT INTO `autor` (`id_autor`, `nombre`, `apellido`) VALUES
(1, 'Antoine', 'de Saint-Exupéry'),
(2, 'Neil', 'deGrasse Tyson'),
(3, 'Peter', 'Wohlleben'),
(4, 'Eckhart', 'Tolle'),
(5, 'Emily', 'Brontë'),
(6, 'J.R.R.', 'Tolkien'),
(7, 'Fyodor', 'Dostoevsky'),
(8, 'William', 'Faulkner'),
(9, 'Edgar Allan', 'Poe'),
(10, 'Virginia', 'Woolf'),
(11, 'Oscar', 'Wilde'),
(12, 'Mark', 'Twain'),
(13, 'Charles', 'Dickens'),
(14, 'Jane', 'Austen'),
(15, 'Ernest', 'Hemingway');

-- --------------------------------------------------------

--
-- Table structure for table `carrito`
--

DROP TABLE IF EXISTS `carrito`;
CREATE TABLE IF NOT EXISTS `carrito` (
  `id_carrito` int NOT NULL AUTO_INCREMENT,
  `fecha_creacion` datetime(6) NOT NULL COMMENT 'The field is only automatically updated when calling Model.save()',
  PRIMARY KEY (`id_carrito`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `carrito`
--

INSERT INTO `carrito` (`id_carrito`, `fecha_creacion`) VALUES
(1, '2023-06-13 21:02:22.652098'),
(2, '2023-06-13 23:30:37.054946'),
(3, '2023-06-13 23:56:13.336471'),
(4, '2023-06-16 21:51:02.868191'),
(5, '2023-06-17 16:57:26.301739');

-- --------------------------------------------------------

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
  `id_categoria` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `nombre`) VALUES
(1, 'Novela'),
(2, 'Ciencia'),
(3, 'Naturaleza'),
(4, 'Autoayuda'),
(5, 'Aventura'),
(6, 'Cocina'),
(7, 'Historia'),
(8, 'Filosofía');

-- --------------------------------------------------------

--
-- Table structure for table `detalle_pedido`
--

DROP TABLE IF EXISTS `detalle_pedido`;
CREATE TABLE IF NOT EXISTS `detalle_pedido` (
  `id_detalle_pedido` int NOT NULL AUTO_INCREMENT,
  `cantidad` smallint UNSIGNED NOT NULL,
  `id_libro_id` int NOT NULL,
  `id_pedido_id` int NOT NULL,
  PRIMARY KEY (`id_detalle_pedido`),
  KEY `detalle_pedido_id_libro_id_59b237ea` (`id_libro_id`),
  KEY `detalle_pedido_id_pedido_id_829ebbd4` (`id_pedido_id`)
) ;

-- --------------------------------------------------------

--
-- Table structure for table `direccion`
--

DROP TABLE IF EXISTS `direccion`;
CREATE TABLE IF NOT EXISTS `direccion` (
  `id_direccion` int NOT NULL AUTO_INCREMENT,
  `calle_nro` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `id_localidad_id` int NOT NULL,
  `id_provincia_id` int NOT NULL,
  PRIMARY KEY (`id_direccion`),
  KEY `direccion_id_localidad_id_730362b8` (`id_localidad_id`),
  KEY `direccion_id_provincia_id_4030fa68` (`id_provincia_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `django_admin_log`
--

DROP TABLE IF EXISTS `django_admin_log`;
CREATE TABLE IF NOT EXISTS `django_admin_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `action_time` datetime(6) NOT NULL,
  `object_id` longtext COLLATE utf8mb4_general_ci,
  `object_repr` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `action_flag` smallint UNSIGNED NOT NULL,
  `change_message` longtext COLLATE utf8mb4_general_ci NOT NULL,
  `content_type_id` int DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `django_admin_log_content_type_id_c4bce8eb` (`content_type_id`),
  KEY `django_admin_log_user_id_c564eba6` (`user_id`)
) ;

-- --------------------------------------------------------

--
-- Table structure for table `django_content_type`
--

DROP TABLE IF EXISTS `django_content_type`;
CREATE TABLE IF NOT EXISTS `django_content_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `app_label` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `model` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `django_content_type_app_label_model_76bd3d3b_uniq` (`app_label`,`model`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `django_content_type`
--

INSERT INTO `django_content_type` (`id`, `app_label`, `model`) VALUES
(1, 'admin', 'logentry'),
(2, 'auth', 'permission'),
(3, 'auth', 'group'),
(4, 'contenttypes', 'contenttype'),
(5, 'sessions', 'session'),
(6, 'libreriavirtual', 'customuser'),
(7, 'libreriavirtual', 'autor'),
(8, 'libreriavirtual', 'carrito'),
(9, 'libreriavirtual', 'categoria'),
(10, 'libreriavirtual', 'editorial'),
(11, 'libreriavirtual', 'estado'),
(12, 'libreriavirtual', 'formato'),
(13, 'libreriavirtual', 'idioma'),
(14, 'libreriavirtual', 'localidad'),
(15, 'libreriavirtual', 'orden'),
(16, 'libreriavirtual', 'provincia'),
(17, 'libreriavirtual', 'pedido'),
(18, 'libreriavirtual', 'pago'),
(19, 'libreriavirtual', 'libro'),
(20, 'libreriavirtual', 'elementoscarrito'),
(21, 'libreriavirtual', 'direccion'),
(22, 'libreriavirtual', 'detallepedido'),
(23, 'django_rest_passwordreset', 'resetpasswordtoken');

-- --------------------------------------------------------

--
-- Table structure for table `django_migrations`
--

DROP TABLE IF EXISTS `django_migrations`;
CREATE TABLE IF NOT EXISTS `django_migrations` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `app` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `applied` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `django_migrations`
--

INSERT INTO `django_migrations` (`id`, `app`, `name`, `applied`) VALUES
(1, 'contenttypes', '0001_initial', '2023-06-13 20:26:09.384898'),
(2, 'contenttypes', '0002_remove_content_type_name', '2023-06-13 20:26:09.431762'),
(3, 'auth', '0001_initial', '2023-06-13 20:26:09.806761'),
(4, 'auth', '0002_alter_permission_name_max_length', '2023-06-13 20:26:09.838013'),
(5, 'auth', '0003_alter_user_email_max_length', '2023-06-13 20:26:09.838013'),
(6, 'auth', '0004_alter_user_username_opts', '2023-06-13 20:26:09.838013'),
(7, 'auth', '0005_alter_user_last_login_null', '2023-06-13 20:26:09.853635'),
(8, 'auth', '0006_require_contenttypes_0002', '2023-06-13 20:26:09.853635'),
(9, 'auth', '0007_alter_validators_add_error_messages', '2023-06-13 20:26:09.853635'),
(10, 'auth', '0008_alter_user_username_max_length', '2023-06-13 20:26:09.853635'),
(11, 'auth', '0009_alter_user_last_name_max_length', '2023-06-13 20:26:09.853635'),
(12, 'auth', '0010_alter_group_name_max_length', '2023-06-13 20:26:09.884884'),
(13, 'auth', '0011_update_proxy_permissions', '2023-06-13 20:26:09.884884'),
(14, 'auth', '0012_alter_user_first_name_max_length', '2023-06-13 20:26:09.884884'),
(15, 'libreriavirtual', '0001_initial', '2023-06-13 20:26:11.782681'),
(16, 'admin', '0001_initial', '2023-06-13 20:26:11.954558'),
(17, 'admin', '0002_logentry_remove_auto_add', '2023-06-13 20:26:11.954558'),
(18, 'admin', '0003_logentry_add_action_flag_choices', '2023-06-13 20:26:11.954558'),
(19, 'django_rest_passwordreset', '0001_initial', '2023-06-13 20:26:12.032681'),
(20, 'django_rest_passwordreset', '0002_pk_migration', '2023-06-13 20:26:12.142056'),
(21, 'django_rest_passwordreset', '0003_allow_blank_and_null_fields', '2023-06-13 20:26:12.188943'),
(22, 'sessions', '0001_initial', '2023-06-13 20:26:12.220182');

-- --------------------------------------------------------

--
-- Table structure for table `django_rest_passwordreset_resetpasswordtoken`
--

DROP TABLE IF EXISTS `django_rest_passwordreset_resetpasswordtoken`;
CREATE TABLE IF NOT EXISTS `django_rest_passwordreset_resetpasswordtoken` (
  `created_at` datetime(6) NOT NULL,
  `key` varchar(64) COLLATE utf8mb4_general_ci NOT NULL,
  `ip_address` char(39) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `user_agent` varchar(256) COLLATE utf8mb4_general_ci NOT NULL,
  `user_id` bigint NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `django_rest_passwordreset_resetpasswordtoken_key_f1b65873_uniq` (`key`),
  KEY `django_rest_passwordreset_resetpasswordtoken_user_id_e8015b11` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `django_session`
--

DROP TABLE IF EXISTS `django_session`;
CREATE TABLE IF NOT EXISTS `django_session` (
  `session_key` varchar(40) COLLATE utf8mb4_general_ci NOT NULL,
  `session_data` longtext COLLATE utf8mb4_general_ci NOT NULL,
  `expire_date` datetime(6) NOT NULL,
  PRIMARY KEY (`session_key`),
  KEY `django_session_expire_date_a5c62663` (`expire_date`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `django_session`
--

INSERT INTO `django_session` (`session_key`, `session_data`, `expire_date`) VALUES
('kpyauzxwy1dtmdx82mf7okhwsm6o0wkz', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1q9DsR:mDbd7BjB9-A0kJnK_Nlma5ZuyxhR4HstDy79qQurvBE', '2023-06-27 23:56:43.812589'),
('s0xza4maihjern12ltl1qdzkkjle4fe0', '.eJxVjMsOwiAQRf-FtSGUMjxcuvcbyAwMUjU0Ke3K-O_apAvd3nPOfYmI21rj1nmJUxZnocXpdyNMD247yHdst1mmua3LRHJX5EG7vM6Zn5fD_Tuo2Ou3xqTAkdHFsPNFK8tDGEMiRQ5CUqgDKM3WjIYH55kDe1IuZyigkS2I9wfYSjeu:1q9DjM:RxMeVCod-n-yEmZ_SNfBkotUdDjav9sjo-3d6QGxTUg', '2023-06-27 23:47:20.187491'),
('f7ypp8dno1hogoteig5j370iky0ibkph', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1q9Dxk:OdO1oBGUIu9PaumaPIyK1L2S4Ap5FZturs7gOVJjKpQ', '2023-06-28 00:02:12.895621'),
('l4jrdhsrpp2iofzp4em1rl0b7ll3kxvy', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1q9Ebe:LliBsi7MfTcoDGmAwHRLxT5gcqOzoUKBU4MTPxYi5rM', '2023-06-28 00:43:26.456557'),
('ici7kd0k79t8rpey5xy2ccb0gxu8089i', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1q9wj8:wK0MA_WBSuLEDH71dzz4sh0pOUJH3wSmy-irViJWuZc', '2023-06-29 23:50:06.277306'),
('w8eqp9oza093017c4kkcrxmxdesnrwmb', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAGNU:lwh-SZ7aIiXhYPTLYblTrRdG2vLjDZNEf3Ice-zjn-g', '2023-06-30 20:49:04.216572'),
('huo97w2hqcas8btuebje9zbl223cu7bc', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAGXG:Sl_N1IFYb_rfwuHFcXmyvsJm9JC5xxs8Ka_lA_90lcU', '2023-06-30 20:59:10.182870'),
('qpi91wmj9f4y6ujenbj7ikgwp7tovhzd', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAGXM:cxasvoOkIgpVzIrhdw23BfPM6c7cPtgJhGBbsZ1S-es', '2023-06-30 20:59:16.400991'),
('fw8nkzumltfkjlapqfodlj60q006i4w5', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAGcV:IuZZ45XRkKyO01M7XBW5-AUMBY3RIEP3-h8g6P654fw', '2023-06-30 21:04:35.169911'),
('iakupqk8li4ildoaad04fycgm2ndviyu', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAGdp:IcbreEWX1RkaMeZaTzRbvjGxmwTvmh3S8_UiWkLqnDQ', '2023-06-30 21:05:57.374408'),
('soypzuvf9dj8ofc9mnvwul6m378mri8i', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAGfj:n8S8ykz6gEz3p3JpUYrcTWPb733XqDdz8F6M3u3MfE4', '2023-06-30 21:07:55.308867'),
('ad12kqwgbmpwtr2r7zf8p704pt3hae6s', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAGil:62Z-zqlGNZsUygrrxgcgKfKj4AHbfPWhK6bb8KN6ShE', '2023-06-30 21:11:03.464607'),
('a1yfmfzjeqothgskhalbyxsyqfdibt4s', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAGuQ:xeHPJPO23m-Kb_WB857XD0UcCh3XjDxtWl8t1SXkSC0', '2023-06-30 21:23:06.240713'),
('oiqttgei1zoww99886dtdxl73u4gyrpa', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAGvo:3ZjRuO3VmwRPVccQt15HhDFDKu8N21fcRwC6Ts_v_Rs', '2023-06-30 21:24:32.912943'),
('zh8kmddmo828fcp7y72k6mo1gofu8y4l', '.eJxVjEEOwiAQRe_C2hDAAYpL9z0DmWFAqoYmpV0Z765NutDtf-_9l4i4rTVuPS9xYnERIE6_G2F65LYDvmO7zTLNbV0mkrsiD9rlOHN-Xg_376Bir9-aQAfrvebEoIrTjg0QEmXvPISMg2V1ZkgKVQmGnWZTDNg0GM6lWCveH-dZODI:1qAHLS:ez8b-hlx5Ma9_zlmVgdRkDfXvUkMcGKJIsHVyHdIZUI', '2023-06-30 21:51:02.871995'),
('c0opomzvxc5oxweqqqg23l5h1fs2zar2', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAIg2:DYUR9fQNt8C19qCnTouOIovScYb3S0Wte9kThvCRTKE', '2023-06-30 23:16:22.317394'),
('1efkc2fokv017x9j6sd0e6zwtrwskepr', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAIqM:qEbk9wrv4xTjC_I5Ot44IDjY5kM5JIhguRlSjiuYE2I', '2023-06-30 23:27:02.582545'),
('7kifa1ykxzmq0x3feb5d042g8d8i3b7t', '.eJxVjEEOwiAQRe_C2hDAAYpL9z0DmWFAqoYmpV0Z765NutDtf-_9l4i4rTVuPS9xYnERIE6_G2F65LYDvmO7zTLNbV0mkrsiD9rlOHN-Xg_376Bir9-aQAfrvebEoIrTjg0QEmXvPISMg2V1ZkgKVQmGnWZTDNg0GM6lWCveH-dZODI:1qAIwK:55mBAC_pg-Pd7AHytHzPWq-5UxCgSoRMwhW_PLRH0No', '2023-06-30 23:33:12.658947'),
('hzk3ugpabndakg5mip248xw3x7e21sy4', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAJFb:NuteogTA8aamZiAHk9KxzQ0ZbdG0n5oVKCq073Kigow', '2023-06-30 23:53:07.173405'),
('cxz530pms6k89h5xfhf07sqzgfhqyrm4', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAJJK:wSNnX3P84qfkhDu1YVJ_gR3P-JiCwOnLJlk5h3jlTz0', '2023-06-30 23:56:58.426757'),
('127eqwlp828bb0ez0adffe3luapqda3a', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAJRi:tmPW9I_G3iTRFQRxVj55Q1L0Emnn4cKyCCZFpMp9wd8', '2023-07-01 00:05:38.448525'),
('cqrov7hs0ffeipbq4iubmlfmw473l60a', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAJTq:Jk8GBn65ujMxbXAUcqXFdvrEVivWkk9uWF4Rx_xcA0I', '2023-07-01 00:07:50.834545'),
('pfq86yxav5kkurx0gck67wmwlkicmyao', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAJVA:k9c55_5sR6d6Z2SRcD_PELe4NAaIJgtlhkjFa7uXwgw', '2023-07-01 00:09:12.287969'),
('7upx2b4k1wx7yo8bjyydysrh35tsaot9', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAJpP:gDHuYzdQy0mtegJI4dOtxsTlsvYytccUV6KNofHw0bA', '2023-07-01 00:30:07.470609'),
('5s7m4tm5jpzsuy3yetaiiuny9tzhwm8c', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAJxG:qQPH_PlQzzu11nBdi2qZnp51dNPUu4FgGw2bFnGU3Ec', '2023-07-01 00:38:14.565713'),
('t32lgnncnf1scjez2m8wqal2uakwwr01', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAJzF:D_W0Uiwd7jLRdsbq2ysgFRtF1uRi0jNddlGPjzIs_8U', '2023-07-01 00:40:17.578387'),
('dvddx3i23iqryckls3xias9hwxe8gcqq', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAK06:GkOzPz-rddBBFoBvGYW4S8g4v58kmksyvML5Ota5Dts', '2023-07-01 00:41:10.342116'),
('ladt1xygzld6manb1nsqc2moqthbupdn', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAK1B:pxmwmSwJlUta-TXWRpkIPsFvf6n_18H9XT3HLcqn524', '2023-07-01 00:42:17.712292'),
('69r27tvsvm1fmq6d2kbla0ygt0muyxhi', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAK7N:eKICnbwihXWIPF7e_Xdx1G1o0bYxSziw20PWoDN0cyg', '2023-07-01 00:48:41.652062'),
('4bnnnqxmpqfm658i74gaqmsxm4k55rzc', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAKHG:pqFzcOalbFJR7sSyJg1TSwr8kn-J_Hpa2NDXYpkLs9c', '2023-07-01 00:58:54.659282'),
('lqn4k5sljgpqm76yvjzvk2q8hyqmqm0u', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAKJd:ftwMYS_qZEx-gMbkW47XLcaKPLVNXnlzliaoX1c972k', '2023-07-01 01:01:21.342561'),
('4jigxuw3gzbws8ld2cid7brlr2cf9g4i', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAKPN:rssCptuenJMbqEqCl8FzK5ihJ_E83w3bU7Hqp41oOCk', '2023-07-01 01:07:17.673050'),
('ua07sf4u81mao1480yr8327xdrstxd1o', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qALzX:qI5pNpue1qlRhtfWlSR6Zvh0YwEtFNS6tHNIDYGoxeU', '2023-07-01 02:48:43.539917'),
('i379wjj089sicze3tk4s3d4fo21gld57', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAM9j:rM0wKIC8Ihz_SZ8TkMjL-UjlgZ5wUbraQC3x3UOrcPw', '2023-07-01 02:59:15.565950'),
('oezwu04u41qmzmi7ll0eohzwhqggy01t', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAMAi:XU70Rrw3819yazQCHiRdJAp5lxzYIgwEH9NZoq1CLTo', '2023-07-01 03:00:16.328647'),
('y6tw54kqsu9p9zm7ovpodrna6yd1kfl1', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAMCI:0FpchAwUbBaZu_Mz97ytDqYX3l_AmIsIf6YO0kwjYfA', '2023-07-01 03:01:54.272858'),
('xf4ly2m0sb9c7huiph0v7kv2r02gb8ri', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAMLq:1lb7CEfkBl-WcBGuym9J4WzHOp_HHJYLJVWPTyFPSiY', '2023-07-01 03:11:46.843076'),
('t1i1vkkrg7939lxojtu1s9w3cow0sjif', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAMQ6:nlbool9FeDDGFJoIkVw1TeiW7jUv36JR43wgtwvyvqc', '2023-07-01 03:16:10.613586'),
('q3g4ymve9r4q1hgvytfzeunhzmgafubv', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAMQj:LTiY9YuAxhYMpNi6A2zghfWBmHuyXUBtYUn_nUX2g2Q', '2023-07-01 03:16:49.258137'),
('5ciffl38asvoe7cn1gg7xnvvnggpoz5z', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAMRJ:8xQWsXoWMzgt0M5OroX-p8O33NOEXDdy_yypmNYhrnI', '2023-07-01 03:17:25.544058'),
('fjxyx3sgbp0flep886zmh8ogz8z0ydrt', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAMSN:Zjh5sbPF-sRojdytRHzZi30Rpog9CAY-PMfJJ6IkyTU', '2023-07-01 03:18:31.939659'),
('w0pjzi34hcw9ldydo1w37kpw34cb5k2s', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAMU3:W-8ZWJx12kU_EB_H8bEZ0AiLNCW75PQI0O7NMuYXaqU', '2023-07-01 03:20:15.985055'),
('e2yzkjgkvt85l23ejb4be0dl6vw0ft3k', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAMV6:GpFgxD0cS5nD7CjzkTdY2GL4EsR-hLkOG4tHwvIO9HU', '2023-07-01 03:21:20.034056'),
('tem3joxno5vrbbqkhrq47atbnlvpug3q', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAMVp:6X1N_mXwaKMpuVD5I9pHn5xtdDTwtaXoRrqwOHSbb1U', '2023-07-01 03:22:05.295435'),
('7efuf9539b56ehu6pkj8u005obws7qdi', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAMWk:YmSEFNlCklpZo-ddUDp6rE_TKARrigsZkn0xuak0ZOQ', '2023-07-01 03:23:02.076804'),
('414533acw6o6onrsopo16yyfe3w7uf7z', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAMjG:w37ChzpUiPGaEaCkjX10BbZf28-BypGEskFAOgzhlhs', '2023-07-01 03:35:58.019671'),
('foekkrh7zaxe2mc21thx1b1fhm34z16v', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAMtH:MB6_tNVOOs2xgBAeb8j1M5qTMx6lfI5PC05Y9vp5pOw', '2023-07-01 03:46:19.832497'),
('cq97qmvcpmc0gjos9xg2thyu2vezv7f3', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAMwP:7hI7hV078IGepN2sjXO-5EzY4jFCI_mZhzVE2Y7O_FI', '2023-07-01 03:49:33.205793'),
('rfix9crjwyumfb1ie7ozxzwsqzea7eb7', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAMzN:q6wwk3zEmJDvkpceKxgcBL0Nm1b0gCMx5yCNJpOWbmw', '2023-07-01 03:52:37.326016'),
('egmnn4o6e0vpgs26nx7hf16iqjntatw7', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAN0I:NApZNVVMulwhmedw9HzHGihjKQ7R23Zqcj2KOy_vvIk', '2023-07-01 03:53:34.753696'),
('5wv9xx6la5rj8ezhufiut8hz7g07si3h', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAN3K:c3grCLnFF47x-UKnFw0bTqih-uQ42ObmWVNh-xuTDXo', '2023-07-01 03:56:42.906714'),
('dahi7moajt81s8x2cs2brbk52vf9gbvl', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAN99:senCnVLMuAq3JM7ttsuXKpK69jGwwqdREdR7egJGxws', '2023-07-01 04:02:43.522321'),
('eodgl4dl8sft555yebc981oo0bjf8w4c', '.eJxVjEEOwiAQRe_C2hDAAYpL9z0DmWFAqoYmpV0Z765NutDtf-_9l4i4rTVuPS9xYnERIE6_G2F65LYDvmO7zTLNbV0mkrsiD9rlOHN-Xg_376Bir9-aQAfrvebEoIrTjg0QEmXvPISMg2V1ZkgKVQmGnWZTDNg0GM6lWCveH-dZODI:1qANDL:GyFJxBWPG-YbzSh93W5j9_o8SB3naTTpWpFOarQC9uw', '2023-07-01 04:07:03.595214'),
('i2kfb7br3wvt11bbpecnnman4zex6k18', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qANGG:OioxG9SNxUpPOCoAPD1ynfr1XPRu-Vz4mgFKsYFGwDs', '2023-07-01 04:10:04.753357'),
('2agheocsfxnk9l8n9bd9uu071yugu4eq', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qANIr:f7wKOjm7UUtediKYmZrf0fyHJ8lFQvjhHSDlj__zUb8', '2023-07-01 04:12:45.447199'),
('tftjm8auvbnekqtq6bvhl9b111xhz7hk', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qANLa:xUKR_AcOJp-HcYJ7Q8F2RrOdBGurBqjUlqV_E8zdYY8', '2023-07-01 04:15:34.231293'),
('qjuo3d7u1r8cypwovc5jrp3fqcnig771', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qANPF:S1GOi8AFls9N2mSJ7w6w1CweR4vsylXeyyKf3z5zdAs', '2023-07-01 04:19:21.952993'),
('g5t1aj5pilwbgtgkotoyn0v5kofcaxcy', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qANV6:LHMP3Z3uvgtfuUsE_703uKLqzm7TAjDXKlAR-p2pdaU', '2023-07-01 04:25:24.801035'),
('9wloqx5xa1u9l1a9hjc0k1bh1cm0z55u', '.eJxVjEEOwiAQRe_C2hDAAYpL9z0DmWFAqoYmpV0Z765NutDtf-_9l4i4rTVuPS9xYnERIE6_G2F65LYDvmO7zTLNbV0mkrsiD9rlOHN-Xg_376Bir9-aQAfrvebEoIrTjg0QEmXvPISMg2V1ZkgKVQmGnWZTDNg0GM6lWCveH-dZODI:1qANW2:Oq2n5kvjyeoDSFp9btFMQP-S1bjcL4gKcTWED4KatbM', '2023-07-01 04:26:22.264758'),
('pzj8fq095i551d2rxdbcgbpasfrewnq3', '.eJxVjEEOwiAQRe_C2hDAAYpL9z0DmWFAqoYmpV0Z765NutDtf-_9l4i4rTVuPS9xYnERIE6_G2F65LYDvmO7zTLNbV0mkrsiD9rlOHN-Xg_376Bir9-aQAfrvebEoIrTjg0QEmXvPISMg2V1ZkgKVQmGnWZTDNg0GM6lWCveH-dZODI:1qANX5:N1kfjndpn17j0WGQ93CcVwJE3svIA-t4cgSioDMFPVA', '2023-07-01 04:27:27.661628'),
('jcwb79s96c2umn5a8250oh8kcsj8lwjc', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qANZX:lT5_7_8K6KnvkQ68HEwTUSURQUd-gL45uMcoeiDiCuU', '2023-07-01 04:29:59.958459'),
('gfjutm0myf78z8razhsxxjb4t7j9tp29', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qANc1:dAqVBBCZDnQrT6kJFejAF-xnN6E15PNq3Yu-8H59B8E', '2023-07-01 04:32:33.228954'),
('8nrauhfat4whwa40g303z3zmq3wn1mnz', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAYLL:rEr_hljthKs4FPxABJxlEVezTEI9aHve3-9fZm6GYS8', '2023-07-01 16:00:03.644746'),
('dcks8kh1zszxljnvs97k253424gpuhd8', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAYWo:Yg7zSdlvJdBjYYsuutG5zhepdbuytZVnkDIAbluEg68', '2023-07-01 16:11:54.141170'),
('wb2o93901waf6qw34a7hsblxt04tpe8c', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAYYR:C5X2JS6SD0AmB4K0NR5DT1QIAjC3n12gCZwnht1Show', '2023-07-01 16:13:35.719275'),
('3nuorzhvl7tl17plxgfgrbxolmv84hrs', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAYbQ:48kJi0dBE_Jb6CncWxoeAAmMnyNuz7UqEVz5mXVCf5k', '2023-07-01 16:16:40.943170'),
('e78su8svcux8azryvf0a2gmccfa7kh9y', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAYsn:iNa9j6kuztP0v1_oePMd8KxkKEBWEGWGklX8p3Uq9E8', '2023-07-01 16:34:37.304057'),
('8dprzsgs76unb0dn60ay6cv7idnmt1al', '.eJxVjEEOwiAQRe_C2hDAAYpL9z0DmWFAqoYmpV0Z765NutDtf-_9l4i4rTVuPS9xYnERIE6_G2F65LYDvmO7zTLNbV0mkrsiD9rlOHN-Xg_376Bir9-aQAfrvebEoIrTjg0QEmXvPISMg2V1ZkgKVQmGnWZTDNg0GM6lWCveH-dZODI:1qAZ45:oXGz72JgCkHYmP27k-Ab4YFdBStn60k63JQNDutXAYM', '2023-07-01 16:46:17.137123'),
('jzdsufidgfz1uju4qoob02cdm0dkeayp', '.eJxVjEEOwiAQRe_C2hDAAYpL9z0DmWFAqoYmpV0Z765NutDtf-_9l4i4rTVuPS9xYnERIE6_G2F65LYDvmO7zTLNbV0mkrsiD9rlOHN-Xg_376Bir9-aQAfrvebEoIrTjg0QEmXvPISMg2V1ZkgKVQmGnWZTDNg0GM6lWCveH-dZODI:1qAZ6v:_J0hbkrwTGn0Ywl0hEWUx9ASxxelhEpQeA5NDuKd_Ds', '2023-07-01 16:49:13.557667'),
('snegap9ji7qt9owaxb4r4aaop0pnl6qm', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAZ8Q:vPyWWdslHhyQK-O6eQTdl7lDvVHeAkPdYHpzo94oPxo', '2023-07-01 16:50:46.070599'),
('fzk4yk8p9x97yta9m2xlrs07lu4mucvo', '.eJxVjEEOwiAQRe_C2hDaAkNduvcMzTAzSNVAUtqV8e7apAvd_vfef6kJtzVPW5NlmlmdlVOn3y0iPaTsgO9YblVTLesyR70r-qBNXyvL83K4fwcZW_7Wwpa5Gx2EjhInGH0QseIdC_SBYvA0UDJkknc9WCQhTGlwBsAgo6j3Bw_tOTs:1qAZEs:dN4vBxmd3r1KHpFIsjdt7ugHozo9zXnw7Cqx_ss8ONY', '2023-07-01 16:57:26.301739'),
('n170x3f49vj1l2c8zcld8xpzoaz2in0a', '.eJxVjEEOwiAQRe_C2hDaAkNduvcMzTAzSNVAUtqV8e7apAvd_vfef6kJtzVPW5NlmlmdlVOn3y0iPaTsgO9YblVTLesyR70r-qBNXyvL83K4fwcZW_7Wwpa5Gx2EjhInGH0QseIdC_SBYvA0UDJkknc9WCQhTGlwBsAgo6j3Bw_tOTs:1qAZMk:llbtMugNxXfTbY1Pasu_OWKhA5H4NRgQ3YTQhnRzAq4', '2023-07-01 17:05:34.004046'),
('t5xpjsj787840t65tsijedv7l1ui9xgm', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAZNS:q-5Pzyl5rprOb1rAd8YK1I3EJuHQIc9RrnTfOE1-DFI', '2023-07-01 17:06:18.972441'),
('9pvo32v16bncj78jggwkz9sx729c647j', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAZXO:akG2hrvfmaLhsyTlUC5mzDlEJFS-gzuQhe9-LxPvRTs', '2023-07-01 17:16:34.748986'),
('mvhxeqcm44vjun7dpd32oqwxz2xc0068', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAZZ6:zpsvQrZDoVso17i8fjF2TVV0h-jBLWuLjBS0X6PKhPw', '2023-07-01 17:18:20.502431'),
('bu3oy24n6yrpniumrfv4easkhcitsl7m', '.eJxVjEEOwiAQRe_C2hDaAkNduvcMzTAzSNVAUtqV8e7apAvd_vfef6kJtzVPW5NlmlmdlVOn3y0iPaTsgO9YblVTLesyR70r-qBNXyvL83K4fwcZW_7Wwpa5Gx2EjhInGH0QseIdC_SBYvA0UDJkknc9WCQhTGlwBsAgo6j3Bw_tOTs:1qAcA6:KjggzZJGZnF2rI1UKNsgIefF6-oyNZuNx0ddmGbpZkk', '2023-07-01 20:04:42.731661'),
('9ol1b6plpdtdqfbr1sbbq81n72ey71xi', '.eJxVjEEOwiAQRe_C2hDAAYpL9z0DmWFAqoYmpV0Z765NutDtf-_9l4i4rTVuPS9xYnERIE6_G2F65LYDvmO7zTLNbV0mkrsiD9rlOHN-Xg_376Bir9-aQAfrvebEoIrTjg0QEmXvPISMg2V1ZkgKVQmGnWZTDNg0GM6lWCveH-dZODI:1qAcDC:_P10QLkaHk4q48mLdnxwJFQ9rQnVaklajiduU-6pTAc', '2023-07-01 20:07:54.867058'),
('fd0cpt37lszbq8cjjt1derk4s328tmj9', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAcJA:0mvpFxTBXSaEWHMEiKwTpaD13-XSp7ysMK-iGnF7wOY', '2023-07-01 20:14:04.156793'),
('e15l4spsf8wq812tjxl2yk8deklgvhpg', '.eJxVjEEOwiAQRe_C2hAoUqYu3fcMZJgZpGpoUtqV8e7apAvd_vfef6mI21ri1mSJE6uLcur0uyWkh9Qd8B3rbdY013WZkt4VfdCmx5nleT3cv4OCrXzrQOiRDVgRTpkHGCywC8ACNhD7BGcQpI58CCn3TH3KHRuXjQHqjVHvDxMbOM8:1qAceS:8AXiyrH1K7mLD3QMhal59wrgpBlFGhVmmaQzdhLbVGA', '2023-07-01 20:36:04.656573');

-- --------------------------------------------------------

--
-- Table structure for table `editorial`
--

DROP TABLE IF EXISTS `editorial`;
CREATE TABLE IF NOT EXISTS `editorial` (
  `id_editorial` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_editorial`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `editorial`
--

INSERT INTO `editorial` (`id_editorial`, `nombre`) VALUES
(1, 'Pluma Brillante Editorial'),
(2, 'Bosque Encantado Publicaciones'),
(3, 'Vuelo Literario Ediciones'),
(4, 'Libros del Horizonte'),
(5, 'Destellos Literarios Publicaciones'),
(6, 'Universo de Páginas Ediciones'),
(7, 'Mar de Historias Ediciones'),
(8, 'Libros del Horizonte'),
(9, 'Linterna de Papel Editorial'),
(10, 'Viajero del Tiempo Editorial'),
(11, 'Sinfonía de Palabras Publicaciones'),
(12, 'Fábrica de Fantasía Editorial'),
(13, 'Sinfonía de Palabras Publicaciones'),
(14, 'Viajero del Tiempo Editorial');

-- --------------------------------------------------------

--
-- Table structure for table `elementos_carrito`
--

DROP TABLE IF EXISTS `elementos_carrito`;
CREATE TABLE IF NOT EXISTS `elementos_carrito` (
  `id_elementos_carrito` int NOT NULL AUTO_INCREMENT,
  `cantidad` smallint UNSIGNED NOT NULL,
  `id_carrito_id` int NOT NULL,
  `id_cliente_id` bigint NOT NULL,
  `id_libro_id` int NOT NULL,
  PRIMARY KEY (`id_elementos_carrito`),
  KEY `elementos_carrito_id_carrito_id_09f0f8eb` (`id_carrito_id`),
  KEY `elementos_carrito_id_cliente_id_7af99f5f` (`id_cliente_id`),
  KEY `elementos_carrito_id_libro_id_c1d41d9d` (`id_libro_id`)
) ;

--
-- Dumping data for table `elementos_carrito`
--

INSERT INTO `elementos_carrito` (`id_elementos_carrito`, `cantidad`, `id_carrito_id`, `id_cliente_id`, `id_libro_id`) VALUES
(54, 1, 3, 3, 1),
(53, 1, 3, 3, 10);

-- --------------------------------------------------------

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
CREATE TABLE IF NOT EXISTS `estado` (
  `id_estado` int NOT NULL AUTO_INCREMENT,
  `estado` varchar(2) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_estado`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `estado`
--

INSERT INTO `estado` (`id_estado`, `estado`) VALUES
(1, 'PP'),
(2, 'RR'),
(3, 'AA');

-- --------------------------------------------------------

--
-- Table structure for table `formato`
--

DROP TABLE IF EXISTS `formato`;
CREATE TABLE IF NOT EXISTS `formato` (
  `id_formato` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_formato`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `formato`
--

INSERT INTO `formato` (`id_formato`, `nombre`) VALUES
(1, 'Libro de bolsillo'),
(2, 'Tapa dura'),
(3, 'Ebook'),
(4, 'Audio libro');

-- --------------------------------------------------------

--
-- Table structure for table `idioma`
--

DROP TABLE IF EXISTS `idioma`;
CREATE TABLE IF NOT EXISTS `idioma` (
  `id_idioma` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(2) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_idioma`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `idioma`
--

INSERT INTO `idioma` (`id_idioma`, `nombre`) VALUES
(1, 'EN'),
(2, 'ES'),
(3, 'FR'),
(4, 'IT'),
(5, 'DE'),
(6, 'ZH'),
(7, 'JA'),
(8, 'PT'),
(9, 'RU'),
(10, 'AR'),
(11, 'ES'),
(12, 'EN'),
(13, 'FR'),
(14, 'DE'),
(15, 'IT'),
(16, 'PT'),
(17, 'RU'),
(18, 'ZH'),
(19, 'JA'),
(20, 'AR');

-- --------------------------------------------------------

--
-- Table structure for table `libreriavirtual_customuser`
--

DROP TABLE IF EXISTS `libreriavirtual_customuser`;
CREATE TABLE IF NOT EXISTS `libreriavirtual_customuser` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(128) COLLATE utf8mb4_general_ci NOT NULL,
  `last_login` datetime(6) DEFAULT NULL,
  `is_superuser` tinyint(1) NOT NULL,
  `username` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `first_name` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `last_name` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `is_staff` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `date_joined` datetime(6) NOT NULL,
  `email` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `dni` varchar(8) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `fecha_nac` date DEFAULT NULL,
  `telefono` varchar(12) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `id_carrito_id` int DEFAULT NULL,
  `id_direccion_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`),
  KEY `libreriavirtual_customuser_id_carrito_id_167b88ef` (`id_carrito_id`),
  KEY `libreriavirtual_customuser_id_direccion_id_8de39ab8` (`id_direccion_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `libreriavirtual_customuser`
--

INSERT INTO `libreriavirtual_customuser` (`id`, `password`, `last_login`, `is_superuser`, `username`, `first_name`, `last_name`, `is_staff`, `is_active`, `date_joined`, `email`, `dni`, `fecha_nac`, `telefono`, `id_carrito_id`, `id_direccion_id`) VALUES
(1, 'pbkdf2_sha256$600000$VWl1JJSvei3cnDrF456Z43$E2my+Bf+Md4w4+RkenJ0JucJ/bCD1aMLSEoMjLlLCAU=', '2023-06-13 21:02:22.652098', 0, 'mpanto', '', '', 0, 1, '2023-06-13 21:02:22.015854', 'test@test.com', NULL, NULL, NULL, 1, NULL),
(2, 'pbkdf2_sha256$600000$K72mXnIDee8yzVDDWr28Rb$1oC/mSFViJ8+gmB29RU2dpRD7QRs5nvDw9qacXzjyxA=', '2023-06-13 23:47:20.176247', 0, 'jmfin', '', '', 0, 1, '2023-06-13 23:30:36.449699', 'prueba@prueba.com', NULL, NULL, NULL, 2, NULL),
(3, 'pbkdf2_sha256$600000$nEhJKHKQBOApo6iPAG6uGN$kIJa/0f1tU2p+QsJZotvWFgOQ4NTlx6xaIwpMKFKG8w=', '2023-06-17 20:36:04.656573', 0, 'asdasd', '', '', 0, 1, '2023-06-13 23:55:12.152740', 'prueba1@prueba.com', NULL, NULL, NULL, 3, NULL),
(4, 'pbkdf2_sha256$600000$H90wuZyLibe4N3ciYttCa9$MDVTUjEJzK4xn978FmSKv656igxAiOyKaJpIPFSU4ZE=', '2023-06-17 20:07:54.859050', 0, 'wwdd', '', '', 0, 1, '2023-06-16 21:51:02.574195', 'prueba3@prueba.com', NULL, NULL, NULL, 4, NULL),
(5, 'pbkdf2_sha256$600000$VPFvCXme41xrS8PEXmSbNc$Fu/Uc2/uemnNczwfk1esaIMIs8Wk7Bi6kDSSk17nOms=', '2023-06-17 20:04:42.716076', 0, 'asd', '', '', 0, 1, '2023-06-17 16:57:26.018633', 'test@1.com', NULL, NULL, NULL, 5, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `libreriavirtual_customuser_groups`
--

DROP TABLE IF EXISTS `libreriavirtual_customuser_groups`;
CREATE TABLE IF NOT EXISTS `libreriavirtual_customuser_groups` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `customuser_id` bigint NOT NULL,
  `group_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `libreriavirtual_customus_customuser_id_group_id_f2ca3f7b_uniq` (`customuser_id`,`group_id`),
  KEY `libreriavirtual_customuser_groups_customuser_id_589282a3` (`customuser_id`),
  KEY `libreriavirtual_customuser_groups_group_id_14f0ec49` (`group_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `libreriavirtual_customuser_user_permissions`
--

DROP TABLE IF EXISTS `libreriavirtual_customuser_user_permissions`;
CREATE TABLE IF NOT EXISTS `libreriavirtual_customuser_user_permissions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `customuser_id` bigint NOT NULL,
  `permission_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `libreriavirtual_customus_customuser_id_permission_d32b0d30_uniq` (`customuser_id`,`permission_id`),
  KEY `libreriavirtual_customuser__customuser_id_03a75d60` (`customuser_id`),
  KEY `libreriavirtual_customuser__permission_id_fde496b0` (`permission_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
CREATE TABLE IF NOT EXISTS `libro` (
  `id_libro` int NOT NULL AUTO_INCREMENT,
  `isbn` varchar(17) COLLATE utf8mb4_general_ci NOT NULL,
  `titulo` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `subtitulo` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `paginas` smallint UNSIGNED NOT NULL,
  `peso` decimal(6,2) NOT NULL,
  `edicion` varchar(4) COLLATE utf8mb4_general_ci NOT NULL,
  `resenia` varchar(1000) COLLATE utf8mb4_general_ci NOT NULL,
  `precio` decimal(7,2) NOT NULL,
  `stock` smallint UNSIGNED NOT NULL,
  `img_url` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `id_autor_id` int NOT NULL,
  `id_categoria_id` int NOT NULL,
  `id_editorial_id` int NOT NULL,
  `id_formato_id` int NOT NULL,
  `id_idioma_id` int NOT NULL,
  PRIMARY KEY (`id_libro`),
  UNIQUE KEY `isbn` (`isbn`),
  KEY `libro_id_autor_id_2aa02e2b` (`id_autor_id`),
  KEY `libro_id_categoria_id_bde041d7` (`id_categoria_id`),
  KEY `libro_id_editorial_id_6fcf054c` (`id_editorial_id`),
  KEY `libro_id_formato_id_ad00c2bb` (`id_formato_id`),
  KEY `libro_id_idioma_id_9987841e` (`id_idioma_id`)
) ;

--
-- Dumping data for table `libro`
--

INSERT INTO `libro` (`id_libro`, `isbn`, `titulo`, `subtitulo`, `paginas`, `peso`, `edicion`, `resenia`, `precio`, `stock`, `img_url`, `id_autor_id`, `id_categoria_id`, `id_editorial_id`, `id_formato_id`, `id_idioma_id`) VALUES
(1, '9782070612758', 'El Principito', 'El Secreto de la Ciudad Olvidada', 500, '700.00', '2022', 'Una misteriosa novela de intriga y romance ambientada en la Barcelona de posguerra.', '2654.99', 100, 'https://m.media-amazon.com/images/I/51qrVjSm1mL._SX578_BO1,204,203,200_.jpg', 1, 1, 1, 1, 1),
(2, '9781234567891', 'Cuando no queden más estrellas que contar', 'Un Viaje por el Cosmos', 300, '500.00', '2023', 'Un fascinante recorrido por el universo y los misterios de la ciencia moderna.', '2900.99', 80, 'https://http2.mlstatic.com/D_NQ_NP_859079-MLA49255030580_032022-O.jpg', 2, 2, 2, 2, 1),
(3, '9781234567892', 'La Vida Secreta de los Árboles', 'Lo que Sienten, Cómo se Comunican', 250, '400.00', '2023', 'Un sorprendente viaje al corazón de los bosques, revelando sus secretos más insondables.', '1956.99', 120, 'https://www.terra.org/sites/default/files/terra/vidasecreta.jpg', 3, 3, 3, 1, 1),
(4, '9781234567893', 'El Juego de la Vida', 'Meditaciones para el Siglo XXI', 200, '300.00', '2022', 'Una colección de reflexiones y meditaciones para navegar los desafíos de la vida moderna.', '1476.99', 50, 'https://pictures.abebooks.com/isbn/9789706660008-es.jpg', 4, 4, 1, 1, 1),
(5, '9781234567894', 'La Gran Travesía', 'Un Viaje a lo Desconocido', 600, '800.00', '2023', 'Una épica aventura de supervivencia y descubrimiento en los confines del mundo.', '8734.99', 30, 'https://www.nocturnaediciones.com/imagenes/biblioteca/170_alta.jpg', 5, 5, 4, 3, 1),
(6, '9781234567895', 'El Secreto de la Felicidad', 'Claves para una Vida Plena', 200, '350.00', '2022', 'Un manual inspirador que explora las prácticas y los hábitos para alcanzar la felicidad auténtica.', '8714.99', 75, 'https://images.cdn3.buscalibre.com/fit-in/360x360/c1/31/c131715e0a4f489bed8625690d1a38c3.jpg', 6, 6, 5, 1, 1),
(7, '9781234567896', 'Caminos Cruzados', 'Destinos Entrelazados', 350, '500.00', '2023', 'Una conmovedora novela de amor y sacrificio, en la que los caminos de dos extraños se entrecruzan de manera inesperada.', '25674.99', 90, 'https://contentv2.tap-commerce.com/cover/large/9788467032574_1.jpg?id_com=1156', 7, 5, 4, 2, 1),
(8, '9781234567897', 'Cocina Saludable', 'Recetas para una Vida Equilibrada', 220, '450.00', '2023', 'Un libro de recetas deliciosas y nutritivas para llevar una vida más saludable.', '1789.99', 200, 'https://http2.mlstatic.com/D_NQ_NP_712887-MLA43135955735_082020-O.jpg', 8, 8, 6, 1, 1),
(9, '9781234567898', 'En el Corazón de la Selva', 'Un Relato de Aventura y Descubrimiento', 450, '600.00', '2022', 'Una historia de aventuras y descubrimientos en la selva amazónica llena de misterio y emoción.', '2454.99', 60, 'https://imagessl9.casadellibro.com/a/l/t5/69/9788418641169.jpg', 9, 5, 1, 1, 1),
(10, '9781234567899', 'La Esencia del Tiempo', 'Una Perspectiva Filosófica', 300, '400.00', '2023', 'Un profundo análisis filosófico de la naturaleza del tiempo y nuestro lugar en el universo.', '2459.99', 40, 'https://pictures.abebooks.com/inventory/md/md30188300367.jpg', 10, 6, 11, 2, 1),
(11, '9781234567800', 'Cuentos de la Luna Azul', 'Leyendas y Mitos', 250, '350.00', '2023', 'Una colección fascinante de mitos y leyendas de todo el mundo relacionadas con la luna.', '1945.99', 120, 'https://m.media-amazon.com/images/I/41gs9t8bsoL._AC_UF1000,1000_QL80_.jpg', 11, 7, 12, 1, 1),
(12, '9781234567802', 'El Arte de la Guerra Moderna', 'Estrategias del Siglo XXI', 260, '360.00', '2023', 'Un análisis profundo de las estrategias y tácticas usadas en los conflictos modernos.', '6729.99', 70, 'https://www.esferalibros.com/wp-content/uploads/2022/10/el-nuevo-arte-de-la-guerra-scaled.jpg', 13, 8, 14, 1, 1),
(13, '9781234567803', 'Ecos del Pasado', 'Historias de un Mundo Olvidado', 320, '450.00', '2023', 'Una compilación de cuentos históricos que nos lleva a tiempos y lugares lejanos.', '7824.99', 65, 'https://2.bp.blogspot.com/-JNgJjxIoWqg/W8VZ9eeuZvI/AAAAAAAAFiE/LGVJdanT284SrayH7GcJtEbPrd47iYQbwCLcBGAs/s1600/44042053_676485059402118_6013615849816981504_n.jpg', 14, 8, 12, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `localidad`
--

DROP TABLE IF EXISTS `localidad`;
CREATE TABLE IF NOT EXISTS `localidad` (
  `id_localidad` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `codigo_postal` varchar(8) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_localidad`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `orden`
--

DROP TABLE IF EXISTS `orden`;
CREATE TABLE IF NOT EXISTS `orden` (
  `id_orden` int NOT NULL AUTO_INCREMENT,
  `fecha_creacion` datetime(6) NOT NULL COMMENT 'The field is only automatically updated when calling Model.save()',
  `total` decimal(7,2) NOT NULL,
  `id_cliente_id` bigint NOT NULL,
  `id_estado_id` int NOT NULL,
  PRIMARY KEY (`id_orden`),
  KEY `orden_id_cliente_id_4972aefe` (`id_cliente_id`),
  KEY `orden_id_estado_id_3f75593f` (`id_estado_id`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orden`
--

INSERT INTO `orden` (`id_orden`, `fecha_creacion`, `total`, `id_cliente_id`, `id_estado_id`) VALUES
(32, '2023-06-17 20:46:55.139894', '5114.98', 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
CREATE TABLE IF NOT EXISTS `pago` (
  `id_pago` int NOT NULL AUTO_INCREMENT,
  `fecha_pago` datetime(6) NOT NULL COMMENT 'The field is only automatically updated when calling Model.save()',
  `monto` decimal(7,2) NOT NULL,
  `info_adicional` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `id_orden_id` int NOT NULL,
  PRIMARY KEY (`id_pago`),
  KEY `pago_id_orden_id_0c18e452` (`id_orden_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
CREATE TABLE IF NOT EXISTS `pedido` (
  `id_pedido` int NOT NULL AUTO_INCREMENT,
  `seguimiento` varchar(2) COLLATE utf8mb4_general_ci NOT NULL,
  `fecha` datetime(6) NOT NULL COMMENT 'The field is only automatically updated when calling Model.save()',
  `nro_tracking` varchar(40) COLLATE utf8mb4_general_ci NOT NULL,
  `id_cliente_id` bigint NOT NULL,
  `id_orden_id` int NOT NULL,
  PRIMARY KEY (`id_pedido`),
  KEY `pedido_id_cliente_id_fcd9c6e9` (`id_cliente_id`),
  KEY `pedido_id_orden_id_5f22fad0` (`id_orden_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
CREATE TABLE IF NOT EXISTS `provincia` (
  `id_provincia` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(2) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_provincia`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `provincia`
--

INSERT INTO `provincia` (`id_provincia`, `nombre`) VALUES
(1, 'BA'),
(2, 'CT'),
(3, 'CH'),
(4, 'CB'),
(5, 'CD'),
(6, 'CR'),
(7, 'ER'),
(8, 'FO'),
(9, 'JY'),
(10, 'LP'),
(11, 'LR'),
(12, 'MZ'),
(13, 'MN'),
(14, 'NQ'),
(15, 'RN'),
(16, 'SA'),
(17, 'SJ'),
(18, 'SL'),
(19, 'SC'),
(20, 'SF'),
(21, 'SE'),
(22, 'TF'),
(23, 'TM');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
