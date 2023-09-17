package com.piggybank.piggybank.modles;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="accountdetails")
@Data
public class AccountDetailsEntity {
    
    @Id
     @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int accountid ; 

    private int userid ;

    private int  accountstatus ;

    private LocalDate accountopeningdate;

    private LocalDate accountclosingdate;

    private double mainbalance;
       
}
