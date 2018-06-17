-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-06-2018 a las 20:15:16
-- Versión del servidor: 10.1.16-MariaDB
-- Versión de PHP: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `academiadb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `id_alumno` int(4) NOT NULL,
  `dni_alumno` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_alumno` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos_alumno` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `direccion_alumno` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `email_alumno` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `telefono_alumno` varchar(9) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`id_alumno`, `dni_alumno`, `nombre_alumno`, `apellidos_alumno`, `direccion_alumno`, `email_alumno`, `telefono_alumno`) VALUES
(1, '48987541Z', 'Mario', 'Suarez', 'Faro, 113', 'mario@gmail.com', '698002211'),
(2, '47898210', 'Sebastian', 'Suarez', 'Faro, 12', 'sebastian@gmail.com', '928465887');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE `curso` (
  `id_curso` int(4) NOT NULL,
  `nombre_curso` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `id_familia` int(4) NOT NULL,
  `id_profesor` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `curso`
--

INSERT INTO `curso` (`id_curso`, `nombre_curso`, `id_familia`, `id_profesor`) VALUES
(1, 'Sistemas Informaticos', 1, 1),
(2, 'Redes', 1, 3),
(6, 'Hardware', 1, 1),
(8, 'Fundamentos', 2, 3),
(9, 'Bases de Datos', 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `familia`
--

CREATE TABLE `familia` (
  `id_familia` int(4) NOT NULL,
  `nombre_familia` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `familia`
--

INSERT INTO `familia` (`id_familia`, `nombre_familia`) VALUES
(1, 'Informatica'),
(2, 'Electricidad'),
(3, 'Motor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matricula`
--

CREATE TABLE `matricula` (
  `id_matricula` int(11) NOT NULL,
  `id_alumno` int(4) NOT NULL,
  `id_curso` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `matricula`
--

INSERT INTO `matricula` (`id_matricula`, `id_alumno`, `id_curso`) VALUES
(3, 1, 6),
(5, 2, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE `profesor` (
  `id_profesor` int(4) NOT NULL,
  `dni_profesor` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `nombre_profesor` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos_profesor` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `direccion_profesor` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `email_profesor` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `telefono_profesor` varchar(9) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`id_profesor`, `dni_profesor`, `nombre_profesor`, `apellidos_profesor`, `direccion_profesor`, `email_profesor`, `telefono_profesor`) VALUES
(1, '44741521Q', 'Maria', 'Santana', 'Caleta, 1', 'maria@gmail.com', '698999999'),
(3, '48547741C', 'Carlos', 'Lopez', 'Darso, 2', 'carlos@gmail.com', '698521025');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`id_alumno`);

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`id_curso`),
  ADD KEY `FK_curso_profesor` (`id_profesor`),
  ADD KEY `FK_curso_familia` (`id_familia`),
  ADD KEY `id_familia` (`id_familia`);

--
-- Indices de la tabla `familia`
--
ALTER TABLE `familia`
  ADD PRIMARY KEY (`id_familia`);

--
-- Indices de la tabla `matricula`
--
ALTER TABLE `matricula`
  ADD PRIMARY KEY (`id_matricula`),
  ADD KEY `FK_matricula_alumno` (`id_alumno`),
  ADD KEY `FK_matricula_curso` (`id_curso`);

--
-- Indices de la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD PRIMARY KEY (`id_profesor`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `id_alumno` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `curso`
--
ALTER TABLE `curso`
  MODIFY `id_curso` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT de la tabla `familia`
--
ALTER TABLE `familia`
  MODIFY `id_familia` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `matricula`
--
ALTER TABLE `matricula`
  MODIFY `id_matricula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `profesor`
--
ALTER TABLE `profesor`
  MODIFY `id_profesor` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `curso`
--
ALTER TABLE `curso`
  ADD CONSTRAINT `FK_curso_familia` FOREIGN KEY (`id_familia`) REFERENCES `familia` (`id_familia`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_curso_profesor` FOREIGN KEY (`id_profesor`) REFERENCES `profesor` (`id_profesor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `matricula`
--
ALTER TABLE `matricula`
  ADD CONSTRAINT `FK_matricula_alumno` FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`id_alumno`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_matricula_curso` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id_curso`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
