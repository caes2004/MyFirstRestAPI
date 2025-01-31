package com.escaes.API.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.escaes.API.repository.TaskRepository;
import com.escaes.API.service.TaskService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.escaes.API.DTO.BoredDTO;
import com.escaes.API.DTO.CombinedDTO;
import com.escaes.API.DTO.TaskDTO;
import com.escaes.API.DTO.TaskUpdateDTO;
import com.escaes.API.model.Task;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.client.RestTemplate;
import com.escaes.API.DTO.StatusDTO;
import com.escaes.API.service.BoredService;
import com.escaes.API.service.StatusService;








@RestController
@RequestMapping("/api")
public class APIController {
    
   /* private final RestTemplate restTemplate;

    public APIController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
     */
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskService taskService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private BoredService boredService;

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
    @PostMapping("/statusDTO")
    public StatusDTO createStatusDTO(@RequestBody StatusDTO statusDTO) {
        
        return statusService.createStatus(statusDTO);
    }
    
    @GetMapping("/tasksDTO")
    public List<TaskDTO>getAllTaskDTO() {

        List<TaskDTO> taskDTOs = taskService.getAllTaskDTO();
        return taskDTOs;
    
    }
    @GetMapping("/statusDTO")
    public List<StatusDTO> getMethodName() {
        List<StatusDTO> statusDTOs = statusService.getAllStatusDTO();
        return statusDTOs; 
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
    @DeleteMapping("/status/{id}")
    public void deleteStatus(@PathVariable Long id) {
        
        statusService.deleteStatus(id);
    }
    /*
    @GetMapping("/bored")
    public List<BoredDTO> BoredAPI() {
        String url = "https://bored-api.appbrewery.com/random";

        ResponseEntity<BoredDTO> response = restTemplate.getForEntity(url, BoredDTO.class);

        return Arrays.asList(response.getBody());
    }
     */
    
    @GetMapping("/bored")
    public ResponseEntity<BoredDTO>BoredApi(){
        BoredDTO response = boredService.randomBored();

        if(response.getActivity().equals("Error al obtener actividad")){
            return ResponseEntity.status(500).body(response);
        }
        return ResponseEntity.ok(response);

    }
    /*
    @GetMapping("/v1")
    public ResponseEntity<CombinedDTO> getCombinedData() {

            String url = "https://bored-api.appbrewery.com/random";
            ResponseEntity<BoredDTO> response = restTemplate.getForEntity(url, BoredDTO.class);
            List<TaskDTO> taskDTOs = taskService.getAllTaskDTO();
            CombinedDTO combinedDTO = new CombinedDTO(taskDTOs, response.getBody());
            return ResponseEntity.ok(combinedDTO);
        
    }
     */

    @GetMapping("/v1")
    public ResponseEntity<CombinedDTO> getCombinedData() {
        BoredDTO response = boredService.randomBored();
        List<TaskDTO> taskDTOs = taskService.getAllTaskDTO();
        if(response.getActivity().equals("Error al obtener actividad")){
            return ResponseEntity.status(500).body(new CombinedDTO(taskDTOs, response));
        }
        CombinedDTO combinedDTO = new CombinedDTO(taskDTOs, response);
        return ResponseEntity.ok(combinedDTO);
    }
}
