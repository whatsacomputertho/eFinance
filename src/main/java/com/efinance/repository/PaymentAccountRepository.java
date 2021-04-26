package com.efinance.repository;

import com.efinance.model.PaymentAccount;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaymentAccountRepository extends JpaRepository<PaymentAccount, Integer>
{
    @Query("SELECT p FROM PaymentAccount p WHERE p.loan.borrower.userid = :id")
    List<PaymentAccount> findByUserId(@Param("id") int id);
}