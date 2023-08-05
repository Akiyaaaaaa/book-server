package com.akiyaaa.myBookServer.services;

import com.akiyaaa.myBookServer.models.Publisher;
import com.akiyaaa.myBookServer.repositories.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class PublisherService {
    private PublisherRepository publisherRepository;
    
    public List<Publisher> getAll(){
        return publisherRepository.findAll();
    }
    
    public Publisher getById(Long id){
        return publisherRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Publisher not found"));
    }
    
    public Publisher create(Publisher publisher){
        if(publisherRepository.existsByName(publisher.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Publisher already exist");
        }
        return publisherRepository.save(publisher);
    }
    
    public Publisher update(Publisher publisher, Long id){
        getById(id);
        publisher.setId(id);
        return publisherRepository.save(publisher);
    }
    
    public Publisher delete(Long id){
        Publisher publisher = getById(id);
        publisherRepository.delete(publisher);
        return  publisher;
    }
}
