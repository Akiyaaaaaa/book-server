package com.akiyaaa.myBookServer.repositories;

import com.akiyaaa.myBookServer.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Boolean findByUsername(String username);
}
