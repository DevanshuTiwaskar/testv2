package com.piggybank.piggybank.modles;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="transactions")
@Data
public class TransactionEntity {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int transactionid;

    private int accountid;

    private int transactiontype;

    private double transactionamount ;

    private double mainbalance ;

    private LocalDate transactiondate ;

}
