package com.cgi.mpw.pocgraph.security.authentication;


import com.cgi.mpw.pocgraph.entities.MicrosoftToken;

public interface IAuthentificationManager {
    public MicrosoftToken getToken();
}
