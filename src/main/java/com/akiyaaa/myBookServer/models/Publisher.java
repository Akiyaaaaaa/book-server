package com.akiyaaa.myBookServer.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "publisher")
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "publisher_name", nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String address;
    
    @OneToMany(mappedBy = "publisher")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Book> books;
}
