
CREATE TABLE userdetails (
    userid INT AUTO_INCREMENT PRIMARY KEY,
	username  VARCHAR(25) NOT NULL,
    userpass VARCHAR(255) NOT NULL
);

----maria db database query ------
CREATE TABLE `accountdetails` (
  `accountid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `accountstatus` int(11) DEFAULT 0,
  `accountopeningdate` date DEFAULT NULL,
  `accountclosingdate` date DEFAULT NULL,
  `mainbalance` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`accountid`),
  KEY `userid` (`userid`),
  CONSTRAINT `accountdetails_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ;



CREATE TABLE `transactions` (
  `transactionid` int(11) NOT NULL AUTO_INCREMENT,
  `accountid` int(11) DEFAULT NULL,
  `transactiontype` int(11) DEFAULT NULL,
  `transactionamount` decimal(10,2) DEFAULT NULL,
  `mainbalance` decimal(10,2) DEFAULT NULL,
  `transactiondate` date DEFAULT NULL,
  PRIMARY KEY (`transactionid`),
  KEY `accountid` (`accountid`),
  CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`accountid`) REFERENCES `accountdetails` (`accountid`)
) ;

CREATE TABLE `transactions` (
  `transactionid` int(11) NOT NULL AUTO_INCREMENT,
  `accountid` int(11) DEFAULT NULL,
  `transactiontype` int(11) DEFAULT NULL,
  `transactionamount` decimal(10,2) DEFAULT NULL,
  `mainbalance` decimal(10,2) DEFAULT NULL,
  `transactiondate` date DEFAULT NULL,
  PRIMARY KEY (`transactionid`),
  KEY `accountid` (`accountid`),
  CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`accountid`) REFERENCES `accountdetails` (`accountid`)
) 


INSERT INTO `userdetails` ( `username`, `userpass`) VALUES("tushar","pass");