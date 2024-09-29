package com.xbrlconverter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data

public class LoginResponse {
    private String token;
    private long expiresIn;
}
