package com.cgi.mpw.pocgraph.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GraphApiPagedResult<T> {
    @JsonProperty("@odata.nextLink")
    private String nextPageLink;
    private T[] value;

    public String getNextPageLink() {
        return nextPageLink;
    }
    public void setNextPageLink(String nextPageLink) {
        this.nextPageLink = nextPageLink;
    }
    public T[] getValue() {
        return value;
    }
    public void setValue(T[] value) {
        this.value = value;
    }
}
