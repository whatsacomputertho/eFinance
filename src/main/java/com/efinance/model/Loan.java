package com.efinance.model;

import java.util.ArrayList;
import java.util.Date;

public class Loan
{
    /**
     * The borrower data field tracks the User who takes out the loan
     */
    private User borrower;
    
    /**
     * The loan type signifies which type of loan the borrower has taken out
     */
    private LoanType type;
    
    /**
     * The loan approval date signifies the date the loan was approved.  This is also referred to as its origination date
     */
    private Date loanApprovalDate;
    
    /**
     * The amount data field signifies how much money the loan is worth in US Dollars (USD)
     */
    private double amountUSD;
    
    /**
     * The interest rate data field signifies the rate at which interest is accrued with regard to time
     */
    private double interestRate;
    
    /**
     * This enumeration specifies the various types of loans that eFinance supports
     * Includes Car loans, Student loans, Mortgages, Project loans, and Renovation loans
     */
    public enum LoanType{CAR, STUDENT, MORTGAGE, PROJECT, RENOVATION};

    /**
     * All parameter constructor
     * @param borrower Tracks the User who takes out the loan
     * @param type Type of loan that the User has taken out
     * @param loanApprovalDate Date that the loan was approved on
     * @param amountUSD Amount of money the loan contain
     * @param interestRate The interest rate of the loan
     */
    public Loan(User borrower, LoanType type, Date loanApprovalDate, double amountUSD, double interestRate)
    {
        this.borrower = borrower;
        this.type = type;
        this.loanApprovalDate = loanApprovalDate;
        this.amountUSD = amountUSD;
        this.interestRate = interestRate;
    }
    
    /**
     * Returns the borrower data field which tracks the User who takes out the loan
     * @return borrower
     */
    public User getBorrower()
    {
        return borrower;
    }

    /**
     * Sets the borrower data field which tracks the User who takes out the loan
     * @param borrower User who takes out the loan
     */
    public void setBorrower(User borrower)
    {
        this.borrower = borrower;
    }

    /**
     * Returns the loan type which signifies which type of loan the borrower has taken out
     * @return type
     */
    public LoanType getType()
    {
        return type;
    }

    /**
     * Sets the loan type which signifies which type of loan the borrower has taken out
     * @param type Loan type that was taken out
     */
    public void setType(LoanType type)
    {
        this.type = type;
    }

    /**
     * Returns the loan approval date which signifies the date the loan was approved.  It is also referred to as its origination date
     * @return loanApprovalDate
     */
    public Date getLoanApprovalDate()
    {
        return loanApprovalDate;
    }

    /**
     * Sets the loan approval date which signifies the date the loan was approved.  It is also referred to as its origination date
     * @param loanApprovalDate Date the loan was approved on
     */
    public void setLoanApprovalDate(Date loanApprovalDate)
    {
        this.loanApprovalDate = loanApprovalDate;
    }

    /**
     * Returns the amount data field which signifies how much money the loan is worth in US Dollars (USD)
     * @return amountUSD
     */
    public double getAmountUSD()
    {
        return amountUSD;
    }

    /**
     * Sets the amount data field which signifies how much money the loan is worth in US Dollars (USD)
     * @param amountUSD Amount of money the loan contains
     */
    public void setAmountUSD(double amountUSD)
    {
        this.amountUSD = amountUSD;
    }

    /**
     * Returns the interest rate data field which signifies the rate at which interest is accrued with regard to time
     * @return interestRate
     */
    public double getInterestRate()
    {
        return interestRate;
    }

    /**
     * Sets the interest rate data field which signifies the rate at which interest is accrued with regard to time
     * @param interestRate The interest rate of the loan
     */
    public void setInterestRate(double interestRate)
    {
        this.interestRate = interestRate;
    }
    
    /**
     * Calculates the interest accrued since last payment date based on the current date, last payment date, and current balance.
     * Also involves the use of the interestRate instance variable.
     * Conditionally involves the use of amountUSD and approvalDate instance variables.
     * @param lastPaymentDate Last time the User made a payment 
     * @param currentBalance The current balance left in the loan needed to calculate the interestRate variable
     * @return interest
     */
    public double calculateInterest(Date lastPaymentDate, double currentBalance)
    {
        double interest = 0.0f;
        /*
        TODO: Implement
        */
        return interest;
    }
    
    /**
     * Generates a formatted list containing the loan's information for front-end display.
     * Involves all instance variables.
     * @return loanInformation
     */
    public ArrayList<String> generateLoanInformation()
    {
        ArrayList<String> loanInformation = new ArrayList();
        /*
        TODO: Implement
        */
        return loanInformation;
    }
}