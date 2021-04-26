package com.efinance.service;

import com.efinance.model.PaymentAccount;
import com.efinance.repository.PaymentAccountRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentAccountService
{
    @Autowired
    PaymentAccountRepository paymentAccountRepository;
    
    public List<PaymentAccount> listAll()
    {
        return this.paymentAccountRepository.findAll();
    }
    
    public void save(PaymentAccount account)
    {
        this.paymentAccountRepository.save(account);
    }
    
    public PaymentAccount get(Integer id)
    {
        return this.paymentAccountRepository.findById(id).get();
    }
    
    public List<PaymentAccount> getByUserId(Integer userId)
    {
        return this.paymentAccountRepository.findByUserId(userId);
    }
    
    public void delete(Integer id)
    {
        this.paymentAccountRepository.deleteById(id);
    }
}
