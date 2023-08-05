package com.akiyaaa.myBookServer.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "book_title", nullable = false)
    private String title;
    
    @Column(name = "release_date",nullable = false)
    private Date releaseDate;
    
    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;
    
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "book_genre", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;
    
    @OneToMany(mappedBy = "book")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Review> review;
    
    @OneToMany(mappedBy = "book")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Favorite> favorites;
    
}
