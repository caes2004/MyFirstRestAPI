package com.escaes.API.repository;


import java.util.Optional;

import  org.springframework.data.jpa.repository.JpaRepository;
import com.escaes.API.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findByTitle(String title);
}
