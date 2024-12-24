package com.escaes.API.repository;


import  org.springframework.data.jpa.repository.JpaRepository;
import com.escaes.API.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    
}
