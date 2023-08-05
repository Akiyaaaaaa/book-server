package com.akiyaaa.myBookServer.repositories;

import com.akiyaaa.myBookServer.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    public Boolean existsByUserIdAndBookId(Long userId, Long bookId);
}
