package com.cgi.mpw.pocgraph.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphUser {
    private String id;
    private String mail;
    private String displayName;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String emailAddress) {
        this.mail = emailAddress;
    }
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return "GraphUser{" +
                "id='" + id + '\'' +
                ", mail='" + mail + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}