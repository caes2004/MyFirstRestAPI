package com.escaes.API.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CombinedDTO {
    private List<TaskDTO> tasks;
    private JokeDTO externalData;

}
