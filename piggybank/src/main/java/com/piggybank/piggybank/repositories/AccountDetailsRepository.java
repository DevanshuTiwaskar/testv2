package com.piggybank.piggybank.repositories;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.piggybank.piggybank.modles.AccountDetailsEntity;

@EnableJpaRepositories
public interface AccountDetailsRepository extends JpaRepository<AccountDetailsEntity,String> {
 
    @Query(value="select * from accountdetails where  userid =?1 and accountstatus =?2  ",nativeQuery=true)
    AccountDetailsEntity gettheuseraccountdetails(int userid ,int accountstatus);

    @Transactional
    @Modifying
    @Query(value = "UPDATE accountdetails  SET accountstatus = ?2 ,accountclosingdate= ?3    WHERE accountid = ?1",nativeQuery = true)
    int  updatetheaccountstatustoclose(int accountid , int accountstatus ,LocalDate dateofclosing  );

    @Transactional
    @Modifying
    @Query(value="Update accountdetails SET mainbalance=?2 where accountid =?1 ",nativeQuery = true)
    void changethemainbalance(int accountid , double mainbalance);
    
    @Query(value = "select  * from accountdetails where accountid=?1",nativeQuery = true)
    AccountDetailsEntity getAccountdetailsbyaccountid(int accountid);
}
