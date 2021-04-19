package com.efinance.repository;

import com.efinance.model.Loan;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoanRepository extends JpaRepository<Loan, Integer>
{
    @Query("SELECT l FROM Loan l WHERE l.borrower.userid = :id")
    List<Loan> findByUserId(@Param("id") int id);
}
