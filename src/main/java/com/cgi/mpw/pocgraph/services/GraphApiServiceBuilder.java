package com.cgi.mpw.pocgraph.services;

import com.cgi.mpw.pocgraph.configurations.GraphApiEndPointProperties;
import com.cgi.mpw.pocgraph.entities.GraphApiAction;
import com.cgi.mpw.pocgraph.entities.GraphApiPagedResult;
import com.cgi.mpw.pocgraph.entities.GraphUser;
import com.cgi.mpw.pocgraph.utilities.GraphApiUtilityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Scope("prototype")
public class GraphApiServiceBuilder {
    protected List<GraphApiAction> actionsRequestList;
    protected MultiValueMap<String, String> requestParams;
    protected ResponseEntity response;
    protected Class responseType;

    @Autowired private GraphApiEndPointProperties graphApiEndPointProperties;
    @Autowired private GraphApiUtilityBuilder graphApiUtilityBuilder;

    public GraphApiServiceBuilder()  {
        actionsRequestList = new ArrayList<>();
    }

    public GraphApiServiceBuilder(GraphApiServiceBuilder from) {
        this.actionsRequestList = from.actionsRequestList;
        this.requestParams = from.requestParams;
        this.response = from.response;
        this.responseType = from.responseType;
        this.graphApiUtilityBuilder = from.graphApiUtilityBuilder;
        this.graphApiEndPointProperties = from.graphApiEndPointProperties;
    }


    public GraphApiEndPointProperties getGraphApiEndPointProperties() {
        return graphApiEndPointProperties;
    }

    public GraphApiUtilityBuilder getGraphApiUtilityBuilder() {
        return graphApiUtilityBuilder;
    }

    public List<GraphApiAction> getActionsRequestList() {
        return actionsRequestList;
    }

    public GraphApiServiceBuilder addAction(String action, String parameter) {
        this.actionsRequestList.add(new GraphApiAction(action, parameter));
        return this;
    }

    public Class getResponseType() {
        return responseType;
    }

    public GraphApiServiceBuilder setResponseType(Class responseType) {
        this.responseType = responseType;
        return this;
    }

    public ResponseEntity getResponse() {
        return response;
    }

    public String getActionsRequestUri(){
        AtomicReference<String> action = new AtomicReference<>("");
        actionsRequestList.forEach(a -> { action.updateAndGet(v -> v + a);});
        return action.get();
    }



    public MultiValueMap<String, String> getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(MultiValueMap<String, String> requestParams) {
        this.requestParams = requestParams;
    }

    public OutlookServiceBuilder outlook(){
        return new OutlookServiceBuilder(this);
    }

    public GraphApiServiceBuilder users(){
        this.addAction(this.graphApiEndPointProperties.getUsersAction(), "");
        this.setResponseType(GraphApiPagedResult.class);
        return this;
    }

    public GraphApiServiceBuilder me(){
        this.addAction(this.graphApiEndPointProperties.getCurrentUserAction(), "");
        this.setResponseType(GraphUser.class);
        return this;
    }

    public GraphApiServiceBuilder user(String id){
        this.addAction(this.graphApiEndPointProperties.getUsersAction(), "/"+id);
        this.setResponseType(GraphUser.class);
        return this;
    }

    public GraphApiServiceBuilder get(){
        response = graphApiUtilityBuilder.get(this.getActionsRequestUri(), this.responseType);
        return this;
    }

    protected GraphApiServiceBuilder post(){
        response = graphApiUtilityBuilder.post(this.getActionsRequestUri(), this.requestParams, this.responseType);
        return this;
    }

}
