Table1 ->  user : 
useid :  Unique user id in int 
userpass : password int string 

Table2 ->  accountdetails 
accountid : unique accountid 
userid : userid  from the table  user
accountstatus : 0 is for active and 1 is for Inactive
accountopeningdate : when the first time accountis open then it is account opening date 
accountclosingdate : when the account status is change to Inactive then account close date is update 

Table3 -> transactions 

transactionid : uique transaction id 
accountid :  accountid id has to be taken from accountdetails table2 
transactiontype : 0 is for credit and 1 is for debit 
transactionamount : the amount user deposit or remove from the account 
mainbalance : the total amount after the user credit or debit  from the account
transactiondate : the date of the transaction 


help me to write the stored procedure  in mysql  to calculate the main balance .
For calculating the main balance ,  use the previous transaction amount  of  the specific accountid .
add the amount when it is having transactiontype as 0  and subtract when it is 1 


  -- update  the new transaction record
    UPDATE transactions  
    SET mainbalance = new_balance
    WHERE accountid = account_id and transactionid =transaction_id ;
	
	
	
	======================================================================================================================
	DELIMITER //

    CREATE PROCEDURE update_balance(IN account_id INT,IN transaction_id INT)	
	BEGIN
    DECLARE previous_balance DECIMAL(10, 2);
    DECLARE new_balance DECIMAL(10, 2);
    DECLARE transaction_type INT;
    DECLARE transaction_amount DECIMAL(10, 2);
    
    -- Get the previous balance for the account
    SELECT IFNULL(mainbalance, 0) INTO previous_balance
    FROM accountdetails
    WHERE accountid = account_id;
    
    -- Calculate the new main balance based on the latest transaction
    SELECT transactiontype, transactionamount INTO transaction_type, transaction_amount
    FROM transactions 
    WHERE accountid = account_id
    ORDER BY transactiondate DESC, transactionid DESC
    LIMIT 1;
    
    IF transaction_type = 0 THEN
        SET new_balance = previous_balance + transaction_amount;
    ELSE
        SET new_balance = previous_balance - transaction_amount;
    END IF;
    
    -- Update the main balance in the accountdetails table
    UPDATE accountdetails
    SET mainbalance = new_balance
    WHERE accountid = account_id;
    
  
  -- update  the new transaction record
    UPDATE transactions  
    SET mainbalance = new_balance
    WHERE accountid = account_id and transactionid =transaction_id ;
    
END //

DELIMITER ;


=====================================================================================================================

CREATE TABLE userdetails (
    userid INT AUTO_INCREMENT PRIMARY KEY,
	username  VARCHAR(25) NOT NULL,
    userpass VARCHAR(255) NOT NULL
);


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
) 



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



==============================================================================================================================================================================================================================================================

