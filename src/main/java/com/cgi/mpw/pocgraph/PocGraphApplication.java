package com.cgi.mpw.pocgraph;

import com.cgi.mpw.pocgraph.configurations.AuthProperties;
import com.cgi.mpw.pocgraph.entities.Token;
import com.cgi.mpw.pocgraph.security.authentication.IAuthentificationManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PocGraphApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PocGraphApplication.class, args);

        AuthProperties authProperties = context.getBean(AuthProperties.class);
        System.out.println(authProperties);

        IAuthentificationManager authentificationManager = context.getBean(IAuthentificationManager.class);
        Token token = authentificationManager.getToken();
        System.out.println(token);
        System.out.println();
        System.out.println(token.getAccessToken());


    }

}