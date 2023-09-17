package com.piggybank.piggybank.repositoryServices;

import java.time.LocalDate;

import com.piggybank.piggybank.dto.UserAccountDetails;
import com.piggybank.piggybank.modles.AccountDetailsEntity;

public interface AccountDetailsRepositoryServices {  

    AccountDetailsEntity gethteuseraccountdetilas(int userid  ,int accountstatus);    
    void changetheaccountstatus(int accountid , int accountstatus  );
    void insertnewaccountfortheuesr(UserAccountDetails userAccountDetails);
    AccountDetailsEntity  getAccountDetailsUsingAccountid(int accountid );
    void Updatethemainbalnce(int accountid ,double mainbalance);
}
