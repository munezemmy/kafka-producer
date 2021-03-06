package com.kafka.example.demo.resource;

import com.kafka.example.demo.mode.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

@RestController
@RequestMapping("kafka")
public class UserResource {
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    private  static  final String TOPIC="Kafka_example";

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name){
        kafkaTemplate.send(TOPIC, new User(name,"IT", "400" ));
        return "published";
    }
}
