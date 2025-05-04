package com.tpt.inventory_management.repository;

import com.tpt.inventory_management.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t FROM Transaction t WHERE YEAR(t.createdAt) = :year AND MONTH(t.createdAt) = :month")
    List<Transaction> findAllByMonthAndYear(@Param("month") int month, @Param("year") int year);

    @Query("SELECT t FROM Transaction t " +
            "LEFT JOIN t.product p " +
            "WHERE :searchText IS NULL OR " +
            "LOWER(t.description) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "LOWER(t.note) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "LOWER(t.name) LIKE LOWER(CONCAT('%', :searchText, '%'))")
    List<Transaction> searchTransactions(@Param("searchText") String searchText);

    Page<Transaction> findAll(Specification<Transaction> specification, Pageable pageable);
}
