package com.balcony.grande.apis.service;

import com.balcony.grande.apis.model.request.LoginRequest;
import com.balcony.grande.apis.model.request.UserProfileRequest;
import com.balcony.grande.apis.model.response.LoginResponse;

public interface UserServices {
    LoginResponse login(LoginRequest loginRequest);
    void addUserProfile(UserProfileRequest userProfileRequest);
    
}
