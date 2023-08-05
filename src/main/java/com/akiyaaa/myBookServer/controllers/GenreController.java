package com.akiyaaa.myBookServer.controllers;

import com.akiyaaa.myBookServer.models.Genre;
import com.akiyaaa.myBookServer.services.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
@AllArgsConstructor
public class GenreController {
    
    private GenreService genreService;
    
    @GetMapping
    public List<Genre> getAll(){
        return genreService.getAll();
    }
    
    @GetMapping("/{id}")
    public Genre getById(@PathVariable Long id){
        return genreService.getById(id);
    }
    
    @PostMapping
    public Genre create(@RequestBody Genre genre){
        return genreService.create(genre);
    }
    
    @PutMapping("/{id}")
    public Genre update(@RequestBody Genre genre, @PathVariable Long id){
        return genreService.update(genre, id);
    }
    
    @DeleteMapping("/{id}")
    public Genre delete(@PathVariable Long id){
        return genreService.delete(id);
    }
}
