package com.escaes.API.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoredDTO {
    private String activity;
    private String type;
    private int participants;
    private double price;
    private String link;
    private String accessibility;
    private boolean kidFriendly;

}
