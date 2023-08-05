package com.akiyaaa.myBookServer.services;

import com.akiyaaa.myBookServer.models.Book;
import com.akiyaaa.myBookServer.models.Genre;
import com.akiyaaa.myBookServer.models.dto.requests.BookRequest;
import com.akiyaaa.myBookServer.repositories.BookRepository;
import com.akiyaaa.myBookServer.utils.ModelMapperUtil;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class BookService {
    private BookRepository bookRepository;
    private ModelMapper modelMapper;
    private AuthorService authorService;
    private GenreService genreService;
    private PublisherService publisherService;
    
    public List<Book> getAll(){
        return bookRepository.findAll();
    }
    
    public Book getById(Long id){
        return bookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
    }
    
    public Book create(BookRequest bookRequest){
        if(bookRepository.existsByTitle(bookRequest.getTitle())){
            for (Book existBook : bookRepository.findByAuthorId(bookRequest.getAuthorId())){
                if(Objects.equals(existBook.getTitle(), bookRequest.getTitle())){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book with that title and author already exist");
                }
            }
        }
        Book book = modelMapper.map(bookRequest, Book.class);
        book.setAuthor(authorService.getById(bookRequest.getAuthorId()));
        book.setPublisher(publisherService.getById(bookRequest.getPublisherId()));
        List<Genre> genres = new ArrayList<>();
        for (Long genre : bookRequest.getGenres()){
            genres.add(genreService.getById(genre));
        }
        book.setGenres(genres);
        return bookRepository.save(book);
    }
    
    public Book update(BookRequest bookRequest, Long id){
        getById(id);
        Book book = modelMapper.map(bookRequest, Book.class);
        book.setAuthor(authorService.getById(bookRequest.getAuthorId()));
        book.setPublisher(publisherService.getById(bookRequest.getPublisherId()));
        List<Genre> genres = new ArrayList<>();
        for (Long genre : bookRequest.getGenres()){
            genres.add(genreService.getById(genre));
        }
        book.setGenres(genres);
        return bookRepository.save(book);
    }
    
    public Book delete(Long id){
        Book book = getById(id);
        bookRepository.delete(book);
        return book;
    }
}
