package com.akiyaaa.myBookServer.repositories;

import com.akiyaaa.myBookServer.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    public Boolean existsByTitle(String title);
    
    List<Book> findByReleaseDate(Date releaseDate);
    
    List<Book> findByAuthorId(Long author);
    
    @Query(value = "SELECT * FROM book a JOIN author b ON a.author_id = b.id WHERE b.first_name = :authorName OR b.last_name = :authorName OR CONCAT(b.first_name + ' ' + b.last_name) LIKE :authorName", nativeQuery = true)
    List<Book> findByAuthor(@Param("authorName") String authorName);
    
    @Query(value = "SELECT * FROM book a JOIN publisher b ON a.publisher_id = b.id WHERE b.publisher_name = :publisherName", nativeQuery = true)
    List<Book> findByPublisher(@Param("publisherName") String publisherName);
    
    @Query(value = "SELECT * FROM book b JOIN book_genre bg ON b.id = bg.book_id JOIN genre g ON bg.genre_id = g.id WHERE g.genre_name = :genreName", nativeQuery = true)
    List<Book> findByGenreName(@Param("genreName") String genreName);
}
