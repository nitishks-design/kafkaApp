package com.example.kafkaOne.service;

import com.example.kafkaOne.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private String message;
    private String msg;

    // on the basis of groupId offset is maintained , so that every consumer can read msg sent to it one by one.
    // if groupid is same, kafka will assign number of partitions between its two listeners.

    @KafkaListener(topics="nitish",groupId = "consumer-group")
    public void consume(Course course){
        message =  course + "Got the message";
        System.out.println("Course ID : " + course.getCourseId());
        System.out.println("Title     : " + course.getTitle());
        System.out.println("Trainer   : " + course.getTrainer());
        System.out.println("Price     : " + course.getPrice());
        System.out.println(message);
    }


    @KafkaListener(topics="nitish",groupId = "consumer-group2")
    public void consume2(Course course){
        msg =  course + "Got the message";
        System.out.println("Course ID : " + course.getCourseId());
        System.out.println("Title     : " + course.getTitle());
        System.out.println("Trainer   : " + course.getTrainer());
        System.out.println("Price     : " + course.getPrice());
        System.out.println(msg);
    }

    public String getMessage() {
        return message;
    }

    public String getMsg() {
        return msg;
    }
}
