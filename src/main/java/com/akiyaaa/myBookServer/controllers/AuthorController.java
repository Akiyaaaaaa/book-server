package com.akiyaaa.myBookServer.controllers;

import com.akiyaaa.myBookServer.models.Author;
import com.akiyaaa.myBookServer.services.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@AllArgsConstructor
public class AuthorController {
    
    private AuthorService authorService;
    
    @GetMapping
    public List<Author> getAll(){
        return authorService.getAll();
    }
    
    @GetMapping("/{id}")
    public Author getById(@PathVariable Long id){
        return authorService.getById(id);
    }
    
    @PostMapping
    public Author create(@RequestBody Author author){
        return authorService.create(author);
    }
    
    @PutMapping("/{id}")
    public Author update(@RequestBody Author author, @PathVariable Long id){
        return authorService.update(author, id);
    }
    
    @DeleteMapping("/{id}")
    public Author delete(@PathVariable Long id){
        return authorService.delete(id);
    }
}
