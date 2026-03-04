package com.balcony.grande.apis.config;

import com.balcony.grande.apis.validation.ValidationUtil;
import com.balcony.grande.apis.validation.ValidationUtilImpl;
import jakarta.validation.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationConfig {
    
    @Bean
    public ValidationUtil validationUtil(Validator validator) {
        return new ValidationUtilImpl(validator);
    }
}
