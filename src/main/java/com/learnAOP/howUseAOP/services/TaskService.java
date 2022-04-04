package com.learnAOP.howUseAOP.services;

import com.learnAOP.howUseAOP.handler.TaskException;

public interface TaskService {

    String createTask(String description);

    void deleteTask(String taskId) throws TaskException;

}
