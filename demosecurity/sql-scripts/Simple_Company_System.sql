CREATE DATABASE IF NOT EXISTS `Simple_Company_System`;
USE `Simple_Company_System`;

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `first_name` varchar(45) DEFAULT NULL,
                            `last_name` varchar(45) DEFAULT NULL,
                            `email` varchar(45) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `employee` VALUES
                           (1,'Leslie','Andrews','leslie@luv2code.com'),
                           (2,'Emma','Baumgarten','emma@luv2code.com'),
                           (3,'Avani','Gupta','avani@luv2code.com'),
                           (4,'Yuri','Petrov','yuri@luv2code.com'),
                           (5,'Juan','Vega','juan@luv2code.com');

DROP TABLE IF EXISTS `members`;

CREATE TABLE `members` (
                           `user_id` varchar(50) NOT NULL,
                           `pw` char(68) NOT NULL,
                           `active` tinyint NOT NULL,
                           PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `members`
VALUES
    ('john','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
    ('mary','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
    ('susan','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1);

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
                         `user_id` varchar(50) NOT NULL,
                         `role` varchar(50) NOT NULL,
                         UNIQUE KEY `authorities5_idx_1` (`user_id`,`role`),
                         CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `roles`
VALUES
    ('john','ROLE_EMPLOYEE'),
    ('mary','ROLE_EMPLOYEE'),
    ('mary','ROLE_MANAGER'),
    ('susan','ROLE_EMPLOYEE'),
    ('susan','ROLE_MANAGER'),
    ('susan','ROLE_ADMIN');
