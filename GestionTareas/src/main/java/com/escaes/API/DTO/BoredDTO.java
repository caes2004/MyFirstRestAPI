package com.escaes.API.DTO;

import lombok.Data;

@Data
public class BoredDTO {
    private String activity;
    private String type;
    private int participants;
    private double price;
    private String link;
    private String accessibility;
    private boolean kidFriendly;

}
