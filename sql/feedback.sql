-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 05, 2018 at 12:21 AM
-- Server version: 10.1.29-MariaDB-6
-- PHP Version: 7.2.5-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `feedback`
--

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `MYUSER` varchar(30) NOT NULL,
  `EMAIL` varchar(30) DEFAULT NULL,
  `WEBPAGE` varchar(100) NOT NULL,
  `DATUM` date NOT NULL,
  `SUMMARY` varchar(40) NOT NULL,
  `COMMENTS` varchar(400) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`id`, `MYUSER`, `EMAIL`, `WEBPAGE`, `DATUM`, `SUMMARY`, `COMMENTS`) VALUES
(1, 'jan', 'myemail@gmail.com', 'http://www.vogella.com', '2009-09-14', 'Summary', 'My first comment'),
(2, 'Test1', 'TestEmail1', 'TestWebpage1', '3910-01-11', 'TestSummary1', 'TestComment1'),
(3, 'Test1', 'TestEmail1', 'TestWebpage1', '3910-01-11', 'TestSummary1', 'TestComment1'),
(4, 'Test1', 'TestEmail1', 'TestWebpage1', '3910-01-11', 'TestSummary1', 'TestComment1'),
(5, 'Test1', 'TestEmail1', 'TestWebpage1', '3910-01-11', 'TestSummary1', 'TestComment1'),
(6, 'Test1', 'TestEmail1', 'TestWebpage1', '3910-01-11', 'TestSummary1', 'TestComment1'),
(7, 'Test1', 'TestEmail1', 'TestWebpage1', '3910-01-11', 'TestSummary1', 'TestComment1'),
(8, 'Test1', 'TestEmail1', 'TestWebpage1', '3910-01-11', 'TestSummary1', 'TestComment1'),
(9, 'Test1', 'TestEmail1', 'TestWebpage1', '3910-01-11', 'TestSummary1', 'TestComment1'),
(10, 'Test1', 'TestEmail1', 'TestWebpage1', '3910-01-11', 'TestSummary1', 'TestComment1'),
(11, 'Test1', 'TestEmail1', 'TestWebpage1', '3910-01-11', 'TestSummary1', 'TestComment1'),
(12, 'Test1', 'TestEmail1', 'TestWebpage1', '3910-01-11', 'TestSummary1', 'TestComment1'),
(13, 'Test1', 'TestEmail1', 'TestWebpage1', '3910-01-11', 'TestSummary1', 'TestComment1'),
(14, 'Test1', 'TestEmail1', 'TestWebpage1', '3910-01-11', 'TestSummary1', 'TestComment1'),
(15, 'Test1', 'TestEmail1', 'TestWebpage1', '3910-01-11', 'TestSummary1', 'TestComment1'),
(16, 'Test1', 'TestEmail1', 'TestWebpage1', '3910-01-11', 'TestSummary1', 'TestComment1'),
(17, 'Test1', 'TestEmail1', 'TestWebpage1', '3910-01-11', 'TestSummary1', 'TestComment1'),
(18, 'Test1', 'TestEmail1', 'TestWebpage1', '3910-01-11', 'TestSummary1', 'TestComment1'),
(19, 'Test1', 'TestEmail1', 'TestWebpage1', '3910-01-11', 'TestSummary1', 'TestComment1'),
(20, 'Test1', 'TestEmail1', 'TestWebpage1', '3910-01-11', 'TestSummary1', 'TestComment1'),
(21, 'Test1', 'TestEmail1', 'TestWebpage1', '3910-01-11', 'TestSummary1', 'TestComment1');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(10) UNSIGNED NOT NULL,
  `first_name` varchar(32) NOT NULL,
  `last_name` varchar(32) NOT NULL,
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_admin` tinyint(1) DEFAULT NULL,
  `num_points` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `first_name`, `last_name`, `date_created`, `is_admin`, `num_points`) VALUES
(1, 'jan', 'de Boer', '2018-07-04 21:21:28', 1, 19),
(2, 'Diana', 'de Boer', '2018-07-04 21:21:28', 1, 20),
(3, 'jan', 'de Boer', '2018-07-04 21:21:34', 1, 19),
(4, 'Diana', 'de Boer', '2018-07-04 21:21:34', 1, 20),
(5, 'Diana', 'de Boer', '2018-07-04 21:22:04', 20, 1000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
