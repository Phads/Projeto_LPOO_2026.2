CREATE DATABASE  IF NOT EXISTS `sepdec_base` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sepdec_base`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sepdec_base
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `chaves`
--

DROP TABLE IF EXISTS `chaves`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chaves` (
  `idChaves` int NOT NULL AUTO_INCREMENT,
  `Sala` varchar(45) NOT NULL,
  `Status` varchar(45) NOT NULL,
  PRIMARY KEY (`idChaves`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `manutencao`
--

DROP TABLE IF EXISTS `manutencao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manutencao` (
  `idManutencao` int NOT NULL AUTO_INCREMENT,
  `fk_viatura` int NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `oficina` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `data_entrada` datetime NOT NULL,
  PRIMARY KEY (`idManutencao`),
  KEY `fk_viatura_idx` (`fk_viatura`),
  CONSTRAINT `fk_viatura` FOREIGN KEY (`fk_viatura`) REFERENCES `viaturas` (`IdViatura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `solicitacao_chave`
--

DROP TABLE IF EXISTS `solicitacao_chave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solicitacao_chave` (
  `idSolicitacao_chave` int NOT NULL AUTO_INCREMENT,
  `idChaves` int NOT NULL,
  `idUsuario` int NOT NULL,
  `Hora_retirada` datetime NOT NULL,
  `Hora_devolucao` datetime DEFAULT NULL,
  PRIMARY KEY (`idSolicitacao_chave`),
  KEY `idChaves_idx` (`idChaves`),
  KEY `idUsuario_idx` (`idUsuario`),
  CONSTRAINT `idChaves` FOREIGN KEY (`idChaves`) REFERENCES `chaves` (`idChaves`),
  CONSTRAINT `idUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `solicitacao_viatura`
--

DROP TABLE IF EXISTS `solicitacao_viatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solicitacao_viatura` (
  `idSolicitacao_viatura` int NOT NULL AUTO_INCREMENT,
  `fk_solic_Viatura` int NOT NULL,
  `fk_solic_Usuario` int NOT NULL,
  `Hora_retirada` datetime NOT NULL,
  `Hora_devolucao` datetime DEFAULT NULL,
  PRIMARY KEY (`idSolicitacao_viatura`),
  KEY `idViatura_idx` (`fk_solic_Viatura`),
  KEY `idUsuario_idx` (`fk_solic_Usuario`),
  CONSTRAINT `fk_solic_Usuario` FOREIGN KEY (`fk_solic_Usuario`) REFERENCES `usuarios` (`idUsuario`),
  CONSTRAINT `fk_solic_Viatura` FOREIGN KEY (`fk_solic_Viatura`) REFERENCES `viaturas` (`IdViatura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) NOT NULL,
  `Login` varchar(45) NOT NULL,
  `Senha` varchar(45) NOT NULL,
  `Role` varchar(45) NOT NULL,
  `Patente` varchar(45) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='\n';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `viaturas`
--

DROP TABLE IF EXISTS `viaturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `viaturas` (
  `IdViatura` int NOT NULL AUTO_INCREMENT,
  `Veiculo` varchar(45) NOT NULL,
  `Placa` varchar(45) NOT NULL,
  `Status` varchar(45) NOT NULL,
  PRIMARY KEY (`IdViatura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `visitas`
--

DROP TABLE IF EXISTS `visitas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visitas` (
  `idVisitas` int NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) NOT NULL,
  `Documento` varchar(45) NOT NULL,
  `Tipo` varchar(45) NOT NULL,
  `Destino` varchar(45) NOT NULL,
  `Hora_entrada` datetime NOT NULL,
  `Hora_saida` datetime DEFAULT NULL,
  `fk_usuario` int NOT NULL,
  PRIMARY KEY (`idVisitas`),
  KEY `fk_usuario_idx` (`fk_usuario`),
  CONSTRAINT `fk_usuario` FOREIGN KEY (`fk_usuario`) REFERENCES `usuarios` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'sepdec_base'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-11-15 20:07:59
