package com.balcony.grande.apis.model.response;

import com.balcony.grande.apis.model.request.LoginRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileResponse {
    private Integer id;
    
    private String userId;
    
    private String firstName;
    
    private String lastName;
    
    private String email;
    
    private String phone;
    
    private String address;
    
    private String district;
    
    private String subdistrict;
    
    private String province;
    
    private String residentialStatus;
    
    private String createdAt;
    
    private String createdBy;
    
    private String updatedAt;
    
    private String updatedBy;
    
    private LoginRequest loginRequest;
}
