package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.fail;

import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.annotation.Rollback;

import com.example.demo.repository.TaskRepository;
import jakarta.transaction.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerDeleteTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testDeleteTaskViaREST() {
        final String taskDesc = "task to delete";

        try {
            // 1. Add a task first
            JSONObject taskJson = new JSONObject();
            taskJson.put("taskdescription", taskDesc);

            mockMvc.perform(MockMvcRequestBuilders.post("/task")
                    .content(taskJson.toString())
                    .contentType(MediaType.APPLICATION_JSON)
                    .characterEncoding("utf-8"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

            // 2. Fetch all tasks to find the ID of the added task
            String allTasksJson = mockMvc.perform(MockMvcRequestBuilders.get("/task"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

            Long taskId = taskRepository.findAll().get(0).getId();

            if (taskId == null) {
                fail("Task ID not found after adding task");
            }

            // 3. Delete the task by ID
            mockMvc.perform(MockMvcRequestBuilders.delete("/task/" + taskId))
                .andExpect(MockMvcResultMatchers.status().isOk());

            // 4. Verify task is deleted
            mockMvc.perform(MockMvcRequestBuilders.get("/task"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.not(Matchers.containsString(taskDesc))));

        } catch (Exception e) {
            fail("test failed because " + e.getMessage());
            e.printStackTrace();
        }
    }
}
