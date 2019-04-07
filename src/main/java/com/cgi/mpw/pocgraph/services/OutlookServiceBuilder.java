package com.cgi.mpw.pocgraph.services;

import com.cgi.mpw.pocgraph.entities.OutlookMailFolder;
import com.cgi.mpw.pocgraph.entities.GraphApiPagedResult;
import org.springframework.stereotype.Service;

public class OutlookServiceBuilder extends GraphApiServiceBuilder {

    public OutlookServiceBuilder(GraphApiServiceBuilder parent) {
        super(parent);
    }

    public OutlookServiceBuilder(OutlookServiceBuilder parent) {
        super(parent);
    }

    public OutlookServiceBuilder mailFolders(){
        this.responseType = GraphApiPagedResult.class;
        this.addAction(this.getGraphApiEndPointProperties().getMailFoldersAction(), "");
        return this;
    }

    public OutlookServiceBuilder mailFolderByName(String name){
        this.responseType = OutlookMailFolder.class;
        this.addAction(this.getGraphApiEndPointProperties().getMailFoldersAction(), "('"+name+"')");
        return this;
    }

    public OutlookServiceBuilder mailFolderById(String id){
        this.responseType = OutlookMailFolder.class;
        this.addAction(this.getGraphApiEndPointProperties().getMailFoldersAction(), "/"+id);
        return this;
    }

    public OutlookServiceBuilder messages(){
        this.responseType = GraphApiPagedResult.class;
        this.addAction(this.getGraphApiEndPointProperties().getMessagesAction(), "");
        return this;
    }

    public OutlookMessageServiceBuilder messageById(String id){
        this.responseType = GraphApiPagedResult.class;
        String action = this.getGraphApiEndPointProperties().getMessagesAction();
        this.addAction(action, "/"+id);
        return new OutlookMessageServiceBuilder(this);
    }


}
