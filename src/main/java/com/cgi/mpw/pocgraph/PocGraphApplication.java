package com.cgi.mpw.pocgraph;

import com.cgi.mpw.pocgraph.configurations.AuthProperties;
import com.cgi.mpw.pocgraph.security.authentication.IAuthentificationManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PocGraphApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PocGraphApplication.class, args);

        AuthProperties properties = context.getBean(AuthProperties.class);
        System.out.println(properties);

        IAuthentificationManager authentificationManager = context.getBean(IAuthentificationManager.class);
        System.out.println(authentificationManager.getAccessToken());
    }

}