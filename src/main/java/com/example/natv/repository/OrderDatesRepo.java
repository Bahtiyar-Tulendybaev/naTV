package com.example.natv.repository;

import com.example.natv.models.entities.OrderDates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDatesRepo extends JpaRepository<OrderDates, Long> {
}
