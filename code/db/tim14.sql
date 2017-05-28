-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 28, 2017 at 11:14 PM
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
  `reason` varchar(512) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `requestedId` varchar(55) COLLATE utf8_slovenian_ci NOT NULL,
  `targetId` varchar(55) COLLATE utf8_slovenian_ci NOT NULL,
  `chatGroupId` varchar(55) COLLATE utf8_slovenian_ci NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

--
-- Dumping data for table `adminbanrequest`
--

INSERT INTO `adminbanrequest` (`reason`, `requestedId`, `targetId`, `chatGroupId`, `id`) VALUES
('prekrsio Hipokratovu zakletvu', '11', '12', '7', 5);

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
(6, 'Sport', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s%2C when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries%2C but also the leap into electronic typesetting%2C remaining essentially unchanged. '),
(7, 'Muzika', 'Lorem ipsum dolor sit amet%2C consectetur adipiscing elit. Suspendisse porta enim non volutpat interdum. Morbi scelerisque ultricies tincidunt. Proin ullamcorper odio ac ullamcorper consequat. Sed quam diam%2C scelerisque in elit ut%2C consectetur fermentum dolor. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis fringilla porttitor mi nec tincidunt. Sed aliquam justo et convallis efficitur. Phasellus eget venenatis ipsum%2C vel iaculis justo. Maecenas ante justo%2C consectetur nec hendrerit sit amet%2C varius sit amet est. Ut tempor dolor purus%2C in cursus nulla consequat nec. Duis bibendum mi nec elit '),
(10, 'Dinosaurusi', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.'),
(11, 'Ples', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.'),
(12, 'Igrice', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.');

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
('4', 'haris', 17, 'Andrej'),
('2', 'neko', 4, 'haris');

-- --------------------------------------------------------

--
-- Table structure for table `poruka`
--

CREATE TABLE `poruka` (
  `id` int(11) NOT NULL,
  `korisnikId` int(11) NOT NULL,
  `groupId` int(11) NOT NULL,
  `sadrzaj` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `privatechat`
--

CREATE TABLE `privatechat` (
  `id` int(11) NOT NULL,
  `sourceId` int(11) NOT NULL,
  `targetId` int(11) NOT NULL
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
  `zanimanje` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `interesovanja` text COLLATE utf8_slovenian_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `firstName`, `lastName`, `email`, `gender`, `dateOfBirth`, `location`, `omeni`, `isAdmin`, `zanimanje`, `interesovanja`) VALUES
(2, 'neko', 'password', ' Dino', 'Merlin', 'dino@gmail.com', NULL, NULL, 'Dubai', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s,     when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries,     but also the leap into electronic typesetting,     remaining essentially unchanged. It was popularised in the 1960s with the release', b'1', 'Pjevac', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s,     when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries,     but also the leap into electronic typesetting,     remaining essentially unchanged. It was popularised in the 1960s with the release'),
(20, 'mikimaus', 'mikimaus3A', ' Miki', ' Maus', 'mikimaus@gmail.com', NULL, NULL, ' Sarajevo', ' Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s,  when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries,  but also the leap into electronic typesetting,  remaining essentially unchanged.', b'0', 'Veterinar', ' '),
(21, 'username2', 'username25A', NULL, NULL, 'username2@gmail.com', NULL, NULL, NULL, NULL, b'0', NULL, NULL),
(22, 'korisnik', 'korisnik123A', NULL, NULL, 'korisnik@gmail.com', NULL, NULL, NULL, NULL, b'0', NULL, NULL),
(23, 'lolek', 'lolek147A', NULL, NULL, 'lolek@gmail.com', NULL, NULL, NULL, NULL, b'0', NULL, NULL),
(24, 'jennifer', 'jennifer1K', NULL, NULL, 'jennifer@gmail.com', NULL, NULL, NULL, NULL, b'0', NULL, NULL),
(25, 'aplikacija', 'aplikacija1A', NULL, NULL, 'aplikacija@gmail.com', NULL, NULL, NULL, NULL, b'0', NULL, NULL),
(27, 'dino2', 'dino2A23', NULL, NULL, 'dino2@gmail.com', NULL, NULL, NULL, NULL, b'0', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `userchatgroup`
--

CREATE TABLE `userchatgroup` (
  `korisnikId` int(11) NOT NULL,
  `groupId` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

--
-- Dumping data for table `userchatgroup`
--

INSERT INTO `userchatgroup` (`korisnikId`, `groupId`, `id`) VALUES
(20, 7, 14),
(21, 11, 15),
(23, 12, 16),
(27, 11, 17);

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
  ADD PRIMARY KEY (`id`);

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
-- Indexes for table `poruka`
--
ALTER TABLE `poruka`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `privatechat`
--
ALTER TABLE `privatechat`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `sourceId` (`sourceId`,`targetId`),
  ADD KEY `privatechat_ibfk_2` (`targetId`);

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
  ADD KEY `userId` (`korisnikId`,`groupId`),
  ADD KEY `userchatgroup_ibfk_2` (`groupId`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `blockeduser`
--
ALTER TABLE `blockeduser`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `chatgroup`
--
ALTER TABLE `chatgroup`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `poruka`
--
ALTER TABLE `poruka`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `privatechat`
--
ALTER TABLE `privatechat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT for table `userchatgroup`
--
ALTER TABLE `userchatgroup`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `userreview`
--
ALTER TABLE `userreview`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `blockeduser`
--
ALTER TABLE `blockeduser`
  ADD CONSTRAINT `blockeduser_ibfk_1` FOREIGN KEY (`sourceId`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `blockeduser_ibfk_2` FOREIGN KEY (`targetId`) REFERENCES `user` (`id`);

--
-- Constraints for table `userreview`
--
ALTER TABLE `userreview`
  ADD CONSTRAINT `userreview_ibfk_1` FOREIGN KEY (`sourceId`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `userreview_ibfk_2` FOREIGN KEY (`targetId`) REFERENCES `user` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
