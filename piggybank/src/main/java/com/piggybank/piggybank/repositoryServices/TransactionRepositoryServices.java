package com.piggybank.piggybank.repositoryServices;

import java.time.LocalDate;
import java.util.List;
import com.piggybank.piggybank.modles.TransactionEntity;
import com.piggybank.piggybank.dto.TransactionEntry;

public interface TransactionRepositoryServices {
     

        List<TransactionEntity> getallthetransactionhistorybyaccountid(int accountid);
        List<TransactionEntity> getthetransactionbetweenfromdatetotodate(int accountid, LocalDate fromDate ,LocalDate toDate);
        void insertnewtransaciton(TransactionEntry transaction,double previousbalance);
}
