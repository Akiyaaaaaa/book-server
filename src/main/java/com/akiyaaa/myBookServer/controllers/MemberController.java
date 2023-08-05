package com.akiyaaa.myBookServer.controllers;

import com.akiyaaa.myBookServer.models.Member;
import com.akiyaaa.myBookServer.models.dto.requests.UserRequest;
import com.akiyaaa.myBookServer.services.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;
    
    @GetMapping
    public List<Member> getAll() {
        return memberService.getAll();
    }
    
    @GetMapping("/{id}")
    public Member getById(@PathVariable Long id){
        return memberService.getById(id);
    }
    
    @PostMapping
    public Member create(@RequestBody Member member){
        return memberService.create(member);
    }
    
    @PutMapping("/{id}")
    public Member update(@RequestBody UserRequest userRequest, @PathVariable Long id){
        return  memberService.update(userRequest, id);
    }
    
    @DeleteMapping("/{id}")
    public Member delete(@PathVariable Long id){
        return memberService.delete(id);
    }
}
