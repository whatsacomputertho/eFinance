/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efinance.model;

/**
 *
 * @author Joseph Haftl
 */
public class paymentAccount {
private int paymentAmount;
private int accountID;
private Loan loan;
private String paymentDate; 



    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    
public void makePayment(int paymentAmount){

    
}
public void trackPayment(String paymentDate){
    
}




//two users 1 customer 1 account manager
//would have a loan
//account for the loan
//use this account to make payments to the loan
        
}
