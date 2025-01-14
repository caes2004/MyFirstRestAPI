package com.escaes.API.service;
import com.escaes.API.repository.StatusRepository;
import com.escaes.API.DTO.StatusDTO;
import com.escaes.API.model.Status;
import java.util.List;
import java.util.ArrayList;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public List<StatusDTO> getAllStatusDTO(){

            List<Status> status = statusRepository.findAll();
            List<StatusDTO> statusDTOs = new ArrayList<StatusDTO>();

            for (Status status1 : status) {
                StatusDTO statusDTO = new StatusDTO();
                statusDTO.setStatusName(status1.getStatusName());
                statusDTOs.add(statusDTO);
            }

            return statusDTOs;
    }

    public StatusDTO createStatus(StatusDTO statusDTO) {
        
        try { 
            Status status = new Status();
            status.setStatusName(statusDTO.getStatusName());
            statusRepository.save(status);
            return statusDTO;
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el estatus");
        }
       
    }

    public void deleteStatus(Long id) {
        statusRepository.deleteById(id);
    }

}
