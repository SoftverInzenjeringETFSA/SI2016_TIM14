-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 27, 2017 at 12:15 AM
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
  `description` text COLLATE utf8_slovenian_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

--
-- Dumping data for table `chatgroup`
--

INSERT INTO `chatgroup` (`id`, `name`, `description`) VALUES
(6, 'Sport', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s%2C when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries%2C but also the leap into electronic typesetting%2C remaining essentially unchanged. ');

-- --------------------------------------------------------

--
-- Table structure for table `invites`
--

CREATE TABLE `invites` (
  `idOfInvitee` varchar(45) DEFAULT NULL,
  `usernameOfInvitee` varchar(45) DEFAULT NULL,
  `idOfInviter` int(11) DEFAULT NULL,
  `usernameOfInviter` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `invites`
--

INSERT INTO `invites` (`idOfInvitee`, `usernameOfInvitee`, `idOfInviter`, `usernameOfInviter`) VALUES
('5', 'nekaosoba', 17, 'Andrej'),
('4', 'haris', 17, 'Andrej');

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
  `location` varchar(100) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `omeni` text COLLATE utf8_slovenian_ci,
  `isAdmin` bit(1) NOT NULL DEFAULT b'0',
  `zanimanje` varchar(255) COLLATE utf8_slovenian_ci NOT NULL,
  `interesovanja` text COLLATE utf8_slovenian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `firstName`, `lastName`, `email`, `gender`, `dateOfBirth`, `location`, `omeni`, `isAdmin`, `zanimanje`, `interesovanja`) VALUES
(1, 'berina', 'ovojesifra1A', NULL, NULL, 'berina@gmail.com', NULL, NULL, NULL, NULL, b'0', '', ''),
(2, 'neko', 'password', 'Neko', 'Nekić', 'neko@gmail.com', NULL, NULL, 'Sarajevo', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse porta enim non volutpat interdum. Morbi scelerisque ultricies tincidunt. Proin ullamcorper odio ac ullamcorper consequat. Sed quam diam, scelerisque in elit ut, consectetur fermentum dolor. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis fringilla porttitor mi nec tincidunt. Sed aliquam justo et convallis efficitur. Phasellus eget venenatis ipsum, vel iaculis justo. ', b'0', 'Programer', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse porta enim non volutpat interdum. Morbi scelerisque ultricies tincidunt. Proin ullamcorper odio ac ullamcorper consequat. Sed quam diam, scelerisque in elit ut, consectetur fermentum dolor. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis fringilla porttitor mi nec tincidunt. Sed aliquam justo et convallis efficitur. Phasellus eget venenatis ipsum, vel iaculis justo. Maecenas ante justo, consectetur nec hendrerit sit amet, varius sit amet est. Ut tempor dolor purus, in cursus nulla consequat nec. Duis bibendum mi nec elit '),
(3, 'korisnik', 'ovojekorisnik', NULL, NULL, 'korisnik@gmail.com', NULL, NULL, NULL, NULL, b'0', '', ''),
(4, 'haris', 'sifrica1A', NULL, NULL, 'haris@gmail.com', NULL, NULL, NULL, NULL, b'0', '', ''),
(5, 'nekaosoba', 'njenpassword2A', NULL, NULL, 'nekaosoba@gmail.com', NULL, NULL, NULL, NULL, b'0', '', ''),
(7, 'nekaosoba1', 'nekaosoba1A', NULL, NULL, 'nekaosoba1@gmail.com', NULL, NULL, NULL, NULL, b'0', '', ''),
(8, 'osobica', 'ovojelozinka2A', NULL, NULL, 'email@gmail.com', NULL, NULL, NULL, NULL, b'0', '', ''),
(9, 'jasamberina', 'password58A', NULL, NULL, 'mojmail@gmail.com', NULL, NULL, NULL, NULL, b'0', '', ''),
(11, 'nekobeze', 'nekobeze22A', NULL, NULL, 'nekobeze@gmail.com', NULL, NULL, NULL, NULL, b'0', '', ''),
(12, 'noviuser1A', 'noviuser1A', NULL, NULL, 'noviuser1A@gmail.com', NULL, NULL, NULL, NULL, b'0', '', ''),
(13, 'ovojeuser25S', 'ovojeuser25S', NULL, NULL, 'ovojeuser25S@gmail.com', NULL, NULL, NULL, NULL, b'0', '', ''),
(14, 'ovojeuser23S', 'ovojeuser25S', NULL, NULL, 'ovojeuser23S@gmail.com', NULL, NULL, NULL, NULL, b'0', '', ''),
(15, 'username5', 'username5A', NULL, NULL, 'username5@gmail.com', NULL, NULL, NULL, NULL, b'0', '', ''),
(16, 'username88', 'username88A', NULL, NULL, 'username88@gmail.com', NULL, NULL, NULL, NULL, b'0', '', ''),
(17, 'Andrej', '1DvaTri!', NULL, NULL, 'andrej@si.ba', NULL, NULL, NULL, NULL, b'0', '', ''),
(18, 'andrej88', 'Ivona88', NULL, NULL, 'andrejoapsod@jdshfuko.com', NULL, NULL, NULL, NULL, b'0', '', ''),
(19, 'Blavblabljkdba', 'RayBan88', NULL, NULL, 'asnjklsdn@djasnd.com', NULL, NULL, NULL, NULL, b'0', '', '');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
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
