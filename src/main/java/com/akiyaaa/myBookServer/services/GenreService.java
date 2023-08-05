package com.akiyaaa.myBookServer.services;

import com.akiyaaa.myBookServer.models.Genre;
import com.akiyaaa.myBookServer.repositories.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreService {
    private GenreRepository genreRepository;
    
    public List<Genre> getAll(){
        return genreRepository.findAll();
    }
    
    public Genre getById(Long id){
        return genreRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Genre not found"));
    }
    
    public Genre create(Genre genre){
        if(genreRepository.existsByName(genre.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Genre already exists");
        }
        return genreRepository.save(genre);
    }
    
    public Genre update(Genre genre, Long id){
        getById(id);
        genre.setId(id);
        return genreRepository.save(genre);
    }
    
    public Genre delete(Long id){
        Genre genre = getById(id);
        genreRepository.delete(genre);
        return genre;
    }
}
