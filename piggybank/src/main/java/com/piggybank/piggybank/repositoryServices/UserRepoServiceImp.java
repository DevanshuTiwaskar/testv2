package com.piggybank.piggybank.repositoryServices;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.piggybank.piggybank.dto.User;
import com.piggybank.piggybank.modles.UserEntity;
import com.piggybank.piggybank.repositories.UserRepository;

@Service
public class UserRepoServiceImp implements UserRepositoryservices{
    
    @Autowired
    UserRepository  userRepository;



    @PersistenceContext
    private final EntityManager userEntityManager;

    public UserRepoServiceImp(EntityManager userEntityManager) {
        this.userEntityManager = userEntityManager;
    }

    @Override
    public List<UserEntity> getAlltheUsers() {
       
        return userRepository.findAll();
        
    }

    @Override
    public boolean checktheuserifpresentornot(String username, String userpassward) {        

         try {
            UserEntity userEntity =  userRepository.checkifuserpresentornot(username, userpassward); 
            userEntity.getUserid();
            System.out.println(userEntity.getUserid()+"from the userimpl");
         } catch (NullPointerException e) {
                System.out.println("please enter correct login details or signup  with new id ");
                return false;
         }
         
         return true;
    }

    @Transactional
    public void insertnewuser(User user) {

        //userRepository.save(user);
        System.out.println(user.getUsername());
        UserEntity userEntity =  new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setUserpass(user.getUserpassword());
        System.out.println(userEntity.getUserid());
        try {
            //userEntityManager.getTransaction().begin();
            userEntityManager.persist(userEntity);
            // System.out.println(userEntity.getUserid());
            user.setUserid(userEntity.getUserid());
            userEntityManager.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        //the below method is for mariadbaand mysql
        // userEntityManager.createQuery("INSERT INTO userdetails (username, userpass) VALUES (?, ?) ")
        // .setParameter(1, user.getUsername())
        // .setParameter(2, user.getUserpassword())
        // .executeUpdate();
    }

    @Override
    public void changethepasswordofUser(int userid, String password) {
       userRepository.updatepassword(userid, password);
    }
    
}
