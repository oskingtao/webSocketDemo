package com.kingtao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebLOgsController {

    @Autowired
    private WebLogsService webLogsService;

    @GetMapping("/output/{id}")
    public void output(@PathVariable(value = "id")String id){
        webLogsService.output(id);
    }
}
