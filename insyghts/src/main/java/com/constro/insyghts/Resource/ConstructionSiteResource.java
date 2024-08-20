package com.constro.insyghts.Resource;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class ConstructionSiteResource {
    private Long id;
    private String name;
    private String location;
    private String description;
    private Set<EmployeeResource> employees;
    private EmployeeResource projectInCharge;
}
