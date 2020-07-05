package com.kingtao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebLOgsController {

    @Autowired
    private WebLogsService webLogsService;

    @GetMapping("/output")
    public void output(){
        webLogsService.output();
    }
}
