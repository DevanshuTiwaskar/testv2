# https---github.com-tushartiwaskar1997-PiggyBank
Hello , This is the Spring Boot Application having the h2 database configuration . Their are Three tables  UserDetails  , AccountDetails ,Transactions .  

The Flow of the Application is :-
1. User has to register to the application using the API : http://localhost:8080/AddNewUser/DAVID/PASSWORD
   here david is username and Password is password .
2. After the user is created ,next step is to login  . In this version i have not written the code for session management , in next verson it will be their .
   Login Url :- http://localhost:8080/Login/DAVID/PASSWORD .
3. To get the List Of all the users  use URL -: http://localhost:8080/Alluser_list
4. To create account of user  Url : - http://localhost:8080/AddNewUser/cvbncbnn/pass
5. To do the transaction in accout   Url -:  for Credit to account --> http://localhost:8080/addnewCredit/1/24 ,   for Debit to account  --> http://localhost:8080/debitamount/1/314
6. In this application user is allowed  do transactions only in one account . The user can only debit the total amount . After the total amount is debited then account is marked close . After this user is able to create new account .
7. data.sql file contains all the script related to h2 database And in sqlfile.sql all the process related to mariadb is their  .
8. IN mariadb procedure is created to auto calculate the main balance of account .
   




