package com.efinance.repository;

import com.efinance.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Integer>
{
    
}
