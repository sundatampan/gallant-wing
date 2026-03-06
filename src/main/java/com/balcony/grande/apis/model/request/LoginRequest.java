package com.balcony.grande.apis.model.request;

import com.balcony.grande.apis.enums.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    
    @NotBlank(message = "Email is required")
    private String username;
    
    @NotBlank(message = "Password is required")
    private String password;
    
    private Role role;
}
