package com.piggybank.piggybank.dto;

import java.time.LocalDate;

public class UserAccountDetails {
    
    private int accountid;
    private int userid;
    private int accountstatus ; 
    private LocalDate accountopeningdate ;
    private LocalDate accountclosingdate ;
    private double mainbalance ;


    public UserAccountDetails(int accountid, int userid, int accountstatus, LocalDate accountopeningdate,
            LocalDate accountclosingdate, double mainbalance) {
        this.accountid = accountid;
        this.userid = userid;
        this.accountstatus = accountstatus;
        this.accountopeningdate = accountopeningdate;
        this.accountclosingdate = accountclosingdate;
        this.mainbalance = mainbalance;
    }
    

    public UserAccountDetails(int userid, int accountstatus, LocalDate accountopeningdate, LocalDate accountclosingdate,
            double mainbalance) {
        this.userid = userid;
        this.accountstatus = accountstatus;
        this.accountopeningdate = accountopeningdate;
        this.accountclosingdate = accountclosingdate;
        this.mainbalance = mainbalance;
    }


    public UserAccountDetails(int accountid, int accountstatus) {
        this.accountid = accountid;
        this.accountstatus = accountstatus;
    }


    public int getAccountid() {
        return accountid;
    }


    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


    public int getUserid() {
        return userid;
    }


    public void setUserid(int userid) {
        this.userid = userid;
    }


    public int getAccountstatus() {
        return accountstatus;
    }


    public void setAccountstatus(int accountstatus) {
        this.accountstatus = accountstatus;
    }


    public LocalDate getAccountopeningdate() {
        return accountopeningdate;
    }


    public void setAccountopeningdate(LocalDate accountopeningdate) {
        this.accountopeningdate = accountopeningdate;
    }


    public LocalDate getAccountclosingdate() {
        return accountclosingdate;
    }


    public void setAccountclosingdate(LocalDate accountclosingdate) {
        this.accountclosingdate = accountclosingdate;
    }


    public double getMainbalance() {
        return mainbalance;
    }


    public void setMainbalance(double mainbalance) {
        this.mainbalance = mainbalance;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + accountid;
        result = prime * result + userid;
        result = prime * result + accountstatus;
        result = prime * result + ((accountopeningdate == null) ? 0 : accountopeningdate.hashCode());
        result = prime * result + ((accountclosingdate == null) ? 0 : accountclosingdate.hashCode());
        long temp;
        temp = Double.doubleToLongBits(mainbalance);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserAccountDetails other = (UserAccountDetails) obj;
        if (accountid != other.accountid)
            return false;
        if (userid != other.userid)
            return false;
        if (accountstatus != other.accountstatus)
            return false;
        if (accountopeningdate == null) {
            if (other.accountopeningdate != null)
                return false;
        } else if (!accountopeningdate.equals(other.accountopeningdate))
            return false;
        if (accountclosingdate == null) {
            if (other.accountclosingdate != null)
                return false;
        } else if (!accountclosingdate.equals(other.accountclosingdate))
            return false;
        if (Double.doubleToLongBits(mainbalance) != Double.doubleToLongBits(other.mainbalance))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "UserAccountDetails [accountid=" + accountid + ", userid=" + userid + ", accountstatus=" + accountstatus
                + ", accountopeningdate=" + accountopeningdate + ", accountclosingdate=" + accountclosingdate
                + ", mainbalance=" + mainbalance + "]";
    }
}
