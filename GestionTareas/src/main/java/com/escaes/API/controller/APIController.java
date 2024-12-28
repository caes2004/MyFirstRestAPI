package com.escaes.API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.escaes.API.repository.TaskRepository;
import com.escaes.API.service.TaskService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

//import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.escaes.API.DTO.TaskDTO;
import com.escaes.API.DTO.TaskUpdateDTO;
import com.escaes.API.model.Task;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        
        return taskRepository.findAll();
    }
    
    @PostMapping("/tasks")
    public Task NewTask(@RequestBody Task task) {
        
        
        return taskRepository.save(task);
    }

    @PostMapping("/tasksDTO")
    public TaskDTO createTaskDTO(@RequestBody TaskDTO taskDTO) {
        
        
        return taskService.createTask(taskDTO);
    }
    
    @GetMapping("/tasksDTO")
    public List<TaskDTO>getAllTaskDTO() {

        List<TaskDTO> taskDTOs = taskService.getAllTaskDTO();
        return taskDTOs;
    
    }
    @PatchMapping("/tasks/{id}")
    public Task patchTask(@RequestBody TaskUpdateDTO taskUpdateDTO, @PathVariable Long id) {
        
        return taskService.patchTask(taskUpdateDTO, id);
    }
    
    @PutMapping("/tasks/{id}")
    public Task putTask(@PathVariable Long id, @RequestBody TaskUpdateDTO taskUpdateDTO) {
        
        
        return taskService.putTask(taskUpdateDTO, id);
    }
    @DeleteMapping("/tasks/id/{id}")
    public void deleteTaskByid(@PathVariable Long id) {
        
        taskService.deleteTaskByid(id);
    }
    @DeleteMapping("/tasks/title/{title}")
    public void deleteTaskByTitle(@PathVariable String title) {
        
        taskService.deleteTaskByTitle(title);
    }
}
