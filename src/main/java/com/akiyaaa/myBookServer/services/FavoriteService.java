package com.akiyaaa.myBookServer.services;

import com.akiyaaa.myBookServer.models.Favorite;
import com.akiyaaa.myBookServer.models.dto.requests.FavoriteRequest;
import com.akiyaaa.myBookServer.repositories.FavoriteRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class FavoriteService {
    private FavoriteRepository favoriteRepository;
    private ModelMapper modelMapper;
    private BookService bookService;
    private UserService userService;
    
    public List<Favorite> getAll(){
        return favoriteRepository.findAll();
    }
    
    public Favorite getById(Long id){
        return favoriteRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Favorite Not found")
        );
    }
    
    public List<Favorite> getAllByUserId(Long id){
        if(id == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User id must not be null");
        }
        return favoriteRepository.findAllByUserId(id);
    }
    
    public Favorite create(FavoriteRequest favoriteRequest){
        Long bookId = favoriteRequest.getBookId();
        Long userId = favoriteRequest.getUserId();
        
        if(favoriteRepository.existsByBookIdAndUserId(bookId, userId)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book is already in favorites");
        }
        
        Favorite favorite = modelMapper.map(favoriteRequest, Favorite.class);
        favorite.setBook(bookService.getById(favoriteRequest.getBookId()));
        favorite.setUser(userService.getById(favoriteRequest.getUserId()));
        return favoriteRepository.save(favorite);
    }
    
    public Favorite delete(Long id){
        Favorite favorite = getById(id);
        favoriteRepository.delete(favorite);
        return favorite;
    }
}
