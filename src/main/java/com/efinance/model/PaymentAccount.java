package com.efinance.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="paymentaccount")
public class PaymentAccount 
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="accountid", nullable=false)
    private Integer accountId;
    
    /**
     * Payment accounts consist of two users, the borrower and the account manager
     * The borrower is already associated with the loan itself, so the only User that must be stored directly within the PaymentAccount class is the account manager
     */
    @ManyToOne
    @JoinColumn(name="userid", nullable=false)
    private User accountManager;
    
    /**
     * Payment accounts also consist of a loan which is used to calculate its current value based on its origination date and its initial value
     * These form the basis for the account balance, and then these are used to calculate interest over time
     */
    @ManyToOne
    @JoinColumn(name="loanid", nullable=false)
    private Loan loan;
    
    @OneToMany(mappedBy="account")
    private Set<Payment> payments;
  
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

    public Integer getAccountId()
    {
        return accountId;
    }

    public void setAccountId(Integer accountId)
    {
        this.accountId = accountId;
    }

    public Set<Payment> getPayments()
    {
        return payments;
    }

    public void setPayments(Set<Payment> payments)
    {
        this.payments = payments;
    }
    
    public double calculateBalance()
    {
        double balance = this.loan.getAmountUSD();
        for(Payment payment : this.payments)
        {
            balance -= payment.getPaymentAmountUSD();
        }
        if(balance <= 0)
        {
            return 0;
        }
        else
        {
            return balance;
        }
    }
}
