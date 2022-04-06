package com.learnAOP.howUseAOP.controllers;

import com.learnAOP.howUseAOP.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/task")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String newTask() {
        return taskService.createTask("My task");
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") String taskId) {
        taskService.deleteTask(taskId);

        return ResponseEntity.noContent().build();
    }
}
