package com.cgi.mpw.pocgraph.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GraphApiEndPointProperties {

    @Value("${microsoft.graph.url}")
    private String url;

    @Value("${microsoft.graph.action.users}")
    private String usersAction;

    @Value("${microsoft.graph.action.me}")
    private String currentUserAction;

    @Value("${microsoft.graph.action.mail-folders}")
    private String mailFoldersAction;

    @Value("${microsoft.graph.action.messages}")
    private String messagesAction;

    @Value("${microsoft.graph.action.move}")
    private String moveAction;

    public String getUrl() {
        return url;
    }

    public String getUsersAction() {
        return usersAction;
    }

    public String getCurrentUserAction() {
        return currentUserAction;
    }

    public String getMailFoldersAction() {
        return mailFoldersAction;
    }

    public String getMessagesAction() {
        return messagesAction;
    }

    public String getMoveAction() {
        return moveAction;
    }
}
