package com.escaes.API.apiconfig;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.escaes.API.repository.StatusRepository;
import jakarta.transaction.Transactional;
import com.escaes.API.model.Status;
//Clase para que se inicialice la base de datos con los estados de las tareas
@Component
public class StatusInitializer implements CommandLineRunner {
    
    private final StatusRepository statusRepository;
    public StatusInitializer(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("StatusInitializer.run");

        if(statusRepository.count() == 0) {
            List<Status>statusList = List.of(
                new Status("Pendiente"),
                new Status("En Proceso"),
                new Status("Terminada")
            );
                statusRepository.saveAll(statusList);
            System.out.println("StatusInitializer.run: Se han creado los estados de las tareas");
        }else{

            System.out.println("StatusInitializer.run: Ya existen los estados de las tareas");
        }
    }

}
