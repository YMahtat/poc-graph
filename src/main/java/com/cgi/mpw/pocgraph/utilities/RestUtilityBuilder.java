package com.cgi.mpw.pocgraph.utilities;

import com.cgi.mpw.pocgraph.entities.Token;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class RestUtilityBuilder {

    private RestTemplate restTemplate;
    private String url;
    private HttpHeaders headers;
    private MultiValueMap<String, String> requestParams;
    private Class responseType;

    public RestUtilityBuilder() {
        restTemplate = new RestTemplate();
    }

    public RestUtilityBuilder addUrl(String url){
        this.url = url;
        return this;
    }

    public RestUtilityBuilder addHeaders(HttpHeaders headers){
        this.headers = headers;
        return this;
    }

    public RestUtilityBuilder addParametersBody(MultiValueMap<String, String> requestParams){
        this.requestParams= requestParams;
        return this;
    }

    public RestUtilityBuilder addResponseType(Class responseType){
        this.responseType = responseType;
        return this;
    }


    public ResponseEntity post(){
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestParams, headers);
        ResponseEntity<Token> response = restTemplate.postForEntity(this.url, entity, this.responseType);
        return response;
    }

    public ResponseEntity get(){
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<Token> response = restTemplate.exchange(this.url, HttpMethod.GET, entity, this.responseType);
        return response;
    }
}
