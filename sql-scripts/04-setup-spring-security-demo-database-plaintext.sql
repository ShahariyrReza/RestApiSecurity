USE `employee_directory`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users` 
VALUES 
('shahariyr','{bcrypt}$2a$10$/Bo2oCcCiLYOeo2yXl6oo.YGGZRWEuFDCnMEWJjw11M/INMkglXle',1),
('mazher','{bcrypt}$2a$10$/Bo2oCcCiLYOeo2yXl6oo.YGGZRWEuFDCnMEWJjw11M/INMkglXle',1),
('maksud','{bcrypt}$2a$10$doC25KbTC7qeFIQXDFPVt.KfWk1.vzUuS1Toe3la36sEmIr9IX5dK',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('shahariyr','ROLE_EMPLOYEE'),
('mazher','ROLE_EMPLOYEE'),
('mazher','ROLE_MANAGER'),
('maksud','ROLE_EMPLOYEE'),
('maksud','ROLE_MANAGER'),
('maksud','ROLE_ADMIN');


