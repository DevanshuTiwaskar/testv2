package com.piggybank.piggybank.repositoryServices;

import java.util.List;

import com.piggybank.piggybank.dto.User;
import com.piggybank.piggybank.modles.UserEntity;

public interface UserRepositoryservices {


    List<UserEntity> getAlltheUsers();

    boolean checktheuserifpresentornot(String username,String userpassward);

    void insertnewuser(User user);

    void changethepasswordofUser(int userid , String password);

    
}
