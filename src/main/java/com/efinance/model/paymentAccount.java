package com.efinance.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Joseph Haftl
 */
public class paymentAccount 
{
    /**
     * Payment accounts consist of two users, the borrower and the account manager.
     * The borrower is already associated with the loan itself, so the only user that must be stored directly within the paymentAccount class is the account manager
     */
    private user accountManager;
    
    /**
     * Payment accounts also consist of a loan which is used to calculate its current value based on its origination date and its initial value.
     * These form the basis for the account balance, and then these are used to calculate interest over time.
     */
    private Loan loan;
    
    /**
     * 
     */
    private ArrayList<Date> paymentDates;
    
    /**
     * 
     */
    private ArrayList<Double> paymentAmounts;

    /**
     * 
     * @return 
     */
    public Loan getLoan()
    {
        return loan;
    }

    /**
     * 
     * @param loan 
     */
    public void setLoan(Loan loan)
    {
        this.loan = loan;
    }

    /**
     * 
     * @return 
     */
    public user getAccountManager()
    {
        return accountManager;
    }

    /**
     * 
     * @param accountManager 
     */
    public void setAccountManager(user accountManager)
    {
        this.accountManager = accountManager;
    }

    /**
     * 
     * @return 
     */
    public ArrayList<Date> getPaymentDates()
    {
        return paymentDates;
    }

    /**
     * 
     * @param paymentDates 
     */
    public void setPaymentDates(ArrayList<Date> paymentDates)
    {
        this.paymentDates = paymentDates;
    }

    /**
     * 
     * @return 
     */
    public ArrayList<Double> getPaymentAmounts()
    {
        return paymentAmounts;
    }

    /**
     * 
     * @param paymentAmounts 
     */
    public void setPaymentAmounts(ArrayList<Double> paymentAmounts)
    {
        this.paymentAmounts = paymentAmounts;
    }

    /**
     * 
     * @param paymentAmount 
     */
    public void makePayment(int paymentAmount)
    {

    }

    /**
     * 
     * @param paymentDate 
     */
    public void trackPayment(String paymentDate)
    {

    }
}
