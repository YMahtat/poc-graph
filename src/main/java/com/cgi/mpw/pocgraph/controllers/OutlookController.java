package com.cgi.mpw.pocgraph.controllers;

import com.cgi.mpw.pocgraph.entities.GraphApiPagedResult;
import com.cgi.mpw.pocgraph.entities.OutlookMessage;
import com.cgi.mpw.pocgraph.services.GraphApiServiceBuilder;
import com.cgi.mpw.pocgraph.services.OutlookMessageServiceBuilder;
import com.cgi.mpw.pocgraph.services.OutlookServiceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OutlookController {

    @Autowired
    GraphApiServiceBuilder graphApiServiceBuilder;

    private GraphApiPagedResult<OutlookMessage> pagedResultMessage;
    private OutlookServiceBuilder outlookMessages;

    private void getMessages(){
        if (outlookMessages == null){
            outlookMessages = graphApiServiceBuilder.me().outlook()
                    .mailFolderByName("inbox")
                    .messages();
        }
        pagedResultMessage = (GraphApiPagedResult<OutlookMessage>) outlookMessages.setResponseType(GraphApiPagedResult.class)
                .get()
                .getResponse()
                .getBody();
    }

    @RequestMapping("/outlook")
    public String testOutlookService(Model model){
        getMessages();
        model.addAttribute("list", pagedResultMessage.getValue());
        return "template.html";
    }


}
