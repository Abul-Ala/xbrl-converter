package com.xbrlconverter.controller;



import com.xbrlconverter.constants.CommonConstants;
import com.xbrlconverter.constants.MessageConstant;
import com.xbrlconverter.constants.RequestMappingConstants;
import com.xbrlconverter.dto.JwtRequest;
import com.xbrlconverter.dto.LoginResponse;
import com.xbrlconverter.dto.RegisterUserDto;
import com.xbrlconverter.entity.Member;
import com.xbrlconverter.helper.JwtService;
import com.xbrlconverter.model.UserResult;
import com.xbrlconverter.service.authenticationService.MemberService;
import com.xbrlconverter.serviceImpl.authenticationServiceImpl.AuthenticationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(RequestMappingConstants.AUTHAPIVERSION)
@Tag(name = "User authentication", description = "validate, create or update user.")
public class AuthenticationController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private MemberService memberService;



    @RequestMapping(value = RequestMappingConstants.SIGNUP, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody RegisterUserDto registerUserDto) throws SQLIntegrityConstraintViolationException {
        try {
            Member exist = memberService.findMember(registerUserDto.getEmail());
            if(exist != null){
                return new ResponseEntity<>(new UserResult<>(MessageConstant.USER_EXIST, HttpStatus.CONFLICT, CommonConstants.EXCEPTION), HttpStatus.CONFLICT);
            }
            Member registeredUser = authenticationService.signup(registerUserDto);
            return ResponseEntity.ok(new UserResult<>(registeredUser, HttpStatus.OK, CommonConstants.SUCCESS));
        } catch (Exception e) {
            return new ResponseEntity<>(new UserResult<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, CommonConstants.EXCEPTION), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = RequestMappingConstants.GETTOKEN, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody JwtRequest jwtRequest) {
        try {
            Member exist = memberService.findMember(jwtRequest.getUsername());
            if(exist == null){
                return new ResponseEntity<>(new UserResult<>(MessageConstant.USER_NOT_FOUND, HttpStatus.NOT_FOUND, CommonConstants.EXCEPTION), HttpStatus.NOT_FOUND);
            }
            Member authenticatedUser = authenticationService.authenticate(jwtRequest);
            String jwtToken = jwtService.generateToken(authenticatedUser);
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setToken(jwtToken);
            loginResponse.setExpiresIn(jwtService.getExpirationTime());
            return ResponseEntity.ok(new UserResult<>(loginResponse, HttpStatus.OK, CommonConstants.SUCCESS));
        } catch (Exception e) {
            return new ResponseEntity<>(new UserResult<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, CommonConstants.EXCEPTION), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}
