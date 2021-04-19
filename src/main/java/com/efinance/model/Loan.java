package com.efinance.model;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="loan")
public class Loan
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="loanid", nullable=false)
    private int loanId;
    
    /**
     * The borrower data field tracks the User who takes out the loan
     */
    @ManyToOne
    @JoinColumn(name="userid", nullable=false)
    private User borrower;
    
    /**
     * The loan type signifies which type of loan the borrower has taken out
     */
    @Column(name="loantype", nullable=false)
    @Enumerated(EnumType.STRING)
    private LoanType loanType;
    
    /**
     * The loan approval date signifies the date the loan was approved.  This is also referred to as its origination date
     */
    @Column(name="loanapprovaldate")
    @Temporal(TemporalType.DATE)
    private Date loanApprovalDate;
    
    @Column(name="isapproved")
    private boolean isApproved;
    
    /**
     * The amount data field signifies how much money the loan is worth in US Dollars (USD)
     */
    @Column(name="amountusd", nullable=false)
    private double amountUSD;
    
    /**
     * The interest rate data field signifies the rate at which interest is accrued with regard to time
     */
    @Column(name="interestrate", nullable=false)
    private double interestRate;
    
    /**
     * This enumeration specifies the various types of loans that eFinance supports
     * Includes Car loans, Student loans, Mortgages, Project loans, and Renovation loans
     */
    public enum LoanType{CAR, STUDENT, MORTGAGE, PROJECT, RENOVATION};

    /**
     * No Parameter Constructor
     */
    public Loan()
    {
        //Just instantiate
    }
    
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
        this.loanType = type;
        this.loanApprovalDate = loanApprovalDate;
        this.amountUSD = amountUSD;
        this.interestRate = interestRate;
    }

    public int getLoanId()
    {
        return loanId;
    }

    public void setLoanId(int loanId)
    {
        this.loanId = loanId;
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
    public LoanType getLoanType()
    {
        return loanType;
    }

    /**
     * Sets the loan type which signifies which type of loan the borrower has taken out
     * @param loanType Loan type that was taken out
     */
    public void setLoanType(LoanType loanType)
    {
        this.loanType = loanType;
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

    public boolean isIsApproved()
    {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved)
    {
        this.isApproved = isApproved;
    }
}