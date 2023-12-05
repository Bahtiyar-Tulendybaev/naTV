package com.example.natv.repository;

import com.example.natv.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query(value = "select * from tb_user where id =:id",
            nativeQuery = true)
    User findById(long id);
}
