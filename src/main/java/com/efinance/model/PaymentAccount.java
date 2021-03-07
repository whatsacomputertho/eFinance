package com.efinance.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Joseph Haftl
 */
public class PaymentAccount 
{
    /**
     * Payment accounts consist of two users, the borrower and the account manager
 The borrower is already associated with the loan itself, so the only User that must be stored directly within the PaymentAccount class is the account manager
     */
    private User accountManager;
    
    /**
     * Payment accounts also consist of a loan which is used to calculate its current value based on its origination date and its initial value
     * These form the basis for the account balance, and then these are used to calculate interest over time
     */
    private Loan loan;
    /**
     * The date that the loan was payed on. This will be an array that shows all the dates that the User made payments on
 This will be used to allow the User and manger to track when payments were made
     */
    private ArrayList<Date> paymentDates;
    
    /**
     * The amount that the User pays each time they make a payment.
     * This will allow the User and manger to track the amount they payed during each payment
     */
    private ArrayList<Double> paymentAmounts;
  
    /**
     * Returns the variable loan of type loan. This variable made in the loan Loan class includes CAR, STUDENT, MORTGAGE, PROJECT, RENOVATION
     * @return loan
     */
    public Loan getLoan()
    {
        return loan;
    }

    /**
     * sets the variable loan of type loan. This variable made in the loan Loan class includes CAR, STUDENT, MORTGAGE, PROJECT, RENOVATION
     * @param loan variable of type loan
     */
    public void setLoan(Loan loan)
    {
        this.loan = loan;
    }

    /**
     * returns the variable accountManager, which is of type User
     * @return accountManager
     */
    public User getAccountManager()
    {
        return accountManager;
    }

    /**
     * sets the variable accountManager, which is of type User
     * @param accountManager variable of type User
     */
    public void setAccountManager(User accountManager)
    {
        this.accountManager = accountManager;
    }

    /**
     * returns the array of payment dates, showing each of the days the User made a payment
     * @return paymentDates
     */
    public ArrayList<Date> getPaymentDates()
    {
        return paymentDates;
    }

    /**
     * sets the array of payment dates
     * @param paymentDates an array of dates that contains each day the User has made a payment
     */
    public void setPaymentDates(ArrayList<Date> paymentDates)
    {
        this.paymentDates = paymentDates;
    }

    /**
     * returns the amount of money that the User paid
     * @return paymentAmounts
     */
    public ArrayList<Double> getPaymentAmounts()
    {
        return paymentAmounts;
    }

    /**
     * sets the amount of money that the User paid.
     * @param paymentAmounts an array of the payment amounts containing the amount that they pay each time
     */
    public void setPaymentAmounts(ArrayList<Double> paymentAmounts)
    {
        this.paymentAmounts = paymentAmounts;
    }

    /**
     * Allows the User to pay a certain amount of money, in order to pay off their loan
     * @param paymentAmount the amount that the User decides to pay off their loan by
     */
    public void makePayment(double paymentAmount)
    {

    }

    /**
     * Allows the User and manager to see all past payments, This displays all the dates these payments were made on and the amount that was paid
     * @param paymentDates an array of dates that contains each day the User has made a payment
     * @param paymentAmounts an array of the payment amounts containing the amount that they pay each time
     */
    public void trackPayment(ArrayList paymentDates, ArrayList paymentAmounts)
    {

    }
}
