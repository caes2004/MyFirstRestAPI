package com.escaes.API.service;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.escaes.API.model.Task;
import com.escaes.API.model.Status;
import com.escaes.API.repository.StatusRepository;
import com.escaes.API.repository.TaskRepository;
import com.escaes.API.DTO.TaskDTO;
@Service
public class TaskService {

    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private TaskRepository taskRepository;
       
        public TaskDTO createTask(TaskDTO taskDTO) {
            
            Task task = new Task();
            Status status = statusRepository.findByStatusName(taskDTO.getStatusName()).orElseThrow(()-> new RuntimeException("Status not found"));
            task.setTitle(taskDTO.getTitle());
            task.setDescription(taskDTO.getDescription());
            task.setDueDate(taskDTO.getDueDate());
            task.setStatus(status);
            
            
            taskRepository.save(task);
            
            return taskDTO;
        }

        public List <TaskDTO> getAllTaskDTO() {

            List<Task> tasks = taskRepository.findAll();

            List<TaskDTO> taskDTOs = new ArrayList<TaskDTO>();

            for (Task task : tasks) {
                TaskDTO taskDTO = new TaskDTO();
                taskDTO.setTitle(task.getTitle());
                taskDTO.setDescription(task.getDescription());
                taskDTO.setDueDate(task.getDueDate());
                taskDTO.setStatusName(task.getStatus().getStatusName());
                taskDTOs.add(taskDTO);
            }

            return taskDTOs;
        }

}
