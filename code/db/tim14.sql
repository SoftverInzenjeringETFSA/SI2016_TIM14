-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2017 at 07:05 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tim14`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminbanrequest`
--

CREATE TABLE `adminbanrequest` (
  `id` int(11) NOT NULL,
  `reason` varchar(512) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `requestedId` int(11) NOT NULL,
  `targetId` int(11) NOT NULL,
  `chatGroupId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

-- --------------------------------------------------------

--
-- Table structure for table `blockeduser`
--

CREATE TABLE `blockeduser` (
  `id` int(11) NOT NULL,
  `sourceId` int(11) NOT NULL,
  `targetId` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

-- --------------------------------------------------------

--
-- Table structure for table `chatgroup`
--

CREATE TABLE `chatgroup` (
  `id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_slovenian_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `isActive` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

-- --------------------------------------------------------

--
-- Table structure for table `privatechat`
--

CREATE TABLE `privatechat` (
  `id` int(11) NOT NULL,
  `sourceId` int(11) NOT NULL,
  `targetId` int(11) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

-- --------------------------------------------------------

--
-- Table structure for table `privatechatarchive`
--

CREATE TABLE `privatechatarchive` (
  `id` int(11) NOT NULL,
  `privateChatId` int(11) NOT NULL,
  `sourceId` int(11) NOT NULL,
  `message` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(55) COLLATE utf8_slovenian_ci NOT NULL,
  `password` varchar(25) COLLATE utf8_slovenian_ci NOT NULL,
  `firstName` varchar(40) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `lastName` varchar(40) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `email` varchar(80) COLLATE utf8_slovenian_ci NOT NULL,
  `gender` bit(1) DEFAULT NULL,
  `dateOfBirth` date DEFAULT NULL,
  `Location` varchar(100) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `about` varchar(512) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `isAdmin` bit(1) NOT NULL DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `firstName`, `lastName`, `email`, `gender`, `dateOfBirth`, `Location`, `about`, `isAdmin`) VALUES
(1, 'berina', 'ovojesifra1A', NULL, NULL, 'berina@gmail.com', NULL, NULL, NULL, NULL, b'0'),
(2, 'neko', 'password', NULL, NULL, 'neko@gmail.com', NULL, NULL, NULL, NULL, b'0'),
(3, 'korisnik', 'ovojekorisnik', NULL, NULL, 'korisnik@gmail.com', NULL, NULL, NULL, NULL, b'0'),
(4, 'haris', 'sifrica1A', NULL, NULL, 'haris@gmail.com', NULL, NULL, NULL, NULL, b'0'),
(5, 'nekaosoba', 'njenpassword2A', NULL, NULL, 'nekaosoba@gmail.com', NULL, NULL, NULL, NULL, b'0'),
(7, 'nekaosoba1', 'nekaosoba1A', NULL, NULL, 'nekaosoba1@gmail.com', NULL, NULL, NULL, NULL, b'0'),
(8, 'osobica', 'ovojelozinka2A', NULL, NULL, 'email@gmail.com', NULL, NULL, NULL, NULL, b'0'),
(9, 'jasamberina', 'password58A', NULL, NULL, 'mojmail@gmail.com', NULL, NULL, NULL, NULL, b'0'),
(11, 'nekobeze', 'nekobeze22A', NULL, NULL, 'nekobeze@gmail.com', NULL, NULL, NULL, NULL, b'0'),
(12, 'noviuser1A', 'noviuser1A', NULL, NULL, 'noviuser1A@gmail.com', NULL, NULL, NULL, NULL, b'0'),
(13, 'ovojeuser25S', 'ovojeuser25S', NULL, NULL, 'ovojeuser25S@gmail.com', NULL, NULL, NULL, NULL, b'0'),
(14, 'ovojeuser23S', 'ovojeuser25S', NULL, NULL, 'ovojeuser23S@gmail.com', NULL, NULL, NULL, NULL, b'0'),
(15, 'username5', 'username5A', NULL, NULL, 'username5@gmail.com', NULL, NULL, NULL, NULL, b'0'),
(16, 'username88', 'username88A', NULL, NULL, 'username88@gmail.com', NULL, NULL, NULL, NULL, b'0');

-- --------------------------------------------------------

--
-- Table structure for table `userchatgroup`
--

CREATE TABLE `userchatgroup` (
  `userId` int(11) NOT NULL,
  `chatGroupId` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

-- --------------------------------------------------------

--
-- Table structure for table `userreview`
--

CREATE TABLE `userreview` (
  `id` int(11) NOT NULL,
  `grade` int(11) NOT NULL,
  `description` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `sourceId` int(11) NOT NULL,
  `targetId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adminbanrequest`
--
ALTER TABLE `adminbanrequest`
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `requestedId` (`requestedId`,`targetId`,`chatGroupId`),
  ADD KEY `adminbanrequest_ibfk_2` (`targetId`),
  ADD KEY `adminbanrequest_ibfk_3` (`chatGroupId`);

--
-- Indexes for table `blockeduser`
--
ALTER TABLE `blockeduser`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `sourceId` (`sourceId`,`targetId`),
  ADD KEY `blockeduser_ibfk_2` (`targetId`);

--
-- Indexes for table `chatgroup`
--
ALTER TABLE `chatgroup`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `privatechat`
--
ALTER TABLE `privatechat`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `sourceId` (`sourceId`,`targetId`),
  ADD KEY `privatechat_ibfk_2` (`targetId`);

--
-- Indexes for table `privatechatarchive`
--
ALTER TABLE `privatechatarchive`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `privateChatId` (`privateChatId`,`sourceId`),
  ADD KEY `privatechatarchive_ibfk_2` (`sourceId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD UNIQUE KEY `id_2` (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `userchatgroup`
--
ALTER TABLE `userchatgroup`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userId` (`userId`,`chatGroupId`),
  ADD KEY `userchatgroup_ibfk_2` (`chatGroupId`);

--
-- Indexes for table `userreview`
--
ALTER TABLE `userreview`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `sourceId` (`sourceId`,`targetId`),
  ADD KEY `userreview_ibfk_2` (`targetId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adminbanrequest`
--
ALTER TABLE `adminbanrequest`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `blockeduser`
--
ALTER TABLE `blockeduser`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `chatgroup`
--
ALTER TABLE `chatgroup`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `privatechat`
--
ALTER TABLE `privatechat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `privatechatarchive`
--
ALTER TABLE `privatechatarchive`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `userchatgroup`
--
ALTER TABLE `userchatgroup`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `userreview`
--
ALTER TABLE `userreview`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `adminbanrequest`
--
ALTER TABLE `adminbanrequest`
  ADD CONSTRAINT `adminbanrequest_ibfk_1` FOREIGN KEY (`requestedId`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `adminbanrequest_ibfk_2` FOREIGN KEY (`targetId`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `adminbanrequest_ibfk_3` FOREIGN KEY (`chatGroupId`) REFERENCES `userchatgroup` (`id`);

--
-- Constraints for table `blockeduser`
--
ALTER TABLE `blockeduser`
  ADD CONSTRAINT `blockeduser_ibfk_1` FOREIGN KEY (`sourceId`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `blockeduser_ibfk_2` FOREIGN KEY (`targetId`) REFERENCES `user` (`id`);

--
-- Constraints for table `privatechat`
--
ALTER TABLE `privatechat`
  ADD CONSTRAINT `privatechat_ibfk_1` FOREIGN KEY (`sourceId`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `privatechat_ibfk_2` FOREIGN KEY (`targetId`) REFERENCES `user` (`id`);

--
-- Constraints for table `privatechatarchive`
--
ALTER TABLE `privatechatarchive`
  ADD CONSTRAINT `privatechatarchive_ibfk_1` FOREIGN KEY (`privateChatId`) REFERENCES `privatechat` (`id`),
  ADD CONSTRAINT `privatechatarchive_ibfk_2` FOREIGN KEY (`sourceId`) REFERENCES `user` (`id`);

--
-- Constraints for table `userchatgroup`
--
ALTER TABLE `userchatgroup`
  ADD CONSTRAINT `userchatgroup_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `userchatgroup_ibfk_2` FOREIGN KEY (`chatGroupId`) REFERENCES `chatgroup` (`id`);

--
-- Constraints for table `userreview`
--
ALTER TABLE `userreview`
  ADD CONSTRAINT `userreview_ibfk_1` FOREIGN KEY (`sourceId`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `userreview_ibfk_2` FOREIGN KEY (`targetId`) REFERENCES `user` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
