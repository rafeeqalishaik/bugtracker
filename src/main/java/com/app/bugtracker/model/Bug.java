package com.app.bugtracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bug {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String title;
    private String description;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Type type;
    @NotNull
    @Enumerated(EnumType.STRING)
    private State state;
    private String assignee;
}
