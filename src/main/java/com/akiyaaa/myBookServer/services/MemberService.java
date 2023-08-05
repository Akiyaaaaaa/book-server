package com.akiyaaa.myBookServer.services;

import com.akiyaaa.myBookServer.models.Member;
import com.akiyaaa.myBookServer.models.User;
import com.akiyaaa.myBookServer.models.dto.requests.UserRequest;
import com.akiyaaa.myBookServer.repositories.MemberRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class MemberService {
    private MemberRepository memberRepository;
    private ModelMapper modelMapper;
    
    public List<Member> getAll(){
        return memberRepository.findAll();
    }
    
    public  Member getById(Long id){
        return memberRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found"));
    }
    
    public Member create(Member member){
        if(memberRepository.findByEmail(member.getEmail())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already registered");
        }
        for (Member existedMember : getAll()){
            if (Objects.equals(existedMember.getPhone(), member.getPhone())){
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Phone Number already registered");
            }
        }
        try {
            Integer.parseInt(member.getPhone());
        }catch (ResponseStatusException responseStatusException){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Phone number is not a number");
        }
        return  memberRepository.save(member);
    }
    
    public Member update(UserRequest userRequest, Long id){
        getById(id);
        User user = modelMapper.map(userRequest, User.class);
        Member member = modelMapper.map(userRequest, Member.class);
        member.setId(id);
        user.setId(id);
        return memberRepository.saveAndFlush(member);
    }
    
    public Member delete(Long id){
        Member member = getById(id);
        memberRepository.delete(member);
        return member;
    }
}
