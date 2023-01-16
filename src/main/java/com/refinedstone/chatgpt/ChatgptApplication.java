package com.refinedstone.chatgpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ChatgptApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatgptApplication.class, args);
    }


}
