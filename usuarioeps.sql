SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `usuarioeps`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eps`
--

DROP TABLE IF EXISTS `eps`;
CREATE TABLE IF NOT EXISTS `eps` (
  `nit` int NOT NULL,
  `direccion` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `razon_social` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `telefono` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`nit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `cedula` int NOT NULL,
  `direccion` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `fecha_afiliacion` datetime(6) DEFAULT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `username` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `eps_actual` int DEFAULT NULL,
  PRIMARY KEY (`cedula`),
  UNIQUE KEY `UK_pbk26prvu4964d3sem2k40cfq` (`eps_actual`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK1d996s5ofnm9us8t6gnl21xot` FOREIGN KEY (`eps_actual`) REFERENCES `eps` (`nit`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
