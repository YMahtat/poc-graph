package com.cgi.mpw.pocgraph.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OutlookRecipient {
    private OutlookEmailAddress emailAddress;

    public OutlookEmailAddress getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(OutlookEmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }
}