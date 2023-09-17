package com.piggybank.piggybank.repositoryServices;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.piggybank.piggybank.dto.UserAccountDetails;
import com.piggybank.piggybank.modles.AccountDetailsEntity;
import com.piggybank.piggybank.repositories.AccountDetailsRepository;
@Service
public class AccountDetailsRepoImp implements AccountDetailsRepositoryServices {
    
    @Autowired
    AccountDetailsRepository accountDetailsRepository;

    @PersistenceContext
    private final EntityManager accouEntityManager; 

    public AccountDetailsRepoImp(EntityManager accouEntityManager)
    {
        this.accouEntityManager=accouEntityManager;
    }


    @Override
    public AccountDetailsEntity gethteuseraccountdetilas(int userid ,int accountstatus) {
       
        return accountDetailsRepository.gettheuseraccountdetails(userid, accountstatus);
    }

    @Override
    public void changetheaccountstatus(int accountid, int accountstatus) {

       if( accountDetailsRepository.updatetheaccountstatustoclose(accountid, accountstatus, LocalDate.now())==1)
       {
        System.out.println("accoun close successfully ");
       }
    }


    // the insert method will be used to insertnew account details from the customer
    @Transactional  
    @Override
    public void insertnewaccountfortheuesr(UserAccountDetails userAccountDetails) {

        AccountDetailsEntity accountDetailsEntity =  new AccountDetailsEntity();
        accountDetailsEntity.setUserid(userAccountDetails.getUserid());
        accountDetailsEntity.setAccountstatus(userAccountDetails.getAccountstatus());
        accountDetailsEntity.setAccountopeningdate(userAccountDetails.getAccountopeningdate());
        accountDetailsEntity.setAccountclosingdate(userAccountDetails.getAccountclosingdate());
        accountDetailsEntity.setMainbalance(userAccountDetails.getMainbalance());

        // accouEntityManager.createQuery("INSERT INTO `accountdetails` ( `userid`, `accountstatus`, `accountopeningdate`, `accountclosingdate`, `mainbalance`) VALUES(?,?,?,?,?)")
        // .setParameter(1, userAccountDetails.getUserid())
        // .setParameter(2, userAccountDetails.getAccountstatus())
        // .setParameter(3, userAccountDetails.getAccountopeningdate())
        // .setParameter(4, 0)
        // .setParameter(5, 0)
        // .executeUpdate();

        try {
               accouEntityManager.persist(accountDetailsEntity);
               userAccountDetails.setAccountid(accountDetailsEntity.getAccountid());
               accouEntityManager.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        }
   
    }


    @Override
    public AccountDetailsEntity getAccountDetailsUsingAccountid(int accountid) {
       
        return accountDetailsRepository.getAccountdetailsbyaccountid(accountid);
    }


    @Override
    public void Updatethemainbalnce(int accountid, double mainbalance) {
        accountDetailsRepository.changethemainbalance(accountid, mainbalance);
    }
    
}
