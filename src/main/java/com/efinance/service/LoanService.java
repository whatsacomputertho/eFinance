package com.efinance.service;

import com.efinance.model.Loan;
import com.efinance.repository.LoanRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService
{
    @Autowired
    LoanRepository loanRepository;
    
    public List<Loan> listAll()
    {
        return this.loanRepository.findAll();
    }
    
    public void save(Loan loan)
    {
        this.loanRepository.save(loan);
    }
    
    public Loan get(Integer id)
    {
        return this.loanRepository.findById(id).get();
    }
    
    public void delete(Integer id)
    {
        this.loanRepository.deleteById(id);
    }
}
