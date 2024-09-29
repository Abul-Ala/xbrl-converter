package com.xbrlconverter.serviceImpl.authenticationServiceImpl;


import com.xbrlconverter.dto.JwtRequest;
import com.xbrlconverter.dto.RegisterUserDto;
import com.xbrlconverter.entity.Member;
import com.xbrlconverter.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;


    public Member signup(RegisterUserDto input) {
        Member member = new Member();
        member.setUsername(input.getFullName());
        member.setEmail(input.getEmail());
        member.setPassword(passwordEncoder.encode(input.getPassword()));
        return memberRepository.save(member);
    }

    public Member authenticate(JwtRequest input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        return memberRepository.findByEmail(input.getUsername())
                .orElseThrow();
    }

    public boolean existByEmail(JwtRequest input) {
        Optional<Member> member = memberRepository.findByEmail(input.getUsername());
        if (member.isPresent()) {
            return true;
        } else {
            return false;
        }
    }
}
