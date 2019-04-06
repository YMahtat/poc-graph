package com.cgi.mpw.pocgraph.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Token {

    @JsonProperty("token_type") private String tokenType;
    @JsonProperty("expires_in") private String expiresIn;
    @JsonProperty("access_token") private String accessToken;
    private LocalDateTime dateTimeExpiration;

    public Token() {
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
        dateTimeExpiration = LocalDateTime.now().plusSeconds(Long.parseLong(this.expiresIn));
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public LocalDateTime getTimeExpiration() {
        return dateTimeExpiration;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tokenType='" + tokenType + '\'' +
                ", expiresIn='" + expiresIn + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", dateTimeExpiration=" + dateTimeExpiration +
                '}';
    }
}
