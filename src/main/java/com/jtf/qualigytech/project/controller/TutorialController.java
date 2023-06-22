package com.jtf.qualigytech.project.controller;

import com.jtf.qualigytech.project.entity.Tutorial;
import com.jtf.qualigytech.project.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutorial")
public class TutorialController {

    @Autowired
    TutorialRepository tutorialRepository;

    @GetMapping("/getTutorial")
    public List<Tutorial> getTutorial(){
        List<Tutorial> tutorialList= tutorialRepository.findAll();
        return  tutorialList;
    }

    @GetMapping("/isPublished")
    public List<Tutorial> getPublished(@RequestParam String publishVal){

        return tutorialRepository.findByPublished(publishVal);
    }

    @PutMapping("/test")
    public String updatePublished(@RequestParam Long id){
        tutorialRepository.publishTutorial(id);
        return "Successfully updated :::";
    }
//    @GetMapping("/test")
//    public String test(){
//        return "test ...";
//    }

}
