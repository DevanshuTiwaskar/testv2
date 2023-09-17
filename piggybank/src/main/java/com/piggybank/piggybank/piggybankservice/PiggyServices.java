package com.piggybank.piggybank.piggybankservice;

import java.util.List;

import com.piggybank.piggybank.dto.TransactionEntry;
import com.piggybank.piggybank.dto.User;
import com.piggybank.piggybank.dto.UserAccountDetails;
import com.piggybank.piggybank.modles.AccountDetailsEntity;
import com.piggybank.piggybank.modles.TransactionEntity;
import com.piggybank.piggybank.modles.UserEntity;

public interface PiggyServices {
    

    boolean CheckIFTheUserisNew(String username ,String userpassword);

    boolean CheckIFTheUserHasActiveAccount(int userid , int accountstatus);

    double GettheMainBalanceOfUser(int userid ,int accountstatus);

    AccountDetailsEntity GetTheDEtailsofAccountFromAccountnumber(int accountid);

    boolean DebitTransactionisEqualtomainbalance( int accountid , double transactionAmountToDebit ) ; /// logic for  dedbit transaction  if debit the debit main balance 

    void AddnewUser( User user );

    void updatepassword(int userid , String pass);

    void AddNewTransaction(TransactionEntry transactionEntity,double amounttocredit );

    void AddNewuserAccount(UserAccountDetails  userAccountDetails);

    List<UserEntity> GetAllUsers();

    void changetheaccountstatusTOCLOSE(int accountid);

    void updatethemainbalanceinAccountDetails(int accountid ,double amount );

    

}
