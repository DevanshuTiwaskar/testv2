
CREATE TABLE userdetails (
    userid INT AUTO_INCREMENT PRIMARY KEY,
	username  VARCHAR(25) NOT NULL,
    userpass VARCHAR(255) NOT NULL
);

CREATE TABLE accountdetails (
  accountid INT AUTO_INCREMENT PRIMARY KEY,
  userid INT,
  accountstatus INT DEFAULT 0,
  accountopeningdate DATE,
  accountclosingdate DATE,
  mainbalance DECIMAL(10, 2),
  FOREIGN KEY (userid) REFERENCES userdetails(userid)
);

CREATE TABLE transactions (
  transactionid INT AUTO_INCREMENT PRIMARY KEY,
  accountid INT,
  transactiontype INT,
  transactionamount DECIMAL(10, 2),
  mainbalance DECIMAL(10, 2),
  transactiondate DATE,
  FOREIGN KEY (accountid) REFERENCES accountdetails(accountid)
);

INSERT INTO `userdetails` ( `username`, `userpass`) VALUES('tushar','pass');

