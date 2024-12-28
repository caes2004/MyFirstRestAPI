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
import com.escaes.API.DTO.TaskUpdateDTO;


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

        public Task patchTask(TaskUpdateDTO taskUpdateDTO,Long id) {
            Task task = taskRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Task not found with ID: " + id));

            Status status = statusRepository.findByStatusName(taskUpdateDTO.getStatusName()).orElseThrow(()-> new RuntimeException("Status not found"));
            task.setStatus(status);
            if(taskUpdateDTO.getTitle() != null) {
                task.setTitle(taskUpdateDTO.getTitle());
            }
            if(taskUpdateDTO.getDescription() != null) {
                task.setDescription(taskUpdateDTO.getDescription());
            }
            if(taskUpdateDTO.getDueDate() != null) {
                task.setDueDate(taskUpdateDTO.getDueDate());
            }
            if(taskUpdateDTO.getStatusName() != null) {
                task.setStatus(status);
            }

            return  taskRepository.save(task);
        }

        public Task putTask(TaskUpdateDTO taskUpdateDTO, Long id) {
            Task task = taskRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Task not found with ID: " + id));

            Status status = statusRepository.findByStatusName(taskUpdateDTO.getStatusName()).orElseThrow(()-> new RuntimeException("Status not found"));
            task.setStatus(status);
            task.setTitle(taskUpdateDTO.getTitle());
            task.setDescription(taskUpdateDTO.getDescription());
            task.setDueDate(taskUpdateDTO.getDueDate());
            task.setStatus(status);

            return  taskRepository.save(task);
        }

        public void deleteTaskByid(Long id) {
            Task task = taskRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Task not found with ID: " + id));
            taskRepository.delete(task);
        }

        public void deleteTaskByTitle(String title) {
            Task task = taskRepository.findByTitle(title)
            .orElseThrow(() -> new RuntimeException("Task not found with Title: " + title));
            taskRepository.delete(task);
        }

}
