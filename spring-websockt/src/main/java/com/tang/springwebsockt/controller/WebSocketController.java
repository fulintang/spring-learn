package com.tang.springwebsockt.controller;

import com.tang.springwebsockt.service.WebSocket;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 建立WebSocket连接
 *
 * @author Liby
 * @since 2022-04-26 10:28
 */
@RestController
@RequestMapping("/webSocket")
@RequiredArgsConstructor
public class WebSocketController {

    private final WebSocket webSocket;

    @PostMapping("/sentMessage")
    public void sentMessage(String userId, String message) {
        try {
            webSocket.sendMessageByUserId(userId, message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @PostMapping("/sentAllMessage")
    public void sentAllMessage(String message) {
        try {
            webSocket.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

