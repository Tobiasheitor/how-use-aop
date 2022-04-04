package com.learnAOP.howUseAOP.controllers;

import com.learnAOP.howUseAOP.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/task")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String newTask() {
        return taskService.createTask("My task");
    }
}
