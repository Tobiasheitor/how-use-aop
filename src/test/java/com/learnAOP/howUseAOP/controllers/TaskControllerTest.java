package com.learnAOP.howUseAOP.controllers;

import com.learnAOP.howUseAOP.services.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @Test
    public void assertValidResponse() throws Exception {
        when(taskService.createTask("My task")).thenReturn("Hello, mock");

        this.mockMvc.perform(get("/task")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void deleteTask() throws Exception {
        doNothing().when(taskService).deleteTask("123");

        this.mockMvc.perform(delete("/task/123")).andExpect(status().isNoContent());
    }
}
