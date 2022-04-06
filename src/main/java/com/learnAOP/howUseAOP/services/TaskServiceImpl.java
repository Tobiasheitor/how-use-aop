package com.learnAOP.howUseAOP.services;

import com.learnAOP.howUseAOP.handler.TaskException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Override
    public String createTask(String description) {
        return "Hello, task";
    }

    @Override
    public void deleteTask(String taskId) throws TaskException {
        if (taskId.contentEquals("123")) {
            throw new TaskException("Failed to delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
