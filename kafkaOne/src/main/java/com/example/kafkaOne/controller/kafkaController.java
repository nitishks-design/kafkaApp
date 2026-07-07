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
    @PostMapping("/add-course")
    public ResponseEntity<String> addCourse(@RequestBody Course course){
        String response = kafkaService.sendMessage(course);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
}
