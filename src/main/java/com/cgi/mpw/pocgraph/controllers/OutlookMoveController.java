package com.cgi.mpw.pocgraph.controllers;

import com.cgi.mpw.pocgraph.entities.GraphApiPagedResult;
import com.cgi.mpw.pocgraph.entities.OutlookMailFolder;
import com.cgi.mpw.pocgraph.entities.OutlookMessage;
import com.cgi.mpw.pocgraph.services.GraphApiServiceBuilder;
import com.cgi.mpw.pocgraph.services.OutlookServiceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/outlook")
public class OutlookMoveController {

    @Autowired
    GraphApiServiceBuilder graphApiServiceBuilder;

    @Autowired
    GraphApiServiceBuilder graphApiServiceBuilder2;



    @RequestMapping("/move/{id}")
    public String testOutlookService(@PathVariable String id){
        System.out.println(id);
        String destionationId = "archive";
        boolean move = graphApiServiceBuilder2.me().outlook().messageById(id).move(destionationId);
        return (move) ? "ok.html" : "ko.html";
    }


}
