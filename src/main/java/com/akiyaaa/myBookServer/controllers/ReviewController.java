package com.akiyaaa.myBookServer.controllers;

import com.akiyaaa.myBookServer.models.Review;
import com.akiyaaa.myBookServer.models.dto.requests.ReviewRequest;
import com.akiyaaa.myBookServer.services.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@AllArgsConstructor
public class ReviewController {
    private ReviewService reviewService;
    
    @GetMapping
    public List<Review> getAll(){
        return reviewService.getAll();
    }
    
    @GetMapping("/{id}")
    public Review getById(@PathVariable Long id){
        return reviewService.getById(id);
    }
    
    @PostMapping
    public Review create(@RequestBody ReviewRequest reviewRequest){
        return reviewService.create(reviewRequest);
    }
    
    @PutMapping("/{id}")
    public Review update(@RequestBody ReviewRequest reviewRequest, @PathVariable Long id){
        return reviewService.update(reviewRequest, id);
    }
    
    @DeleteMapping("/{id}")
    public Review delete(@PathVariable Long id){
        return reviewService.delete(id);
    }
}
