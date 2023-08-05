package com.akiyaaa.myBookServer.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "genre")
@AllArgsConstructor
@NoArgsConstructor
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "genre_name", nullable = false)
    private String name;
    
    @ManyToMany(mappedBy = "genres")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Book> books;
}
