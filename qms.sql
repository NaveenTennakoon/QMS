-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 30, 2019 at 05:12 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qms`
--

-- --------------------------------------------------------

--
-- Table structure for table `call_quotations`
--

CREATE TABLE `call_quotations` (
  `SID` int(11) NOT NULL,
  `productService` text NOT NULL,
  `quantity` int(11) NOT NULL,
  `Status` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `call_quotations`
--

INSERT INTO `call_quotations` (`SID`, `productService`, `quantity`, `Status`) VALUES
(1, 'Books', 1000, 'Open'),
(2, 'Pens', 500, 'Closed'),
(3, 'Pencils', 600, 'Open');

-- --------------------------------------------------------

--
-- Table structure for table `login_details`
--

CREATE TABLE `login_details` (
  `ID` int(11) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login_details`
--

INSERT INTO `login_details` (`ID`, `username`, `password`) VALUES
(1, 'naveen', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `quotations`
--

CREATE TABLE `quotations` (
  `QID` int(11) NOT NULL,
  `companyName` text NOT NULL,
  `quantity` int(11) NOT NULL,
  `unitPrice` int(11) NOT NULL,
  `prevQuotations` text NOT NULL,
  `notes` text DEFAULT NULL,
  `SID` int(11) NOT NULL,
  `contact` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `quotations`
--

INSERT INTO `quotations` (`QID`, `companyName`, `quantity`, `unitPrice`, `prevQuotations`, `notes`, `SID`, `contact`) VALUES
(1, 'ABCD', 100, 50, 'No', 'Nothing to say here for you', 1, 718723129),
(2, 'XYZ Travels', 30, 12, 'Yes', 'Nothing to say here either', 3, 459872431),
(4, 'Diarra Cmp', 300, 23, 'No', 'Hi there i am using Whatsapp', 1, 789872354),
(5, 'Hiace Company', 800, 43, 'Yes', 'Nothing to say for the transactions', 1, 764573421);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `call_quotations`
--
ALTER TABLE `call_quotations`
  ADD PRIMARY KEY (`SID`);

--
-- Indexes for table `login_details`
--
ALTER TABLE `login_details`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `quotations`
--
ALTER TABLE `quotations`
  ADD PRIMARY KEY (`QID`),
  ADD KEY `SID_fk` (`SID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `call_quotations`
--
ALTER TABLE `call_quotations`
  MODIFY `SID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `login_details`
--
ALTER TABLE `login_details`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `quotations`
--
ALTER TABLE `quotations`
  MODIFY `QID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `quotations`
--
ALTER TABLE `quotations`
  ADD CONSTRAINT `SID_fk` FOREIGN KEY (`SID`) REFERENCES `call_quotations` (`SID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
