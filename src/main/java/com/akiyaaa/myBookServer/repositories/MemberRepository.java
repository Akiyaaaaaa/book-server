package com.akiyaaa.myBookServer.repositories;

import com.akiyaaa.myBookServer.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    public Boolean findByEmail(String email);
    public Boolean findByPhone(String phone);
}
