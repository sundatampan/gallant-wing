package com.balcony.grande.apis.model.request;

import com.balcony.grande.apis.enums.ResidentialStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileRequest {
    
    @NotBlank(message = "User id is required")
    private String userId;
    
    @NotBlank(message = "First name is required")
    private String firstName;
    
    @NotBlank(message = "Last name is required")
    private String lastName;
    
    @Email(message = "Email is invalid")
    private String email;
    
    @NotBlank(message = "Phone is required")
    private String phone;
    
    private String address;
    
    private String district;
    
    private String subdistrict;
    
    private String province;
    
    private ResidentialStatus residentialStatus;
    
    private Long createdAt;
    
    private String createdBy;
    
    private Long updatedAt;
    
    private String updatedBy;
    
    private LoginRequest loginRequest;
}
