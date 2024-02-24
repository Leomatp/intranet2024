/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 5.7.43-log : Database - intranet_2024
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`intranet_2024` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `intranet_2024`;

/*Table structure for table `alumno` */

DROP TABLE IF EXISTS `alumno`;

CREATE TABLE `alumno` (
  `ciclo` varchar(255) DEFAULT NULL,
  `cod_alumno` int(11) NOT NULL,
  PRIMARY KEY (`cod_alumno`),
  CONSTRAINT `FKsgptjk0i5j3dp4fh93y80hha8` FOREIGN KEY (`cod_alumno`) REFERENCES `tb_persona` (`cod_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `alumno` */

insert  into `alumno`(`ciclo`,`cod_alumno`) values 
('I',1),
('II',2);

/*Table structure for table `curso` */

DROP TABLE IF EXISTS `curso`;

CREATE TABLE `curso` (
  `cod_curso` int(11) NOT NULL AUTO_INCREMENT,
  `cre_curso` int(11) DEFAULT NULL,
  `nom_curso` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cod_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `curso` */

insert  into `curso`(`cod_curso`,`cre_curso`,`nom_curso`) values 
(1,2,'Matematicas I'),
(2,3,'Gestion Empresarial'),
(3,2,'Redaccion'),
(4,3,'EFSRT I'),
(5,3,'Arquitectura de Entornos Web');

/*Table structure for table `nota` */

DROP TABLE IF EXISTS `nota`;

CREATE TABLE `nota` (
  `codigo_nota` int(11) NOT NULL AUTO_INCREMENT,
  `nota` int(11) NOT NULL,
  `codigo_alumno` int(11) NOT NULL,
  PRIMARY KEY (`codigo_nota`),
  KEY `FKju1jxqnsuu56mopqxbib3as4b` (`codigo_alumno`),
  CONSTRAINT `FKju1jxqnsuu56mopqxbib3as4b` FOREIGN KEY (`codigo_alumno`) REFERENCES `alumno` (`cod_alumno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `nota` */

/*Table structure for table `profesor` */

DROP TABLE IF EXISTS `profesor`;

CREATE TABLE `profesor` (
  `cod_profesor` int(11) NOT NULL,
  `horas_trabajadas` int(11) DEFAULT NULL,
  `salario_pro` double DEFAULT NULL,
  PRIMARY KEY (`cod_profesor`),
  CONSTRAINT `FKd26ymob3qwt6rlc38j8oesmrj` FOREIGN KEY (`cod_profesor`) REFERENCES `tb_persona` (`cod_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `profesor` */

insert  into `profesor`(`cod_profesor`,`horas_trabajadas`,`salario_pro`) values 
(3,50,60);

/*Table structure for table `profesor_curso` */

DROP TABLE IF EXISTS `profesor_curso`;

CREATE TABLE `profesor_curso` (
  `cod_curso` int(11) NOT NULL,
  `cod_profesor` int(11) NOT NULL,
  KEY `FKktulscv06tvke3wlvlnbecr5r` (`cod_profesor`),
  KEY `FK2avmumiyd4hqcni7xuvwjjwv8` (`cod_curso`),
  CONSTRAINT `FK2avmumiyd4hqcni7xuvwjjwv8` FOREIGN KEY (`cod_curso`) REFERENCES `curso` (`cod_curso`),
  CONSTRAINT `FKktulscv06tvke3wlvlnbecr5r` FOREIGN KEY (`cod_profesor`) REFERENCES `profesor` (`cod_profesor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `profesor_curso` */

/*Table structure for table `sede` */

DROP TABLE IF EXISTS `sede`;

CREATE TABLE `sede` (
  `cod_sede` int(11) NOT NULL,
  `nom_sede` varchar(25) NOT NULL,
  PRIMARY KEY (`cod_sede`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `sede` */

insert  into `sede`(`cod_sede`,`nom_sede`) values 
(1,'Independencia'),
(2,'Lima Centro'),
(3,'Arequipa'),
(4,'San Isidro'),
(5,'Piura');

/*Table structure for table `tarea` */

DROP TABLE IF EXISTS `tarea`;

CREATE TABLE `tarea` (
  `cod_tarea` int(11) NOT NULL AUTO_INCREMENT,
  `asignacion` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cod_tarea`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `tarea` */

insert  into `tarea`(`cod_tarea`,`asignacion`,`descripcion`,`titulo`) values 
(1,'Introduccion a la Algoritmia','Breve analisis a los algrotimos y sus usos','Algoritmos: Definicion y usos'),
(2,'Proyecto de Contabilidad','Preparar estados financieros para el trimestre','Análisis Financiero'),
(3,'Investigación de Mercado','Realizar un estudio de mercado para un nuevo producto','Investigación de Mercado'),
(4,'Desarrollo de Software','Crear una aplicación de gestión de proyectos','Desarrollo de Aplicación'),
(5,'Análisis de Costos','Evaluar y reducir los costos operativos','Optimización de Costos'),
(6,'Gestión de Recursos Humanos','Elaborar un plan de capacitación para el personal','Plan de Capacitación'),
(7,'Implementación de Redes','Configurar una red para mejorar la conectividad','Implementación de Redes'),
(8,'Contabilidad Fiscal','Preparar la documentación para la declaración de impuestos','Declaración de Impuestos'),
(9,'Desarrollo de Páginas Web','Crear un sitio web para promocionar la empresa','Diseño Web'),
(10,'Auditoría de Sistemas','Realizar una auditoría de seguridad informática','Auditoría de Seguridad'),
(11,'Planificación Estratégica','Desarrollar un plan estratégico para el próximo año','Planificación Estratégica');

/*Table structure for table `tb_matricula` */

DROP TABLE IF EXISTS `tb_matricula`;

CREATE TABLE `tb_matricula` (
  `num_matri` int(11) NOT NULL,
  PRIMARY KEY (`num_matri`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_matricula` */

/*Table structure for table `tb_menu` */

DROP TABLE IF EXISTS `tb_menu`;

CREATE TABLE `tb_menu` (
  `cod_menu` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cod_menu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_menu` */

/*Table structure for table `tb_menu_rol` */

DROP TABLE IF EXISTS `tb_menu_rol`;

CREATE TABLE `tb_menu_rol` (
  `cod_menu` int(11) NOT NULL,
  `cod_rol` int(11) NOT NULL,
  KEY `FKdo6eokj8o691fp6nj3nrspo80` (`cod_rol`),
  KEY `FKsdyi6h3by9nodvij3d09qd5om` (`cod_menu`),
  CONSTRAINT `FKdo6eokj8o691fp6nj3nrspo80` FOREIGN KEY (`cod_rol`) REFERENCES `tb_rol` (`cod_rol`),
  CONSTRAINT `FKsdyi6h3by9nodvij3d09qd5om` FOREIGN KEY (`cod_menu`) REFERENCES `tb_menu` (`cod_menu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_menu_rol` */

/*Table structure for table `tb_persona` */

DROP TABLE IF EXISTS `tb_persona`;

CREATE TABLE `tb_persona` (
  `cod_persona` int(11) NOT NULL AUTO_INCREMENT,
  `cel_persona` int(11) NOT NULL,
  `ema_persona` varchar(20) NOT NULL,
  `dir_persona` varchar(80) NOT NULL,
  `dni_persona` varchar(8) NOT NULL,
  `fec_nac_persona` date NOT NULL,
  `mat_persona` varchar(30) NOT NULL,
  `nom_persona` varchar(25) NOT NULL,
  `pat_persona` varchar(30) NOT NULL,
  `sex_persona` varchar(12) NOT NULL,
  `cod_sede` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_persona`),
  KEY `FKg7th3xjsj8f53quy3bwa1f78p` (`cod_sede`),
  CONSTRAINT `FKg7th3xjsj8f53quy3bwa1f78p` FOREIGN KEY (`cod_sede`) REFERENCES `sede` (`cod_sede`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `tb_persona` */

insert  into `tb_persona`(`cod_persona`,`cel_persona`,`ema_persona`,`dir_persona`,`dni_persona`,`fec_nac_persona`,`mat_persona`,`nom_persona`,`pat_persona`,`sex_persona`,`cod_sede`) values 
(1,921331212,'abc123@gmail.com','Av Universitaria 123','1212121','1999-07-21','Garcia','Alberto','Perez','M',1),
(2,12121221,'xyz789gmail.com','Av Universitaria 78','1231231','2000-02-15','Lopez','Albert','Mendez','M',1),
(3,1212121,'abcd1234@gmail.com','Av Universitaria 77','0977123','1988-08-25','Galvan','Paolo','Lopez','M',1);

/*Table structure for table `tb_rol` */

DROP TABLE IF EXISTS `tb_rol`;

CREATE TABLE `tb_rol` (
  `cod_rol` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cod_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tb_rol` */

insert  into `tb_rol`(`cod_rol`,`descripcion`) values 
(1,'ADMIN'),
(2,'ALUMNO'),
(3,'PROFESOR'),
(4,'SOPORTE');

/*Table structure for table `tb_usuario` */

DROP TABLE IF EXISTS `tb_usuario`;

CREATE TABLE `tb_usuario` (
  `cod_usu` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `idrol` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_usu`),
  KEY `FKrrkra08jv7501dvnchq8gb2fs` (`idrol`),
  CONSTRAINT `FKrrkra08jv7501dvnchq8gb2fs` FOREIGN KEY (`idrol`) REFERENCES `tb_rol` (`cod_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `tb_usuario` */

insert  into `tb_usuario`(`cod_usu`,`apellido`,`password`,`login`,`nombre`,`idrol`) values 
(1,'Matias Pinto','$2a$10$5znNViEQ1V69SDlGCrqzU.qNfAH1U4/hUFtLNL7s3.GONntDY7wE.','admin','Leonel',1),
(2,'matias','$2a$10$5VLzOfbQXxqhqRTWhKl7FuOUILwkkryfpUv0A.apNC/Xpur9wwDfy','Leomatp','leonel',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
