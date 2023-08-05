package com.akiyaaa.myBookServer.services;

import com.akiyaaa.myBookServer.models.Member;
import com.akiyaaa.myBookServer.models.User;
import com.akiyaaa.myBookServer.models.dto.requests.UserRequest;
import com.akiyaaa.myBookServer.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    
    public List<User> getAll(){
        return userRepository.findAll();
    }
    
    public User getById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }
    
    public User create(UserRequest userRequest){
        User user = modelMapper.map(userRequest, User.class);
        Member member = modelMapper.map(userRequest, Member.class);
        user.setMember(member);
        member.setUser(user);
        return userRepository.save(user);
    }
    
    public User update(UserRequest userRequest, Long id){
        getById(id);
        User user = modelMapper.map(userRequest, User.class);
        Member member = modelMapper.map(userRequest, Member.class);
        user.setId(id);
        member.setUser(user);
        user.setMember(member);
        return userRepository.save(user);
    }
    
    public User delete(Long id){
        User user = getById(id);
        userRepository.delete(user);
        return user;
    }
}
