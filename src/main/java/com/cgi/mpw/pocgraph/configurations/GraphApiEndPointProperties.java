package com.cgi.mpw.pocgraph.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GraphApiEndPointProperties {

    @Value("${microsoft.graph.url}")
    private String url;

    @Value("${microsoft.graph.action.users}")
    private String usersAction;

}
