package com.xbrlconverter.controller;


import com.xbrlconverter.constants.CommonConstants;
import com.xbrlconverter.constants.RequestMappingConstants;
import com.xbrlconverter.entity.User;
import com.xbrlconverter.model.UserResult;
import com.xbrlconverter.service.userService.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RequestMappingConstants.USERAPIVERSION)
@Tag(name = "User Operations", description = "get, create or update user details.")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = RequestMappingConstants.GETUSER, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@RequestParam("emailId") String emailId) {
        try{
            User user = userService.findByEmail(emailId);
            if (user == null) {
                return new ResponseEntity<>(new UserResult<>(user, HttpStatus.NOT_FOUND, CommonConstants.EXCEPTION), HttpStatus.NOT_FOUND);
            } else {
                return ResponseEntity.ok(new UserResult<>(user, HttpStatus.OK, CommonConstants.SUCCESS));
            }
        }catch (Exception e){
            return new ResponseEntity<>(new UserResult<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, CommonConstants.EXCEPTION), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
