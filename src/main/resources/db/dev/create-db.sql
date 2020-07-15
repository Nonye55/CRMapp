
--
-- Table structure for table customer`
--

CREATE DATABASE IF NOT EXISTS customer_db;
use customer_db;
 
DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (

  `id` long(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `phone_Number`varchar(45) DEFAULT NULL, 
  `email` varchar(45) DEFAULT NULL,
  `user_name`varchar(45)DEFAULT NULL,
  `pass_word` varchar(45)DEFAULT NULL,
  `salt` varchar(20)DEFAULT NULL

 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
--
--



