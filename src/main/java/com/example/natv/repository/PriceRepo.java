package com.example.natv.repository;

import com.example.natv.models.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepo extends JpaRepository<Price, Long> {
    @Query(value = "select * from tb_price where channel = :id", nativeQuery = true)
    Price getPrice(Long id);
    @Query (value = "select price_per_symbol from tb_price where channel = :id ", nativeQuery = true)
    double getPricePerSymbol(Long id);

}
