package com.cgi.mpw.pocgraph.utilities;

import com.cgi.mpw.pocgraph.configurations.GraphApiEndPointProperties;
import com.cgi.mpw.pocgraph.entities.Token;
import com.cgi.mpw.pocgraph.security.authentication.IAuthentificationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

@Component
public class GraphApiUtilityBuilder {

    private HttpHeaders headers;
    private String endPoint;

    final RestUtilityBuilder restUtilityBuilder;
    final IAuthentificationManager authentificationManager;
    final GraphApiEndPointProperties graphApiEndPointProperties;

    @Autowired
    public GraphApiUtilityBuilder(RestUtilityBuilder restUtilityBuilder, IAuthentificationManager authentificationManager, GraphApiEndPointProperties graphApiEndPointProperties) {
        this.restUtilityBuilder = restUtilityBuilder;
        this.authentificationManager = authentificationManager;
        this.graphApiEndPointProperties = graphApiEndPointProperties;
        endPoint = graphApiEndPointProperties.getUrl();
        headers = new HttpHeaders();
        Token token = authentificationManager.getToken();
        headers.set("Authorization", token.getTokenType() + " " + token.getAccessToken());
    }

    public ResponseEntity get(String requestAction, Class responseType){
        return  restUtilityBuilder.addUrl(endPoint+requestAction)
                .addHeaders(headers)
                .addResponseType(responseType)
                .get();
    }

    public ResponseEntity post(String requestAction, MultiValueMap<String, String> requestParams, Class responseType){
        headers.setContentType(MediaType.APPLICATION_JSON);
        return  restUtilityBuilder.addUrl(endPoint+requestAction)
                .addHeaders(headers)
                .addParametersBody(requestParams)
                .addResponseType(responseType)
                .post();
    }
}
