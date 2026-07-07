package com.example.kafkaOne.controller;

import com.example.kafkaOne.model.Course;
import com.example.kafkaOne.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class kafkaController {
    @Autowired
    private KafkaService kafkaService;

    @GetMapping("/get-course")
    public ResponseEntity<String> getCourse(){
        String response = kafkaService.getMessage();
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @GetMapping("/get-data")
    public ResponseEntity<String> getdata(){
        String response = kafkaService.getMsg();
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
}
