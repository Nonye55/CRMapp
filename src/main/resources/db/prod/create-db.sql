
--
-- Table structure for table customer`
--

use heroku_c601739d2b94a00;

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (

  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `phone_Number`varchar(45) DEFAULT NULL, 
  `email` varchar(45) DEFAULT NULL, 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
--
--



