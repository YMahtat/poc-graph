package com.cgi.mpw.pocgraph;

import com.cgi.mpw.pocgraph.configurations.AuthProperties;
import com.cgi.mpw.pocgraph.configurations.GraphApiEndPointProperties;
import com.cgi.mpw.pocgraph.entities.GraphUser;
import com.cgi.mpw.pocgraph.entities.MicrosoftToken;
import com.cgi.mpw.pocgraph.entities.OutlookMessage;
import com.cgi.mpw.pocgraph.security.authentication.IAuthentificationManager;
import com.cgi.mpw.pocgraph.services.GraphApiServiceBuilder;
import com.cgi.mpw.pocgraph.utilities.GraphApiUtilityBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PocGraphApplication {



    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PocGraphApplication.class, args);

    }

}