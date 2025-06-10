package com.example.demo;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;


/** the simplest task 
 * 
 * @author luh
 */
@Entity
@Getter @Setter
public class Task {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    private Long id;
 
    @NotBlank
    private String taskdescription; // must have the EXACT name as his React state property and may not be ignored!
 
}