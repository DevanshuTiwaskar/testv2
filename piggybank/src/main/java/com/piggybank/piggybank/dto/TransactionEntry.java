package com.piggybank.piggybank.dto;

import java.time.LocalDate;

public class TransactionEntry {
    
    private int transactionid;
    private int accountid ;
    private int transactiontype;
    private double  transactionamount;
    private double  mainbalance;
    private LocalDate transactiondate;


    public TransactionEntry(int transactionid, int accountid, int transactiontype, double transactionamount, int mainbalance,
            LocalDate transactiondate) {
        this.transactionid = transactionid;
        this.accountid = accountid;
        this.transactiontype = transactiontype;
        this.transactionamount = transactionamount;
        this.mainbalance = mainbalance;
        this.transactiondate = transactiondate;
    }

    

    public TransactionEntry(int accountid, int transactiontype, double transactionamount, double mainbalance,
            LocalDate transactiondate) {
        this.accountid = accountid;
        this.transactiontype = transactiontype;
        this.transactionamount = transactionamount;
        this.mainbalance = mainbalance;
        this.transactiondate = transactiondate;
    }



    public int getTransactionid() {
        return transactionid;
    }


    public void setTransactionid(int transactionid) {
        this.transactionid = transactionid;
    }


    public int getAccountid() {
        return accountid;
    }


    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


    public int getTransactiontype() {
        return transactiontype;
    }


    public void setTransactiontype(int transactiontype) {
        this.transactiontype = transactiontype;
    }


    public double getTransactionamount() {
        return transactionamount;
    }


    public void setTransactionamount(double transactionamount) {
        this.transactionamount = transactionamount;
    }


    public double getMainbalance() {
        return mainbalance;
    }


    public void setMainbalance(double mainbalance) {
        this.mainbalance = mainbalance;
    }


    public LocalDate getTransactiondate() {
        return transactiondate;
    }


    public void setTransactiondate(LocalDate transactiondate) {
        this.transactiondate = transactiondate;
    }

    



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + transactionid;
        result = prime * result + accountid;
        result = prime * result + transactiontype;
        long temp;
        temp = Double.doubleToLongBits(transactionamount);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(mainbalance);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((transactiondate == null) ? 0 : transactiondate.hashCode());
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
        TransactionEntry other = (TransactionEntry) obj;
        if (transactionid != other.transactionid)
            return false;
        if (accountid != other.accountid)
            return false;
        if (transactiontype != other.transactiontype)
            return false;
        if (Double.doubleToLongBits(transactionamount) != Double.doubleToLongBits(other.transactionamount))
            return false;
        if (Double.doubleToLongBits(mainbalance) != Double.doubleToLongBits(other.mainbalance))
            return false;
        if (transactiondate == null) {
            if (other.transactiondate != null)
                return false;
        } else if (!transactiondate.equals(other.transactiondate))
            return false;
        return true;
    }



    @Override
    public String toString() {
        return "Transactons [transactionid=" + transactionid + ", accountid=" + accountid + ", transactiontype="
                + transactiontype + ", transactionamount=" + transactionamount + ", mainbalance=" + mainbalance
                + ", transactiondate=" + transactiondate + "]";
    }

    
    


    


}
