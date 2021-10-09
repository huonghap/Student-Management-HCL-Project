-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 08, 2021 at 02:33 PM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.3.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `student_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `std`
--

CREATE TABLE `std` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `dob` varchar(255) NOT NULL,
  `score` decimal(6,1) NOT NULL,
  `gender` varchar(40) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `std`
--

INSERT INTO `std` (`id`, `name`, `dob`, `score`, `gender`, `email`) VALUES
(1, 'my', '10/02/2000', '9.2', 'F', 'my@gmail.com'),
(2, 'hoai', '08/12/2000', '8.5', 'F', 'hoai@gmail.com'),
(3, 'huong', '06/08/2000', '8.9', 'F', 'huong@gmail.com'),
(4, 'kiet', '05/12/2000', '9.0', 'M', 'kiet@gmail.com'),
(6, 'linh', '12/12/2000', '7.7', 'F', 'linh@gmail.com'),
(9, 'hoa', '12/02/2000', '8.8', 'F', 'hoa@gmail.com'),
(11, 'nga', '01/02/2000', '7.2', 'F', 'nga@gmail.com'),
(12, 'nam', '2/5/2000', '7.7', 'F', 'nam@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `std`
--
ALTER TABLE `std`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `std`
--
ALTER TABLE `std`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
