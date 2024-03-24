package com.example.management.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class AuthenticationResponse {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    private String role;  // إضافة حقل الرول
    private Long id;  // إضافة حقل الإيدي
    private String username;  // إضافة حقل اسم المستخدم


    public static AuthenticationResponseBuilder builder() {
        return new AuthenticationResponseBuilder();
    }

    public AuthenticationResponse(String accessToken, String refreshToken, String role,Long id,
                                  String username) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.role = role;
        this.id = id;
        this.username = username;

    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
