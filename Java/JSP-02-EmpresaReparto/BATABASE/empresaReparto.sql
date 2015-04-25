-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 28-03-2015 a las 14:30:10
-- Versión del servidor: 5.5.41-0ubuntu0.14.04.1
-- Versión de PHP: 5.5.9-1ubuntu4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `empresaReparto`
--
CREATE DATABASE IF NOT EXISTS `empresaReparto` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `empresaReparto`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coche`
--

DROP TABLE IF EXISTS `coche`;
CREATE TABLE IF NOT EXISTS `coche` (
  `matricula` varchar(10) NOT NULL,
  `numeroPlazas` int(11) DEFAULT NULL,
  `nombre` varchar(40) DEFAULT NULL,
  `cif` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`matricula`),
  KEY `nombre` (`nombre`),
  KEY `cif` (`cif`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `coche`
--

INSERT INTO `coche` (`matricula`, `numeroPlazas`, `nombre`, `cif`) VALUES
('1122-AB', 1, 'carlos11', '1'),
('4253-WED', 3, 'carlos22', '2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

DROP TABLE IF EXISTS `empleado`;
CREATE TABLE IF NOT EXISTS `empleado` (
  `nombre` varchar(40) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `edad` int(11) DEFAULT NULL,
  `nombreJefe` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`nombre`),
  KEY `nombreJefe` (`nombreJefe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`nombre`, `fechaNacimiento`, `edad`, `nombreJefe`) VALUES
('carlos11', '2015-02-01', 30, NULL),
('carlos21', '2015-02-02', 29, 'carlos11'),
('carlos22', '2015-02-01', 30, NULL),
('carlos31', '2015-02-03', 28, 'carlos22'),
('carlos41', '2015-02-04', 27, 'carlos11'),
('carlos51', '2015-02-12', 26, 'carlos22'),
('carlos61', '2015-02-13', 25, 'carlos11'),
('carlos71', '2015-02-14', 24, 'carlos22'),
('carlos81', '2015-02-15', 23, 'carlos11'),
('carlos91', '2015-02-16', 22, 'carlos22');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleadoEmpresa`
--

DROP TABLE IF EXISTS `empleadoEmpresa`;
CREATE TABLE IF NOT EXISTS `empleadoEmpresa` (
  `nombre` varchar(40) NOT NULL,
  `cif` varchar(10) NOT NULL,
  PRIMARY KEY (`nombre`,`cif`),
  KEY `cif` (`cif`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleadoEmpresa`
--

INSERT INTO `empleadoEmpresa` (`nombre`, `cif`) VALUES
('carlos11', '1'),
('carlos21', '1'),
('carlos22', '2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

DROP TABLE IF EXISTS `empresa`;
CREATE TABLE IF NOT EXISTS `empresa` (
  `cif` varchar(10) NOT NULL,
  `nombre` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`cif`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`cif`, `nombre`) VALUES
('1', 'Innova4b'),
('2', 'InnoBaske'),
('2222', '11111'),
('xzcv', 'vzxc');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `coche`
--
ALTER TABLE `coche`
  ADD CONSTRAINT `coche_ibfk_1` FOREIGN KEY (`nombre`) REFERENCES `empleado` (`nombre`),
  ADD CONSTRAINT `coche_ibfk_2` FOREIGN KEY (`cif`) REFERENCES `empresa` (`cif`);

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`nombreJefe`) REFERENCES `empleado` (`nombre`);

--
-- Filtros para la tabla `empleadoEmpresa`
--
ALTER TABLE `empleadoEmpresa`
  ADD CONSTRAINT `empleadoEmpresa_ibfk_1` FOREIGN KEY (`nombre`) REFERENCES `empleado` (`nombre`),
  ADD CONSTRAINT `empleadoEmpresa_ibfk_2` FOREIGN KEY (`cif`) REFERENCES `empresa` (`cif`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
