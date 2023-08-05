package com.akiyaaa.myBookServer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "member")
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String firstName;
    
    @Column(nullable = false)
    private String lastName;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(unique = true, nullable = false, length = 13)
    private String phone;
    
    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private User user;
}
