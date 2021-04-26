package com.efinance.repository;

import com.efinance.model.Payment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaymentRepository extends JpaRepository<Payment, Integer>
{
    @Query("SELECT p FROM Payment p WHERE p.account.accountId = :id")
    List<Payment> findByAccountId(@Param("id") int id);
}