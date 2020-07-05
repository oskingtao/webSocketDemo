package com.kingtao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebLogsService {

    @Autowired
    private WebSocket webSocket;

    public void output(){
        webSocket.sendMessage("loading.....");
        try {
            Thread.sleep(1000);
            webSocket.sendMessage("正在导入人员。。。。");
            Thread.sleep(1000);
            webSocket.sendMessage("导入人员成功");
            Thread.sleep(1000);
            webSocket.sendMessage("正在导入项目。。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
