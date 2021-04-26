package com.efinance.service;

import com.efinance.model.Payment;
import com.efinance.repository.PaymentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService
{
    @Autowired
    PaymentRepository paymentRepository;
    
    public List<Payment> listAll()
    {
        return this.paymentRepository.findAll();
    }
    
    public void save(Payment payment)
    {
        this.paymentRepository.save(payment);
    }
    
    public Payment get(Integer id)
    {
        return this.paymentRepository.findById(id).get();
    }
    
    public List<Payment> getByAccountId(Integer accountId)
    {
        return this.paymentRepository.findByAccountId(accountId);
    }
    
    public void delete(Integer id)
    {
        this.paymentRepository.deleteById(id);
    }
}
