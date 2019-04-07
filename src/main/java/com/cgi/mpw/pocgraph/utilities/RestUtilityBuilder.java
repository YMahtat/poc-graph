package com.cgi.mpw.pocgraph.utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
@Scope("prototype")
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
        try {
            HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestParams, headers);
            return restTemplate.postForEntity(this.url, entity, this.responseType);
        } catch (HttpClientErrorException ex) {
            System.out.println(ex.getResponseBodyAsString());
            return null;
        }
    }

    public ResponseEntity postJson(){
        try {
            Gson objGson = new GsonBuilder().setPrettyPrinting().create();
            String requestJson = objGson.toJson(requestParams.toSingleValueMap());
            HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
            return restTemplate.postForEntity(this.url, entity, this.responseType);
        } catch (HttpClientErrorException ex) {
            System.out.println(ex.getResponseBodyAsString());
            return null;
        }
    }

    public ResponseEntity get(){
        try {
            HttpEntity entity = new HttpEntity(headers);
            return restTemplate.exchange(this.url, HttpMethod.GET, entity, this.responseType);
        } catch (HttpClientErrorException ex) {
            System.out.println(ex.getResponseBodyAsString());
            return null;
        }
    }
}
