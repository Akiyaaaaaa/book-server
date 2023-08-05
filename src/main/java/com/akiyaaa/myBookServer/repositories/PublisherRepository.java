package com.akiyaaa.myBookServer.repositories;

import com.akiyaaa.myBookServer.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    public Boolean existsByName(String name);
}
