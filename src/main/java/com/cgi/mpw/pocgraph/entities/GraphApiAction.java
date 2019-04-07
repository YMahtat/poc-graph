package com.cgi.mpw.pocgraph.entities;

public class GraphApiAction {
    private String action;
    private String parameter;

    public GraphApiAction() {
    }

    public GraphApiAction(String action, String parameter) {
        this.action = action;
        this.parameter = parameter;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public String toString() {
        return  action + parameter;
    }
}
