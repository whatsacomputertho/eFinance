package com.efinance.model;

import java.util.Date;

public class Loan
{
    /**
     * The borrower data field tracks the user who takes out the loan
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
     * @param borrower
     * @param type
     * @param loanApprovalDate
     * @param amountUSD
     * @param interestRate 
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
     * Returns the borrower data field which tracks the user who takes out the loan
     * @return borrower
     */
    public User getBorrower()
    {
        return borrower;
    }

    /**
     * Sets the borrower data field which tracks the user who takes out the loan
     * @param borrower 
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
     * @param type 
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
     * @param loanApprovalDate 
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
     * @param amountUSD 
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
     * @param interestRate
     */
    public void setInterestRate(double interestRate)
    {
        this.interestRate = interestRate;
    }
    
    /*
    TODO: Insert Methods Here
    */
}