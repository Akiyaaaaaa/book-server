package com.akiyaaa.myBookServer.services;

import com.akiyaaa.myBookServer.models.Review;
import com.akiyaaa.myBookServer.models.dto.requests.ReviewRequest;
import com.akiyaaa.myBookServer.repositories.ReviewRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {
    private ReviewRepository reviewRepository;
    private ModelMapper modelMapper;
    private BookService bookService;
    private UserService userService;
    
    public List<Review> getAll(){
        return reviewRepository.findAll();
    }
    
    public Review getById(Long id){
        return reviewRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found")
        );
    }
    
    public Review create(ReviewRequest reviewRequest){
        if(reviewRepository.existsByUserIdAndBookId(reviewRequest.getUserId(), reviewRequest.getBookId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "your review has been add for this book");
        }
        
        Review review = modelMapper.map(reviewRequest, Review.class);
        review.setBook(bookService.getById(reviewRequest.getBookId()));
        review.setUser(userService.getById(reviewRequest.getUserId()));
        return reviewRepository.save(review);
    }
    
    public Review update(ReviewRequest reviewRequest, Long id){
        getById(id);
        Review review = modelMapper.map(reviewRequest, Review.class);
        review.setBook(bookService.getById(reviewRequest.getBookId()));
        review.setUser(userService.getById(reviewRequest.getUserId()));
        return reviewRepository.save(review);
    }
    
    public Review delete(Long id){
        Review review = getById(id);
        reviewRepository.delete(review);
        return review;
    }
}
