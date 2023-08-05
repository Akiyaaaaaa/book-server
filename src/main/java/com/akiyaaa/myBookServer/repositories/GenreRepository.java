package com.akiyaaa.myBookServer.repositories;

import com.akiyaaa.myBookServer.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    public Boolean existsByName(String name);
}
