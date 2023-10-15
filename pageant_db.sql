-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 23, 2023 at 10:50 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pageant_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_contestants`
--

CREATE TABLE `tbl_contestants` (
  `id` int(11) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `contact` varchar(11) NOT NULL,
  `country` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `birthdate` date NOT NULL,
  `height` int(11) NOT NULL,
  `weight` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_contestants`
--

INSERT INTO `tbl_contestants` (`id`, `fullname`, `contact`, `country`, `age`, `birthdate`, `height`, `weight`) VALUES
(1, 'Candidate #1\r\n', '01234567890', 'Philippines', 18, '2004-12-31', 175, 60),
(2, 'Candidate #2', '01234567890', 'Pakistan', 20, '2004-12-31', 175, 60),
(3, 'Candidate #3', '01234567890', 'India', 22, '2004-12-31', 175, 60),
(4, 'Candidate #4', '01234567890', 'USA', 25, '2004-12-31', 180, 65),
(5, 'Candidate #5', '01234567980', 'Russia', 24, '2004-12-31', 177, 62);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_finals`
--

CREATE TABLE `tbl_finals` (
  `id` int(11) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `intelligence` int(11) NOT NULL,
  `beauty` int(11) NOT NULL,
  `poise_bearing` int(11) NOT NULL,
  `finals_total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_finals`
--

INSERT INTO `tbl_finals` (`id`, `fullname`, `intelligence`, `beauty`, `poise_bearing`, `finals_total`) VALUES
(1, 'Candidate #1', 90, 90, 90, 90),
(2, 'Candidate #2', 94, 93, 83, 90),
(3, 'Candidate #3', 88, 89, 90, 89),
(4, 'Candidate #4', 99, 93, 90, 94),
(5, 'Candidate #5', 90, 80, 84, 84);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_gown`
--

CREATE TABLE `tbl_gown` (
  `id` int(11) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `poise_smartness` int(11) NOT NULL,
  `confidence` int(11) NOT NULL,
  `audience_impact` int(11) NOT NULL,
  `gown_total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_gown`
--

INSERT INTO `tbl_gown` (`id`, `fullname`, `poise_smartness`, `confidence`, `audience_impact`, `gown_total`) VALUES
(1, 'Candidate #1', 90, 90, 90, 90),
(2, 'Candidate #2', 91, 91, 94, 92),
(3, 'Candidate #3', 99, 89, 85, 91),
(4, 'Candidate #4', 96, 86, 80, 87),
(5, 'Candidate #5', 87, 98, 97, 94);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_swimsuit`
--

CREATE TABLE `tbl_swimsuit` (
  `id` int(11) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `poise_smartness` int(11) NOT NULL,
  `confidence` int(11) NOT NULL,
  `audience_impact` int(11) NOT NULL,
  `swimsuit_total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_swimsuit`
--

INSERT INTO `tbl_swimsuit` (`id`, `fullname`, `poise_smartness`, `confidence`, `audience_impact`, `swimsuit_total`) VALUES
(1, 'Candidate #1', 98, 99, 89, 95),
(2, 'Candidate #2', 90, 90, 95, 91),
(3, 'Candidate #3', 95, 96, 99, 96),
(4, 'Candidate #4', 88, 86, 96, 90),
(5, 'Candidate #5', 97, 87, 88, 90);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_talent`
--

CREATE TABLE `tbl_talent` (
  `id` int(11) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `content_delivery` int(11) NOT NULL,
  `clarification` int(11) NOT NULL,
  `poise_projection` int(11) NOT NULL,
  `talent_total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_talent`
--

INSERT INTO `tbl_talent` (`id`, `fullname`, `content_delivery`, `clarification`, `poise_projection`, `talent_total`) VALUES
(1, 'Candidate #1', 90, 90, 90, 90),
(2, 'Candidate #2', 87, 86, 92, 88),
(3, 'Candidate #3', 88, 90, 93, 90),
(4, 'Candidate #4', 89, 99, 97, 95),
(5, 'Candidate #5', 87, 88, 88, 87);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_contestants`
--
ALTER TABLE `tbl_contestants`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_finals`
--
ALTER TABLE `tbl_finals`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_gown`
--
ALTER TABLE `tbl_gown`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_swimsuit`
--
ALTER TABLE `tbl_swimsuit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_talent`
--
ALTER TABLE `tbl_talent`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_contestants`
--
ALTER TABLE `tbl_contestants`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_finals`
--
ALTER TABLE `tbl_finals`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_gown`
--
ALTER TABLE `tbl_gown`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_swimsuit`
--
ALTER TABLE `tbl_swimsuit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_talent`
--
ALTER TABLE `tbl_talent`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
