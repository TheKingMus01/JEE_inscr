-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 04, 2022 at 06:10 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inscription`
--

-- --------------------------------------------------------

--
-- Table structure for table `etudiant`
--

CREATE TABLE `etudiant` (
  `CNE` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `date_de_naissance` varchar(255) NOT NULL,
  `type_de_Bac` varchar(255) NOT NULL,
  `code_de_formation` int(11) NOT NULL,
  `Titre_de_formation` varchar(255) NOT NULL,
  `nombre_heures` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `etudiant`
--

INSERT INTO `etudiant` (`CNE`, `nom`, `prenom`, `date_de_naissance`, `type_de_Bac`, `code_de_formation`, `Titre_de_formation`, `nombre_heures`) VALUES
(1, 'Ziyech', 'Hakim', '1992-02-07', 'SVT', 106, 'Filiere Ingenieur-Genie Informatique', '170 H'),
(2, 'Hakimi', 'Achraf ', '1998-04-18', 'MATH', 108, 'DCESS Marketing Digital', '155 H'),
(3, 'Harit', 'Mohamed', '1994-08-14', 'PC', 107, 'DCA Genie Informatique', '150 H'),
(4, 'Boufal', 'Sofiane ', '2000-02-13', 'MATH', 107, 'DCA Genie Informatique', '150 H');

-- --------------------------------------------------------

--
-- Table structure for table `formation`
--

CREATE TABLE `formation` (
  `code` int(11) NOT NULL,
  `Titre_de_formation` varchar(255) NOT NULL,
  `nombre_heures` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `formation`
--

INSERT INTO `formation` (`code`, `Titre_de_formation`, `nombre_heures`) VALUES
(106, 'Filiere Ingenieur-Genie Informatique', '170 H'),
(107, 'DCA Genie Informatique', '150 H'),
(108, 'DCESS Marketing Digital', '155 H');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`CNE`);

--
-- Indexes for table `formation`
--
ALTER TABLE `formation`
  ADD PRIMARY KEY (`code`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `formation`
--
ALTER TABLE `formation`
  MODIFY `code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=110;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
