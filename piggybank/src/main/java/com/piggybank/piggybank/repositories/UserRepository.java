package com.piggybank.piggybank.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.piggybank.piggybank.dto.User;
import com.piggybank.piggybank.modles.UserEntity;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<UserEntity,String> {
    
    @Query(value = "select * from userdetails",nativeQuery = true)
    List<UserEntity> findall();

    @Query(value = "select * from userdetails where username=?1 and userpass=?2",nativeQuery = true)
    UserEntity checkifuserpresentornot(String username, String userpass); 
    
    @Transactional
    @Modifying
    @Query(value ="update userdetails set userpass =?2 where userid =?1 " ,nativeQuery=true)
    void updatepassword(int userid , String userpass);


    // UserEntity  save(User user);
}
