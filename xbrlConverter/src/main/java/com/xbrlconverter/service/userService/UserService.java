package com.xbrlconverter.service.userService;


import com.xbrlconverter.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    User findByEmail(String emailId);
}
