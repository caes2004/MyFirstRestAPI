package com.escaes.API.model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "status_name")
    private String statusName;

}
