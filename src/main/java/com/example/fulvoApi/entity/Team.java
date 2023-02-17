package com.example.fulvoApi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "teams")
public class Team {
    private static final long serialVersionUID = 5032242502913382870L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    private String logo;

}
