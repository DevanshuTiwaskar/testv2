package com.piggybank.piggybank.repositoryServices;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.piggybank.piggybank.dto.TransactionEntry;
import com.piggybank.piggybank.modles.TransactionEntity;
import com.piggybank.piggybank.repositories.TransactionsRepository;

@Service
public class TransactionRepSeviceImp  implements TransactionRepositoryServices {

    @Autowired 
    TransactionsRepository transactionsRepository;

    @PersistenceContext
    private final EntityManager  transEntityManager;

    public TransactionRepSeviceImp(EntityManager transEntityManager)
    {
        this.transEntityManager=transEntityManager;
    }

    @Override
    public List<TransactionEntity> getallthetransactionhistorybyaccountid(int accountid) {       
        return transactionsRepository.findByAccountid(accountid) ;
    }

    @Override
    public List<TransactionEntity> getthetransactionbetweenfromdatetotodate(int accountid, LocalDate fromDate,
            LocalDate toDate) {
      
        return transactionsRepository.gettransactionasperdate(accountid, fromDate, toDate);
    }
    @Transactional
    @Override
    public void insertnewtransaciton(TransactionEntry transaction,double previousbalance) {
            
            TransactionEntity  transactionEntity =  new TransactionEntity();
            transactionEntity.setAccountid(transaction.getAccountid());
            transactionEntity.setTransactionamount(transaction.getTransactionamount());
            if(transaction.getTransactiontype()==1)
            {
                transactionEntity.setMainbalance(transaction.getTransactionamount()-previousbalance);
            }else
            {
                transactionEntity.setMainbalance(transaction.getTransactionamount()+previousbalance);
            }
           
            transactionEntity.setTransactiondate(LocalDate.now());
            transactionEntity.setTransactiontype(transaction.getTransactiontype());

            try {
                transEntityManager.persist(transactionEntity);
                transaction.setMainbalance(transactionEntity.getMainbalance());
                transEntityManager.close();

            } catch (Exception e) {
                e.printStackTrace();
            }


            


            // transEntityManager.createQuery("INSERT INTO `transactions` ( `accountid`, `transactiontype`, `transactionamount`, `mainbalance`, `transactiondate`)VALUES(?,?,?,?,?)")
            // .setParameter(1, transaction.getAccountid())
            // .setParameter(2, transaction.getTransactiontype())
            // .setParameter(3, transaction.getTransactionamount())
            // .setParameter(4, 0)
            // .setParameter(5, LocalDate.now())
            // .executeUpdate();

            // transactionsRepository.calculateMainBalance(transaction.getAccountid(), transaction.getTransactionid());
            //        in transaction repos     Transaction save(Transaction transaction);
            //        Transaction savedTransaction = transactionRepository.save(transaction);
            //        return savedTransaction;
        }
    
}
