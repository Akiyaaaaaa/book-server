package com.akiyaaa.myBookServer.services;

import com.akiyaaa.myBookServer.models.Author;
import com.akiyaaa.myBookServer.repositories.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {
    private AuthorRepository authorRepository;
    
    public List<Author> getAll(){
        return authorRepository.findAll();
    }
    
    public Author getById(Long id){
        return authorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found"));
    }
    
    public Author create(Author author){
        if(authorRepository.existsByFirstName(author.getFirstName()) && authorRepository.existsByLastName(author.getLastName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Author already exist");
        }
        return authorRepository.save(author);
    }
    
    public Author update(Author author, Long id){
        getById(id);
        author.setId(id);
        return authorRepository.save(author);
    }
    
    public  Author delete(Long id){
        Author author = getById(id);
        authorRepository.delete(author);
        return author;
    }
}
