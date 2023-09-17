package com.piggybank.piggybank.piggybankservice;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.piggybank.piggybank.dto.TransactionEntry;
import com.piggybank.piggybank.dto.User;
import com.piggybank.piggybank.dto.UserAccountDetails;
import com.piggybank.piggybank.modles.AccountDetailsEntity;
import com.piggybank.piggybank.modles.TransactionEntity;
import com.piggybank.piggybank.modles.UserEntity;
import com.piggybank.piggybank.repositories.AccountDetailsRepository;
import com.piggybank.piggybank.repositoryServices.AccountDetailsRepositoryServices;
import com.piggybank.piggybank.repositoryServices.TransactionRepositoryServices;
import com.piggybank.piggybank.repositoryServices.UserRepositoryservices;
@Service
public class PiggyServicesImp  implements PiggyServices {


    @Autowired
    UserRepositoryservices userRepositoryservices;

    @Autowired 
    AccountDetailsRepositoryServices accountDetailsRepositoryServices;
    @Autowired
    TransactionRepositoryServices transactionRepositoryServices;

    @Override
    public boolean CheckIFTheUserisNew(String username, String userpassword) {

        if(userRepositoryservices.checktheuserifpresentornot(username,userpassword))
        return true;

        return false ;
    }

    @Override
    public boolean CheckIFTheUserHasActiveAccount(int userid, int accountstatus) {

        AccountDetailsEntity accountDetailsEntity =  accountDetailsRepositoryServices.gethteuseraccountdetilas(userid, accountstatus) ;  //.gettheuseraccountdetails(userid ,accountstatus);
        if(accountDetailsEntity==null)
        {
            return false;
        }


        return true;
    }

    @Override
    public double GettheMainBalanceOfUser(int userid ,int accountstatus) {
     
        AccountDetailsEntity accountDetailsEntity =   accountDetailsRepositoryServices.gethteuseraccountdetilas(userid, accountstatus);
        return accountDetailsEntity.getMainbalance();
    }

    @Override
    public boolean DebitTransactionisEqualtomainbalance( int accountid , double transactionAmountToDebit) {

        if(GetTheDEtailsofAccountFromAccountnumber(accountid).getMainbalance() ==transactionAmountToDebit)
        return true;
    
        return false;
    }

    @Override
    public void AddnewUser(User user) {
        
        userRepositoryservices.insertnewuser(user);
    }

   

    @Override
    public void AddNewuserAccount(UserAccountDetails  userAccountDetails) {
        
        accountDetailsRepositoryServices.insertnewaccountfortheuesr(userAccountDetails);
    }

    @Override
    public List<UserEntity> GetAllUsers() {
        
        return  userRepositoryservices.getAlltheUsers();
    }

    @Override
    public void updatepassword(int userid, String pass) {
       
        userRepositoryservices.changethepasswordofUser(userid, pass);
    }

    @Override
    public void changetheaccountstatusTOCLOSE(int accountid) {

        accountDetailsRepositoryServices.changetheaccountstatus(accountid, 1);
    }

    @Override
    public AccountDetailsEntity GetTheDEtailsofAccountFromAccountnumber(int accountid) {
       
        return accountDetailsRepositoryServices.getAccountDetailsUsingAccountid(accountid);
    }

    @Override
    public void updatethemainbalanceinAccountDetails(int accountid,double amount) {
        // TODO Auto-generated method stub
       accountDetailsRepositoryServices.Updatethemainbalnce(accountid, amount);
    }

    @Override
    public void AddNewTransaction(TransactionEntry  transaction  ,double amounttocredit) {
       
        if(GetTheDEtailsofAccountFromAccountnumber(transaction.getAccountid()).getMainbalance()==0.00)
        {
            updatethemainbalanceinAccountDetails(transaction.getAccountid(), amounttocredit);            

            transactionRepositoryServices.insertnewtransaciton(transaction,0  );
        }else
        {
             double  previousbalance =  GetTheDEtailsofAccountFromAccountnumber(transaction.getAccountid()).getMainbalance();
          if(transaction.getTransactiontype()==1)
          {
            updatethemainbalanceinAccountDetails(transaction.getAccountid(),  previousbalance-amounttocredit);  
          }
          else
          {
            updatethemainbalanceinAccountDetails(transaction.getAccountid(),  previousbalance+amounttocredit); 
          }
          
        transactionRepositoryServices.insertnewtransaciton(transaction,previousbalance); 
        }
        
    }
    
}
