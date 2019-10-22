-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 22-Out-2019 às 09:39
-- Versão do servidor: 5.7.26
-- versão do PHP: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cnfbd`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

DROP TABLE IF EXISTS `aluno`;
CREATE TABLE IF NOT EXISTS `aluno` (
  `idAluno` int(11) NOT NULL AUTO_INCREMENT,
  `nomeAluno` varchar(45) NOT NULL,
  `CPFAluno` varchar(15) NOT NULL,
  `dataNascimentoAluno` date NOT NULL,
  `statusAluno` int(11) NOT NULL,
  PRIMARY KEY (`idAluno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno_has_turma`
--

DROP TABLE IF EXISTS `aluno_has_turma`;
CREATE TABLE IF NOT EXISTS `aluno_has_turma` (
  `aluno_idAluno` int(11) NOT NULL,
  `turma_idTurma` int(11) NOT NULL,
  PRIMARY KEY (`aluno_idAluno`,`turma_idTurma`),
  KEY `fk_aluno_has_turma_turma1` (`turma_idTurma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
CREATE TABLE IF NOT EXISTS `disciplina` (
  `idDisciplina` int(11) NOT NULL AUTO_INCREMENT,
  `nomeDisciplina` varchar(45) NOT NULL,
  `descricaoDisciplina` varchar(45) NOT NULL,
  `faculdade_idFaculdade` int(11) NOT NULL,
  `statusDisciplina` int(11) NOT NULL,
  PRIMARY KEY (`idDisciplina`) USING BTREE,
  KEY `fk_disciplina_faculdade` (`faculdade_idFaculdade`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `disciplina`
--

INSERT INTO `disciplina` (`idDisciplina`, `nomeDisciplina`, `descricaoDisciplina`, `faculdade_idFaculdade`, `statusDisciplina`) VALUES
(6, 'ED II', 'Cabulosa', 11, 1),
(7, 'sryssr', 'wyw', 11, 0),
(8, 'Prática de eng. de soft', 'teste', 11, 1),
(9, 'teste1', 'teste11', 21, 1),
(10, 'TFC I', 'TCF nivel HARD', 11, 1),
(11, 'teste2', 'teste22', 17, 1),
(12, 'Algoritmos II', 'TEstes', 20, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `faculdade`
--

DROP TABLE IF EXISTS `faculdade`;
CREATE TABLE IF NOT EXISTS `faculdade` (
  `idFaculdade` int(11) NOT NULL AUTO_INCREMENT,
  `nomeFaculdade` varchar(45) NOT NULL,
  `descricaoFaculdade` varchar(45) NOT NULL,
  `UFfaculdade` varchar(45) NOT NULL,
  `cidadeFaculdade` varchar(45) NOT NULL,
  `statusFaculdade` int(11) NOT NULL,
  PRIMARY KEY (`idFaculdade`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `faculdade`
--

INSERT INTO `faculdade` (`idFaculdade`, `nomeFaculdade`, `descricaoFaculdade`, `UFfaculdade`, `cidadeFaculdade`, `statusFaculdade`) VALUES
(2, 'TEste', 'TEste', 'Go', 'Rv', 0),
(3, 'teste', 'Teste', 'MG', 'Sei la', 0),
(4, 'stetsee', 'EAyeaya', 'GR', 'srsuust', 0),
(5, 'testsetsetes', 'ruruusr', 'ywy', 'suutssut', 0),
(6, 'Objective Delas', 'Objetivo', 'MG', 'Patos das Minas', 0),
(7, 'testesckg', 'rsyysr', 'teatae', 'aetta', 0),
(8, 'aey', 'ay', 'aet', 'ay', 0),
(9, 'ateaeyae', 'ate', 'ate', 'ate', 0),
(10, 'a', 'a', 'a', 'a', 0),
(11, 'UniRv', 'Universidade de Rio Verde', 'GO', 'Rio Verde city', 1),
(12, 'faculdade das primas', 'jao no comando', 'GO', 'Rio verde', 0),
(13, 'Zobjetivo Faculdades', 'Vem para vencer', 'GO', 'Quimba', 0),
(14, 'Teste', 'Far', 'GO', 'Rv', 0),
(15, 'Objetivo', 'TEste', 'CE', 'Rio Verde', 1),
(16, '', '', '', '', 0),
(17, 'd', 'd', 'DF', 'd', 1),
(18, 'faculdade das primas', 'teste no comando', 'GO', 'Rio verde', 1),
(19, 'Unopar', 'EAD', 'GO', 'Rio Verde', 0),
(20, 'UFT', 'Universidade Federal do Tocantins', 'TO', 'Palmas', 1),
(21, 'UFA', 'Mata', 'AM', 'Amazônas', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

DROP TABLE IF EXISTS `professor`;
CREATE TABLE IF NOT EXISTS `professor` (
  `idProfessor` int(11) NOT NULL AUTO_INCREMENT,
  `nomeProfessor` varchar(45) NOT NULL,
  `dataNascimentoProfessor` date NOT NULL,
  `usuarioProfessor` varchar(45) NOT NULL,
  `senhaProfessor` varchar(50) NOT NULL,
  `statusProfessor` int(11) NOT NULL,
  PRIMARY KEY (`idProfessor`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `professor`
--

INSERT INTO `professor` (`idProfessor`, `nomeProfessor`, `dataNascimentoProfessor`, `usuarioProfessor`, `senhaProfessor`, `statusProfessor`) VALUES
(2, 'João Otávio Mota Roriz', '1996-08-16', 'joao.otvo.rv@gmail.com', 'r1v3rJoao', 1),
(3, '', '1923-05-26', '', '', 0),
(6, '', '2016-09-20', '', '', 0),
(7, 'bruno', '2000-10-20', 'bru@no.com', 'Q123', 0),
(8, 'Teste', '2016-09-20', 'testse@testse.com', 'Q123', 1),
(9, 'CArla', '1666-03-13', 'Car@la.com', 'Q123', 0),
(10, '', '1300-03-19', '', '', 0),
(11, '', '6276-10-21', '', '', 0),
(12, '', '2004-12-15', '', '', 0),
(13, 'Armaria', '2010-10-10', 'armaria@gmail.com', 'Q123', 1),
(14, 'Romildo carlo', '1002-01-15', 'carlo@mildo.com', 'Q123', 1),
(15, 'tstse', '1212-11-12', 'aeatea@taetae.com', 'Q123', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `turma`
--

DROP TABLE IF EXISTS `turma`;
CREATE TABLE IF NOT EXISTS `turma` (
  `idTurma` int(11) NOT NULL AUTO_INCREMENT,
  `nomeTurma` varchar(45) NOT NULL,
  `descricaoTurma` varchar(45) NOT NULL,
  `statusTurma` varchar(45) NOT NULL,
  `disciplina_idDisciplina` int(11) NOT NULL,
  `professor_idProfessor` int(11) NOT NULL,
  PRIMARY KEY (`idTurma`,`disciplina_idDisciplina`,`professor_idProfessor`),
  KEY `fk_turma_disciplina1` (`disciplina_idDisciplina`),
  KEY `fk_turma_professor1` (`professor_idProfessor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `aluno_has_turma`
--
ALTER TABLE `aluno_has_turma`
  ADD CONSTRAINT `fk_aluno_has_turma_aluno1` FOREIGN KEY (`aluno_idAluno`) REFERENCES `aluno` (`idAluno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_aluno_has_turma_turma1` FOREIGN KEY (`turma_idTurma`) REFERENCES `turma` (`idTurma`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `disciplina`
--
ALTER TABLE `disciplina`
  ADD CONSTRAINT `fk_disciplina_faculdade1` FOREIGN KEY (`faculdade_idFaculdade`) REFERENCES `faculdade` (`idFaculdade`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `turma`
--
ALTER TABLE `turma`
  ADD CONSTRAINT `fk_turma_disciplina1` FOREIGN KEY (`disciplina_idDisciplina`) REFERENCES `disciplina` (`idDisciplina`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_turma_professor1` FOREIGN KEY (`professor_idProfessor`) REFERENCES `professor` (`idProfessor`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
