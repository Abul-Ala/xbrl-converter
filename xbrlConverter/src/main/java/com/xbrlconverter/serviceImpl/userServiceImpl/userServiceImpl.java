package com.xbrlconverter.serviceImpl.userServiceImpl;


import com.xbrlconverter.dao.userDao.UserDao;
import com.xbrlconverter.entity.User;
import com.xbrlconverter.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByEmail(String emailId) {
        return userDao.findByEmail(emailId);
    }
}
