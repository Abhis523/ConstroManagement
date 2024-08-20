package com.constro.insyghts.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String position;
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "construction_site_id")
    private ConstructionSite constructionSite;

}
