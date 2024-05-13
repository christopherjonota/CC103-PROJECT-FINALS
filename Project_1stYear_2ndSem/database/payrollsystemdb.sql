-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2024 at 12:14 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `payrollsystemdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `credentials`
--

CREATE TABLE `credentials` (
  `ID` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `newUser` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `credentials`
--

INSERT INTO `credentials` (`ID`, `username`, `password`, `newUser`) VALUES
(2, 'admin', 'admin', 0),
(5, 'adada', 'adadaa', 0),
(6, 'adada', 'adadaa', 0),
(7, 'Chris', 'hahha', 0);

-- --------------------------------------------------------

--
-- Table structure for table `userdata`
--

CREATE TABLE `userdata` (
  `ID` int(11) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `middlename` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `job_position` varchar(20) NOT NULL,
  `employment_type` varchar(20) NOT NULL,
  `basic_rate` varchar(20) NOT NULL,
  `per` varchar(20) NOT NULL,
  `profile` varchar(50) DEFAULT NULL,
  `birthday` varchar(20) NOT NULL,
  `contactNumber` varchar(20) NOT NULL,
  `emailAddress` varchar(50) NOT NULL,
  `sssIdNumber` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `contactfullname` varchar(50) NOT NULL,
  `contactrelationship` varchar(50) NOT NULL,
  `contactPhoneNumber` varchar(50) NOT NULL,
  `contactEmailAddress` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `userdata`
--

INSERT INTO `userdata` (`ID`, `firstname`, `middlename`, `lastname`, `job_position`, `employment_type`, `basic_rate`, `per`, `profile`, `birthday`, `contactNumber`, `emailAddress`, `sssIdNumber`, `address`, `contactfullname`, `contactrelationship`, `contactPhoneNumber`, `contactEmailAddress`) VALUES
(1, 'Christopher', 'Boragay', 'Jonota', 'Owner', 'owner', '20000', 'Month', NULL, 'January 31, 2005', '09351539638', 'cristopherjonota@gmail.com', '1234-123-123-45123', 'Blk 5 Lot 29 IBP cluster Quezon City  NCR  - 1126', 'emma', 'mother', '09228305975', 'emma@yahoo.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `credentials`
--
ALTER TABLE `credentials`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `userdata`
--
ALTER TABLE `userdata`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `credentials`
--
ALTER TABLE `credentials`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `userdata`
--
ALTER TABLE `userdata`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
