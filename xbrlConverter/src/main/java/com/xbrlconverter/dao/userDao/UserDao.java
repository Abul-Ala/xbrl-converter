package com.xbrlconverter.dao.userDao;


import com.xbrlconverter.entity.User;
import com.xbrlconverter.repository.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String emailId) {
        return userRepository.findByEmail(emailId);
    }
}
