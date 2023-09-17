package com.piggybank.piggybank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.piggybank.piggybank.modles.TransactionEntity;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;


@EnableJpaRepositories
public interface TransactionsRepository extends JpaRepository<TransactionEntity,String>  {

    List<TransactionEntity> findByAccountid(int accountid);
    
    @Query(value = "select * from transactions where accountid=?1 and transactiondate BETWEEN :?2 AND :?3 ",nativeQuery = true)
    List<TransactionEntity> gettransactionasperdate(int accountid,LocalDate fromDate , LocalDate toDate);
    //transactionDate >= 'fromDate' AND transactionDate <= 'toDate';


    @Transactional
    @Modifying
    @Query(value = "CALL update_balance(accountid ,transactionid)", nativeQuery = true)
    void calculateMainBalance(@Param("accountid") int accountid , @Param("transactionid") int transactionid );
   
}
