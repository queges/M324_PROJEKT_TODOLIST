package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.model.Task;

public class TaskTest {

    @Test
    void testDescription() {
        final String taskdescription = "DEMO";
        Task testee = new Task();

        testee.setTaskdescription(taskdescription);

        assertEquals(taskdescription, testee.getTaskdescription(),"should be the same");
        testee.getTaskdescription();
    }
}