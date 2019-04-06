package com.cgi.mpw.pocgraph.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AuthProperties {

    @Value("${ms-confidential.tenant.id}")
    private String tenentId;

    @Value("${ms-confidential.client.id}")
    private String clientId;

    @Value("${ms-confidential.client.secret}")
    private String clientSecret;

    @Value("${ms-confidential.user.email}")
    private String userEmail;

    @Value("${ms-confidential.user.password}")
    private String userPassword;

    @Value("${ms-confidential.grant.user}")
    private String grantUser;

    @Value("${ms-confidential.grant.application}")
    private String grantApplication;

    @Value("${ms-confidential.scope.default}")
    private String defaultScope;

    @Value("${microsoft.auth.url}")
    private String authentificationUrl;

    public String getTenentId() {
        return tenentId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getGrantUser() {
        return grantUser;
    }

    public String getGrantApplication() {
        return grantApplication;
    }

    public String getDefaultScope() {
        return defaultScope;
    }

    public String getAuthentificationUrl() {
        return authentificationUrl;
    }

    @Override
    public String toString() {
        return "AuthProperties{" +
                "tenentId='" + this.getTenentId() + '\'' +
                ", clientId='" + this.getClientId() + '\'' +
                ", clientSecret='" + this.getClientSecret() + '\'' +
                ", userEmail='" + this.getUserEmail() + '\'' +
                ", userPassword='" + this.getUserPassword() + '\'' +
                ", grantUser='" + this.getGrantUser() + '\'' +
                ", grantApplication='" + this.getGrantApplication() + '\'' +
                ", defaultScope='" + this.getDefaultScope() + '\'' +
                ", authentificationUrl='" + this.getAuthentificationUrl() + '\'' +
                '}';
    }
}
