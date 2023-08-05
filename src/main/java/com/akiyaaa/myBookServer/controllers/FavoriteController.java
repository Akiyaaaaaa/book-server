package com.akiyaaa.myBookServer.controllers;

import com.akiyaaa.myBookServer.models.Favorite;
import com.akiyaaa.myBookServer.models.dto.requests.FavoriteRequest;
import com.akiyaaa.myBookServer.services.FavoriteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorite")
@AllArgsConstructor
public class FavoriteController {
    private FavoriteService favoriteService;
    
    @GetMapping
    public List<Favorite> getAll(){
        return favoriteService.getAll();
    }
    
    @GetMapping("/{id}")
    public Favorite getById(@PathVariable Long id){
        return favoriteService.getById(id);
    }
    
    @GetMapping("/user/{id}")
    public List<Favorite> getAllByUserId(@PathVariable Long id){
        return favoriteService.getAllByUserId(id);
    }
    
    @PostMapping
    public Favorite create(@RequestBody FavoriteRequest favoriteRequest){
        return favoriteService.create(favoriteRequest);
    }
    
    @DeleteMapping("/{id}")
    public Favorite delete(@PathVariable Long id){
        return favoriteService.delete(id);
    }
}
