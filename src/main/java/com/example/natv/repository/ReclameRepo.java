package com.example.natv.repository;

import com.example.natv.models.entities.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclameRepo extends JpaRepository<Banner, Long> {
}
