package com.example.natv.repository;

import com.example.natv.models.entities.Text;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextRepo extends JpaRepository<Text, Long> {
    Text findById(long id);
}
