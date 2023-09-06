package com.example.vivek.redispubsub.config;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class RedisMessageSubscriber implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(RedisMessageSubscriber.class);
    public static List<String> messageList = new ArrayList<>();
    
    @Override
    public void onMessage(Message message, byte[] pattern) {
        messageList.add(message.toString());
        logger.info("Message received {} : "+message.toString());
    }
    

}
