package com.balcony.grande.apis.service.impl;

import com.balcony.grande.apis.config.BCrypt;
import com.balcony.grande.apis.entity.User;
import com.balcony.grande.apis.entity.UserProfile;
import com.balcony.grande.apis.model.request.LoginRequest;
import com.balcony.grande.apis.model.request.UserProfileRequest;
import com.balcony.grande.apis.model.response.LoginResponse;
import com.balcony.grande.apis.repository.UserProfileRepository;
import com.balcony.grande.apis.repository.UserRepository;
import com.balcony.grande.apis.service.UserServices;
import com.balcony.grande.apis.validation.ValidationUtil;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserServices {
    
    private final UserRepository userRepository;
    
    private final UserProfileRepository userProfileRepository;
    
    private final ValidationUtil validator;
    
    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        validator.validate(loginRequest);
        
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "Invalid username or password"));
        if(!BCrypt.checkpw(loginRequest.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
        }
        
        user.setLastLoginAt(Instant.now());
        userRepository.save(user);
        
        return LoginResponse.builder().username(user.getUsername()).enable(user.getEnabled()).lastLoginAt(user.getLastLoginAt().toEpochMilli()).build();
    }
    
    @Override
    public void addUserProfile(UserProfileRequest userProfileRequest) {
        
        validator.validate(userProfileRequest);
        
        User user = new User();
        user.setUsername(userProfileRequest.getLoginRequest().getUsername());
        user.setPassword(BCrypt.hashpw(userProfileRequest.getLoginRequest().getPassword(), BCrypt.gensalt()));
        user.setRole(userProfileRequest.getLoginRequest().getRole().toString());
        user.setEnabled(true);
        user.setCreatedAt(Instant.now());
        userRepository.save(user);
        
        UserProfile userProfile = new UserProfile();
        userProfile.setUserId(user.getId());
        userProfile.setFirstName(userProfileRequest.getFirstName());
        userProfile.setLastName(userProfileRequest.getLastName());
        userProfile.setEmail(userProfileRequest.getEmail());
        userProfile.setPhone(userProfileRequest.getPhone());
        userProfile.setAddress(userProfileRequest.getAddress());
        userProfile.setDistrict(userProfileRequest.getDistrict());
        userProfile.setSubdistrict(userProfileRequest.getSubdistrict());
        userProfile.setProvince(userProfileRequest.getProvince());
        userProfile.setResidentialStatus(userProfileRequest.getResidentialStatus().toString());
        userProfile.setCreatedAt(Instant.now());
        userProfile.setCreatedBy("Super Admin");
        userProfileRepository.save(userProfile);
    }
}
