package com.example.vivek.redispubsub.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vivek.redispubsub.config.RedisMessagePublisher;
import com.example.vivek.redispubsub.config.RedisMessageSubscriber;
import com.example.vivek.redispubsub.entity.Message;

@RestController
@RequestMapping("/api/redis")
public class RedisController {
    private static final Logger logger = LoggerFactory.getLogger(RedisController.class);
    
    @Autowired
    private RedisMessagePublisher redisMessgaPublisher;

    @Autowired
    private RedisMessageSubscriber redisMessageSubscriber;

    @PostMapping("/publish")
    public void publish(@RequestBody Message message){
        logger.info("------> publishing : {}",message);
        redisMessgaPublisher.publish(message.toString());
    }

    @GetMapping("/subscribe")
    public List<String> getMessages(){
        return RedisMessageSubscriber.messageList;
    }
}
