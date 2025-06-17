package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.Task;

@DataJpaTest
public class TaskRepositoryTest {
  
  @Autowired
  private TaskRepository taskRepository;

  @Test
  public void testAddFind() {
    final String DESCRIPTION = "demo";
    Task t = new Task();
    t.setTaskdescription(DESCRIPTION);
    taskRepository.save(t);
    
    assertNotNull(t.getId());
    assertEquals(DESCRIPTION, t.getTaskdescription());

    Optional<Task> savedTask = taskRepository.findById(t.getId());
    assertFalse(savedTask.isEmpty(), "should not be empty");

    assertEquals(DESCRIPTION, savedTask.get().getTaskdescription());
  }
}
