package com.piggybank.piggybank.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.piggybank.piggybank.dto.TransactionEntry;
import com.piggybank.piggybank.dto.User;
import com.piggybank.piggybank.dto.UserAccountDetails;
import com.piggybank.piggybank.modles.UserEntity;
import com.piggybank.piggybank.piggybankservice.PiggyServices;

import net.bytebuddy.asm.Advice.Return;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class Controller {
    
@Autowired
private PiggyServices piggyServices;

//http://localhost:8080/Alluser_list
@GetMapping("/Alluser_list")
public List<UserEntity> GettheListofUsers()
{   
   return  piggyServices.GetAllUsers();    
}

//http://localhost:8080/Login/cvbncbnn/pass
@GetMapping("/Login/{name}/{password}")
public String  LoginUser( @PathVariable("name") String name ,  @PathVariable("password") String password )
{
  if(  piggyServices.CheckIFTheUserisNew(name, password)) 
   return  "You are Loggin !!!" ;

   return "Invalid Creditional or Please SignUP";
}

//http://localhost:8080/AddNewUser/cvbncbnn/pass
@PostMapping(value="/AddNewUser/{name}/{password}")
public ResponseEntity<String>  Addnewuser( @PathVariable("name") String name ,  @PathVariable("password") String password) {
   
    User user=new User(name, password) ;
    if(piggyServices.CheckIFTheUserisNew(name, password)) 
    {
      return ResponseEntity.ok().body("Please enter unique name ")  ; 
    }else
    {
      piggyServices.AddnewUser(user);
    }

    System.out.println(user.getUserid()+"this is your customer id ");
    return ResponseEntity.ok("new user  successfully");  
}

//http://localhost:8080/update/passb
@PostMapping(value="/update/{password}")
public ResponseEntity<String>  changepass(  @PathVariable("password") String password) {
  piggyServices.updatepassword(1, password);
  return ResponseEntity.ok().body("New Password set successfully ");
}

///http://localhost:8080/creatnewAccount/1
@PostMapping(value ="/creatnewAccount/{userid}")
public ResponseEntity<String>  createnewAccount(@PathVariable("userid") String  userid )
{  
  int accid = Integer.parseInt(userid.trim());

  if(!piggyServices.CheckIFTheUserHasActiveAccount(accid, 0))
  {
  UserAccountDetails userAccountDetails = new UserAccountDetails(accid, 0,LocalDate.now(), null, 0);
  piggyServices.AddNewuserAccount(userAccountDetails); 
  
  return ResponseEntity.ok().body("new Account number is "+ userAccountDetails.getAccountid());
  }  
  return ResponseEntity.ok().body("user has an active account"); 
}

//http://localhost:8080/closeAccount/1
@PostMapping(value = "/closeAccount/{accountid}")
public String CloseAccountOfUser(@PathVariable("accountid") String  accountid)
{
  int accid =  Integer.parseInt(accountid.trim());
  //UserAccountDetails userAccountDetails = new UserAccountDetails(accid, 0);
  piggyServices.changetheaccountstatusTOCLOSE(accid);
  return "account close successfully ";
}

//http://localhost:8080/debitamount/1/314
@PostMapping(value = "/debitamount/{accountid}/{amount}")
public ResponseEntity<String> CanCustomerrDebitAccount(@PathVariable("accountid") String accountid, @PathVariable("amount") String amount )
{
  int accid =  Integer.parseInt(accountid.trim());
  double amounttodebit  = Double.parseDouble(amount.trim());
  TransactionEntry transactionEntry =  new TransactionEntry(accid, 1, amounttodebit, 0, LocalDate.now());

  if(piggyServices.DebitTransactionisEqualtomainbalance(accid, amounttodebit))
  {
    piggyServices.AddNewTransaction(transactionEntry, amounttodebit);
    piggyServices.changetheaccountstatusTOCLOSE(accid);
    ResponseEntity.ok().body(transactionEntry.getMainbalance()+" this is your current balance and your account status is CLOSED");
  }

  return   ResponseEntity.ok().body("you are not able to withdraw the amount as is does not matches to main balance");
}

//http://localhost:8080/addnewCredit/1/24
@PostMapping(value="/addnewCredit/{accountid}/{transactionAmount}")
public ResponseEntity<String> AddMoneyToPiggyBank(@PathVariable("accountid") String accountid, @PathVariable("transactionAmount") String transactionAmount) {
    int accid =  Integer.parseInt(accountid.trim());
    double  amount =  Double.parseDouble(transactionAmount.trim());

    TransactionEntry  transactionEntry =  new TransactionEntry(accid, 0, amount, 0, LocalDate.now());
    if(piggyServices.GetTheDEtailsofAccountFromAccountnumber(accid).getAccountstatus()==0)
    {
      piggyServices.AddNewTransaction(transactionEntry, amount);
    }else
    {
      return  ResponseEntity.ok().body("account is closed  . Not able to do transaction !!");
    }

  return ResponseEntity.ok().body("transaction was successfully and your main balance is   "+transactionEntry.getMainbalance());
}
}


