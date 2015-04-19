-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 19-01-2013 a las 16:12:52
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `anbulategia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita_sendagile`
--

CREATE TABLE IF NOT EXISTS `cita_sendagile` (
  `idazkarizenbakia` int(200) NOT NULL,
  `gaixozenbakia` int(200) NOT NULL,
  `sendagilezenbakia` int(200) NOT NULL,
  `data` date NOT NULL,
  `gela` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `hasiera` time NOT NULL,
  PRIMARY KEY (`idazkarizenbakia`,`gaixozenbakia`,`sendagilezenbakia`,`data`),
  KEY `gaixozenbakia` (`gaixozenbakia`),
  KEY `sendagilezenbakia` (`sendagilezenbakia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `cita_sendagile`
--

INSERT INTO `cita_sendagile` (`idazkarizenbakia`, `gaixozenbakia`, `sendagilezenbakia`, `data`, `gela`, `hasiera`) VALUES
(2, 2, 2, '2013-01-07', 'Gela A1', '08:00:00'),
(3, 30, 5, '2013-01-06', 'a1', '08:00:00'),
(3, 30, 5, '2013-01-07', 'a2', '09:00:00'),
(3, 30, 5, '2013-01-08', 'a2', '10:00:00'),
(3, 31, 5, '2013-01-06', 'a1', '08:00:00'),
(3, 31, 5, '2013-01-07', 'a2', '09:00:00'),
(3, 31, 5, '2013-01-08', 'a3', '12:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `episodioa`
--

CREATE TABLE IF NOT EXISTS `episodioa` (
  `episodiozenbakia` int(200) NOT NULL AUTO_INCREMENT,
  `kontsultazenbakia` int(200) NOT NULL,
  `deskribapena` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `larritasuna` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `gaixozenbakia` int(200) NOT NULL,
  PRIMARY KEY (`episodiozenbakia`),
  KEY `kontsultazenbakia` (`kontsultazenbakia`),
  KEY `gaixozenbakia` (`gaixozenbakia`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `episodioa`
--

INSERT INTO `episodioa` (`episodiozenbakia`, `kontsultazenbakia`, `deskribapena`, `larritasuna`, `gaixozenbakia`) VALUES
(5, 52, 'fantasma', 'fantasma', 2),
(6, 53, 'mukiak', 'ez', 31),
(7, 53, 'nekea', 'ez', 31),
(8, 54, 'begi gorriak', 'pixkat', 31),
(9, 55, 'Neumonia', 'larria', 30);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `erizaina`
--

CREATE TABLE IF NOT EXISTS `erizaina` (
  `erizainzenbakia` int(200) NOT NULL AUTO_INCREMENT,
  `dni` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `izena` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `abizena` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `helbidea` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `tlf` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `jaiotzedata` date NOT NULL,
  `user` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `pass` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `perfilzenbakia` int(200) NOT NULL,
  PRIMARY KEY (`erizainzenbakia`),
  KEY `perfilzenbakia` (`perfilzenbakia`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `erizaina`
--

INSERT INTO `erizaina` (`erizainzenbakia`, `dni`, `izena`, `abizena`, `helbidea`, `tlf`, `jaiotzedata`, `user`, `pass`, `perfilzenbakia`) VALUES
(3, '11111111', 'maite', 'zubizarreta', 'juan de albisu', '943625825', '2012-12-05', 'e', 'e', 2),
(4, '10', 'miren', 'alustiza', 'C\\Nagusiaa', '4343', '2013-01-08', 'e1', 'e1', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `errezeta`
--

CREATE TABLE IF NOT EXISTS `errezeta` (
  `errezetazenbakia` int(200) NOT NULL AUTO_INCREMENT,
  `episodiozenbakia` int(200) NOT NULL,
  `emandakodata` datetime NOT NULL,
  `deskribapena` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `kantitatea` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`errezetazenbakia`),
  KEY `episodiozenbakia` (`episodiozenbakia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `froga`
--

CREATE TABLE IF NOT EXISTS `froga` (
  `frogazenbakia` int(200) NOT NULL AUTO_INCREMENT,
  `idazkarizenbakia` int(200) NOT NULL,
  `gaixozenbakia` int(200) NOT NULL,
  `erizainzenbakia` int(200) NOT NULL,
  `episodiozenbakia` int(200) NOT NULL,
  `gela` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `frogadata` date NOT NULL,
  `frogaordua` time NOT NULL,
  `idazkariakegindakodata` datetime NOT NULL,
  `sendagileakegindakodata` datetime NOT NULL,
  `deskribapena` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `emaitza` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `ikusia` tinyint(1) NOT NULL,
  `eginda` tinyint(1) NOT NULL,
  PRIMARY KEY (`frogazenbakia`),
  KEY `idazkarizenbakia` (`idazkarizenbakia`,`gaixozenbakia`,`erizainzenbakia`,`episodiozenbakia`),
  KEY `idazkarizenbakia_2` (`idazkarizenbakia`,`gaixozenbakia`,`erizainzenbakia`,`episodiozenbakia`),
  KEY `erizainzenbakia` (`erizainzenbakia`),
  KEY `gaixozenbakia` (`gaixozenbakia`),
  KEY `episodiozenbakia` (`episodiozenbakia`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `froga`
--

INSERT INTO `froga` (`frogazenbakia`, `idazkarizenbakia`, `gaixozenbakia`, `erizainzenbakia`, `episodiozenbakia`, `gela`, `frogadata`, `frogaordua`, `idazkariakegindakodata`, `sendagileakegindakodata`, `deskribapena`, `emaitza`, `ikusia`, `eginda`) VALUES
(1, 3, 30, 4, 6, 'a2', '2013-01-02', '12:00:00', '2013-01-01 00:00:00', '2013-01-01 00:00:00', 'Analisia', 'Ondo', 0, 1),
(2, 3, 31, 4, 8, 'a2', '2013-01-01', '11:00:00', '2013-01-01 00:00:00', '2013-01-01 00:00:00', 'Tentsioa', 'gaixki', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gaixoa`
--

CREATE TABLE IF NOT EXISTS `gaixoa` (
  `gaixozenbakia` int(200) NOT NULL AUTO_INCREMENT,
  `sendagilenagusia` int(200) NOT NULL,
  `dni` varchar(20) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `izena` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `abizena` varchar(200) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `helbidea` varchar(200) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `tlf` varchar(50) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `jaiotzedata` date DEFAULT NULL,
  PRIMARY KEY (`gaixozenbakia`),
  KEY `sendagilenagusia` (`sendagilenagusia`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=43 ;

--
-- Volcado de datos para la tabla `gaixoa`
--

INSERT INTO `gaixoa` (`gaixozenbakia`, `sendagilenagusia`, `dni`, `izena`, `abizena`, `helbidea`, `tlf`, `jaiotzedata`) VALUES
(2, 2, 'asda', 'asddas', 'adsa', NULL, NULL, NULL),
(3, 2, 'dsf', 'dfsgfdgdfsg', 'dsfgdsgsdgs', 'df', 'adsf', '2013-01-01'),
(4, 2, 'dsf', 'ddddddddddd', 'dddddddddddd', 'df', 'adsf', '2013-01-02'),
(5, 2, 'gaixoa 11111', 'cccccccccc', 'cccccccccc', 'gaixoa 11111', 'gaixoa 11111', '2013-01-02'),
(6, 4, '232333234', 'mikelon', 'amunarriz', 'hernani343', 'hernani343', '2013-01-08'),
(7, 4, '44560675', 'carlos', 'iribarren', 'irunnnnnn', 'irunnnnnn', '1984-08-08'),
(8, 3, 'fffffffff', 'ffffffff', 'fffffffff', 'fffffffff', 'fffffffff', '2013-01-13'),
(9, 3, 'eeeeeeeee', 'eeeeeee', 'eeeeeeeee', 'eeeeeeeee', 'eeeeeeeeee', '2013-01-10'),
(10, 2, 'zzzzzzzzzz', 'zzzzzzzz', 'zzzzzzzzzz', 'zzzzzzzzzz', 'zzzzzzzzzz', '2013-01-01'),
(11, 3, 'wwwwwwww', 'wwwwwww', 'wwwwwwwww', 'wwwwwwww', 'wwwwwwwww', '2013-01-06'),
(12, 2, 'ooooooooo', 'oooooooo', 'ooooooooo', 'ooooooooo', 'ooooooooo', '2013-01-01'),
(13, 3, 'vvvvvvvvv', 'vvvvvvvv', 'vvvvvvvv', 'vvvvvvvv', 'vvvvvvvvv', '2013-01-01'),
(14, 4, 'jjjjjjjj', 'jjjjjjjj', 'jjjjjjjjj', 'jjjjjjjjj', 'jjjjjjjjj', '2013-01-05'),
(15, 2, '333333333', '3333333', '333333333', '333333333', '333333333', '2013-01-01'),
(16, 2, 'adsfadsfasf', 'asdfsfasf', 'dsafasfasf', 'adsfasfasf', 'adsfasfasf', '2013-01-01'),
(17, 2, '55555555', '55555555', '55555555', '555555555', '555555555', '2013-01-02'),
(18, 2, 'asdfasfasf', 'fdasfssdaf', 'adsfasfasf', 'asdfasfasf', 'adsfafadf', '2013-01-01'),
(19, 4, 'bai', 'bai', 'bai', 'bai', 'bai', '2013-01-08'),
(20, 4, 'ez', 'ez', 'ez', 'ez', 'ez', '2013-01-03'),
(21, 2, 'ezez', 'ezez', 'ezez', 'ezez', 'ezez', '2013-01-04'),
(22, 2, 're', 're', 'rev', 're', 'rere', '2013-01-03'),
(23, 2, 'FFFF', 'FFFF', 'FFFFF', 'FFF', 'FFF', '2013-01-03'),
(24, 2, 'ZXCV', 'DFASF', 'DFZCXV', 'ZCVX', 'ZVX', '2013-01-03'),
(25, 3, 'oooo', 'oooooooooo', 'oooooooo', 'ooooo', 'oooo', '2013-01-12'),
(26, 4, 'wer', 'wer', 'wer', 'wer', 'wer', '2013-01-15'),
(27, 2, 'zxcv', 'dasf', 'zcv', 'zv', 'zcxv', '2013-01-02'),
(28, 2, 'zcvx', 'dszcxv', 'zcxv', 'zcv', 'z', '2013-01-09'),
(29, 2, 'A', 'asd', 'A', 'SAD', 'SD', '2013-01-03'),
(30, 2, 'agustin', 'ceberio', 'xb', 'cb', 'bx', '2013-01-01'),
(31, 5, 'carlos', 'iribarren', 'xcb', 'xcb', 'xcb', '2013-01-01'),
(32, 2, 'xcb', 'gh', 'bx', 'xcb', 'xcb', '2013-01-01'),
(33, 2, 'fff', 'fffffff', 'ffff', 'fff', 'ffff', '2013-01-07'),
(34, 2, 'cvx', 'cv', 'cvx', 'cvx', 'cxv', '2013-01-01'),
(35, 3, 'vx', 'qqqq', 'cxv', 'xcv', 'qqq', '2013-01-01'),
(36, 3, 'mmm', 'mmmm', 'mmmm', 'mmm', 'mm', '2013-01-02'),
(37, 2, 'nnn', 'nnnn', 'nnn', 'nnn', 'nn', '2013-01-01'),
(38, 2, 'asdf', 'asdf', 'asd', 'adsf', 'adsf', '2013-01-01'),
(39, 4, '45454545', 'juan', 'ramon', 'donostia', '65434564', '2013-01-07'),
(40, 2, '3333', 'maite', 'zubizarreta', 'irun', '24324', '2013-01-02'),
(41, 2, 'ccc', 'cccc', 'ccc', 'ccc', 'ccc', '2013-01-01'),
(42, 5, '1212', 'roberto', 'zeberio', 'Mendian', '3232', '2013-01-02');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `idazkaria`
--

CREATE TABLE IF NOT EXISTS `idazkaria` (
  `idazkarizenbakia` int(200) NOT NULL AUTO_INCREMENT,
  `dni` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `izena` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `abizena` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `helbidea` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `tlf` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `jaoitzedata` date NOT NULL,
  `user` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `pass` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `perfilzenbakia` int(200) NOT NULL,
  PRIMARY KEY (`idazkarizenbakia`),
  KEY `perfilzenbakia` (`perfilzenbakia`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `idazkaria`
--

INSERT INTO `idazkaria` (`idazkarizenbakia`, `dni`, `izena`, `abizena`, `helbidea`, `tlf`, `jaoitzedata`, `user`, `pass`, `perfilzenbakia`) VALUES
(2, '3241341', 'ivon', 'zubicaray', 'donosti', '943443322', '2012-12-02', 'i', 'i', 3),
(3, '2233223', 'Nerea', 'Alvarez', 'C\\Karrika', '64433332', '2013-01-15', 'id', 'id', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `kontsulta`
--

CREATE TABLE IF NOT EXISTS `kontsulta` (
  `kontsultazenbakia` int(200) NOT NULL AUTO_INCREMENT,
  `gaixozenbakia` int(200) NOT NULL,
  `sendagilezenbakia` int(200) NOT NULL,
  `data` date NOT NULL,
  `hasiera` time NOT NULL,
  `gela` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`kontsultazenbakia`),
  KEY `gaixozenbakia` (`gaixozenbakia`,`sendagilezenbakia`),
  KEY `sendagilezenbakia` (`sendagilezenbakia`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=57 ;

--
-- Volcado de datos para la tabla `kontsulta`
--

INSERT INTO `kontsulta` (`kontsultazenbakia`, `gaixozenbakia`, `sendagilezenbakia`, `data`, `hasiera`, `gela`) VALUES
(52, 2, 2, '2013-01-01', '11:00:00', 'fantasma'),
(53, 31, 5, '2013-01-06', '08:00:00', 'a1'),
(54, 31, 5, '2013-01-07', '09:00:00', 'a2'),
(55, 30, 5, '2013-01-06', '08:00:00', 'a1'),
(56, 30, 5, '2013-01-07', '09:00:00', 'a2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lan_orduak_erizaina`
--

CREATE TABLE IF NOT EXISTS `lan_orduak_erizaina` (
  `eguna` date NOT NULL,
  `hasiera` time NOT NULL,
  `bukaera` time NOT NULL,
  `erizainzenbakia` int(200) NOT NULL,
  `gela` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `okupatua` tinyint(1) NOT NULL,
  PRIMARY KEY (`eguna`,`hasiera`,`bukaera`,`erizainzenbakia`),
  KEY `erizainzenbakia` (`erizainzenbakia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `lan_orduak_erizaina`
--

INSERT INTO `lan_orduak_erizaina` (`eguna`, `hasiera`, `bukaera`, `erizainzenbakia`, `gela`, `okupatua`) VALUES
('2013-01-03', '08:00:00', '08:15:00', 3, '11', 0),
('2013-01-03', '09:00:00', '09:30:00', 3, '12', 1),
('2013-01-03', '09:30:00', '09:35:00', 3, '22', 0),
('2013-01-03', '11:35:00', '11:37:00', 3, '33', 1),
('2013-01-03', '11:40:00', '11:50:00', 3, '33', 0),
('2013-01-03', '12:00:00', '12:15:00', 3, '22', 1),
('2013-01-03', '12:12:12', '13:13:13', 3, '23', 1),
('2013-01-03', '12:30:00', '12:45:00', 3, '44', 1),
('2013-01-04', '11:11:11', '10:10:10', 3, '33', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lan_orduak_idazkaria`
--

CREATE TABLE IF NOT EXISTS `lan_orduak_idazkaria` (
  `eguna` date NOT NULL,
  `hasiera` time NOT NULL,
  `bukaera` time NOT NULL,
  `idazkarizenbakia` int(200) NOT NULL,
  `gela` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `okupatua` tinyint(1) NOT NULL,
  PRIMARY KEY (`eguna`,`hasiera`,`bukaera`,`idazkarizenbakia`),
  KEY `idazkarizenbakia` (`idazkarizenbakia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `lan_orduak_idazkaria`
--

INSERT INTO `lan_orduak_idazkaria` (`eguna`, `hasiera`, `bukaera`, `idazkarizenbakia`, `gela`, `okupatua`) VALUES
('2013-01-08', '08:30:00', '12:00:00', 2, '36', 0),
('2013-01-08', '18:00:00', '18:15:00', 2, '22', 0),
('2013-01-09', '08:00:00', '12:00:00', 2, '76', 0),
('2013-01-15', '08:00:00', '15:00:00', 2, '11', 0),
('2013-01-15', '17:00:00', '22:00:00', 2, '21', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lan_orduak_sendagilea`
--

CREATE TABLE IF NOT EXISTS `lan_orduak_sendagilea` (
  `eguna` date NOT NULL,
  `hasiera` time NOT NULL,
  `bukaera` time NOT NULL,
  `sendagilezenbakia` int(200) NOT NULL,
  `gela` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `okupatua` tinyint(1) NOT NULL,
  PRIMARY KEY (`eguna`,`hasiera`,`bukaera`,`sendagilezenbakia`),
  KEY `sendagilezenbakia` (`sendagilezenbakia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `lan_orduak_sendagilea`
--

INSERT INTO `lan_orduak_sendagilea` (`eguna`, `hasiera`, `bukaera`, `sendagilezenbakia`, `gela`, `okupatua`) VALUES
('2013-01-09', '10:00:00', '11:00:00', 3, 'w3', 0),
('2013-01-10', '08:00:00', '14:00:00', 2, 'a2', 0),
('2013-01-10', '10:00:00', '11:00:00', 4, 'operazio gela', 1),
('2013-01-10', '15:00:00', '19:00:00', 2, '22', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfil`
--

CREATE TABLE IF NOT EXISTS `perfil` (
  `perfilzenbakia` int(200) NOT NULL AUTO_INCREMENT,
  `deskribapena` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `gaixoa` tinyint(1) NOT NULL,
  `gaixoberria` tinyint(1) NOT NULL,
  `bilatuhistorial` tinyint(1) NOT NULL,
  `cita` tinyint(1) NOT NULL,
  `gaurkoproba` tinyint(1) NOT NULL,
  `gaurkokontsulta` tinyint(1) NOT NULL,
  `emancita` tinyint(1) NOT NULL,
  `ordutegia` tinyint(1) NOT NULL,
  `ordutegiakontsultatu` tinyint(1) NOT NULL,
  `ordutegiajarri` tinyint(1) NOT NULL,
  PRIMARY KEY (`perfilzenbakia`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `perfil`
--

INSERT INTO `perfil` (`perfilzenbakia`, `deskribapena`, `gaixoa`, `gaixoberria`, `bilatuhistorial`, `cita`, `gaurkoproba`, `gaurkokontsulta`, `emancita`, `ordutegia`, `ordutegiakontsultatu`, `ordutegiajarri`) VALUES
(1, 'Sendagilea', 1, 0, 1, 1, 0, 1, 0, 1, 1, 0),
(2, 'Erizaina', 0, 0, 0, 1, 1, 0, 0, 1, 1, 0),
(3, 'Idazkaria', 1, 1, 0, 1, 0, 0, 1, 1, 1, 0),
(4, 'Sendagile Espezialista', 1, 0, 1, 1, 0, 1, 0, 1, 1, 0),
(5, 'Administratzailea', 1, 1, 1, 1, 0, 1, 0, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sendagilea`
--

CREATE TABLE IF NOT EXISTS `sendagilea` (
  `sendagilezenbakia` int(200) NOT NULL AUTO_INCREMENT,
  `dni` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `izena` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `abizena` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `helbidea` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `tlf` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `jaiotzedata` date NOT NULL,
  `user` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `pass` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `perfilzenbakia` int(200) NOT NULL,
  PRIMARY KEY (`sendagilezenbakia`),
  KEY `perfilzenbakia` (`perfilzenbakia`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `sendagilea`
--

INSERT INTO `sendagilea` (`sendagilezenbakia`, `dni`, `izena`, `abizena`, `helbidea`, `tlf`, `jaiotzedata`, `user`, `pass`, `perfilzenbakia`) VALUES
(2, '32432432', 'carlos', 'iribarren', 'C\\Nagusia', '644280363', '2012-12-04', 'see', 'see', 1),
(3, '32332', 'admin', 'txls', 'juan dealbisu', '4535432', '2013-01-01', 'admin', 'admin', 5),
(4, '3212312', 'Jon', 'lopez', 'Hondarribi', '54343332', '2013-01-02', 'sb', 'sb', 4),
(5, 'se12', 'Alvaro', 'Uranga', 'Salis', '943564322', '2011-12-06', 's', 's', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tratamendua`
--

CREATE TABLE IF NOT EXISTS `tratamendua` (
  `tratamenduzenbakia` int(200) NOT NULL AUTO_INCREMENT,
  `episodiozenbakia` int(200) NOT NULL,
  `emandakodata` datetime NOT NULL,
  `deskribapena` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`tratamenduzenbakia`),
  KEY `episodiozenbakia` (`episodiozenbakia`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `tratamendua`
--

INSERT INTO `tratamendua` (`tratamenduzenbakia`, `episodiozenbakia`, `emandakodata`, `deskribapena`) VALUES
(1, 7, '2013-01-06 00:00:00', 'lo egin');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cita_sendagile`
--
ALTER TABLE `cita_sendagile`
  ADD CONSTRAINT `cita_sendagile_ibfk_1` FOREIGN KEY (`idazkarizenbakia`) REFERENCES `idazkaria` (`idazkarizenbakia`),
  ADD CONSTRAINT `cita_sendagile_ibfk_2` FOREIGN KEY (`gaixozenbakia`) REFERENCES `gaixoa` (`gaixozenbakia`),
  ADD CONSTRAINT `cita_sendagile_ibfk_3` FOREIGN KEY (`sendagilezenbakia`) REFERENCES `sendagilea` (`sendagilezenbakia`);

--
-- Filtros para la tabla `episodioa`
--
ALTER TABLE `episodioa`
  ADD CONSTRAINT `episodioa_ibfk_1` FOREIGN KEY (`kontsultazenbakia`) REFERENCES `kontsulta` (`kontsultazenbakia`),
  ADD CONSTRAINT `episodioa_ibfk_2` FOREIGN KEY (`gaixozenbakia`) REFERENCES `gaixoa` (`gaixozenbakia`);

--
-- Filtros para la tabla `erizaina`
--
ALTER TABLE `erizaina`
  ADD CONSTRAINT `erizaina_ibfk_1` FOREIGN KEY (`perfilzenbakia`) REFERENCES `perfil` (`perfilzenbakia`);

--
-- Filtros para la tabla `errezeta`
--
ALTER TABLE `errezeta`
  ADD CONSTRAINT `errezeta_ibfk_1` FOREIGN KEY (`episodiozenbakia`) REFERENCES `episodioa` (`episodiozenbakia`);

--
-- Filtros para la tabla `froga`
--
ALTER TABLE `froga`
  ADD CONSTRAINT `froga_ibfk_1` FOREIGN KEY (`idazkarizenbakia`) REFERENCES `idazkaria` (`idazkarizenbakia`),
  ADD CONSTRAINT `froga_ibfk_2` FOREIGN KEY (`gaixozenbakia`) REFERENCES `gaixoa` (`gaixozenbakia`),
  ADD CONSTRAINT `froga_ibfk_3` FOREIGN KEY (`erizainzenbakia`) REFERENCES `erizaina` (`erizainzenbakia`),
  ADD CONSTRAINT `froga_ibfk_4` FOREIGN KEY (`episodiozenbakia`) REFERENCES `episodioa` (`episodiozenbakia`);

--
-- Filtros para la tabla `gaixoa`
--
ALTER TABLE `gaixoa`
  ADD CONSTRAINT `gaixoa_ibfk_1` FOREIGN KEY (`sendagilenagusia`) REFERENCES `sendagilea` (`sendagilezenbakia`);

--
-- Filtros para la tabla `idazkaria`
--
ALTER TABLE `idazkaria`
  ADD CONSTRAINT `idazkaria_ibfk_1` FOREIGN KEY (`perfilzenbakia`) REFERENCES `perfil` (`perfilzenbakia`);

--
-- Filtros para la tabla `kontsulta`
--
ALTER TABLE `kontsulta`
  ADD CONSTRAINT `kontsulta_ibfk_1` FOREIGN KEY (`gaixozenbakia`) REFERENCES `gaixoa` (`gaixozenbakia`),
  ADD CONSTRAINT `kontsulta_ibfk_2` FOREIGN KEY (`sendagilezenbakia`) REFERENCES `sendagilea` (`sendagilezenbakia`);

--
-- Filtros para la tabla `lan_orduak_erizaina`
--
ALTER TABLE `lan_orduak_erizaina`
  ADD CONSTRAINT `lan_orduak_erizaina_ibfk_1` FOREIGN KEY (`erizainzenbakia`) REFERENCES `erizaina` (`erizainzenbakia`);

--
-- Filtros para la tabla `lan_orduak_idazkaria`
--
ALTER TABLE `lan_orduak_idazkaria`
  ADD CONSTRAINT `lan_orduak_idazkaria_ibfk_1` FOREIGN KEY (`idazkarizenbakia`) REFERENCES `idazkaria` (`idazkarizenbakia`);

--
-- Filtros para la tabla `lan_orduak_sendagilea`
--
ALTER TABLE `lan_orduak_sendagilea`
  ADD CONSTRAINT `lan_orduak_sendagilea_ibfk_1` FOREIGN KEY (`sendagilezenbakia`) REFERENCES `sendagilea` (`sendagilezenbakia`);

--
-- Filtros para la tabla `sendagilea`
--
ALTER TABLE `sendagilea`
  ADD CONSTRAINT `sendagilea_ibfk_1` FOREIGN KEY (`perfilzenbakia`) REFERENCES `perfil` (`perfilzenbakia`);

--
-- Filtros para la tabla `tratamendua`
--
ALTER TABLE `tratamendua`
  ADD CONSTRAINT `tratamendua_ibfk_1` FOREIGN KEY (`episodiozenbakia`) REFERENCES `episodioa` (`episodiozenbakia`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
