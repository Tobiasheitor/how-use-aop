package com.learnAOP.howUseAOP.services;

import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Override
    public String createTask(String description) {
        return "Hello, task";
    }

}
