package com.akiyaaa.myBookServer.controllers;

import com.akiyaaa.myBookServer.models.User;
import com.akiyaaa.myBookServer.models.dto.requests.UserRequest;
import com.akiyaaa.myBookServer.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    
    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }
    
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }
    
    @PostMapping
    public User create(@RequestBody UserRequest userRequest){
        return userService.create(userRequest);
    }
    
    @PutMapping("/{id}")
    public User update(@RequestBody UserRequest userRequest, @PathVariable Long id){
        return userService.update(userRequest, id);
    }
    
    @DeleteMapping("/{id}")
    public User delete(@PathVariable Long id){
        return userService.delete(id);
    }
}
