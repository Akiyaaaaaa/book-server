package com.akiyaaa.myBookServer.repositories;

import com.akiyaaa.myBookServer.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    public Boolean existsByFirstName(String firstName);
    public Boolean existsByLastName(String lastName);
}
