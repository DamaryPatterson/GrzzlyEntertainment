-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 11, 2023 at 06:00 PM
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
-- Database: `rentalent`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customerID` varchar(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `accountBalance` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerID`, `username`, `password`, `accountBalance`) VALUES
('11001', 'JPatterson', '0000', 2000),
('2001463', 'dP', '12345', 123);

-- --------------------------------------------------------

--
-- Table structure for table `customermessage`
--

CREATE TABLE `customermessage` (
  `messageID` varchar(20) NOT NULL,
  `customerID` varchar(20) DEFAULT NULL,
  `messageContent` varchar(1000) NOT NULL,
  `employeeResponse` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customermessage`
--

INSERT INTO `customermessage` (`messageID`, `customerID`, `messageContent`, `employeeResponse`) VALUES
('2x2x22', '2001463', 'testing again', 'I am A Employee'),
('xxxx', '11001', 'This is a new message', 'This is the employee response using update');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `employeeID` varchar(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employeeID`, `username`, `password`) VALUES
('2000', 'empTest', 'login'),
('2001', 'panther', 'test');

-- --------------------------------------------------------

--
-- Table structure for table `equipment`
--

CREATE TABLE `equipment` (
  `equipmentID` varchar(20) NOT NULL,
  `equipmentName` varchar(50) NOT NULL,
  `equipmentCategory` varchar(50) NOT NULL,
  `isAvailable` tinyint(1) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `equipment`
--

INSERT INTO `equipment` (`equipmentID`, `equipmentName`, `equipmentCategory`, `isAvailable`, `price`) VALUES
('100', 'Drums', 'Sound', 1, 1000);

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `eventID` varchar(20) NOT NULL,
  `eventName` varchar(20) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`eventID`, `eventName`, `date`) VALUES
('654xx', 'TeenFete', '2023-12-11');

-- --------------------------------------------------------

--
-- Table structure for table `eventschedule`
--

CREATE TABLE `eventschedule` (
  `eventScheduleID` varchar(20) NOT NULL,
  `eventID` varchar(50) NOT NULL,
  `employeeID` varchar(50) NOT NULL,
  `EquipmentID` varchar(20) NOT NULL,
  `eventDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `eventschedule`
--

INSERT INTO `eventschedule` (`eventScheduleID`, `eventID`, `employeeID`, `EquipmentID`, `eventDate`) VALUES
('12345', '654xx', '2000', '100', '2023-02-02');

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `inventoryID` varchar(20) NOT NULL,
  `equipmentID` varchar(20) NOT NULL,
  `quantityAvailable` int(11) NOT NULL,
  `equipmentCategory` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rentalrequest`
--

CREATE TABLE `rentalrequest` (
  `requestID` varchar(20) NOT NULL,
  `customerID` varchar(20) NOT NULL,
  `equipmentID` varchar(20) NOT NULL,
  `rentalDate` date NOT NULL,
  `quotationCost` double NOT NULL,
  `rentalStatus` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rentalrequest`
--

INSERT INTO `rentalrequest` (`requestID`, `customerID`, `equipmentID`, `rentalDate`, `quotationCost`, `rentalStatus`) VALUES
('00011', '2001463', '100', '2023-12-05', 5000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transactionID` varchar(20) NOT NULL,
  `customerID` varchar(20) NOT NULL,
  `requestID` varchar(20) NOT NULL,
  `transactionDate` date NOT NULL,
  `amountPaid` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`transactionID`, `customerID`, `requestID`, `transactionDate`, `amountPaid`) VALUES
('t1263', '11001', '00011', '2023-12-12', 1000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerID`);

--
-- Indexes for table `customermessage`
--
ALTER TABLE `customermessage`
  ADD PRIMARY KEY (`messageID`),
  ADD KEY `customerID` (`customerID`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employeeID`);

--
-- Indexes for table `equipment`
--
ALTER TABLE `equipment`
  ADD PRIMARY KEY (`equipmentID`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`eventID`);

--
-- Indexes for table `eventschedule`
--
ALTER TABLE `eventschedule`
  ADD PRIMARY KEY (`eventScheduleID`),
  ADD KEY `employeeID` (`employeeID`),
  ADD KEY `EquipmentID` (`EquipmentID`),
  ADD KEY `eventID` (`eventID`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`inventoryID`),
  ADD KEY `equipmentID` (`equipmentID`);

--
-- Indexes for table `rentalrequest`
--
ALTER TABLE `rentalrequest`
  ADD PRIMARY KEY (`requestID`),
  ADD KEY `customerID` (`customerID`),
  ADD KEY `equipmentID` (`equipmentID`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transactionID`),
  ADD KEY `customerID` (`customerID`),
  ADD KEY `requestID` (`requestID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customermessage`
--
ALTER TABLE `customermessage`
  ADD CONSTRAINT `customermessage_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`);

--
-- Constraints for table `eventschedule`
--
ALTER TABLE `eventschedule`
  ADD CONSTRAINT `eventschedule_ibfk_1` FOREIGN KEY (`employeeID`) REFERENCES `employee` (`employeeID`),
  ADD CONSTRAINT `eventschedule_ibfk_2` FOREIGN KEY (`EquipmentID`) REFERENCES `equipment` (`equipmentID`),
  ADD CONSTRAINT `eventschedule_ibfk_3` FOREIGN KEY (`eventID`) REFERENCES `event` (`eventID`);

--
-- Constraints for table `inventory`
--
ALTER TABLE `inventory`
  ADD CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`equipmentID`) REFERENCES `equipment` (`equipmentID`);

--
-- Constraints for table `rentalrequest`
--
ALTER TABLE `rentalrequest`
  ADD CONSTRAINT `rentalrequest_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`),
  ADD CONSTRAINT `rentalrequest_ibfk_2` FOREIGN KEY (`equipmentID`) REFERENCES `equipment` (`equipmentID`);

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`),
  ADD CONSTRAINT `transaction_ibfk_2` FOREIGN KEY (`requestID`) REFERENCES `rentalrequest` (`requestID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
