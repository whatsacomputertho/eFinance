package com.efinance.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="payment")
public class Payment
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="paymentid", nullable=false)
    private Integer paymentId;
    
    @ManyToOne
    @JoinColumn(name="accountid", nullable=false)
    private PaymentAccount account;
    
    @Column(name="paymentdate")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    
    @Column(name="paymentamountusd", nullable=false)
    private double paymentAmountUSD;
    
    public void Payment(){}

    public Integer getPaymentId()
    {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId)
    {
        this.paymentId = paymentId;
    }

    public PaymentAccount getAccount()
    {
        return account;
    }

    public void setAccount(PaymentAccount account)
    {
        this.account = account;
    }

    public Date getPaymentDate()
    {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate)
    {
        this.paymentDate = paymentDate;
    }

    public double getPaymentAmountUSD()
    {
        return paymentAmountUSD;
    }

    public void setPaymentAmountUSD(double paymentAmountUSD)
    {
        this.paymentAmountUSD = paymentAmountUSD;
    }
}
