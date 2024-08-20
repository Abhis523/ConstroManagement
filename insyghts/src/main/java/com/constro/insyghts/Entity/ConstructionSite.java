package com.constro.insyghts.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "constructionSite")
public class ConstructionSite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String description;

    private boolean deleted = false; // Default to false

    @OneToMany(mappedBy = "constructionSite", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Employee> employees;

    @OneToOne
    @JoinColumn(name = "project_in_charge_id")
    private Employee siteInCharge;

    public ConstructionSite() {}

    // Constructor with arguments (if needed)
    public ConstructionSite(Long id, String name, String location, String description, boolean deleted, Set<Employee> employees, Employee siteInCharge) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
        this.deleted = deleted;
        this.employees = employees;
        this.siteInCharge = siteInCharge;
    }
}
