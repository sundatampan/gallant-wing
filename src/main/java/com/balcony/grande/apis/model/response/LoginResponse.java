package com.balcony.grande.apis.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    private String username;

    private boolean enable;

    private Long createdAt;
    
    private String createdBy;
    
    private Long updatedAt;
    
    private String updatedBy;
    
    private Long lastLoginAt;
}
