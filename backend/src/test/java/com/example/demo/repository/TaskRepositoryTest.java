package com.example.demo.repository;

import org.junit.runner.RunWith;

import com.example.demo.repository.TaskRepository;

import com.example.demo.model.Task;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


@DataJpaTest
public class TaskRepositoryTest {

    @Autowowired
    TaskRepository taskRepository;

    @Test
    public void testAddFind() {

        Task t = new Task();
        t.setTaskdescription("demo");
        taskRepository.save(t);

        assertNotNull(t.getId());
    }
}
