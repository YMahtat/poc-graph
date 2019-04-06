package com.cgi.mpw.pocgraph.security.authentication;


import com.cgi.mpw.pocgraph.entities.Token;

public interface IAuthentificationManager {
    public Token getAccessToken();
}
