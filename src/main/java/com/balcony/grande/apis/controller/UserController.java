package com.balcony.grande.apis.controller;

import com.balcony.grande.apis.model.request.LoginRequest;
import com.balcony.grande.apis.model.request.UserProfileRequest;
import com.balcony.grande.apis.model.response.LoginResponse;
import com.balcony.grande.apis.model.response.WebResponse;
import com.balcony.grande.apis.service.UserServices;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    
    private final UserServices userServices;
    
    @PostMapping("/login")
    public WebResponse login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        LoginResponse loginResponse = userServices.login(loginRequest);
        return WebResponse.<LoginResponse>builder().code(HttpStatus.OK.value()).status(HttpStatus.OK.name()).data(loginResponse)
                .build();
    }
    @PostMapping("/add")
    public WebResponse addUser(@RequestBody UserProfileRequest userProfileRequest) {
        userServices.addUserProfile(userProfileRequest);
        return WebResponse.<Void>builder().code(HttpStatus.OK.value()).status(HttpStatus.OK.name()).build();
    }
}
