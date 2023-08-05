package com.akiyaaa.myBookServer.controllers;

import com.akiyaaa.myBookServer.models.Publisher;
import com.akiyaaa.myBookServer.services.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
@AllArgsConstructor
public class PublisherController {
    
    private PublisherService publisherService;
    
    @GetMapping
    public List<Publisher> getAll(){
        return publisherService.getAll();
    }
    
    @GetMapping("/{id}")
    public Publisher getById(@PathVariable Long id){
        return publisherService.getById(id);
    }
    
    @PostMapping
    public Publisher create(@RequestBody Publisher publisher){
        return publisherService.create(publisher);
    }
    
    @PutMapping("/{id}")
    public Publisher update(@RequestBody Publisher publisher, @PathVariable Long id){
        return publisherService.update(publisher, id);
    }
    
    @DeleteMapping("/{id}")
    public Publisher delete(@PathVariable Long id){
        return publisherService.delete(id);
    }
}
