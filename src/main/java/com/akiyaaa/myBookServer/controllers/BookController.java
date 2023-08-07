package com.akiyaaa.myBookServer.controllers;

import com.akiyaaa.myBookServer.models.Book;
import com.akiyaaa.myBookServer.models.dto.requests.BookRequest;
import com.akiyaaa.myBookServer.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {
    private BookService bookService;
    
    @GetMapping
    public List<Book> getAll(){
        return bookService.getAll();
    }
    
    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id){
        return bookService.getById(id);
    }
    
    @GetMapping("/author/{authorName}")
    public List<Book> getByAuthor(@PathVariable String authorName){
        return bookService.getByAuthor(authorName);
    }
    
    @GetMapping("/publisher/{publisher}")
    public List<Book> getByPublisher(@PathVariable String publisher) {
        return bookService.getByPublisher(publisher);
    }
    
    @GetMapping("/genre/{genre}")
    public List<Book> getByGenre(@PathVariable String genre){
        return bookService.getByGenre(genre);
    }
    
    @PostMapping
    public Book create(@RequestBody BookRequest bookRequest){
        return bookService.create(bookRequest);
    }
    
    @PutMapping("/{id}")
    public Book update(@RequestBody BookRequest bookRequest, @PathVariable Long id){
        return bookService.update(bookRequest, id);
    }
    
    @DeleteMapping("/{id}")
    public Book delete(@PathVariable Long id){
        return bookService.delete(id);
    }
}
