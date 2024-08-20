package com.constro.insyghts.Entity;

import com.constro.insyghts.Enum.RoleEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleEnum rolename;
}

