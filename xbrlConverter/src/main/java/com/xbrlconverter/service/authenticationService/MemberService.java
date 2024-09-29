package com.xbrlconverter.service.authenticationService;


import com.xbrlconverter.entity.Member;

public interface MemberService{
    Member findMember(String username);
}
