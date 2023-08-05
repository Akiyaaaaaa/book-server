package com.akiyaaa.myBookServer.repositories;

import com.akiyaaa.myBookServer.models.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    public Boolean existsByBookIdAndUserId(Long bookId, Long UserId);
    
    public List<Favorite> findAllByUserId(Long userId);
}
