package com.cgi.mpw.pocgraph.services;

import com.cgi.mpw.pocgraph.entities.OutlookMessage;
import org.springframework.http.HttpStatus;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class OutlookMessageServiceBuilder extends OutlookServiceBuilder {

    public OutlookMessageServiceBuilder(OutlookServiceBuilder parent) {
        super(parent);
    }

    public OutlookMessage getValue(){
        this.setResponseType(OutlookMessage.class);
        this.get();
        return (OutlookMessage) this.getResponse().getBody();
    }

    public boolean move(String destinationId){
        this.addAction(this.getGraphApiEndPointProperties().getMoveAction(), "");
        this.setResponseType(OutlookMessage.class);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        requestBody.add("destinationId", destinationId);
        this.setRequestParams(requestBody);
        this.post();
        return this.getResponse().getStatusCode() == HttpStatus.CREATED;
    }
}
