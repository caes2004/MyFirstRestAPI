package com.escaes.API.model;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    @Column(name = "description", nullable = false, length = 200)
    private String description;
    @Column(name = "due_date", nullable = false)
    private Date dueDate;
    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

}
