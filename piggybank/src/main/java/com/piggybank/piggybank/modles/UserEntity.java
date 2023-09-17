package com.piggybank.piggybank.modles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "userdetails")
@Data

public class UserEntity {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int userid;

    private String username;

    private String userpass ;
}
