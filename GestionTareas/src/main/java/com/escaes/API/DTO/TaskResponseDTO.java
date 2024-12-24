package com.escaes.API.DTO;

import java.sql.Date;
import lombok.Data;
@Data
public class TaskResponseDTO {
    private String title;
    private String description;
    private Date dueDate;
    private String statusName;

}
