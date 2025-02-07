package com.escaes.API.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JokeDTO {
    private boolean error;
    private String category;
    private String type;
    private String setup;
    private String delivery;

}
