package com.balcony.grande.apis.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private UUID id;
    
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @ColumnDefault("true")
    @Column(name = "enabled")
    private Boolean enabled = true;
    
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;
    
    @Size(max = 100)
    @Column(name = "created_by", length = 100)
    private String createdBy;
    
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private Instant updatedAt;
    
    @Size(max = 100)
    @Column(name = "updated_by", length = 100)
    private String updatedBy;
    
    @Column(name = "last_login_at")
    private Instant lastLoginAt;
    
    @Size(max = 20)
    @Column(name = "role", length = 20)
    private String role;
    
}